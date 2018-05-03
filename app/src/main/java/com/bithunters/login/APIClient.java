package com.bithunters.login;

import com.bithunters.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kushan on 1/22/18.
 */

public interface APIClient {
    @POST("api/loginattempt")
    @FormUrlEncoded
    Call<Response> login(@Field("useremail") String username,
                         @Field("password") String password);
}
