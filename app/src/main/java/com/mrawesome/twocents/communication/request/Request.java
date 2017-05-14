package com.mrawesome.twocents.communication.request;

/**
 * Created by mrawesome on 14/5/17.
 */

public interface Request {
    public RequestType type();
    public String getRequestParams();
}
