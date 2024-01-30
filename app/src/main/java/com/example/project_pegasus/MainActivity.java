package com.example.project_pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    //init views
    ImageView imageView;

    //textview
    TextView textView;

    //init animation
    Animation fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //conect views
        imageView = findViewById(R.id.logo);

        textView = findViewById(R.id.text);

        //concectthe animation
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        //functies
        startAnimation();
        nextActivity();

    }

    public void startAnimation(){
        //apply animation to imageview
        imageView.startAnimation(fadeIn);
        textView.startAnimation(fadeIn);
    }

    public void nextActivity(){
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}