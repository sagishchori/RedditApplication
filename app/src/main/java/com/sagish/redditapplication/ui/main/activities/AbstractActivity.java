package com.sagish.redditapplication.ui.main.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sagish.redditapplication.R;

public abstract class AbstractActivity extends AppCompatActivity {

    protected abstract int getLayoutRes();

    protected void setFragmentToView(@Nullable Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow();
    }
}
