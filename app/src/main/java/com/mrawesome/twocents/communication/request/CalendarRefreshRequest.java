package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;

/**
 * Created by mrawesome on 14/5/17.
 */

public class CalendarRefreshRequest implements Request {

    private String username;

    CalendarRefreshRequest() {
        username = Profile.getInstance().getUsername();
    }

    @Override
    public RequestType type() {
        return RequestType.CalendarRefresh;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
