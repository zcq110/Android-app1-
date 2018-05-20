package com.example.zcq.bigwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

/**
 * Created by zcq on 2018/4/21.
 */

public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcom);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
             @Override public void run() {
                 startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                 WelcomeActivity.this.finish();
             }}, 3000);
    }
}
