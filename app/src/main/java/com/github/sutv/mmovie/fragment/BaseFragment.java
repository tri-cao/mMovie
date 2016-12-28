package com.github.sutv.mmovie.fragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.github.sutv.mmovie.activity.BaseActivity;
import com.github.sutv.mmovie.di.FragmentComponent;
import com.github.sutv.mmovie.di.FragmentModule;

public abstract class BaseFragment extends Fragment {

    private FragmentComponent fragmentComponent;

    @NonNull
    public FragmentComponent getComponent() {
        if (fragmentComponent != null) {
            return fragmentComponent;
        }

        Activity activity = getActivity();
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalStateException(
                    "The activity of this fragment is not an instance of BaseActivity");
        }
        fragmentComponent = ((BaseActivity) activity).getComponent()
                .plus(new FragmentModule(this));
        return fragmentComponent;
    }
}
