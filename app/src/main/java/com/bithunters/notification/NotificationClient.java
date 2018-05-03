package com.bithunters.notification;

import com.bithunters.Response;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kushan on 1/23/18.
 */

public interface NotificationClient {
    @FormUrlEncoded
    @POST("api/leave")
    Call<ArrayList<LeaveItem>> getNotifications(@Field("email") String email);
}
