package com.example.TaashKheloApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.graphics.Color.rgb;

public class Thirteen extends AppCompatActivity {


    Button p2,p3,p4,start;

    EditText p1_name,p2_name,p3_name,p4_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteen);


        start = (Button) findViewById(R.id.start_btn);

        p1_name = (EditText) findViewById(R.id.player_01_text);
        p2_name = (EditText) findViewById(R.id.player_02_text);
        p3_name = (EditText) findViewById(R.id.player_03_text);
        p4_name = (EditText) findViewById(R.id.player_04_text);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FullscreenActivity.getInstance().play_Sound();
                start.setAlpha(1f);
                start.setTextColor(rgb(141, 36, 170));
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), ThirteenDashboard.class);
                intent.putExtra("p1_name", p1_name.getText() + "");
                intent.putExtra("p2_name", p2_name.getText() + "");
                intent.putExtra("p3_name", p3_name.getText() + "");
                intent.putExtra("p4_name", p4_name.getText() + "");

                startActivity(intent);

            }
        });

    }


    }










