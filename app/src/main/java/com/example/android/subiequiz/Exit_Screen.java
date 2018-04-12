package com.example.android.subiequiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Exit_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit__screen);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                //Allows later OS version 16+ to fully close out the app instead of going directly back
                //to the quia page with old data
                finishAffinity();
            }
        }, 3000);
}
}