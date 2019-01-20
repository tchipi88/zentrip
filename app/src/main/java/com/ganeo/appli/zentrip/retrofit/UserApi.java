package com.ganeo.appli.zentrip.retrofit;


import com.ganeo.appli.zentrip.dto.User;
import com.ganeo.appli.zentrip.dto.password.KeyAndPasswordVM;
import com.ganeo.appli.zentrip.dto.retrofit.AccessToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by tchipnangngansopa on 17/12/2017.
 */

public interface UserApi {


    @GET("/api/firebase")
    Call<User> setFirebaseToken(@Query("token") String token);

    @POST("/api/account/reset_password/init")
    @FormUrlEncoded
    Call<Void> requestPasswordReset(@Field("mail") String mail);

    @POST("/api/account/change_password")
    @FormUrlEncoded
    Call<Void> changePassword(@Field("password") String password);

    @POST("/api/account/reset_password/finish")
    Call<Void> finishPasswordReset(@Body KeyAndPasswordVM keyAndPasswordVM);


    @FormUrlEncoded
    @POST("/oauth/token?grant_type=password")
    Call<AccessToken> getAccessToken(
            @Field("username") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/oauth/token?grant_type=refresh_token")
    Call<AccessToken> refreshAccessToken(
            @Field("refresh_token") String refreshToken
    );


}
