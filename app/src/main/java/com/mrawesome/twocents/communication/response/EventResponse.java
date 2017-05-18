package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventResponse extends Response {

    private Event[] events;
    private Set<String> users = new HashSet<>();

    EventResponse(Event[] events) {
        this.events = events;
        for (Event event : events) {
            users.add(event.getHost());
            users.addAll(event.getUserRegistered());
            users.addAll(event.getParticipants());
        }
    }

    @Override
    public ResponseType type() {
        return ResponseType.Event;
    }

    @Override
    public Set<String> getUserIds() {
        return users;
    }

    @Override
    public Set<String> getEventIds() {
        return EMPTY;
    }
}
