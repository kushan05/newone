package com.bithunters;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bithunters.login.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText userNameInput = (EditText) findViewById(R.id.username);
        //userNameInput.setText("sanda@gmail.com");
        final EditText passwordInput = (EditText) findViewById(R.id.password);
        //passwordInput.setText("123456");
        Button loginButton = (Button) findViewById(R.id.login_button);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressDialog = new ProgressDialog(LoginActivity.this);
                mProgressDialog.setTitle("Logging In...");
                mProgressDialog.setMessage("Please wait...");


                final String username = userNameInput.getText().toString();
                final String password = passwordInput.getText().toString();

                if("".equals(username)) {
                    userNameInput.setError("Can't be empty");
                } else if("".equals(password)) {
                    passwordInput.setError("Can't be empty");
                } else {
                    mProgressDialog.show();
                    Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                            .baseUrl(Config.API_DOMAIN)
                            .addConverterFactory(GsonConverterFactory.create());
                    Retrofit retrofit = retrofitBuilder.build();
                    APIClient client = retrofit.create(APIClient.class);
                    Call<Response> call = client.login(username, password); //APiclientlogin
                    call.enqueue(new Callback<Response>() {
                        @Override
                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                            mProgressDialog.dismiss();
                            Response responseBody = response.body();
                            //Toast.makeText(LoginActivity.this, responseBody.getSuccess(), Toast.LENGTH_SHORT).show();
                            if("valid".equals(responseBody.getSuccess())) {
                                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                                //saving email into shared preferences
                                SharedPreferences preferences = getApplicationContext().getSharedPreferences("loginDetails", 0);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("login_email", username);
                                editor.commit();

                                Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(homeIntent);
                            } else {
                                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Response> call, Throwable t) {
                            mProgressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "error occured " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }
}
