package com.example.zcq.bigwork;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import android.webkit.WebSettings;
import android.view.KeyEvent;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {

    private Button button_app1;
    private Button button_web1;
    private Button button_search1;

    private Button button_cate;

    private Button button_tip;

    private WebView webView_active;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_active();

        button_app1 = (Button) findViewById(R.id.button_app);


        button_app1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        AppActivity.class);
                startActivity(intent);

            }
        });

        button_web1 = (Button) findViewById(R.id.button_web);
        button_web1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
            }
        });

        button_search1 = (Button)findViewById(R.id.button_search);
        button_search1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });

        button_cate = (Button)findViewById(R.id.button_category);

        button_cate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Category.class);
                startActivity(intent);
            }
        });

        button_tip = (Button)findViewById(R.id.button);
        button_tip.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Category.class);
                startActivity(intent);
            }
        });

    }


     private void init_active() {
        webView_active = (WebView) findViewById(R.id.webView_active);


        webView_active.loadUrl("http:/m.wufazhuce.com");

        webView_active.setWebViewClient(new android.webkit.WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }
            //WebViewClient帮助WebView去处理一些页面控制和请求通知
        });

        WebSettings settings = webView_active.getSettings();
        settings.setJavaScriptEnabled(true);

        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView_active.canGoBack()) {
                webView_active.goBack();
                return true;
            } else {
                System.exit(0);
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
