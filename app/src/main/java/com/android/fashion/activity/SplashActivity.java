package com.android.fashion.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.android.fashion.R;
import com.android.fashion.app.ConstantsImageUrl;
import com.android.fashion.app.GlideApp;
import com.android.fashion.databinding.ActivitySplashBinding;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySplashBinding splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        init(splashBinding);
    }

    private void init(ActivitySplashBinding splashBinding) {
        immersiveStatusBar();
        int i = new Random().nextInt(ConstantsImageUrl.TRANSITION_URLS.length);

        GlideApp.with(this)
                .load(ConstantsImageUrl.TRANSITION_URLS[i])
                .placeholder(R.mipmap.img_default)
                .error(R.mipmap.img_default)
                .into(splashBinding.ivDefault);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toMainActivity();
            }
        }, 3500);
    }

    private void immersiveStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void toMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
        finish();
    }
}
