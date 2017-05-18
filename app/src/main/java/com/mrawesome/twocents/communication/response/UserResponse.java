package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.User;

import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class UserResponse extends Response {

    private User[] users;

    UserResponse(User[] users) {
        this.users = users;
    }

    @Override
    public ResponseType type() {
        return ResponseType.User;
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
