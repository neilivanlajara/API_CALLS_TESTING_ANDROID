package com.example.api_calls_testing_android;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.api_calls_testing_android.databinding.ActivityWelcomeBinding;
import com.example.api_calls_testing_android.ui.login.LoginActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class WelcomeActivity extends AppCompatActivity {

    private TextView withoutRegistration;
    private TextView loginOrSign;
    private String TAG = "Welcome Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        initialize();


    }

    private void initialize(){
        this.withoutRegistration = (TextView) findViewById(R.id.withoutRegistration);
        this.loginOrSign = (TextView)findViewById(R.id.loginOrSignIn);


        this.loginOrSign.setOnClickListener(v->{
            final Intent intent;
            Log.d(TAG, "initialize: clicked loginOrSign");
            intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        this.withoutRegistration.setOnClickListener(v->{
            Log.d(TAG, "initialize: clicked withoutRegistration");
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}