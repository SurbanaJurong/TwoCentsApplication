package com.mrawesome.twocents.fragment.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.ui.adapter.EventAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class EventFragment extends Fragment {

    private static final String TAG = EventFragment.class.getSimpleName();

    private Calendar start1 = Calendar.getInstance();
    private Calendar start2 = (Calendar) start1.clone();
    {
        start2.add(Calendar.DAY_OF_WEEK, 1);
    }
    private List<Event> events = Arrays.asList(new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start1.getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start1.getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start1.getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start2.getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start2.getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start2.getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start2.getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start2.getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, start2.getTimeInMillis(), 2));

    // TODO: Customize parameters
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_event_list);
        recyclerView.setAdapter(new EventAdapter(events));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.event_floating_btn);
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) button.getLayoutParams();
//        params.setBehavior(new ScrollAwareFABBehavior());
//        button.requestLayout();

        return view;
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onEventListFragmentInteraction();
    }
}
