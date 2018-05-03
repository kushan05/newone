package com.bithunters;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker;

import com.bithunters.leaveapply.LeaveApplyClient;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeaveApplyActivity extends AppCompatActivity {
    private Calendar calendar;
    private int year, month,day;
    private String leaveStartDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_apply);

        //final TypedArray styledAttributes = getTheme().obtainStyledAttributes(
               // new int[] { android.R.attr.actionBarSize });


        //final EditText emailInput = (EditText) findViewById(R.id.email);
        final EditText timeInput = (EditText) findViewById(R.id.time);
        final EditText leavedaysInput = (EditText) findViewById(R.id.leavedays);
        final TextView leaveStartDayInput = (TextView) findViewById(R.id.leavestartday);
        final Spinner leaveTypeInput = (Spinner) findViewById(R.id.leavetype);
        Button applyButton = (Button) findViewById(R.id.applybutton);

        //taking email from shared preferences
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginDetails",0);
        final String email = sharedPreferences.getString("login_email","");

        //taking current leaveStartDate
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        leaveStartDate = Integer.toString(month+1) + "/" + Integer.toString(day) + "/" + Integer.toString(year);

        leaveStartDayInput.setText(leaveStartDate);//set current date


        leavedaysInput.setInputType(InputType.TYPE_CLASS_NUMBER);//numbertype type


        leaveStartDayInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(LeaveApplyActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        year = datePicker.getYear();
                        month = datePicker.getMonth()+1;
                        day = datePicker.getDayOfMonth();
                        leaveStartDate = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
                        leaveStartDayInput.setText(leaveStartDate);
                        //Toast.makeText(getApplicationContext(),leaveStartDate, Toast.LENGTH_LONG).show();
                    }
                }, year, month, day).show();
            }
        });


        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    //taking current time
                    Date date =new Date();
                    DateFormat dateFormat = new DateFormat();
                    final String formattedTime = dateFormat.format("hh:mm:ss", date).toString();

                    int leavedays = Integer.parseInt(leavedaysInput.getText().toString());
                    String leavetype = leaveTypeInput.getSelectedItem().toString();


                        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                                .baseUrl(Config.API_DOMAIN)
                                .addConverterFactory(GsonConverterFactory.create());
                        Retrofit retrofit = retrofitBuilder.build();
                        LeaveApplyClient client = retrofit.create(LeaveApplyClient.class);
                        Call<Response> call = client.leaveapply(formattedTime, leaveStartDate, email, leavetype, leavedays);
                        call.enqueue(new Callback<Response>() {
                            @Override
                            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                                Response responseBody = response.body();
                                //Toast.makeText(LeaveApplyActivity.this, responseBody.getSuccess(), Toast.LENGTH_SHORT).show();
                                if("valid".equals(responseBody.getSuccess())) {
                                    Toast.makeText(LeaveApplyActivity.this, "Leave Apply Success", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(LeaveApplyActivity.this, "Leave Apply not Success", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Response> call, Throwable t) {
                                Toast.makeText(LeaveApplyActivity.this, "Error Leave Apply Failed " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

        });
    }
}
