package com.mrawesome.twocents.ui.fragment.onboarding;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Profile;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnboardingFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OnboardingFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnboardingFragment2 extends Fragment {

    private static final String TAG = OnboardingFragment2.class.getSimpleName();

    private EditText usernameField;
    private EditText phoneNumberField;
    private EditText yobField;
    private EditText postalCodeField;
    private EditText nricField;

    private static OnboardingFragment2 fragment = null;

    private OnFragmentInteractionListener mListener;

    public OnboardingFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OnboardingFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static OnboardingFragment2 newInstance() {
        if (fragment == null) {
            fragment = new OnboardingFragment2();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.onboarding_screen2, container, false);
        usernameField = (EditText) view.findViewById(R.id.review_username_field);
        phoneNumberField = (EditText) view.findViewById(R.id.review_phoneNumber_field);
        yobField = (EditText) view.findViewById(R.id.review_year_field);
        postalCodeField = (EditText) view.findViewById(R.id.review_postalCode_field);
        nricField = (EditText) view.findViewById(R.id.review_nric_field);
        return view;
    }

    public void setData() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmQuery<Profile> query = realm.where(Profile.class);
                Profile profile = query.findFirst();
                fragment.setUsername(profile.getUsername());
                fragment.setPhoneNumber(profile.getPhoneNumber());
                fragment.setYob(String.valueOf(profile.getYear()));
                fragment.setPostalCode(profile.getLocation());
                fragment.setNric(profile.getNric());
            }
        });
    }

    private void setUsername(String value) {
        if (value != null) {
            usernameField.setText(value);
        }
    }

    private void setPhoneNumber(String value) {
        if (value != null) {
            phoneNumberField.setText(value);
        }
    }

    private void setYob(String value) {
        if (value != null) {
            yobField.setText(value);
        }
    }

    private  void setPostalCode(String value) {
        if (value != null) {
            postalCodeField.setText(value);
        }
    }

    private void setNric(String value) {
        if (value != null) {
            nricField.setText(value);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onOnboarding2FragmentInteraction(uri);
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onOnboarding2FragmentInteraction(Uri uri);
    }
}
