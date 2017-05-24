package com.mrawesome.twocents.fragment.onboarding;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrawesome.twocents.R;

/**
 * Created by mrawesome on 20/5/17.
 */

public class OnboardingFragment4 extends Fragment {

    private static final String TAG = OnboardingFragment4.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle s) {
        return inflater.inflate(R.layout.onboarding_screen4, container, false);
    }
}
