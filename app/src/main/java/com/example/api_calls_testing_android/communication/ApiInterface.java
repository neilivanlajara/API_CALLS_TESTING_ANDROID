package com.example.api_calls_testing_android.communication;

import com.example.api_calls_testing_android.model.Artwork;
import com.example.api_calls_testing_android.model.SearchQuery;
import com.example.api_calls_testing_android.model.WholeDepartmentList;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {


    //Search
    @GET
    Call<SearchQuery> getSearchQuery(@Url String url);


    @GET
    Call<SearchQuery> getArtworkFromDepartment(@Url String url);
    @GET
    Call<Artwork> getObject(@Url String url);

    @GET
    Call<WholeDepartmentList> getWholeDepartmentList(@Url String url);
  /*  @POST("getTwok")
    Call<Twok> getSpecificTwokWithTid(@Body GetSpecificTwokTID getSpecificTwokTID);


    @POST("users")
    Call<Sid> getSid();

    @POST("getTwok")
    Call<Twok> getRandomTwok(@Body Sid sid);
    @POST("getTwok")
    Call<Twok> getSpecificTwok(@Body GetSpecificUserProfile getSpecificUserProfile);
    @POST("getFollowed")
    Call<List<UserListFollower>> getListFollowers(@Body Sid sid);
    @POST("follow")
    Call<Void> getFollow(@Body GetSpecificUserProfile getSpecificUserProfile);

    @POST("unfollow")
    Call<Void> getUnfollow(@Body GetSpecificUserProfile getSpecificUserProfile);
    @POST("getProfile")
    Call<User> getProfile(@Body Sid sid);

    @POST("isFollowed")
    Call<followed> followed(@Body GetSpecificUserProfile getSpecificUserProfile);

    @POST("getPictureAndBadge")
    Call<User> getPicture(@Body GetSpecificUserProfile getSpecificUserProfile);

    @POST("setProfile")
    Call<Void> setMyProfile(@Body SetMyProfile setMyProfile);

    @POST("addTwok")
    Call<AddTwok> addTwok(@Body AddTwok addTwok);
*/

}
