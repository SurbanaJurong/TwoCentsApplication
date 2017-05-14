package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.communication.request.RequestType;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrawesome on 14/5/17.
 */

public enum ResponseType {
    Profile(0), Calendar(1), Event(2), User(3), Notification(4), Null(5);

    private int code;
    private static final Map<Integer, ResponseType> index = new HashMap<>();

    ResponseType(int code) {
        this.code = code;
    }

    static {
        for (ResponseType r : EnumSet.allOf(ResponseType.class)) {
            index.put(r.code, r);
        }
    }

    public int getCode() {
        return this.code;
    }

    public static ResponseType valueOf(int code) {
        return index.get(code);
    }
}
