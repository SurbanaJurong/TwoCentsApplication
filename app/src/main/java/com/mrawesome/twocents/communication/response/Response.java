package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public interface Response {
    Set<String> EMPTY = new HashSet<>();
    ResponseType type();
    Set<String> getUserIds();
    Set<String> getEventIds();
}
