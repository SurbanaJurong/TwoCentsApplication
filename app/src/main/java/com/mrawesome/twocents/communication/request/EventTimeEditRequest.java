package com.mrawesome.twocents.communication.request;

import java.util.Calendar;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventTimeEditRequest implements Request {

    private String eventId;
    private Long startTime = null;
    private Integer duration = null;

    EventTimeEditRequest(String eventId) {
        this.eventId = eventId;
    }

    void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public RequestType type() {
        return RequestType.EventTimeEdit;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
