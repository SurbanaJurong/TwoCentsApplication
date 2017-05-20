package com.mrawesome.twocents.communication.response;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public abstract class Response {
    Set<String> EMPTY = new HashSet<>();
    public String payload;
    abstract ResponseType type();
    abstract Set<String> getUserIds();
    abstract Set<String> getEventIds();
}
