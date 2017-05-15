package com.mrawesome.twocents.communication.request;

/**
 * Created by mrawesome on 14/5/17.
 */

public interface Request {
    RequestType type();
    String getRequestParams();
}
