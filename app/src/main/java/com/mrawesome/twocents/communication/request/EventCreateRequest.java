package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;
import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.util.StreamReader;

import java.util.Calendar;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventCreateRequest implements Request {

    private String host;
    private String description;
    private Event.EventMode isRecurring;
    private String venueId;
    private int minCapacity;
    private int maxCapacity;
    private Calendar startTime;
    private int duration;

    EventCreateRequest(String description, Event.EventMode isRecurring, String venueId, int minCapacity, int maxCapacity, long startTime, int duration) {
        this.host = Profile.getInstance().getUsername();
        StreamReader.collapse(description);
        this.description = description;
        this.isRecurring = isRecurring;
        this.venueId = venueId;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.startTime = Calendar.getInstance();
        this.startTime.setTimeInMillis(startTime);
        this.duration = duration;
    }

    @Override
    public RequestType type() {
        return RequestType.EventCreate;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
