package com.sagish.redditapplication.ui.main.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sagish.redditapplication.R;

public abstract class AbstractActivity extends AppCompatActivity {

    /**
     * Get the layout resource id.
     *
     * @return      int as a @{@link androidx.annotation.LayoutRes}
     */
    protected abstract int getLayoutRes();

    /**
     * Set a fragment in a {@link android.widget.FrameLayout} which has an id named conainer.
     *
     * @param fragment
     * @param fragmentTag
     */
    protected void setFragmentToView(@Nullable Fragment fragment, String fragmentTag) {
        Fragment f;

        if ((f = getSupportFragmentManager().findFragmentByTag(fragmentTag)) == null) {
            f = fragment;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f, fragmentTag)
                .commitNow();
    }
}
