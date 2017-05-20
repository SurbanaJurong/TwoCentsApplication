package com.mrawesome.twocents.communication;

import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.data.Profile;
import com.mrawesome.twocents.data.User;
import com.mrawesome.twocents.data.Venue;

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
    Call<Set<Interest>> addInterest(@Path("username") String username);

    @GET("event")
    Call<Set<Event>> getAllEvents();

    @GET("event/{username}")
    Call<Set<Event>> getEventByUser(@Path("username") String username);

    @POST("event")
    Call<Event> createEvent(@Body Event event);

    @GET("user")
    Call<Set<User>> getAllUsers();

    @GET("user/{username}")
    Call<Set<User>> getUserByUser(@Path("username") String username);

    @GET("user")
    Call<Set<User>> getUserByQuery(@Query("query") String query);

    @POST("user")
    Call<Profile> createUserProfile(@Body Profile profile);

    @GET("venue")
    Call<Set<Venue>> getAllVenues();

    @GET("venue/{venueId}")
    Call<Venue> getVenueById(@Path("venueId") String venueId);

    @POST("venue")
    Call<Venue> addNewVenue(@Body Venue venue);

    @GET("http://graph.facebook.com/me/photos")
    Call<String> testGetApi();
}
