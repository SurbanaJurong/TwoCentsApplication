package com.mrawesome.twocents.communication.request;

import android.content.res.Resources;
import android.os.Bundle;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.Event;

import java.util.ArrayList;

/**
 * Created by mrawesome on 14/5/17.
 */

public class RequestFactory {
    
    public static final String p_username = "username";
    public static final String p_profilePic = "profilePic";
    public static final String p_phoneNumber = "phoneNumber";
    public static final String p_nric = "nric";
    public static final String p_postalCode = "postalCode";
    public static final String p_year = "year";
    public static final String p_interests = "interests";
    public static final String p_eventRegister = "eventRegister";
    public static final String p_userBookmark = "userBookmark";

    public static final String e_eventId = "eventId";
    public static final String e_profilePic = "profilePic";
    public static final String e_description = "description";
    public static final String e_isRecurring = "isRecurring";
    public static final String e_venueId = "venueId";
    public static final String e_comment = "comment";
    public static final String e_minCapacity = "minCapacity";
    public static final String e_maxCapacity = "maxCapacity";
    public static final String e_startTime = "startTime";
    public static final String e_duration = "duration";

    private RequestFactory() {};

    public static Request newRequest(RequestType requestType, Bundle payload) {
        switch (requestType) {
            case CalendarRefresh:
                return newCalendarRefreshRequest();
            case EventCreate:
                return newEventCreateRequest(payload);
            case EventEdit:
                return newEventEditRequest(payload);
            case EventRegister:
                return newEventRegisterRequest(payload);
            case EventTimeEdit:
                return newEventTimeEditRequest(payload);
            case EventVenueEdit:
                return newEventVenueEditRequest(payload);
            case InterestEdit:
                return newInterestEditRequest(payload);
            case ProfileCreate:
                return newProfileCreateRequest(payload);
            case ProfileEdit:
                return newProfileEditRequest(payload);
            case SwitchRecur:
                return newSwitchRecurRequest(payload);
            case UserBookmark:
                return newUserBookmarkRequest(payload);
            case UserSuggestion:
                return newUserSuggestionRequest();
            case CommentPost:
                return newCommentPostRequest(payload);
            default:
                return newAttendanceMarkRequest(payload);
        }
    }

    private static AttendanceMarkRequest newAttendanceMarkRequest(Bundle payload) {
        String eventId = payload.getString(e_eventId);
        return new AttendanceMarkRequest(eventId);
    }

    private static CalendarRefreshRequest newCalendarRefreshRequest() {
        return new CalendarRefreshRequest();
    }

    private static EventCreateRequest newEventCreateRequest(Bundle payload) {
        String description = payload.getString(e_description);
        int isRecurring = payload.getInt(e_isRecurring);
        String venueId = payload.getString(e_venueId);
        int minCapacity = payload.getInt(e_minCapacity);
        int maxCapacity = payload.getInt(e_maxCapacity);
        long startTime = payload.getLong(e_startTime);
        int duration = payload.getInt(e_duration);
        return new EventCreateRequest(description, Event.EventMode.valueOf(isRecurring), venueId, minCapacity, maxCapacity, startTime, duration);
    }

    private static EventEditRequest newEventEditRequest(Bundle payload) {
        String eventId = payload.getString(e_eventId);
        EventEditRequest request = new EventEditRequest(eventId);
        request.setDescription(payload.getString(e_description));
        request.setProfilePic(payload.getString(e_profilePic));
        request.setMinCapacity(payload.getInt(e_minCapacity));
        request.setMaxCapacity(payload.getInt(e_maxCapacity));
        return request;
    }

    private static EventRegisterRequest newEventRegisterRequest(Bundle payload) {
        String eventId = payload.getString(p_eventRegister);
        return new EventRegisterRequest(eventId);
    }

    private static EventTimeEditRequest newEventTimeEditRequest(Bundle payload) {
        String eventId = payload.getString(e_eventId);
        EventTimeEditRequest request = new EventTimeEditRequest(eventId);
        request.setStartTime(payload.getLong(e_startTime));
        request.setDuration(payload.getInt(e_duration));
        return request;
    }

    private static EventVenueEditRequest newEventVenueEditRequest(Bundle payload) {
        String eventId = payload.getString(e_eventId);
        String venueId = payload.getString(e_venueId);
        return new EventVenueEditRequest(eventId, venueId);
    }

    private static InterestEditRequest newInterestEditRequest(Bundle payload) {
        ArrayList<String> interests = payload.getStringArrayList(p_interests);
        return new InterestEditRequest(interests);
    }

    private static ProfileCreateRequest newProfileCreateRequest(Bundle payload) {
        String username = payload.getString(p_username);
        String phoneNumber = payload.getString(p_phoneNumber);
        String nric = payload.getString(p_nric);
        String postalCode = payload.getString(p_postalCode);
        int year = payload.getInt(p_year);
        return new ProfileCreateRequest(username, phoneNumber, nric, postalCode, year);
    }

    private static ProfileEditRequest newProfileEditRequest(Bundle payload) {
        ProfileEditRequest request = new ProfileEditRequest();
        request.setProfilePic(payload.getString(p_profilePic));
        request.setPhoneNumber(payload.getString(p_phoneNumber));
        request.setPostalCode(payload.getString(p_postalCode));
        return request;
    }

    private static SwitchRecurRequest newSwitchRecurRequest(Bundle payload) {
        String eventId = payload.getString(e_eventId);
        int isRecurring = payload.getInt(e_isRecurring);
        return new SwitchRecurRequest(eventId, Event.EventMode.valueOf(isRecurring));
    }

    private static UserBookmarkRequest newUserBookmarkRequest(Bundle payload) {
        String targetUsername = payload.getString(p_userBookmark);
        return new UserBookmarkRequest(targetUsername);
    }

    private static UserSuggestionRequest newUserSuggestionRequest() {
        return new UserSuggestionRequest();
    }

    private static CommentPostRequest newCommentPostRequest(Bundle payload) {
        String eventId = payload.getString(e_eventId);
        String comment = payload.getString(e_comment);
        return new CommentPostRequest(eventId, comment);
    }
}
