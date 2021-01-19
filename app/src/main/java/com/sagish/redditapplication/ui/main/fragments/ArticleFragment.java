package com.sagish.redditapplication.ui.main.fragments;

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

import com.sagish.redditapplication.R;
import com.sagish.redditapplication.databinding.MainFragmentBinding;
import com.sagish.redditapplication.ui.main.helpers.ErrorDialog;
import com.sagish.redditapplication.ui.main.retrofit.Result;
import com.sagish.redditapplication.ui.main.viewmodels.ArticleViewModel;
import com.sagish.redditapplication.ui.main.adapters.ArticleAdapter;
import com.sagish.redditapplication.ui.main.models.ChildrenItem;

import java.util.ArrayList;
import java.util.List;

public class ArticleFragment extends AbstractFragment {

    public static final String TAG = ArticleFragment.class.getSimpleName();

    private ArticleViewModel viewModel;
    private MainFragmentBinding binding;
    private ArticleAdapter adapter;

    public static ArticleFragment newInstance() {
        return new ArticleFragment();
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
        viewModel = new ViewModelProvider(requireActivity()).get(ArticleViewModel.class);

        setupObservers();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);

        adapter = new ArticleAdapter(null);
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
            }
        });
    }
}
