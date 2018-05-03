package com.bithunters;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bithunters.details.DetailsClient;
import com.bithunters.details.Resposedetail;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {
    TextView firstnameInput,middlenameInput,lastnameInput,dobInput,emailInput,workhourInput,dateInput,categoryInput,
                departmentInput,descriptionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        firstnameInput = (TextView)findViewById(R.id.first);
        lastnameInput = (TextView)findViewById(R.id.last);
        dobInput = (TextView)findViewById(R.id.dob);
        emailInput = (TextView)findViewById(R.id.mail);
        workhourInput = (TextView)findViewById(R.id.hours);
        dateInput = (TextView)findViewById(R.id.sdate);
        categoryInput = (TextView)findViewById(R.id.category);
        departmentInput = (TextView)findViewById(R.id.department);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginDetails",0);
        final String email = sharedPreferences.getString("login_email","");

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Config.API_DOMAIN)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.build();
        DetailsClient client = retrofit.create(DetailsClient.class);
        Call<Resposedetail> call = client.getdetails(email);
        call.enqueue(new Callback<Resposedetail>() {
            @Override
            public void onResponse(Call<Resposedetail> call, retrofit2.Response<Resposedetail> response) {
                Resposedetail Responsebody = response.body();
                if("valid".equals(Responsebody.getSuccess())){

                    firstnameInput.setText(Responsebody.getFirstname());
                    lastnameInput.setText(Responsebody.getLastname());
                    dobInput.setText(Responsebody.getDob());
                    emailInput.setText(Responsebody.getEmail());
                    workhourInput.setText(Responsebody.getWorkinghours());
                    dateInput.setText(Responsebody.getStartdate());
                    categoryInput.setText(Responsebody.getCategory());
                    departmentInput.setText(Responsebody.getDepartment());


                }

                else {
                    Toast.makeText(DetailsActivity.this,"error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Resposedetail> call, Throwable t) {
                Toast.makeText(DetailsActivity.this,"Error occur",Toast.LENGTH_LONG).show();

            }
        });
    }
}
