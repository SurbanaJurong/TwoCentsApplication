package com.mrawesome.twocents.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrawesome on 20/5/17.
 */

public enum VenueStatus {
    Cancelled(0), Pending(1), Booked(2);

    private int code;
    private static Map<Integer, VenueStatus> index = new HashMap<>();

    VenueStatus(int code) {
        this.code = code;
    }

    static {
        for (VenueStatus v : EnumSet.allOf(VenueStatus.class)) {
            index.put(v.code, v);
        }
    }

    public int getCode() {
        return this.code;
    }

    public static VenueStatus valueOf(int code) {
        return index.get(code);
    }
}