package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;
import com.mrawesome.twocents.communication.request.Request;
import com.mrawesome.twocents.communication.request.RequestType;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventRegisterRequest implements Request {

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
        return null;
    }
}
