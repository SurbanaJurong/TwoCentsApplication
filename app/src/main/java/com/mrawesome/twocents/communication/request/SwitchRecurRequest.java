package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.data.Event;

/**
 * Created by mrawesome on 14/5/17.
 */

public class SwitchRecurRequest implements Request {

    private String eventId;
    private Event.EventMode mode;

    SwitchRecurRequest(String eventId, Event.EventMode mode) {
        this.eventId = eventId;
        this.mode = mode;
    }

    @Override
    public RequestType type() {
        return RequestType.SwitchRecur;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
