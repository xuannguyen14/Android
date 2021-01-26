package com.example.readrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    WebView wvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        wvNews = (WebView) findViewById(R.id.webviewNews);

        Intent intent = getIntent();
        String linkReceive = intent.getStringExtra("linkNews");

        wvNews.loadUrl(linkReceive);

        // khi click vào đường dẫn ko mở ra ngoài app (ko bị chạy trên google hay các browser khác)
        wvNews.setWebViewClient(new WebViewClient());
    }
}