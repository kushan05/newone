package com.bithunters;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bithunters.confirmout.ConfirmOutClient;
import com.bithunters.leaveapply.LeaveApplyClient;


import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfirmActivity extends AppCompatActivity {
    private Calendar calendar;
    private int year, month,day;
    private String FogotDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        //taking email from shared preferences
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginDetails",0);
        final String email = sharedPreferences.getString("login_email","");

        Date date =new Date();
        DateFormat dateFormat = new DateFormat();
        final String formattedDate = dateFormat.format("MM/dd/yyyy", date).toString();
        final String formattedTime = dateFormat.format("hh:mm:ss", date).toString();



        final EditText Content = (EditText) findViewById(R.id.content);
        final TextView fogotDate = (TextView)findViewById(R.id.fogotdate);
        Button confirmButton = (Button) findViewById(R.id.confirmbutton);


        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        FogotDate = Integer.toString(month+1) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
        fogotDate.setText(FogotDate);

        fogotDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        year = datePicker.getYear();
                        month = datePicker.getMonth()+1;
                        day = datePicker.getDayOfMonth();
                        FogotDate = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
                        fogotDate.setText(FogotDate);
                        //Toast.makeText(getApplicationContext(),leaveStartDate, Toast.LENGTH_LONG).show();
                    }
                }, year, month, day).show();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String ContentInput = Content.getText().toString();

                if("".equals(ContentInput)){
                    Content.setError("can't be empty");
                }
                else {
                    Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                            .baseUrl(Config.API_DOMAIN)
                            .addConverterFactory(GsonConverterFactory.create());
                    Retrofit retrofit = retrofitBuilder.build();
                    ConfirmOutClient client = retrofit.create(ConfirmOutClient.class);
                    Call<Response> call = client.confirmout(email, formattedTime, formattedDate, "bithuntersuom@gmail.com", "OUT :" + ContentInput+FogotDate);
                    call.enqueue(new Callback<Response>() {
                        @Override
                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                            Response responseBody = response.body();

                            if ("valid".equals(responseBody.getSuccess())) {
                                Toast.makeText(ConfirmActivity.this, "Your Confirm Success", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(ConfirmActivity.this, "Confirm  Failed", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Response> call, Throwable t) {
                            Toast.makeText(ConfirmActivity.this, "Error Confirm Failed " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }
}
