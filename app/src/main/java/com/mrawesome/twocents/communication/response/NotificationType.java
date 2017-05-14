package com.mrawesome.twocents.communication.response;

import com.mrawesome.twocents.communication.request.RequestType;
import com.mrawesome.twocents.data.Notification;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrawesome on 14/5/17.
 */

public enum NotificationType {
    Invitation(0), EventCreated(1), EventUpdatedTime(2), EventUpdatedVenue(3);

    private int code;
    private static final Map<Integer, NotificationType> index = new HashMap<>();

    NotificationType(int code) {
        this.code = code;
    }

    static {
        for (NotificationType n : EnumSet.allOf(NotificationType.class)) {
            index.put(n.code, n);
        }
    }

    public int getCode() {
        return this.code;
    }

    public static NotificationType valueOf(int code) {
        return index.get(code);
    }
}
