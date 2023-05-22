package com.rumanweb.webtoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.webtoapp.R;

public class MainActivity extends AppCompatActivity {

    WebView myweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data, Please Wait...");
        progressDialog.setCancelable(false);
        getSupportActionBar().hide();
        myweb = findViewById(R.id.myweb);
        myweb.requestFocus();
        myweb.loadUrl("http://ucam.uits.edu.bd/Security/LogIn.aspx");
        myweb.getSettings().setSavePassword(true);
        myweb.getSettings().setJavaScriptEnabled(true);
        myweb.getSettings().setLoadWithOverviewMode(true);
        myweb.getSettings().setUseWideViewPort(true);
        myweb.getSettings().setSupportZoom(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myweb.getSettings().setBuiltInZoomControls(true);
        myweb.getSettings().setDisplayZoomControls(false);
        myweb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        myweb.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
        public void onBackPressed() {
            super.onBackPressed();
            finish();
        }
    }
}