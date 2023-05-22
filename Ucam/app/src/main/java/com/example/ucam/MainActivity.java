import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    String url = "http://ucam.uits.edu.bd/Security/LogIn.aspx";

    class MyJavaScriptInterface {
        MyJavaScriptInterface() {
        }
        @SuppressWarnings("unused")
        @JavascriptInterface
        public void processContent(String user,String pass) {
            Log.e("Remember", "user:"+user+" pass:"+pass);
            if (!(user.length() >= 1 && pass.length() >= 1))
                return;


            SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserInformation",MODE_PRIVATE);
            if (sharedPreferences.getBoolean("isClickYes", false)) {
                sharedPreferences.edit().putString("us",user).apply();
                sharedPreferences.edit().putString("pass",pass).apply();
            }

            if (!sharedPreferences.getBoolean("isClickYes", false)) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("save information")
                        .setMessage("Are You Want Save Password?")

                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                sharedPreferences.edit().putString("us",user).apply();
                                sharedPreferences.edit().putString("pass",pass).apply();
                                sharedPreferences.edit().putBoolean("isClickYes",true).apply();
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_popup_reminder)
                        .show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();

        websettings.setDomStorageEnabled(true);
        websettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new MyJavaScriptInterface(), "INTERFACE");
        webView.getSettings().setAppCachePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/cache");
        webView.getSettings().setDatabasePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/databases");

        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }



            private void runOnUi(int page, WebView view ,SharedPreferences sharedPreferences) {
                int LOGIN      = 0;
                int LOGIN_PASS = 1;
                WebViewActivity.this.runOnUiThread(() -> {
                    if (page == LOGIN_PASS) {
                        view.loadUrl("javascript:(function(){l=document.getElementById(\"formLogin\"); l.setAttribute(\"onclick\",\"" +
                                "INTERFACE.processContent(  document.getElementById('txtUserId').value , document.getElementById('txtPassword').value  );\"   );       " + "})()");

                        if (sharedPreferences.getBoolean("isClickYes", false)) {
                            String pass = sharedPreferences.getString("pass", "");
                            view.loadUrl("javascript:(function(){l=document.getElementById('txtPassword');l.value='" + pass + "'; })()");
                        }
                    } else if (page == LOGIN) {
                        String user = sharedPreferences.getString("us", "");
                        view.loadUrl("javascript:(function(){l=document.getElementById('txtUserId2');l.value='" + user + "'; })()");
                    }
                });
            }



            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {




                if (request.getUrl().toString().equals("https/.../....png")) {
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserInformation", MODE_PRIVATE);
                    if (request.getRequestHeaders().toString().contains("Referer=https/...../loginpass"))
                        runOnUi(1, view, sharedPreferences);
                    else if (request.getRequestHeaders().toString().contains("Referer=https/...../login"))
                        runOnUi(0, view, sharedPreferences);
                }



                return super.shouldInterceptRequest(view, request);
            }
        }

    }

    webView.loadUrl("http://ucam.uits.edu.bd/Security/LogIn.aspx");
    ...
}