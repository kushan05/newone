package com.bithunters;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bithunters.leaveapply.Responses;
import com.bithunters.leavebalance.LeavebalanceClient;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeavebalanceActivity extends AppCompatActivity {

    TextView medicalInput,annualInput,casualInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leavebalance);

         medicalInput = (TextView)findViewById(R.id.medicalnum1);
         annualInput = (TextView)findViewById(R.id.annualnum1);
         casualInput = (TextView)findViewById(R.id.casualnum1);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginDetails",0);
        final String email = sharedPreferences.getString("login_email","");

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Config.API_DOMAIN)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.build();
        LeavebalanceClient client = retrofit.create(LeavebalanceClient.class);
        Call<Responses> call = client.getleavebalance(email);
        call.enqueue(new Callback<Responses>() {
            @Override
            public void onResponse(Call<Responses> call, retrofit2.Response<Responses> response) {
                Responses Responsesbody = response.body();

                if("success".equals(Responsesbody.getSuccess())){
                    //Toast.makeText(getApplication(),""+Responsesbody.getMedical(),Toast.LENGTH_LONG).show();

                    medicalInput.setText(""+Responsesbody.getMedical());
                    annualInput.setText(""+Responsesbody.getAnnual());
                    casualInput.setText(""+Responsesbody.getCasual());

                }

                else {
                    Toast.makeText(LeavebalanceActivity.this,"error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Responses> call, Throwable t) {
                Toast.makeText(LeavebalanceActivity.this,"Error occur",Toast.LENGTH_LONG).show();
            }
        });
    }
}
