package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.data.User;

/**
 * Created by mrawesome on 14/5/17.
 */

public class UserResponse implements Response {

    private User[] users;

    UserResponse(User[] users) {
        this.users = users;
    }

    @Override
    public ResponseType type() {
        return ResponseType.User;
    }
}
