package com.mrawesome.twocents.ui.fragment.addInterest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.ApiEndpointInterface;
import com.mrawesome.twocents.communication.CommModule;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.data.persistent.User;
import com.mrawesome.twocents.data.persistent.Venue;
import com.mrawesome.twocents.ui.adapter.EventAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mrawesome on 21/5/17.
 */

public class AddInterestFragment2 extends Fragment {

    private static final String TAG = AddInterestFragment2.class.getSimpleName();

    private static AddInterestFragment2 fragment = null;

    private Set<Event> events = new HashSet<>();
    private EventAdapter eventAdapter;

    public AddInterestFragment2() {

    }

    public static AddInterestFragment2 newInstance() {
        if (fragment == null) {
            fragment = new AddInterestFragment2();
        }
        return fragment;
    }

    public void setEvents(List<Event> events) {
        this.events.addAll(events);
        for (Event event : events) {
            ApiEndpointInterface apiEndpointInterface = CommModule.getApiEndpointExpose();
            apiEndpointInterface.getUserById(event.getHost()).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, final Response<User> response) {
                    if (response.isSuccessful()) {
                        Realm realm = Realm.getDefaultInstance();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.insertOrUpdate(response.body());
                                eventAdapter.notifyDataSetChanged();
                            }
                        });
                    } else {
                        Log.d(TAG, "request unsucessful");
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.d(TAG, "request fail");
                }
            });
            apiEndpointInterface.getVenueById(event.getVenueId()).enqueue(new Callback<Venue>() {
                @Override
                public void onResponse(Call<Venue> call, final Response<Venue> response) {
                    if (response.isSuccessful()) {
                        Realm realm = Realm.getDefaultInstance();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.insertOrUpdate(response.body());
                                eventAdapter.notifyDataSetChanged();
                            }
                        });
                    } else {
                        Log.d(TAG, "request unsucessful");
                    }
                }

                @Override
                public void onFailure(Call<Venue> call, Throwable t) {
                    Log.d(TAG, "request fail");
                }
            });
        }
        Log.d(TAG, "data set changed");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.add_interest_screen2, container, false);
        eventAdapter = new EventAdapter(events);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.event_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eventAdapter);
        return view;
    }
}
