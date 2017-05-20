package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.data.Profile;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventRegisterRequest extends Request {

    private String username;
    private String eventId;

    EventRegisterRequest(String eventId) {
        this.username = Profile.getInstance().getUsername();
        this.eventId = eventId;
    }

    @Override
    public RequestType type() {
        return RequestType.EventRegister;
    }

    @Override
    public String getRequestParams() {
        append(RequestFactory.p_username, username);
        append(RequestFactory.e_eventId, eventId);
        return stringBuilder.toString();
    }
}
