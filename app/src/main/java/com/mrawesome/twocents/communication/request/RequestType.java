package com.mrawesome.twocents.communication.request;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrawesome on 14/5/17.
 */

public enum RequestType {
    ProfileCreate(0), ProfileEdit(1), InterestEdit(2), EventRegister(3), UserBookmark(4), EventCreate(5), EventEdit(6), SwitchRecur(7), EventVenueEdit(8), AttendanceMark(9), EventTimeEdit(10), UserSuggestion(11), CalendarRefresh(12), CommentPost(13);

    private int code;
    private static final Map<Integer, RequestType> index = new HashMap<>();

    RequestType(int code) {
        this.code = code;
    }

    static {
        for (RequestType r : EnumSet.allOf(RequestType.class)) {
            index.put(r.code, r);
        }
    }

    public int getCode() {
        return this.code;
    }

    public static RequestType valueOf(int code) {
        return index.get(code);
    }
}
