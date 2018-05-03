package com.bithunters.leavebalance;

import com.bithunters.leaveapply.Responses;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kushan on 1/27/2018.
 */

public interface LeavebalanceClient {

    @POST("api/availableleaves")
    @FormUrlEncoded
    Call<Responses> getleavebalance(@Field("email") String email);
}
