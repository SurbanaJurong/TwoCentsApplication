package com.mrawesome.twocents.fragment.addInterest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.ui.adapter.EventAdapter;
import com.mrawesome.twocents.ui.adapter.InterestAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by mrawesome on 21/5/17.
 */

public class AddInterestFragment2 extends Fragment {

    private ArrayList<Event> events = new ArrayList<>(Arrays.asList(new Event[] {
            new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, Calendar.getInstance().getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, Calendar.getInstance().getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, Calendar.getInstance().getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, Calendar.getInstance().getTimeInMillis(), 2), new Event("event 1", "football", "u123123", "Some description", 1, "v123123", 10, 20, Calendar.getInstance().getTimeInMillis(), 2)
    }));

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.add_interest_screen2, container, false);
        EventAdapter eventAdapter = new EventAdapter(events);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.event_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eventAdapter);
        return view;
    }
}