package com.mrawesome.twocents.communication.request;

/**
 * Created by mrawesome on 14/5/17.
 */

public abstract class Request {
    String SLASH = "/";
    String QUESTION = "?";
    String EQUAL = "=";
    abstract RequestType type();
    abstract String getRequestParams();

    protected StringBuilder stringBuilder = new StringBuilder().append(SLASH).append(type().getCode()).append(SLASH);

    protected void append(String key, Object value) {
        if (value != null) {
            stringBuilder.append(QUESTION).append(key).append(EQUAL).append(value);
        }
    }
}
