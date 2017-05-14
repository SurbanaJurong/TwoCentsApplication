package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.Event;

/**
 * Created by mrawesome on 14/5/17.
 */

public class EventResponse implements Response {

    private Event[] events;

    EventResponse(Event[] events) {
        this.events = events;
    }

    @Override
    public ResponseType type() {
        return ResponseType.Event;
    }
}
