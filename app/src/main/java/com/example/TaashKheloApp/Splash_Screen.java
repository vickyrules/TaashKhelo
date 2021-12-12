package com.example.TaashKheloApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    Animation top_welcome_anim,bottom_welcome_anim;
    ImageView icon;
    TextView logo,tagLine;
     static  int Splash_screen=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       /* ActionBar actionBar= getSupportActionBar();
        //code for ActionBar hide
        actionBar.hide();
       */

        //code for status bar hide

        /*
         View decorView =getWindow().getDecorView();
        int uioptions=View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uioptions);
        */


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //setting animation to imageView and Textview
        top_welcome_anim= AnimationUtils.loadAnimation(this,R.anim.welcome_top_animation);
        bottom_welcome_anim= AnimationUtils.loadAnimation(this,R.anim.welcome_bottom_animation);
        icon=(ImageView)findViewById(R.id.fullscreen_welcome_icon);
        logo=(TextView)findViewById(R.id.welcome_text);
        tagLine=(TextView)findViewById(R.id.welcome_tag);

        icon.setAnimation(top_welcome_anim);
        logo.setAnimation(bottom_welcome_anim);
        tagLine.setAnimation(bottom_welcome_anim);

        //Creating Splash Screen
        try {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Creating another activity link
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(),FullscreenActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, Splash_screen);

        }
        catch (RuntimeException e)
        {

        }
    }
}