package com.mrawesome.twocents.util;

import android.os.Bundle;
import com.mrawesome.twocents.communication.request.RequestFactory;
import com.mrawesome.twocents.data.Interest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class BundleWriter {

    private BundleWriter() {};

    public static Bundle packAttendanceMark(String eventId) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.e_eventId, eventId);
        return bundle;
    }

    public static Bundle packEventCreate(String eventName, String category, String description, String venueId, int minCapacity, int maxCapacity, Calendar startTime, int duration) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.e_eventName, eventName);
        bundle.putString(RequestFactory.e_category, category);
        bundle.putString(RequestFactory.e_description, description);
        bundle.putString(RequestFactory.e_venueId, venueId);
        bundle.putInt(RequestFactory.e_minCapacity, minCapacity);
        bundle.putInt(RequestFactory.e_maxCapacity, maxCapacity);
        bundle.putLong(RequestFactory.e_startTime, startTime.getTimeInMillis());
        bundle.putInt(RequestFactory.e_duration, duration);
        return bundle;
    }

    public static Bundle packEventEdit(String eventId, String description, String profilePic, Integer minCapacity, Integer maxCapacity) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.e_eventId, eventId);
        bundle.putString(RequestFactory.e_description, description);
        bundle.putString(RequestFactory.p_profilePic, profilePic);
        bundle.putInt(RequestFactory.e_minCapacity, minCapacity);
        bundle.putInt(RequestFactory.e_maxCapacity, maxCapacity);
        return bundle;
    }

    public static Bundle packEventRegister(String eventId) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.e_eventId, eventId);
        return bundle;
    }

    public static Bundle packEventTimeEdit(String eventId, Calendar startTime, Integer duration) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.e_eventId, eventId);
        bundle.putLong(RequestFactory.e_startTime, startTime.getTimeInMillis());
        bundle.putInt(RequestFactory.e_duration, duration);
        return bundle;
    }

    public static Bundle packEventVenueEdit(String eventId, String venueId) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.e_eventId, eventId);
        bundle.putString(RequestFactory.e_venueId, venueId);
        return bundle;
    }

    public static Bundle packInterestEdit(Set<Interest> interests) {
        Bundle bundle = new Bundle();
        ArrayList<String> strings = new ArrayList<>();
        for (Interest i : interests) {
            strings.add(i.getSubject());
        }
        bundle.putStringArrayList(RequestFactory.p_interests, strings);
        return bundle;
    }

    public static Bundle packProfileCreate(String username, String phoneNumber, String nric, String postalCode, int year) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.p_username, username);
        bundle.putString(RequestFactory.p_phoneNumber, phoneNumber);
        bundle.putString(RequestFactory.p_nric, nric);
        bundle.putString(RequestFactory.p_postalCode, postalCode);
        bundle.putInt(RequestFactory.p_year, year);
        return bundle;
    }

    public static Bundle packProfileEdit(String profilePic, String phoneNumber, String postalCode) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.p_profilePic, profilePic);
        bundle.putString(RequestFactory.p_phoneNumber, phoneNumber);
        bundle.putString(RequestFactory.p_postalCode, postalCode);
        return bundle;
    }

    public static Bundle packSwitchRecur(String eventId, int isRecurring) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.e_eventId, eventId);
        bundle.putInt(RequestFactory.e_isRecurring, isRecurring.getCode());
        return bundle;
    }

    public static Bundle packUserBookmark(String targetUsername) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.p_userBookmark, targetUsername);
        return bundle;
    }

    public static Bundle packCommentPost(String eventId, String comment) {
        Bundle bundle = new Bundle();
        bundle.putString(RequestFactory.e_eventId, eventId);
        bundle.putString(RequestFactory.e_comment, comment);
        return bundle;
    }
}
