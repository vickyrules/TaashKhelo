package com.example.TaashKheloApp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirteenDashboard extends AppCompatActivity {

    int[]  total_list={0,0};
    TextView team_A_name,team_B_name,score_A,score_B,winner_label;
    EditText input_A,input_B;
    Button success_A,success_B,failed_A,failed_B;
    String team_A,team_B,p1_name,p2_name,p3_name,p4_name;
    MediaPlayer swap_alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteen_dashboard);

        Intent caller = getIntent();
        swap_alert=MediaPlayer.create(this,R.raw.swap_alert);
        p1_name=caller.getStringExtra("p1_name").toUpperCase();
        p3_name=caller.getStringExtra("p3_name").toUpperCase();
        p2_name=caller.getStringExtra("p2_name").toUpperCase();
        p4_name=caller.getStringExtra("p4_name").toUpperCase();

        team_A_name=(TextView)findViewById(R.id.p1_p3_names);
        team_B_name=(TextView)findViewById(R.id.p2_p4_names);
        winner_label=(TextView)findViewById(R.id.winner_label);
        score_A=(TextView)findViewById(R.id.score_A);
        score_B=(TextView)findViewById(R.id.score_B);
        success_A=(Button)findViewById(R.id.team_A_success);
        success_B=(Button)findViewById(R.id.team_B_success);
        failed_A=(Button)findViewById(R.id.team_A_failed);
        failed_B=(Button)findViewById(R.id.team_B_failed);
        input_A=(EditText)findViewById(R.id.p1_p3_bid_input);
        input_B=(EditText)findViewById(R.id.p2_p4_bid_input);


        if(caller.getStringExtra("p1_name").isEmpty())
        {
            p1_name="Player 01";
        }

        if(p2_name.isEmpty())
        {
            p2_name="Player 02";
        }

        if(p3_name.isEmpty())
        {
            p3_name="Player 03";
        }

        if(p4_name.isEmpty())
        {
            p4_name="Player 04";
        }


         team_A=p1_name+" | "+p3_name;
         team_B=p2_name+" | "+p4_name;

        team_A_name.setText(team_A);
        team_B_name.setText(team_B);


        success_A.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                if(TextUtils.isEmpty(input_A.getText().toString()))
                {
                    input_A.setError("Enter pts.first");
                }
                else if(Integer.parseInt(String.valueOf(input_A.getText()))>13)
                {
                    input_A.setError("Target should be less than 14");
                }
                else if(Integer.parseInt(String.valueOf(input_A.getText()))<7)
                {
                    input_A.setError("Target should be more than 6");
                }


                else {

                    if(total_list[0]==0 ) {
                        total_list[1] += Integer.parseInt(String.valueOf(input_A.getText()));
                        score_B.setText((total_list[1]) + "");
                        if(total_list[1]>=52)
                        {
                            check_Winner("TEAM A");
                        }
                    }

                     else if(total_list[0]>=Integer.parseInt(String.valueOf(input_A.getText())) && total_list[1]==0) {
                             total_list[0] -= Integer.parseInt(String.valueOf(input_A.getText()));
                             score_A.setText(total_list[0] + "");
                             if(total_list[0]==0)
                             {
                                 swap_alert.start();;
                             }
                         }

                         else if(total_list[0]<Integer.parseInt(String.valueOf(input_A.getText())))
                         {
                             total_list[1]=Integer.parseInt(String.valueOf(input_A.getText()))-total_list[0];
                             total_list[0]-=total_list[0];
                             score_B.setText(total_list[1]+"");
                             score_A.setText("00");
                             swap_alert.start();

                         }


                       }


                       input_A.setText("");


            }
        });

        failed_A.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                if(TextUtils.isEmpty(input_A.getText().toString()))
                {
                    input_A.setError("Enter pts.first");
                }
                else if(Integer.parseInt(String.valueOf(input_A.getText()))>13)
                {
                    input_A.setError("Target should be less than 14");
                }

                else if(Integer.parseInt(String.valueOf(input_A.getText()))<7)
                {
                    input_A.setError("Target should be more than 6");
                }

                else {
                    if( total_list[1]>=(2*Integer.parseInt(String.valueOf(input_A.getText())))) {
                        total_list[1] -= (2 * Integer.parseInt(String.valueOf(input_A.getText())));
                        score_B.setText(total_list[1] + "");
                    }

                    else if(total_list[0]==0&&total_list[1]==0)
                    {
                        total_list[0] += (2 * Integer.parseInt(String.valueOf(input_A.getText())));
                        score_A.setText(total_list[0] + "");
                        if(total_list[0]>=52)
                        {
                            check_Winner("TEAM B");
                        }
                    }
                    else if(total_list[1]<=(2*Integer.parseInt(String.valueOf(input_A.getText()))) && total_list[1]!=0)
                    {

                        total_list[0] = (2*Integer.parseInt(String.valueOf(input_A.getText())))-total_list[1];
                        total_list[1]-=total_list[1];
                        score_A.setText(total_list[0]+"");
                        score_B.setText("00");
                        swap_alert.start();
                    }

                    else if(total_list[0]>0 && total_list[1]==0)
                    {
                        total_list[0]+=(2*Integer.parseInt(String.valueOf(input_A.getText())));
                        score_A.setText(total_list[0]+"");
                        if(total_list[0]>=52)
                        {
                            check_Winner("TEAM B");
                        }
                    }

                    input_A.setText("");
                }

            }
        });


        success_B.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                if(TextUtils.isEmpty(input_B.getText().toString()))
                {
                    input_B.setError("Enter pts.first");
                }
                else if(Integer.parseInt(String.valueOf(input_B.getText()))>13)
                {
                    input_B.setError("Target should be less than 14");
                }

                else if(Integer.parseInt(String.valueOf(input_B.getText()))<7)
                {
                    input_B.setError("Target should be more than 6");
                }


                else {

                    if(total_list[1]==0 ) {
                        total_list[0] += Integer.parseInt(String.valueOf(input_B.getText()));
                        score_A.setText((total_list[0]) + "");
                        if(total_list[0]>=52)
                        {
                            check_Winner("TEAM B");
                        }
                    }

                    else if(total_list[1]>=Integer.parseInt(String.valueOf(input_B.getText())) && total_list[0]==0) {
                        total_list[1] -= Integer.parseInt(String.valueOf(input_B.getText()));
                        score_B.setText(total_list[1] + "");
                        if(total_list[0]==0)
                        {
                            swap_alert.start();;
                        }
                    }

                    else if(total_list[1]<Integer.parseInt(String.valueOf(input_B.getText())))
                    {
                        total_list[0]=Integer.parseInt(String.valueOf(input_B.getText()))-total_list[1];
                        total_list[1]-=total_list[1];
                        score_A.setText(total_list[0]+"");
                        score_B.setText("00");
                        swap_alert.start();
                    }


                }


                input_B.setText("");


            }

        });

        failed_B.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                if(TextUtils.isEmpty(input_B.getText().toString()))
                {
                    input_B.setError("Enter pts.first");
                }

                else if(Integer.parseInt(String.valueOf(input_B.getText()))>13)
                {
                    input_B.setError("Target should be less than 14");
                }

                else if(Integer.parseInt(String.valueOf(input_B.getText()))<7)
                {
                    input_B.setError("Target should be more than 6");
                }


                else {
                    if( total_list[0]>=(2*Integer.parseInt(String.valueOf(input_B.getText())))) {
                        total_list[0] -= (2 * Integer.parseInt(String.valueOf(input_B.getText())));
                        score_A.setText(total_list[0] + "");
                    }

                    else if(total_list[1]==0&&total_list[0]==0)
                    {
                        total_list[1] += (2 * Integer.parseInt(String.valueOf(input_B.getText())));
                        score_B.setText(total_list[1] + "");
                        if(total_list[1]>=52)
                        {
                            check_Winner("TEAM A");
                        }
                    }
                    else if(total_list[0]<=(2*Integer.parseInt(String.valueOf(input_B.getText()))) && total_list[0]!=0)
                    {

                        total_list[1] = (2*Integer.parseInt(String.valueOf(input_B.getText())))-total_list[0];
                        total_list[0]-=total_list[0];
                        score_B.setText(total_list[1]+"");
                        score_A.setText("00");
                        swap_alert.start();
                    }

                    else if(total_list[1]>0 && total_list[0]==0)
                    {
                        total_list[1]+=(2*Integer.parseInt(String.valueOf(input_B.getText())));
                        score_B.setText(total_list[1]+"");
                        if(total_list[1]>=52)
                        {
                            check_Winner("TEAM A");
                        }
                    }

                    input_B.setText("");
                }

            }
        });












    }

    public void check_Winner(String team)
    {
        StringBuilder result;
        if(team.equals("TEAM A"))
        {
         result=new StringBuilder("👑\n"+ "TEAM A\n"+"😀\n"+ p1_name+ " | "+ p3_name +"\n" + "\nWins the game");}
        else {
            result = new StringBuilder("👑\n" + "TEAM B\n" + "😀\n" + p2_name + " | " + p4_name  + "\n\nWins the game");
        }
            winner_label.setText(result);
            input_A.setVisibility(View.GONE);
            input_B.setVisibility(View.GONE);
            FullscreenActivity.getInstance().play_Celebrate();
            winner_label.setVisibility(View.VISIBLE);


    }

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