package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.data.Event;

/**
 * Created by mrawesome on 14/5/17.
 */

public class SwitchRecurRequest extends Request {

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
        append(RequestFactory.e_eventId, eventId);
        append(RequestFactory.e_isRecurring, mode.getCode());
        return stringBuilder.toString();
    }
}
