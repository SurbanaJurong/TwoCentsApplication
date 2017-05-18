package com.mrawesome.twocents.communication.response;

import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class NullResponse extends Response {
    @Override
    public ResponseType type() {
        return ResponseType.Null;
    }

    @Override
    Set<String> getUserIds() {
        return EMPTY;
    }

    @Override
    Set<String> getEventIds() {
        return EMPTY;
    }
}
