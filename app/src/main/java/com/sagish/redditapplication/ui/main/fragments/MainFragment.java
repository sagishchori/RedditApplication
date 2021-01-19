package com.sagish.redditapplication.ui.main.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sagish.redditapplication.ui.main.activities.ArticleActivity;
import com.sagish.redditapplication.R;
import com.sagish.redditapplication.databinding.MainFragmentBinding;
import com.sagish.redditapplication.ui.main.helpers.ErrorDialog;
import com.sagish.redditapplication.ui.main.viewmodels.MainViewModel;
import com.sagish.redditapplication.ui.main.adapters.CardViewAdapter;
import com.sagish.redditapplication.ui.main.adapters.MainAdapter;
import com.sagish.redditapplication.ui.main.models.ChildrenItem;
import com.sagish.redditapplication.ui.main.retrofit.Result;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends AbstractFragment implements CardViewAdapter.OnItemClickListener {

    public static final String TAG = MainFragment.class.getSimpleName();

    private MainViewModel viewModel;
    private MainFragmentBinding binding;
    private MainAdapter adapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        setupObservers();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(this);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.main_fragment;
    }

    @Override
    protected void showDialog(String message) {
        ErrorDialog.getErrorDialog(requireContext(),
                getString(R.string.error_title),
                message,
                getString(R.string.ok),
                null,
                null).show();
    }

    @Override
    protected void setupObservers() {
        viewModel.getResult().observe(getViewLifecycleOwner(), new Observer<Result<List<ChildrenItem>>>() {
            @Override
            public void onChanged(Result result) {
                switch (result.getStatus()) {
                    case ERROR:
                        showDialog(result.getMessage());
                        break;

                    case SUCCESS:
                        adapter.setData((ArrayList) result.getData());
                        break;

                    default:
                        break;
                }
                if (result.getStatus() == Result.Status.ERROR) {
                    showDialog(result.getMessage());
                }
            }
        });
    }

    @Override
    public void onItemClicked(ChildrenItem item) {
        Intent article = new Intent(requireActivity(), ArticleActivity.class);
        article.putExtra("URL_LINK", item.getData().getPermalink());
        requireActivity().startActivity(article);
    }
}