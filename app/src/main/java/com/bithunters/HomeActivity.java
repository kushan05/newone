package com.bithunters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ImageButton notificationButton = (ImageButton) findViewById(R.id.notification);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationIntent = new Intent(HomeActivity.this, NotificationActivity.class);
                //notificationIntent.putExtra("email",mail);
                startActivity(notificationIntent);
            }
        });

        ImageButton confirmOutButton = (ImageButton) findViewById(R.id.confirm_out);
        confirmOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmOutIntent = new Intent(HomeActivity.this, ConfirmActivity.class);
                startActivity(confirmOutIntent);
            }
        });

        ImageButton applyLeaveButton = (ImageButton) findViewById(R.id.applyLeave);
        applyLeaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent applyLeaveIntent = new Intent(HomeActivity.this, LeaveApplyActivity.class);
               // applyLeaveIntent.putExtra("email",mail);
                startActivity(applyLeaveIntent);
            }
        });

        ImageButton confirmInBuutton = (ImageButton)findViewById(R.id.confirm_in);
        confirmInBuutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmInIntent = new Intent(HomeActivity.this , ConfirmInActivity.class);
                startActivity(confirmInIntent);
            }
        });
        ImageButton leavebalanceButton = (ImageButton)findViewById(R.id.leavebalace);
        leavebalanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent leavebalanceIntent = new Intent(HomeActivity.this , LeavebalanceActivity.class);
                startActivity(leavebalanceIntent);
            }
        });

        ImageButton logoutButton = (ImageButton)findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent = new Intent(HomeActivity.this , LoginActivity.class);
                startActivity(logoutIntent);
            }
        });

        ImageButton detailsButton = (ImageButton)findViewById(R.id.detail);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailsIntent = new Intent(HomeActivity.this , DetailsActivity.class);
                startActivity(detailsIntent);
            }
        });

        ImageButton rankButton = (ImageButton)findViewById(R.id.rank);
        rankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rankIntent = new Intent(HomeActivity.this , NamesActivity.class);
                startActivity(rankIntent);
            }
        });
    }
}
