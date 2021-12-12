package com.example.TaashKheloApp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RummyDashboard extends AppCompatActivity {

    int[] total_list = {0,0,0,0};
    int i=0,j=0,k=0,l=0;
    TextView p1_name_label;
    TextView p2_name_label;
    TextView p3_name_label;
    TextView p4_name_label;
    TextView score_label ,p1_score,p2_score,p3_score,p4_score,winner_label,closed_btn,lang_btn,instruction_list,instruction_title;
    EditText p1_score_limit,p2_score_limit,p3_score_limit,p4_score_limit;
    Button p1,p2,p3,p4;
    int score_limit,player_num;
    LinearLayout play_03,play_04;
    RelativeLayout instruct;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rummy_dashboard);

        Intent caller = getIntent();
        play_03=(LinearLayout)findViewById(R.id.player_03_layout);
        play_04=(LinearLayout)findViewById(R.id.player_04_layout);

        String p1_name =caller.getStringExtra("p1_name");
         String p2_name =caller.getStringExtra("p2_name");
         String p3_name =caller.getStringExtra("p3_name");
         String p4_name =caller.getStringExtra("p4_name");
         score_limit=caller.getIntExtra("score_limit",0);
         player_num=caller.getIntExtra("player_num",0);

        if(player_num==2)
        {
            play_03.setVisibility(View.INVISIBLE);
            play_04.setVisibility(View.INVISIBLE);

        }
        else if(player_num==3)
        {

            play_04.setVisibility(View.INVISIBLE);

        }if(player_num==4)
        {
            play_03.setVisibility(View.VISIBLE);
            play_04.setVisibility(View.VISIBLE);

        }






        p1_name_label=(TextView) findViewById(R.id.player_01_name);
        p2_name_label=(TextView) findViewById(R.id.player_02_name);
        p3_name_label=(TextView) findViewById(R.id.player_03_name);
        p4_name_label=(TextView) findViewById(R.id.player_04_name);

        score_label=(TextView) findViewById(R.id.score_label);
        closed_btn=(TextView) findViewById(R.id.close_btn);
        lang_btn=(TextView) findViewById(R.id.lang_btn);
        instruction_title=(TextView) findViewById(R.id.instruction_title);
        instruction_list=(TextView) findViewById(R.id.instructions_list);
        p1_score=(TextView) findViewById(R.id.player_01_score);
        p2_score=(TextView) findViewById(R.id.player_02_score);
        p3_score=(TextView) findViewById(R.id.player_03_score);
        p4_score=(TextView) findViewById(R.id.player_04_score);
        p1_score_limit=(EditText) findViewById(R.id.player_01_score_input);
        p2_score_limit=(EditText) findViewById(R.id.player_02_score_input);
        p3_score_limit=(EditText) findViewById(R.id.player_03_score_input);
        p4_score_limit=(EditText) findViewById(R.id.player_04_score_input);
        winner_label=(TextView) findViewById(R.id.winner_label);
        instruct=(RelativeLayout)findViewById(R.id.instruction_lay);

        score_label.setText(new StringBuilder().append(score_label.getText().toString()).append(score_limit).toString());

        p1=(Button)findViewById(R.id.plus_btn_1);
        p2=(Button)findViewById(R.id.plus_btn_2);
        p3=(Button)findViewById(R.id.plus_btn_3);
        p4=(Button)findViewById(R.id.plus_btn_4);
        lang_btn.setText("हिंदी");







        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FullscreenActivity.getInstance().play_Sound();

                if(TextUtils.isEmpty(p1_score_limit.getText().toString()))
                {
                    p1_score_limit.setError("Enter pts.first");
                }


                else {
                    total_list[0] += Integer.parseInt(String.valueOf(p1_score_limit.getText()));
                    p1_score.setText(total_list[0] + "");
                    i++;

                    p1_score_limit.setText("");
                }
            }
        });

         p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                if(TextUtils.isEmpty(p2_score_limit.getText().toString()))
                {
                    p2_score_limit.setError("Enter pts.first");

                }

                else {
                    total_list[1] += Integer.parseInt(String.valueOf(p2_score_limit.getText()));
                    p2_score.setText(total_list[1] + "");
                    j++;
                    if(player_num==2) {
                        if (i == j && j == i  && (total_list[0] >= score_limit || total_list[1] >= score_limit )) {
                            check_Winner();
                        }
                    }
                    p2_score_limit.setText("");
                }

            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FullscreenActivity.getInstance().play_Sound();

                if(TextUtils.isEmpty(p3_score_limit.getText().toString()))
                {
                    p3_score_limit.setError("Enter pts.first");
                }



                else {
                    total_list[2] += Integer.parseInt(String.valueOf(p3_score_limit.getText()));
                    p3_score.setText(total_list[2] + "");
                    k++;
                    if(player_num==3) {
                        if (i == j && j == k && k == i && (total_list[0] >= score_limit || total_list[1] >= score_limit || total_list[2] >= score_limit)) {
                            check_Winner();
                        }
                    }
                    p3_score_limit.setText("");
                }

            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();


                if(TextUtils.isEmpty(p4_score_limit.getText().toString()))
                {
                    p4_score_limit.setError("Enter pts.first");
                }

                else {
                    total_list[3] += Integer.parseInt(String.valueOf(p4_score_limit.getText()));
                    p4_score.setText(total_list[3] + "");
                      l++;
                      if(player_num==4) {
                          if (i == j && j == k && k == l && l == i && (total_list[0] >= score_limit || total_list[1] >= score_limit || total_list[2] >= score_limit || total_list[3] >= score_limit)) {
                              check_Winner();
                          }
                      }
                    p4_score_limit.setText("");

                }

            }
        });

        closed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    FullscreenActivity.getInstance().play_Sound();
                    instruct.setVisibility(View.GONE);
            }
        });

        lang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(lang_btn.getText().toString().equals("हिंदी"))
                {
                    lang_btn.setText("English");
                    instruction_title.setText("निर्देश");
                    instruction_list.setText("1. सबसे पहले खिलाड़ी_01 के अंक डालें| \n\n2. अंत में अंतिम खिलाड़ी के अंक दर्ज करें अर्थात (खिलाड़ी_02 अगर 2 खेल रहे हैं), (खिलाड़ी_03 अगर 3 खेल रहे हैं), (खिलाड़ी_04 अगर 4 खेल रहे हैं|)\n\n3. जिस खिलाड़ी के सबसे कम अंक होंगे वह खेल  जीतेगा| \n\n4.जो खिलाड़ी पहले अंक सीमा पर पहुंचेगा वह खेल हार जाएगा| ");
                }
                else if(lang_btn.getText().toString().equals("English"))
                {
                    lang_btn.setText("हिंदी");
                    instruction_title.setText("Instructions");
                    instruction_list.setText("1. At first enter the points of player_01. \n\n2.At last enter the points of the last player i.e (player_02 if playing 2), (player_03 if playing 3), (player_04 if playing 4. \n\n3. The player with the lowest points will win the game. \n\n4. The player who reaches the point limit first will lose the game. ");

                }

            }
        });




        if(p1_name.isEmpty())
        {
            p1_name="Player 01";
        }
        p1_name_label.setText(p1_name);
        if(p2_name.isEmpty())
        {
            p2_name="Player 02";
        }
        p2_name_label.setText(p2_name+"");
        if(p3_name.isEmpty())
        {
            p3_name="Player 03";
        }
        p3_name_label.setText(p3_name);
        if(p4_name.isEmpty())
        {
            p4_name="Player 04";
        }
        p4_name_label.setText(p4_name);

        //




    }


    public void check_Winner()
    {
        FullscreenActivity.getInstance().play_Celebrate();

        StringBuilder result = new StringBuilder("👑\n"+"😀 ");

        if(player_num==2) {
            if (total_list[0] < total_list[1]  ) {
                result.append(p1_name_label.getText().toString());
            } else if (total_list[1] < total_list[0] ) {
                result.append(p2_name_label.getText().toString());
            }
            else
            {
                result.append("Tied\n Both");
            }

        }

        else if(player_num==3) {
            if (total_list[0] < total_list[1] && total_list[0] < total_list[2] ) {
                result.append(p1_name_label.getText().toString());
            } else if (total_list[1] < total_list[0] && total_list[1] < total_list[2]) {
                result.append(p2_name_label.getText().toString());
            } else if (total_list[2] < total_list[0] && total_list[2] < total_list[1] ) {
                result.append(p3_name_label.getText().toString());
            }
            else if(total_list[1]==total_list[0]||total_list[0]==total_list[2]||total_list[1]==total_list[2])
            {
                result.append("Tied \nNo one ");
            }

        }

        else if(player_num==4) {
            if (total_list[0] < total_list[1] && total_list[0] < total_list[2] && total_list[0] < total_list[3]) {
                result.append(p1_name_label.getText().toString());
            } else if (total_list[1] < total_list[0] && total_list[1] < total_list[2] && total_list[1] < total_list[3]) {
                result.append(p2_name_label.getText().toString());
            } else if (total_list[2] < total_list[0] && total_list[2] < total_list[1] && total_list[2] < total_list[3]) {
                result.append(p3_name_label.getText().toString());
            } else if (total_list[3] < total_list[1] && total_list[3] < total_list[2] && total_list[3] < total_list[0]) {
                result.append(p4_name_label.getText().toString());
            }
            else if(total_list[1]==total_list[0]||total_list[0]==total_list[2]||total_list[0]==total_list[3]||total_list[1]==total_list[3]||total_list[2]==total_list[3]||total_list[2]==total_list[1])
            {
                result.append("Tied \nNo one ");
            }
        }
        result.append(" 😀\n"+"Wins the Game");
        winner_label.setText(result);
        winner_label.setVisibility(View.VISIBLE);
        p1_score_limit.setVisibility(View.GONE);
        p2_score_limit.setVisibility(View.GONE);
        p3_score_limit.setVisibility(View.GONE);
        p4_score_limit.setVisibility(View.GONE);

    }

    //exit confirmation'

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
          new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Closing Activity").setMessage("You want to exit:")
                  .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                })
                .setNegativeButton("No",null).show();
    }




}