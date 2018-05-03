package com.bithunters.leaveapply;

import com.bithunters.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kushan on 1/23/18.
 */

public interface LeaveApplyClient {
    @POST("api/leaveapply")
    @FormUrlEncoded
    Call<Response> leaveapply(@Field("appliedtime") String time,
                              @Field("leavedate") String leaveStartDay,
                              @Field("empemail") String email,
                              @Field("leavetype") String leaveType,
                              @Field("noofdays") int leavedays);
}
