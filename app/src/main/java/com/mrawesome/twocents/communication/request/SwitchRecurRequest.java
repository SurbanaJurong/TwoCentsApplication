package com.mrawesome.twocents.communication.request;

/**
 * Created by mrawesome on 14/5/17.
 */

public class SwitchRecurRequest extends Request {

    private String eventId;
    private int mode;

    SwitchRecurRequest(String eventId, int mode) {
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
        append(RequestFactory.e_isRecurring, mode);
        return stringBuilder.toString();
    }
}
