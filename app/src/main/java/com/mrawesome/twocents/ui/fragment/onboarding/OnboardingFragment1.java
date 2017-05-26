package com.mrawesome.twocents.ui.fragment.onboarding;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Profile;

import io.realm.Realm;

/**
 * Created by mrawesome on 20/5/17.
 */

public class OnboardingFragment1 extends Fragment {

    public static final String USERNAME = "username";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String YOB = "yob";
    public static final String POSTAL_CODE = "postalCode";
    public static final String NRIC = "nric";

    private static final String TAG = OnboardingFragment1.class.getSimpleName();

    private static OnboardingFragment1 fragment = null;

    EditText username;
    TextView usernameMsg;
    EditText phoneNumber;
    TextView phoneNumberMsg;
    EditText yob;
    TextView yobMsg;
    EditText postalCode;
    TextView postalCodeMsg;
    EditText nric;
    TextView nricMsg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle s) {
        View view = inflater.inflate(R.layout.onboarding_screen1, container, false);
        username = (EditText) view.findViewById(R.id.username_field);
        usernameMsg = (TextView) view.findViewById(R.id.username_message);
        phoneNumber = (EditText) view.findViewById(R.id.phoneNumber_field);
        phoneNumberMsg = (TextView) view.findViewById(R.id.phoneNumber_message);
        yob = (EditText) view.findViewById(R.id.year_field);
        yobMsg = (TextView) view.findViewById(R.id.year_message);
        postalCode = (EditText) view.findViewById(R.id.postalCode_field);
        postalCodeMsg = (TextView) view.findViewById(R.id.postalCode_message);
        nric = (EditText) view.findViewById(R.id.nric_field);
        nricMsg = (TextView) view.findViewById(R.id.nric_message);
        return view;
    }

    public void updateProfileData() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Profile profile = Profile.getInstance();
                // validation check
                Log.d(TAG, username.getText().toString() + "|" + phoneNumber.getText().toString() + "|" + postalCode.getText().toString());
                profile.setUsername(username.getText().toString());
                profile.setPhoneNumber("+65" + phoneNumber.getText().toString());
                profile.setYear(Integer.parseInt(yob.getText().toString()));
                profile.setLocation(postalCode.getText().toString());
                profile.setNric(nric.getText().toString());
                realm.insertOrUpdate(profile);
//                Profile pf = realm.where(Profile.class).findFirst();
//                if (pf != null && pf.getUserId() == profile.getUserId()) {
//                    pf.setUsername(profile.getUsername());
//                    pf.setPhoneNumber(profile.getPhoneNumber());
//                    pf.setYear(profile.getYear());
//                    pf.setLocation(profile.getLocation());
//                    pf.setNric(profile.getNric());
//                } else {
//                    realm.copyToRealm(profile);
//                }
            }
        });
    }

    private OnFragmentInteractionListener mListener;

    public OnboardingFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OnboardingFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static OnboardingFragment1 newInstance() {
        if (fragment == null) {
            fragment = new OnboardingFragment1();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onOnboarding1FragmentInteraction(Uri uri);
    }
}
