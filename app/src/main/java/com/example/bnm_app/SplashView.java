package com.example.bnm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashView extends AppCompatActivity {

    Animation mTopAnim,mBottomAnim;
    ImageView mImage;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_view);

        mTopAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        mBottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        mImage = findViewById(R.id.splash_img);
        mText = findViewById(R.id.splash_txt);

        mImage.setAnimation(mTopAnim);
        mText.setAnimation(mBottomAnim);

        //Intent is used to switch from one activity to another.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashView.this, WelComePage.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(mImage,"logo_image");
                pairs[1] = new Pair<View,String>(mText,"logo_text");

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashView.this, pairs);
                    startActivity(i,options.toBundle());
                    finish();
                }
            }
        }, 3000);
    }
}