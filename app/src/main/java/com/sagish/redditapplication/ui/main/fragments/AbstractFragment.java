package com.sagish.redditapplication.ui.main.fragments;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class AbstractFragment extends Fragment {

    protected abstract int getLayoutRes();

    protected void showDialog(@Nullable String message) {

    }
}
