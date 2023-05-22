package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView myweb;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myweb.requestFocus();
        myweb.getSettings().setJavaScriptEnabled(true);
        myweb.getSettings().setLoadWithOverviewMode(true);
        myweb.getSettings().setUseWideViewPort(true);
        myweb.setWebViewClient(new WebViewClient());
        myweb.getSettings().setSupportZoom(true);
        myweb.getSettings().setBuiltInZoomControls(true);
        myweb.getSettings().setDisplayZoomControls(false);
        preferences  = getSharedPreferences("loginPrefs", MODE_PRIVATE);



        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        getSupportActionBar().hide();
        myweb = findViewById(R.id.myweb);
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
        myweb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                // Retrieve login information from SharedPreferences
                String username = preferences.getString("username", "");
                String password = preferences.getString("password", "");

                // Set Authorization header for WebView
                String auth = username + ":" + password;
                String base64Auth = Base64.encodeToString(auth.getBytes(), Base64.NO_WRAP);
                view.getSettings().setUserAgentString(base64Auth);
            }
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });

        // Load URL in WebView
        myweb.loadUrl("http://ucam.uits.edu.bd/Security/LogIn.aspx");
    }

    private void saveLoginInfo(String username, String password) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }


    private void login(String username, String password) {
        // Simulate successful login
        saveLoginInfo(username, password);
        myweb.loadUrl("http://ucam.uits.edu.bd/Security/LogIn.aspx");
    }
}