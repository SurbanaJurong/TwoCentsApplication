package com.mrawesome.twocents.fragment.addInterest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrawesome.twocents.R;

/**
 * Created by mrawesome on 21/5/17.
 */

public class AddInterestFragment3 extends Fragment {

    private static final String TAG = AddInterestFragment3.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.add_interest_screen3, container, false);
    }
}
