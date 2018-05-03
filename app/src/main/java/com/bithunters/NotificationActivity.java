package com.bithunters;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.bithunters.Config;
import com.bithunters.R;
import com.bithunters.login.APIClient;
import com.bithunters.notification.LeaveItem;
import com.bithunters.notification.NotificationAdapter;
import com.bithunters.notification.NotificationClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.*;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView.Adapter mNotificationAdapter;
    private RecyclerView mRecyclerViewNotifications;
    private List<LeaveItem> mLeaveItems;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("loginDetails", 0);
        String email = preferences.getString("login_email", null);

        mLeaveItems = new ArrayList<>();

        mRecyclerViewNotifications = (RecyclerView) findViewById(R.id.recyclerViewNotifications);
        mRecyclerViewNotifications.setHasFixedSize(true);
        mRecyclerViewNotifications.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Fetching Data...");
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.show();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Config.API_DOMAIN)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.build();
        NotificationClient client = retrofit.create(NotificationClient.class);
        Call<ArrayList<LeaveItem>> call = client.getNotifications(email);
        call.enqueue(new Callback<ArrayList<LeaveItem>>() {
            @Override
            public void onResponse(Call<ArrayList<LeaveItem>> call, Response<ArrayList<LeaveItem>> response) {
                mProgressDialog.dismiss();
                mLeaveItems = response.body();
                mNotificationAdapter = new NotificationAdapter(mLeaveItems);
                mRecyclerViewNotifications.setAdapter(mNotificationAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<LeaveItem>> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Error " + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
