package com.mrawesome.twocents.communication;

import com.mrawesome.twocents.data.persistent.Comment;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.data.persistent.Profile;
import com.mrawesome.twocents.data.persistent.User;
import com.mrawesome.twocents.data.persistent.Venue;

import java.util.Set;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mrawesome on 20/5/17.
 */

public interface ApiEndpointInterface {

    @GET("interest")
    Call<Set<Interest>> getAllInterests();

    @GET("interest/{username}")
    Call<Set<Interest>> getInterestByUser(@Path("username") String username);

    @POST("interest/{username}")
    Call<Set<Interest>> setUserInterests(@Path("username") String username, @Body Set<Interest> interests);

    @GET("event")
    Call<Set<Event>> getAllEvents();

    @GET("event/{username}")
    Call<Set<Event>> getEventByUser(@Path("username") String username);

    @POST("event")
    Call<Event> insertEvent(@Body Event event);

    @GET("user")
    Call<Set<User>> getAllUsers();

    @GET("user/{username}")
    Call<Set<User>> getUserByUser(@Path("username") String username);

    @GET("user")
    Call<Set<User>> getUserByQuery(@Query("query") String query);

    @POST("user")
    Call<Profile> insertUserProfile(@Body Profile profile);

    @GET("venue")
    Call<Set<Venue>> getAllVenues();

    @GET("venue/{venueId}")
    Call<Venue> getVenueById(@Path("venueId") String venueId);

    @POST("venue")
    Call<Venue> addNewVenue(@Body Venue venue);

    @GET("http://graph.facebook.com/me/photos")
    Call<String> testGetApi();

    @POST("event/attend/{username}")
    Call<Event> markAttendance(@Path("username") String username, @Body Event event);

    @POST("event/{eventId}")
    Call<Event> postComment(@Path("eventId") String eventId, @Body Comment comment);

    @POST("event/join/{username}")
    Call<Event> registerEvent(@Path("username") String username, @Body Event event);
}
