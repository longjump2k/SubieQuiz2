package com.example.android.subiequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private ImageView background;
    private ImageView logo;
    private ImageView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        background = findViewById(R.id.backgroundImage);
        logo = findViewById(R.id.logoImage);
        text = findViewById(R.id.textImage);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        background.startAnimation(myanim);
        logo.startAnimation(myanim);
        text.startAnimation(myanim);
        final Intent i = new Intent(this,MainActivity.class);
        Thread timer = new Thread() {
                public void run() {
                    try {
                        sleep(3000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        startActivity (i);
                        finish();
                    }
        }
        };
                    timer.start();
    }
}
