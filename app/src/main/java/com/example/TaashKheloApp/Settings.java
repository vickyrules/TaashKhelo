package com.example.TaashKheloApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;


public class Settings extends AppCompatActivity {
    int bg_index;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    NumberPicker numberpicker;
    Button save;
    ImageView bg_1,bg_2,bg_3,bg_4;
    float alpha=0.18f;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences= getSharedPreferences("Shared_prep", Context.MODE_PRIVATE);
        editor= preferences.edit();
        if(preferences.contains("bgindex"))
        {
            bg_index=preferences.getInt("bgindex",2131362311);

        }


        bg_1=(ImageView) findViewById(R.id.bg_1);
        bg_2=(ImageView) findViewById(R.id.bg_2);
        bg_3=(ImageView) findViewById(R.id.bg_3);
        bg_4=(ImageView) findViewById(R.id.bg_4);
        save=(Button)findViewById(R.id.save_button);
        numberpicker=(NumberPicker)findViewById(R.id.numberpicker);
        String[] picker_context={"Low","Medium","High"};
        numberpicker.setDisplayedValues(picker_context);
        numberpicker.setMinValue(0);
        numberpicker.setWrapSelectorWheel(false);
        numberpicker.setMaxValue(picker_context.length -1);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            numberpicker.setTextSize(50f);
            numberpicker.setSelectionDividerHeight(30);

        }



        bg_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg_1.setAlpha(1f);
                bg_2.setAlpha(.6f);
                bg_3.setAlpha(.6f);
                bg_4.setAlpha(.6f);
                bg_index=R.drawable.background3;

            }
        });

        bg_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg_2.setAlpha(1f);
                bg_1.setAlpha(.6f);
                bg_3.setAlpha(.6f);
                bg_4.setAlpha(.6f);
                bg_index=R.drawable.background4;

            }
        });

        bg_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg_3.setAlpha(1f);
                bg_1.setAlpha(.6f);
                bg_2.setAlpha(.6f);
                bg_4.setAlpha(.6f);
                bg_index=R.drawable.background2;
            }
        });

        bg_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg_4.setAlpha(1f);
                bg_1.setAlpha(.6f);
                bg_3.setAlpha(.6f);
                bg_2.setAlpha(.6f);
                bg_index=R.drawable.background_dash;
                Log.v("bg4_id",bg_4.getId()+"");
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            numberpicker.setSelectionDividerHeight(12);
            numberpicker.setTextColor(getColor(android.R.color.white));
        }

        numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FullscreenActivity.getInstance().play_Sound();
                        Toast.makeText(getApplicationContext(),"Changes applied",Toast.LENGTH_SHORT).show();
                        setAlp(newVal);
                        FullscreenActivity.getInstance().setBackground(bg_index);
                        editor.putInt("bgindex",bg_index);
                        editor.commit();
                    }
                });

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();
                Toast.makeText(getApplicationContext(),"Changes applied",Toast.LENGTH_SHORT).show();
                FullscreenActivity.getInstance().setBackground(bg_index);
                editor.putInt("bgindex",bg_index);
                editor.commit();
            }
        });
    }



    public void setAlp(int newVal)
    {
        switch (newVal) {
            case 0: alpha=.65f;
                Log.v("Number Picker Status:",newVal+"");
                FullscreenActivity.getInstance().setAlpha(alpha);
                break;

            case 1: alpha=0.45f;
                FullscreenActivity.getInstance().setAlpha(alpha);
                Log.v("Number Picker Status:",newVal+"");
                break;

            case 2: alpha=0.18f;
                FullscreenActivity.getInstance().setAlpha(alpha);
                Log.v("Number Picker Status:",newVal+"");
                break;

        }
    }

}