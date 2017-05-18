package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;
import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.util.StreamReader;

import java.util.Calendar;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventCreateRequest extends Request {

    private String host;
    private String eventName;
    private String category;
    private String description;
    private String venueId;
    private int minCapacity;
    private int maxCapacity;
    private Calendar startTime;
    private int duration;

    EventCreateRequest(String eventName, String category, String description, String venueId, int minCapacity, int maxCapacity, long startTime, int duration) {
        this.host = Profile.getInstance().getUsername();
        StreamReader.collapse(eventName);
        this.eventName = eventName;
        this.category = category;
        StreamReader.collapse(description);
        this.description = description;
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
        append(RequestFactory.p_username, host);
        append(RequestFactory.e_eventName, eventName);
        append(RequestFactory.e_category, category);
        append(RequestFactory.e_description, description);
        append(RequestFactory.e_venueId, venueId);
        append(RequestFactory.e_minCapacity, minCapacity);
        append(RequestFactory.e_maxCapacity, maxCapacity);
        append(RequestFactory.e_startTime, startTime.getTimeInMillis());
        append(RequestFactory.e_duration, duration);
        return stringBuilder.toString();
    }
}
