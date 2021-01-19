package com.sagish.redditapplication.ui.main.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sagish.redditapplication.R;
import com.sagish.redditapplication.databinding.FragmentActivityLayoutBinding;
import com.sagish.redditapplication.ui.main.fragments.ArticleFragment;
import com.sagish.redditapplication.ui.main.viewmodels.ArticleViewModel;

public class ArticleActivity extends AbstractActivity {

    private ArticleViewModel viewModel;
    private FragmentActivityLayoutBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutRes());

        setFragmentToView(ArticleFragment.newInstance());

        viewModel = new ViewModelProvider(this).get(ArticleViewModel.class);

        if (getIntent() != null) {
            String link = getIntent().getStringExtra("URL_LINK");
            viewModel.setArticleLink(link);
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_activity_layout;
    }
}
