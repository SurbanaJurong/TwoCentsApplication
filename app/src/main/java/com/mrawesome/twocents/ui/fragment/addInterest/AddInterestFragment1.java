package com.mrawesome.twocents.ui.fragment.addInterest;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.ui.adapter.InterestAdapter;
import com.mrawesome.twocents.ui.adapter.RecyclerViewOnClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by mrawesome on 21/5/17.
 */

public class AddInterestFragment1 extends Fragment implements RecyclerViewOnClickListener {

    private static final String TAG = AddInterestFragment1.class.getSimpleName();

    private List<Interest> interests;

    private OnListFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private InterestAdapter adapter;

    private static AddInterestFragment1 fragment = null;
    private Set<Integer> selectedItem = new HashSet<>();

    public AddInterestFragment1() {

    }

    public static AddInterestFragment1 newInstance() {
        if (fragment == null) {
            fragment = new AddInterestFragment1();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.add_interest_screen1, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.interest_list);
        interests = queryInterest();
        adapter = new InterestAdapter(view.getContext(), this, interests);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    private List<Interest> queryInterest() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Interest> query = realm.where(Interest.class);
        RealmResults<Interest> result = query.findAll();
        List<Interest> interests = new ArrayList<>();
        interests.addAll(result);
        Log.d(TAG, interests.toString());
        return interests;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    public Set<Interest> getSelectedInterest() {
        Set<Interest> interests = new HashSet<>();
        for (int index : selectedItem) {
            interests.add(adapter.getItem(index));
        }
        return interests;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onRecyclerViewListClicked(View v, int position) {
        mListener.onInterestListFragmentInteraction();
        if (!selectedItem.contains(position)) {
            selectedItem.add(position);
            updateSelection(position, false);
        } else {
            selectedItem.remove(position);
            updateSelection(position, true);
        }
    }

    private void updateSelection(int position, boolean isSelected) {
        View view = recyclerView.getLayoutManager().findViewByPosition(position);
        if (isSelected) {
            view.setBackgroundResource(R.color.cardview_light_background);
        } else {
            view.setBackgroundResource(R.color.colorRed);
        }
    }

    public interface OnListFragmentInteractionListener {
        void onInterestListFragmentInteraction();
    }
}
