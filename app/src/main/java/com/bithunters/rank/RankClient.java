package com.bithunters.rank;

import com.bithunters.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kushan on 2/1/2018.
 */

public interface RankClient {
    @POST("api/givefeedback")
    @FormUrlEncoded
    Call<Response> giverank (@Field("reviewer") String reviewer,
                              @Field("reviewee") String reviewee,
                              @Field("rank") int rank);
}
