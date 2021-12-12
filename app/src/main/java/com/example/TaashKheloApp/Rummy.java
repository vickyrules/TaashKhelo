package com.example.TaashKheloApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static android.graphics.Color.*;

public class Rummy extends AppCompatActivity {

    Button p2,p3,p4,start;
    int player_num=2;
    EditText score_limit,p1_name,p2_name,p3_name,p4_name;
    LinearLayout p3_lay,p4_lay,start_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rummy);

        p2=(Button)findViewById(R.id.num_player_02);
        p3=(Button)findViewById(R.id.num_player_03);
        p4=(Button)findViewById(R.id.num_player_04);
        score_limit=(EditText)findViewById(R.id.score_input);
        start=(Button)findViewById(R.id.start_btn);

        p1_name=(EditText)findViewById(R.id.player_01_text);
        p2_name=(EditText)findViewById(R.id.player_02_text);
        p3_name=(EditText)findViewById(R.id.player_03_text);
        p4_name=(EditText)findViewById(R.id.player_04_text);
        score_limit=(EditText)findViewById(R.id.score_input);

        p3_lay=(LinearLayout)findViewById(R.id.player_03_layout);
        p4_lay=(LinearLayout)findViewById(R.id.player_04_layout);
        start_menu=(LinearLayout)findViewById(R.id.start_menu);





         Button[] clicked_previous = {p2};
        ColorStateList color_old = p2.getTextColors();
         ColorStateList color_new = p3.getTextColors();


        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                p2.setAlpha(1f);
                p2.setTextColor(color_old);
                p3.setTextColor(color_new);
                p4.setTextColor(color_new);
                p4.setAlpha(0.7f);
                p3.setAlpha(0.7f);

                p3_lay.setVisibility(View.GONE);
                p4_lay.setVisibility(View.GONE);

                player_num=2;



            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                p3.setAlpha(1f);
                p3.setTextColor(color_old);
                p2.setTextColor(color_new);
                p4.setTextColor(color_new);
                p2.setAlpha(0.7f);
                p4.setAlpha(0.7f);


                p3_lay.setVisibility(View.VISIBLE);
                p4_lay.setVisibility(View.GONE);
                player_num=3;

            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                p4.setAlpha(1f);
                p4.setTextColor(color_old);
                p2.setTextColor(color_new);
                p3.setTextColor(color_new);
                p2.setAlpha(0.7f);
                p3.setAlpha(0.7f);

                p4_lay.setVisibility(View.VISIBLE);
                p3_lay.setVisibility(View.VISIBLE);

                player_num=4;

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(score_limit.getText().toString())) {
                    score_limit.setError("This field can't be empty");
                }

                else {

                    FullscreenActivity.getInstance().play_Sound();
                    start.setAlpha(1f);
                    start.setTextColor(rgb(141, 36, 170));
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), RummyDashboard.class);
                    intent.putExtra("p1_name", p1_name.getText() + "");
                    intent.putExtra("p2_name", p2_name.getText() + "");
                    intent.putExtra("p3_name", p3_name.getText() + "");
                    intent.putExtra("p4_name", p4_name.getText() + "");

                    intent.putExtra("score_limit", Integer.parseInt(String.valueOf(score_limit.getText())));
                    intent.putExtra("player_num",player_num);


                    startActivity(intent);
                }
            }
        });



    }
}