package com.example.bnm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class WelComePage extends AppCompatActivity {

    Animation mTopAnim;
    ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come_page);
    }

    public void signinscreen(View view){
        Intent i1 = new Intent(getApplicationContext(),SignIn.class);
        Pair[] pair = new Pair[1];
        pair[0] = new Pair<View,String>(findViewById(R.id.SignInBtn),"transition_SignIn");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(WelComePage.this,pair);
            startActivity(i1,options.toBundle());
        }
        else{ startActivity(i1); }
    }

    public void signupscreen(View view) {
        Intent i1 = new Intent(getApplicationContext(),SignUp.class);
        Pair[] pair = new Pair[1];
        pair[0] = new Pair<View,String>(findViewById(R.id.SignUpBtn),"transition_SignUp");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(WelComePage.this,pair);
            startActivity(i1,options.toBundle());
        }
        else{ startActivity(i1); }
    }
}