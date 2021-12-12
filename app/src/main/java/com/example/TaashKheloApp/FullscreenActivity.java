package com.example.TaashKheloApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

public class FullscreenActivity extends AppCompatActivity {
    Animation animation;
    static FullscreenActivity instance;
    float alpha=0.18f;
    int bg_int=2131362311;
    boolean isInitial=true;
    int rt_pad;

    MediaPlayer btn_sound,celebrate;
    TextView gussg_text,thirteen_text,coming_soon,rummy_text;
    ImageView gussh_img,thirteen_img,coming_soon_img,rummy_img,dashboard_bg;
    ImageButton setting_btn;
    ArrayList<String> arrayList=new ArrayList<String>();
    MySpinner spinner;
    SharedPreferences preferences;
     SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
         btn_sound=MediaPlayer.create(this,R.raw.hard_click_sound);
         celebrate=MediaPlayer.create(this,R.raw.group_applause_sound);
         instance=this;


        //setting animation to  Textview
        animation= AnimationUtils.loadAnimation(this, R.anim.dash_text_anim);

        gussg_text=(TextView)findViewById(R.id.gussh_text);
        thirteen_text=(TextView)findViewById(R.id.thirteen_text);
        rummy_text=(TextView)findViewById(R.id.rummy_text);
        coming_soon=(TextView)findViewById(R.id.coming_soon);



        rummy_img=(ImageView)findViewById(R.id.rummy_img);
        thirteen_img=(ImageView)findViewById(R.id.thirteen_img);
        gussh_img=(ImageView)findViewById(R.id.gussh_img);
        coming_soon_img=(ImageView)findViewById(R.id.coming_soon_img);
        dashboard_bg=(ImageView)findViewById(R.id.dahboard_background);

        spinner=  findViewById(R.id.spinner);

        gussg_text.setAnimation(animation);
        thirteen_text.setAnimation(animation);
        rummy_text.setAnimation(animation);
        coming_soon.setAnimation(animation);




        preferences= getSharedPreferences("Shared_prep", Context.MODE_PRIVATE);
        editor= preferences.edit();
        if(preferences.contains(("bg_index")) || preferences.contains(("alpha")) )
        {
            dashboard_bg.setImageResource(preferences.getInt("bg_index",2131362311));
            dashboard_bg.setPadding(0,0,preferences.getInt("rt_pad",0),0);
            if(preferences.getInt("rt_pad",0)!=472)
            {
                dashboard_bg.setScaleY(1.845f);
            }
            dashboard_bg.setAlpha(preferences.getFloat("alpha",0.18f));
            Log.v("pref_getint ->",preferences.getInt("bg_index",2131362311)+"");
            Log.v("pref_getfloat ->",preferences.getFloat("alpha",0.18f)+"");
        }




        //adding onclick sound

        gussg_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play_Sound();
                gussh_Play(v);
            }
        });

        rummy_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_Sound();
                rummy_Play(v);
            }
        });

        thirteen_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play_Sound();
                thirteen_Play(v);
            }
        });

        coming_soon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play_Sound();
                coming_Soon_Toast(v);
            }
        });



        rummy_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play_Sound();
                rummy_Play(v);
            }
        });

        gussh_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play_Sound();
                gussh_Play(v);
            }
        });

        thirteen_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play_Sound();
                thirteen_Play(v);
            }
        });

        coming_soon_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play_Sound();
                coming_Soon_Toast(v);
            }
        });


        //Spinner


                //play_Sound();
              arrayList.add(0," Settings  ");
               arrayList.add(1," About      ");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                        Log.v("about tag", parent.getSelectedItem() + "->" + parent.getSelectedItemPosition());

                        if(isInitial) {
                            isInitial=false;
                            return;
                        }
                        else {
                            switch (position) {

                                case 0:
                                    Intent intent0 = new Intent();
                                    intent0.setClass(getApplicationContext(), Settings.class);
                                    startActivity(intent0);
                                    isInitial=false;
                                    break;
                                case 1:
                                    Intent intent = new Intent();
                                    intent.setClass(getApplicationContext(), about.class);
                                    startActivity(intent);
                                    isInitial=true  ;
                                    break;

                            }

                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }

                });



                try {

                }
                catch ( RuntimeException e)
                {

                }

                try {

                }
                catch (IllegalArgumentException f )
                {

                }



        //wating for Splash Screen finish

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Creating another activity link
                }
            }, 5000);



        }


    public static FullscreenActivity getInstance()
    {
        return instance;
    }

    public void coming_Soon_Toast(View view)
    {
        Toast.makeText(this.getApplicationContext(),"Coming Soon...",Toast.LENGTH_SHORT).show();
    }

    public void gussh_Play(View v)
    {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),Gussh.class);
        startActivity(intent);

    }


    public void thirteen_Play(View v)
    {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),Thirteen.class);
        startActivity(intent);

    }

    public void rummy_Play(View v)
    {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),Rummy.class);
        startActivity(intent);

    }

    public void setBackground(int bg)
    {

        bg_int=bg;
        if(bg==R.id.dahboard_background)
        {
            dashboard_bg.setPadding(0,0,472,0);
            dashboard_bg.setMaxHeight(682);
            rt_pad=472;
        }

        else
        {
            dashboard_bg.setMinimumHeight(850);
            dashboard_bg.setPadding(0, 0, 0, 0);
            dashboard_bg.setScaleY(1.845f);
            rt_pad=0;
        }
        dashboard_bg.setImageResource(bg);
        editor.putInt("bg_index",bg);
        editor.putInt("rt_pd",rt_pad);
        editor.commit();



    }

    public void  setAlpha(float alpha1)
    {
        dashboard_bg.setAlpha(alpha1);
         Log.v("alpha_pre  ->",alpha1+"");
        editor.putFloat("alpha",alpha1);
        editor.putInt("bg_index",bg_int);
        editor.putInt("rt_pd",rt_pad);
        editor.commit();
    }


    public void play_Sound()
    {
        btn_sound.start();
        //btn_sound.setVolume(10f,10f);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            btn_sound.setPlaybackParams(btn_sound.getPlaybackParams().setSpeed(2.5f));
        }
    }


    public void play_Celebrate()
    {
        int i=0;

            celebrate.start();



        //btn_sound.setVolume(10f,10f);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            btn_sound.setPlaybackParams(btn_sound.getPlaybackParams().setSpeed(2.5f));
        }
    }


}