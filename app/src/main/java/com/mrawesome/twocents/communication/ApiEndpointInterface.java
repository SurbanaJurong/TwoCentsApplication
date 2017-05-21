package com.mrawesome.twocents.communication;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

    // Interest API
    @GET("interest")
    Call<Set<Interest>> getAllInterests();

    @GET("interest/{username}")
    Call<Set<Interest>> getInterestByUser(@Path("username") String username);

    @POST("interest/")
    Call<Set<Interest>> addToInterest(@Body Set<Interest> interests);

    // Event API
    @GET("event")
    Call<Set<Event>> getAllEvents();

    @GET("event/{username}")
    Call<Set<Event>> getEventByUser(@Path("username") String username);

    @POST("event")
    Call<Event> insertEvent(@Body Event event);

    // User API
    @GET("user")
    Call<Set<User>> getAllUsers();

    @GET("user/{username}")
    Call<Set<User>> getUserByUser(@Path("username") String username);

    @GET("user")
    Call<Set<User>> getUserByQuery(@Query("query") String query);

    @POST("user")
    Call<Profile> insertUserProfile(@Body Profile profile);

    // Venue API
    @GET("venue")
    Call<Set<Venue>> getAllVenues();

    @GET("venue/{venueId}")
    Call<Venue> getVenueById(@Path("venueId") String venueId);

    @POST("venue")
    Call<Venue> addNewVenue(@Body Venue venue);

    // Participation API
    @POST("participation")
    Call<Event> getAllParticipations();

    @GET("participation")
    Call<Event> getParticipationsByQuery(@Query("userId") String userId, @Query("eventId") String eventId);

    @POST("participation")
    Call<Event> markParticipation(@Body JsonObject jsonObject);

    // User Interest API
    @GET("userinterest")
    Call<JsonArray> getAllUserInterests();

    @GET("userinterest")
    Call<JsonArray> getUserInterestsByQuery(@Query("userId") String userId, @Query("interestId") String interestId);

    @POST("userinterest")
    Call<JsonObject> registerInterest(JsonObject jsonObject);

    // pending API
    @POST("postComment")
    Call<Set<Comment>> postComment(@Body Comment comment);

    @POST("bookmarkUser")
    Call<JsonObject> bookmarkUser(@Body JsonObject jsonObject);

    @POST("bookmarkEvent")
    Call<JsonObject> bookmarkEvent(@Body JsonObject jsonObject);

    //debug
    @GET("http://graph.facebook.com/me/photos")
    Call<String> testGetApi();
}
