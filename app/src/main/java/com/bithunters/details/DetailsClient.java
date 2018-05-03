package com.bithunters.details;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kushan on 1/28/2018.
 */

public interface DetailsClient {

    @POST("api/employee")
    @FormUrlEncoded
    Call<Resposedetail> getdetails(@Field("email") String email);
}
