package com.example.api_calls_testing_android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ((ProgressBar) findViewById(R.id.checkingProgress)).animate();
        ImageView imageLogo = (ImageView) findViewById(R.id.imageLogo);
        imageLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.heart_animation));
        final Intent intent;


            intent = new Intent(this, WelcomeActivity.class);


        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 1000);
    }
}
