package com.sagish.redditapplication.ui.main.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.sagish.redditapplication.R;
import com.sagish.redditapplication.databinding.FragmentActivityLayoutBinding;
import com.sagish.redditapplication.ui.main.fragments.MainFragment;
import com.sagish.redditapplication.ui.main.retrofit.RetrofitClient;

public class MainActivity extends AbstractActivity {

    private FragmentActivityLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutRes());

        if (savedInstanceState == null) {
            setFragmentToView(MainFragment.newInstance());
        }

        // Should be in Application class
        RetrofitClient.getClient(this.getApplicationContext());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_activity_layout;
    }
}