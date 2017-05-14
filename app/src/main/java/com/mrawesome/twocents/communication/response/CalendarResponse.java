package com.mrawesome.twocents.communication.response;

/**
 * Created by mrawesome on 14/5/17.
 */

public class CalendarResponse implements Response {
    @Override
    public ResponseType type() {
        return ResponseType.Calendar;
    }
}
