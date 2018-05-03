package com.bithunters.confirmout;

import com.bithunters.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by nilupul on 1/23/18.
 */

public interface ConfirmOutClient {
    @POST("api/sendmessage") //Change
    @FormUrlEncoded
    Call<Response> confirmout(@Field("sender") String email,
                              @Field("time") String time,
                              @Field("date") String date,
                              @Field("reciever") String receiveremail,
                              @Field("content") String content);
}
