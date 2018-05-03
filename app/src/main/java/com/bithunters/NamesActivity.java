package com.bithunters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class NamesActivity extends AppCompatActivity {
    private  Button selectButton;
    private Spinner namespinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        selectButton = (Button)findViewById(R.id.select);
        namespinner = (Spinner)findViewById(R.id.name);

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedname = namespinner.getSelectedItem().toString();
                if("SANDARUWAN".equals(selectedname)){
                    Intent intent1 = new Intent(NamesActivity.this,RankActivity.class);
                    intent1.putExtra("username",selectedname);
                    intent1.putExtra("useremail","sanda@gmail.com");
                    startActivity(intent1);
                }

                else if("KUSHAN".equals(selectedname)){
                    Intent intent2 = new Intent(NamesActivity.this,RankActivity.class);
                    intent2.putExtra("username",selectedname);
                    intent2.putExtra("useremail","kushan@gmail.com");
                    startActivity(intent2);
                }

                else if("RANGA".equals(selectedname)){
                    Intent intent3 = new Intent(NamesActivity.this,RankActivity.class);
                    intent3.putExtra("username",selectedname);
                    intent3.putExtra("useremail","ranga@gmail.com");
                    startActivity(intent3);
                }

                else if("SUDARAKA".equals(selectedname)){
                    Intent intent4 = new Intent(NamesActivity.this,RankActivity.class);
                    intent4.putExtra("username",selectedname);
                    intent4.putExtra("useremail","sudaraka@hotmail.com");
                    startActivity(intent4);
                }

                else{
                    Intent intent5 = new Intent(NamesActivity.this,RankActivity.class);
                    intent5.putExtra("username",selectedname);
                    intent5.putExtra("useremail","hashini@gmail.com");
                    startActivity(intent5);

                }
            }
        });

    }
}
