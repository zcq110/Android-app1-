package com.example.zcq.bigwork;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zcq on 2018/4/22.
 */

public class AppActivity extends Activity {

    private Button button_back_app;
    private Button button_help_app;

    private WebView webview_app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        init_app();

        findViewById(R.id.button_wx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.tencent.mm","com.tencent.mm.ui.LauncherUI");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivityForResult(intent, 0);
                } catch (Exception e) {
                    Uri uri = Uri.parse("https://weixin.qq.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
        findViewById(R.id.button_qq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.tencent.mobileqq","com.tencent.tim.activity.SplashActivity");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivityForResult(intent, 0);
                } catch (Exception e) {

                    Uri uri = Uri.parse("https://im.qq.com/immobile/android");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
        findViewById(R.id.button_wb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.sina.weibo","com.sina.weibo.SplashActivity");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivityForResult(intent, 0);
                } catch (Exception e) {

                    Uri uri = Uri.parse("https://www.weibo.com/login.php");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
            }
        });

        findViewById(R.id.button_tao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.taobao.taobao","com.taobao.tao.welcom.Welcome");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivityForResult(intent, 0);
                } catch (Exception e) {

                    Uri uri = Uri.parse("https://www.taobao.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.jingdong.app.mall","com.jingdong.appmall.MainActivity");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivityForResult(intent, 0);
                } catch (Exception e) {

                    Uri uri = Uri.parse("https://www.jd.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });


        findViewById(R.id.button_zhi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.eg.android.AlipayGphone","com.eg.android.AlipayGphone.AlipayLogin");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivityForResult(intent, 0);
                } catch (Exception e) {

                    Uri uri = Uri.parse("https://m.alipay.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.button_wangyi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.netease.cloudmusic","com.netease.cloudmusic.activity.LodingActivity");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivityForResult(intent,0);
            }catch (Exception e){
                Uri uri = Uri.parse("http://music.163.com/#/download");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                }
            }
        });

        findViewById(R.id.button_ditu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent();
                    ComponentName cmp = new ComponentName("com.autonavi.minimap","com.autonavi.map.activity.SplashActivity");
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivityForResult(intent,0);
                }catch (Exception e){
                    Uri uri = Uri.parse("http://www.autonavi.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
            }
        });

        button_back_app = (Button)findViewById(R.id.button_back_app);
        button_back_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        button_help_app = (Button)findViewById(R.id.button_help_app);

        button_help_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppActivity.this,Category.class);
                startActivity(intent);
            }
        });

    }

    private void init_app() {
        webview_app = (WebView) findViewById(R.id.webview_app);

        webview_app.loadUrl("http://www.wandoujia.com/award");

        webview_app.setWebViewClient(new android.webkit.WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }
            //WebViewClient帮助WebView去处理一些页面控制和请求通知
        });

        WebSettings settings = webview_app.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webview_app.canGoBack()) {
                webview_app.goBack();
                return true;
            } else {
                System.exit(0);
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
