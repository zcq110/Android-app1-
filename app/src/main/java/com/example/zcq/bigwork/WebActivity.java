package com.example.zcq.bigwork;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.os.Handler;
import android.os.Message;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;



/**
 * Created by zcq on 2018/4/22.
 */

public class WebActivity extends Activity {

    private android.widget.ImageView img;
    private String url = "https://images.pexels.com/photos/297996/pexels-photo-297996.jpeg?auto=compress&cs=tinysrgb&h=350";


    private WebView webview_image1;


    private Button button_back_web;

    private Button button_help_web;


  private Handler handle = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case 0:
                System.out.println("111");
                Bitmap bmp=(Bitmap)msg.obj;
                img.setImageBitmap(bmp);
                break;
            }
        };
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        init_image();
        img = (android.widget.ImageView) findViewById(R.id.image_view);



        new Thread(new Runnable() {

            @Override
            public void run() {
                Bitmap bmp = getURLimage(url);
                Message msg = new Message();
                msg.what = 0;
                msg.obj = bmp;
                System.out.println("000");
                handle.sendMessage(msg);
            }
        }).start();

        button_back_web = (Button)findViewById(R.id.button_web_back);
        button_back_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        button_help_web = (Button)findViewById(R.id.button_web_help);

        button_help_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebActivity.this,Category.class);
                startActivity(intent);
            }
        });
    }

    public Bitmap getURLimage(String url) {
        Bitmap bmp = null;
        try {
            URL myurl = new URL(url);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is = conn.getInputStream();//获得图片的数据流
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }



    private void init_image() {
        webview_image1 = (WebView) findViewById(R.id.webview_image);

        webview_image1.loadUrl("http:/www.pexels.com");

        webview_image1.setWebViewClient(new android.webkit.WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }
            //WebViewClient帮助WebView去处理一些页面控制和请求通知
        });

        WebSettings settings = webview_image1.getSettings();
        settings.setJavaScriptEnabled(true);

        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webview_image1.canGoBack()) {
                webview_image1.goBack();
                return true;
            } else {
                System.exit(0);
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}

