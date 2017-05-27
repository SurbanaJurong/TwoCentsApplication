package com.mrawesome.twocents.communication;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mrawesome.twocents.data.persistent.Comment;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.data.persistent.Profile;
import com.mrawesome.twocents.data.persistent.User;
import com.mrawesome.twocents.data.persistent.Venue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mrawesome on 20/5/17.
 */

public interface ApiEndpointInterface {

    // Interest API
    @GET("interest")
    Call<List<Interest>> getAllInterests();

    @GET("interest/{interestId}")
    Call<Interest> getInterestById(@Path("interestId") int interestId);

    @POST("interest")
    Call<List<Interest>> addToInterest(@Body Interest interest);

    // Event API
    @GET("event")
    Call<List<Event>> getAllEvents();

    @GET("event/{eventId}")
    Call<Event> getEventById(@Path("eventId") int eventId);

    @GET("event")
    Call<List<Event>> getEventByInterest(@Query("interestId") int interestId);

    @POST("event")
    Call<Event> insertEvent(@Body Event event);

    // User API
    @GET("user")
    Call<List<User>> getAllUsers();

    @GET("user/{userId}")
    Call<User> getUserById(@Path("userId") int userId);

    @GET("user")
    Call<List<User>> getUserByQuery(@Query("query") String query);

    @POST("user")
    Call<JsonObject> insertUserProfile(@Body Profile profile);

    @PUT("user/")
    Call<Profile> confirmOTP(@Body JsonObject jsonObject);

    // Venue API
    @GET("venue")
    Call<List<Venue>> getAllVenues();

    @GET("venue/{venueId}")
    Call<Venue> getVenueById(@Path("venueId") int venueId);

    @POST("venue")
    Call<Venue> addNewVenue(@Body Venue venue);

    // Participation API
    @POST("participation")
    Call<Event> getAllParticipations();

    @GET("participation")
    Call<Event> getParticipationsByQuery(@Query("userId") String userId, @Query("eventId") String eventId);

    @POST("participation")
    Call<Event> markParticipation(@Body JsonObject jsonObject);

    // Event Bookmark API
    @GET("registration")
    Call<List<JsonObject>> getAllRegistration();

    @GET("registration")
    Call<List<JsonObject>> getRegistrationByQuery(@Query("userId") int userId, @Query("eventId") int eventId);

    @POST("registration")
    Call<JsonObject> insertRegistration(@Body JsonObject jsonObject);

    // User Interest API
    @GET("userinterest")
    Call<JsonArray> getAllUserInterests();

    @GET("userinterest")
    Call<JsonArray> getUserInterestsByQuery(@Query("userId") int userId, @Query("interestId") int interestId);

    @POST("userinterest")
    Call<JsonObject> registerInterest(JsonObject jsonObject);

    // Comment API
    @GET("comment")
    Call<List<Comment>> getAllComment();

    @GET("comment")
    Call<List<Comment>> getCommentByQuery(@Query("userId") int userId, @Query("eventId") int eventId);

    @POST("comment")
    Call<Comment> insertComment(@Body Comment comment);

    // User Bookmark API
    @GET("bookmarkuser")
    Call<List<JsonObject>> getAllUserBookmark();

    @GET("bookmarkuser")
    Call<List<JsonObject>> getUserBookmarkByQuery(@Query("userId") int userId, @Query("eventId") int eventId);

    @POST("bookmarkuser")
    Call<JsonObject> insertUserBookmark(@Body List<JsonObject> lists);

    @DELETE("bookmarkuser")
    Call<JsonObject> removeUserBookmark(@Body List<JsonObject> lists);
}
