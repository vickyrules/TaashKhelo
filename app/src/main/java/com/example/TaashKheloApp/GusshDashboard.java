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
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.text.DecimalFormat;

public class GusshDashboard extends AppCompatActivity {

    TextView p1_name_label;
    TextView p2_name_label;
    TextView p3_name_label;
    TextView p4_name_label;

    double[] total_list = {0.0,0.0,0.0,0.0};
    String p1_name,p2_name,p3_name,p4_name;



    DecimalFormat format =new DecimalFormat("0.0");

    TextView score_label ,p1_score,p2_score,p3_score,p4_score,winner_label,current_label,instruction_title,instruction_list,lang_btn,closed_btn;
    EditText p1_score_limit,p2_score_limit,p3_score_limit,p4_score_limit;
    Button p1,p2,p3,p4,p11,p22,p33,p44;
    int  score_limit,p1_i=0,p2_i=0,p3_i=0,p4_i=0;
    RelativeLayout instruct;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gussh_dashboard);

        Intent caller = getIntent();


         p1_name =caller.getStringExtra("p1_name");
         p2_name =caller.getStringExtra("p2_name");
         p3_name =caller.getStringExtra("p3_name");
         p4_name =caller.getStringExtra("p4_name");
         score_limit=caller.getIntExtra("score_limit",0);


         try {



         }
         catch (NullPointerException e)
         {

         }








        p1_name_label=(TextView) findViewById(R.id.player_01_name);
        p2_name_label=(TextView) findViewById(R.id.player_02_name);
        p3_name_label=(TextView) findViewById(R.id.player_03_name);
        p4_name_label=(TextView) findViewById(R.id.player_04_name);

        score_label=(TextView) findViewById(R.id.score_label);
        current_label=(TextView) findViewById(R.id.current_label);

        closed_btn=(TextView) findViewById(R.id.close_btn);
        lang_btn=(TextView) findViewById(R.id.lang_btn);
        instruction_title=(TextView) findViewById(R.id.instruction_title);
        instruction_list=(TextView) findViewById(R.id.instructions_list);
        instruct=(RelativeLayout)findViewById(R.id.instruction_lay);
        p1_score=(TextView) findViewById(R.id.player_01_score);
        p2_score=(TextView) findViewById(R.id.player_02_score);
        p3_score=(TextView) findViewById(R.id.player_03_score);
        p4_score=(TextView) findViewById(R.id.player_04_score);
        p1_score_limit=(EditText) findViewById(R.id.player_01_score_input);
        p2_score_limit=(EditText) findViewById(R.id.player_02_score_input);
        p3_score_limit=(EditText) findViewById(R.id.player_03_score_input);
        p4_score_limit=(EditText) findViewById(R.id.player_04_score_input);
        winner_label=(TextView) findViewById(R.id.winner_label);

       score_label.setText(new StringBuilder().append(score_label.getText().toString()).append( score_limit).toString());
        lang_btn.setText("हिंदी");

        p1=(Button)findViewById(R.id.plus_btn_1);
        p2=(Button)findViewById(R.id.plus_btn_2);
        p3=(Button)findViewById(R.id.plus_btn_3);
        p4=(Button)findViewById(R.id.plus_btn_4);
        p11=(Button)findViewById(R.id.minus_btn_1);
        p22=(Button)findViewById(R.id.minus_btn_2);
        p33=(Button)findViewById(R.id.minus_btn_3);
        p44=(Button)findViewById(R.id.minus_btn_4);




        if(p1_i<score_limit&&p2_i<score_limit && p3_i<score_limit && p4_i<score_limit) {

            p1.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    FullscreenActivity.getInstance().play_Sound();

                    if (TextUtils.isEmpty(p1_score_limit.getText().toString())) {
                        p1_score_limit.setError("Enter pts. first");

                    }
                    else if(Integer.parseInt(String.valueOf(p1_score_limit.getText()))>13)
                    {
                        p1_score_limit.setError("Target should be less than 14");
                    }
                    else if(Integer.parseInt(String.valueOf(p1_score_limit.getText()))<2) {
                        p1_score_limit.setError("Target should be more than 1");
                    }



                    else {
                        total_list[0] += Double.parseDouble(String.valueOf(p1_score_limit.getText()));
                        p1_score.setText(format.format(total_list[0]) + "");

                        //    check_Winner(total_list[0], p1_name_label.getText().toString());
                        p1_score_limit.setText("");
                        p1_i++;
                    }
                }
            });

            p2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FullscreenActivity.getInstance().play_Sound();

                    if (TextUtils.isEmpty(p2_score_limit.getText().toString())) {
                        p2_score_limit.setError("Enter pts.first");

                    }
                    else if(Integer.parseInt(String.valueOf(p2_score_limit.getText()))>13)
                    {
                        p2_score_limit.setError("Target should be less than 14");
                    }
                    else if(Integer.parseInt(String.valueOf(p2_score_limit.getText()))<2) {
                        p2_score_limit.setError("Target should be more than 1");
                    }
                    else {
                        total_list[1] += Double.parseDouble(String.valueOf(p2_score_limit.getText()));
                        p2_score.setText(format.format(total_list[1]) + "");

                        // check_Winner(total_list[1], p2_name_label.getText().toString());
                        p2_score_limit.setText("");
                        p2_i++;
                    }

                }
            });
            p3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FullscreenActivity.getInstance().play_Sound();

                    if (TextUtils.isEmpty(p3_score_limit.getText().toString())) {
                        p3_score_limit.setError("Enter pts. first");
                    }
                    else if(Integer.parseInt(String.valueOf(p3_score_limit.getText()))>13)
                    {
                        p3_score_limit.setError("Target should be less than 14");
                    }
                    else if(Integer.parseInt(String.valueOf(p3_score_limit.getText()))<2) {
                        p3_score_limit.setError("Target should be more than 1");
                    }

                    else {
                        total_list[2] += Double.parseDouble(String.valueOf(p3_score_limit.getText()));
                        p3_score.setText(format.format(total_list[2]) + "");

                        // check_Winner(total_list[2], p3_name_label.getText().toString());

                        p3_score_limit.setText("");
                        p3_i++;
                    }

                }
            });
            p4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FullscreenActivity.getInstance().play_Sound();


                    if (TextUtils.isEmpty(p4_score_limit.getText().toString())) {
                        p4_score_limit.setError("Enter pts. first");
                    }
                    else if(Integer.parseInt(String.valueOf(p4_score_limit.getText()))>13)
                    {
                        p4_score_limit.setError("Target should be less than 14");
                    }
                    else if(Integer.parseInt(String.valueOf(p4_score_limit.getText()))<2) {
                        p4_score_limit.setError("Target should be more than 1");
                    }

                    else {
                        total_list[3] += Double.parseDouble(String.valueOf(p4_score_limit.getText()));
                        p4_score.setText(format.format(total_list[3]) + "");

                        //check_Winner(total_list[3], p4_name_label.getText().toString());
                        p4_score_limit.setText("");
                        p4_i++;
                        if (p1_i == p2_i && p2_i == p3_i && p3_i == p4_i && p4_i == p1_i) {
                            current_label.setText("Current Round:" + (p4_i));
                            if(p1_i==score_limit && p2_i==score_limit &&p3_i==score_limit &&p4_i==score_limit ) {
                                check_Winner();
                            }
                        }


                    }


                }
            });


            p11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    FullscreenActivity.getInstance().play_Sound();


                    if (TextUtils.isEmpty(p1_score_limit.getText().toString())) {
                        p1_score_limit.setError("Enter pts. first");

                    }
                    else if(Integer.parseInt(String.valueOf(p1_score_limit.getText()))>13)
                    {
                        p1_score_limit.setError("Target should be less than 14");
                    }
                    else if(Integer.parseInt(String.valueOf(p1_score_limit.getText()))<2) {
                        p1_score_limit.setError("Target should be more than 1");
                    } else {

                        total_list[0] -= Double.parseDouble(String.valueOf(p1_score_limit.getText()));
                        p1_score.setText(format.format(total_list[0]) + "");

                        p1_score_limit.setText("");
                        p1_i++;
                    }
                }
            });

            p22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FullscreenActivity.getInstance().play_Sound();

                    if (TextUtils.isEmpty(p2_score_limit.getText().toString())) {
                        p2_score_limit.setError("Enter pts.first");

                    }
                    else if(Integer.parseInt(String.valueOf(p2_score_limit.getText()))>13)
                    {
                        p2_score_limit.setError("Target should be less than 14");
                    }
                    else if(Integer.parseInt(String.valueOf(p2_score_limit.getText()))<2) {
                        p2_score_limit.setError("Target should be more than 1");
                    } else {
                        total_list[1] -= Double.parseDouble(String.valueOf(p2_score_limit.getText()));
                        p2_score.setText(format.format(total_list[1]) + "");

                        p2_score_limit.setText("");
                        p2_i++;
                    }

                }
            });

            p33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FullscreenActivity.getInstance().play_Sound();

                    if (TextUtils.isEmpty(p3_score_limit.getText().toString())) {
                        p3_score_limit.setError("Enter pts. first");
                    }
                    else if(Integer.parseInt(String.valueOf(p3_score_limit.getText()))>13)
                    {
                        p3_score_limit.setError("Target should be less than 14");
                    }
                    else if(Integer.parseInt(String.valueOf(p3_score_limit.getText()))<2) {
                        p3_score_limit.setError("Target should be more than 1");
                    } else {

                        total_list[2] -= Double.parseDouble(String.valueOf(p3_score_limit.getText()));
                        p3_score.setText(format.format(total_list[2]) + "");


                        p3_score_limit.setText("");
                        p3_i++;
                    }

                }
            });
            p44.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FullscreenActivity.getInstance().play_Sound();


                    if (TextUtils.isEmpty(p4_score_limit.getText().toString())) {
                        p4_score_limit.setError("Enter pts. first");
                    }
                    else if(Integer.parseInt(String.valueOf(p4_score_limit.getText()))>13)
                    {
                        p4_score_limit.setError("Target should be less than 14");
                    }
                    else if(Integer.parseInt(String.valueOf(p4_score_limit.getText()))<2) {
                        p4_score_limit.setError("Target should be more than 1");
                    }
                     else {
                        total_list[3] -= Double.parseDouble(String.valueOf(p4_score_limit.getText()));
                        p4_score.setText(format.format(total_list[3]) + "");
                        p4_score_limit.setText("");
                        p4_i++;
                        if (p1_i == p2_i && p2_i == p3_i && p3_i == p4_i && p4_i == p1_i) {
                            current_label.setText("Current Round:" + (p4_i ));

                            if(p1_i==score_limit && p2_i==score_limit &&p3_i==score_limit &&p4_i==score_limit ) {
                                check_Winner();
                            }
                        }


                    }


                }
            });


        }







        //
        if (p1_name.isEmpty()) {
            p1_name = "Player 01";
        }
        p1_name_label.setText(p1_name);
        if (p2_name.isEmpty()) {
            p2_name = "Player 02";
        }
        p2_name_label.setText(p2_name + "");
        if (p3_name.isEmpty()) {
            p3_name = "Player 03";
        }
        p3_name_label.setText(p3_name);
        if (p4_name.isEmpty()) {
            p4_name = "Player 04";
        }
        p4_name_label.setText(p4_name);





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
                    instruction_list.setText("1. सबसे पहले खिलाड़ी_01 के अंक डालें| \n\n2. अंत में अंतिम खिलाड़ी के अंक दर्ज करें अर्थात  (खिलाड़ी_04)\n\n3. जिस खिलाड़ी के सबसे अधिक अंक होंगे वह खेल जीतेगा| \n\n4.जिस खिलाड़ी के सबसे कम अंक होंगे वह खेल हार जायेगा| ");
                }
                else if(lang_btn.getText().toString().equals("English"))
                {
                    lang_btn.setText("हिंदी");
                    instruction_title.setText("Instructions");
                    instruction_list.setText("1. At first enter the points of player_01. \n\n2.At last enter the points of the last player i.e (Player_04) . \n\n3. The player with the highest points will win the game. \n\n4. The player with lowest points will lose the game. ");

                }

            }
        });

    }

    public void check_Winner()
    {

        StringBuilder result=new StringBuilder();

        if(total_list[0]>total_list[1] && total_list[0]>total_list[2]&&total_list[0]>total_list[3])
        {
            result.append("\n👑 "+p1_name);

        }

        else if(total_list[1]>total_list[0] && total_list[1]>total_list[2]&&total_list[1]>total_list[3])
        {
            result.append("\n👑 "+p2_name);

        }

        else if(total_list[2]>total_list[0] && total_list[2]>total_list[1]&&total_list[2]>total_list[3])
        {
            result.append("\n👑 "+p3_name);

        }

        else if(total_list[3]>total_list[0] && total_list[3]>total_list[2]&&total_list[3]>total_list[1])
        {
            result.append("👑 "+p4_name);

        }

        else if(total_list[0]==total_list[1]  && total_list[0]>total_list[2]&&total_list[0]>total_list[3])
        {
            result.append("👑\n"+p1_name+"\n"+p2_name);
        }
        else if(total_list[0]==total_list[2] &&total_list[0]>total_list[1] &&total_list[0]>total_list[3])
        {
            result.append("👑\n"+p1_name+"\n"+p3_name);
        }
        else if(total_list[0]==total_list[3] && total_list[0]>total_list[1] && total_list[0]>total_list[2])
        {
            result.append("👑\n"+p1_name+"\n"+p4_name);
        }

        else if(total_list[1]==total_list[2]&&total_list[1]>total_list[0] &&total_list[1]>total_list[3])
        {
            result.append("👑\n"+p2_name+"\n"+p3_name);

        }
        else if(total_list[1]==total_list[3] &&total_list[1]>total_list[0] && total_list[1]>total_list[2])
        {
            result.append("👑\n"+p2_name+"\n"+p4_name);

        }

        else if(total_list[2]==total_list[3] && total_list[2]>total_list[0] && total_list[2]>total_list[1])
        {
            result.append("👑\n"+p3_name+"\n"+p4_name);
        }




        result.append("\n Wins the Game");
        winner_label.setText(result);


            FullscreenActivity.getInstance().play_Celebrate();
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