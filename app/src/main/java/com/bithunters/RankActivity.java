package com.bithunters;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bithunters.leaveapply.LeaveApplyClient;
import com.bithunters.rank.RankClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RankActivity extends AppCompatActivity {
    private TextView nameView;
    private Button rankButton1,rankButton2,rankButton3,rankButton4,rankButton5;
    String userName,reviewee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        Intent intent = getIntent();
        userName = intent.getStringExtra("username");
        reviewee = intent.getStringExtra("useremail");

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginDetails",0);
        final String reviewer = sharedPreferences.getString("login_email","");


        nameView = (TextView)findViewById(R.id.tvname);
        rankButton1 = (Button)findViewById(R.id.rank1);
        rankButton2 = (Button)findViewById(R.id.rank2);
        rankButton3 = (Button)findViewById(R.id.rank3);
        rankButton4 = (Button)findViewById(R.id.rank4);
        rankButton5 = (Button)findViewById(R.id.rank5);

        nameView.setText(userName);


        rankButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                        .baseUrl(Config.API_DOMAIN)
                        .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = retrofitBuilder.build();
                RankClient client = retrofit.create(RankClient.class);
                Call<Response> call = client.giverank(reviewer,reviewee,1);
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Response responseBody = response.body();
                        if("success".equals(responseBody.getSuccess())) {
                            Toast.makeText(RankActivity.this, "give your feedback successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RankActivity.this, " not Success", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(RankActivity.this, "Error occurred " , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        rankButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                        .baseUrl(Config.API_DOMAIN)
                        .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = retrofitBuilder.build();
                RankClient client = retrofit.create(RankClient.class);
                Call<Response> call = client.giverank(reviewer,reviewee,2);
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Response responseBody = response.body();
                        if("success".equals(responseBody.getSuccess())) {
                            Toast.makeText(RankActivity.this, "give your feedback successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RankActivity.this, " not Success", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(RankActivity.this, "Error occurred " , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        rankButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                        .baseUrl(Config.API_DOMAIN)
                        .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = retrofitBuilder.build();
                RankClient client = retrofit.create(RankClient.class);
                Call<Response> call = client.giverank(reviewer,reviewee,3);
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Response responseBody = response.body();
                        if("success".equals(responseBody.getSuccess())) {
                            Toast.makeText(RankActivity.this, "give your feedback successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RankActivity.this, " not Success", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(RankActivity.this, "Error occurred " , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        rankButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                        .baseUrl(Config.API_DOMAIN)
                        .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = retrofitBuilder.build();
                RankClient client = retrofit.create(RankClient.class);
                Call<Response> call = client.giverank(reviewer,reviewee,4);
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Response responseBody = response.body();
                        if("success".equals(responseBody.getSuccess())) {
                            Toast.makeText(RankActivity.this, "give your feedback successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RankActivity.this, " not Success", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(RankActivity.this, "Error occurred " , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        rankButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                        .baseUrl(Config.API_DOMAIN)
                        .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = retrofitBuilder.build();
                RankClient client = retrofit.create(RankClient.class);
                Call<Response> call = client.giverank(reviewer,reviewee,5);
                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Response responseBody = response.body();
                        if("success".equals(responseBody.getSuccess())) {
                            Toast.makeText(RankActivity.this, "give your feedback successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RankActivity.this, " not Success", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(RankActivity.this, "Error occurred " , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
}
