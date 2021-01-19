package com.sagish.redditapplication.ui.main.fragments;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class AbstractFragment extends Fragment {

    /**
     * Get the layout resource id.
     *
     * @return          int as a @{@link androidx.annotation.LayoutRes}
     */
    protected abstract int getLayoutRes();

    /**
     * A method to show a pop up dialog to the user. Use this to notify the user.
     * Each view should implement its own method to decide how the dialog will be
     * shown.
     *
     * @param message   The message to set
     */
    protected void showDialog(@Nullable String message) {

    }

    /**
     * implement the method for setting observers on {@link androidx.lifecycle.ViewModel}
     * data objects.
     */
    protected void setupObservers() {

    }
}
