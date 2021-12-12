package com.example.TaashKheloApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class about extends AppCompatActivity {

    TextView email;
    ImageView linkedin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        email=(TextView)findViewById(R.id.about_dev_info_emial);
        linkedin=(ImageView)findViewById(R.id.linkedin);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setTextColor(Color.rgb(8,180,193));
                FullscreenActivity.getInstance().play_Sound();

                Intent mail=new Intent(Intent.ACTION_SENDTO);
               // mail.setType("*/*");
                mail.setData(Uri.parse("mailto:"+"vickyrules1705@gmail.com"));
                mail.putExtra(Intent.EXTRA_EMAIL,"");
                mail.putExtra(Intent.EXTRA_SUBJECT,"");
                if(mail.resolveActivity(getPackageManager())!=null) {
                    startActivity(mail);


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No App is Installed for E-Mails",Toast.LENGTH_SHORT).show();
                }
            }


        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullscreenActivity.getInstance().play_Sound();

                Uri webpage = Uri.parse("https://www.linkedin.com/in/vikas-kumar-9151b7191/");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.linkedin.com/in/vikas-kumar-9151b7191/"));

                    startActivity(intent);


            }
        });


    }



}