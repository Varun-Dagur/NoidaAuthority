package com.noida.authority.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.errorprone.annotations.concurrent.UnlockMethod;
import com.noida.authority.R;
import com.noida.authority.utils.BaseActivity;

public class WebVersion extends AppCompatActivity {

    ProgressDialog pDialog;
    private WebView webview;
    String url = "";
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        url = getIntent().getStringExtra("Url");
        setWebview();
    }

    private void setWebview() {
        pDialog = new ProgressDialog(this);
        pDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        pDialog.setCancelable(false);

        webview = findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setAllowFileAccessFromFileURLs(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.addJavascriptInterface(new UnlockMethod[0], "AndroidUnlock");
        webview.setWebChromeClient(new WebChromeClient());


        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setDatabaseEnabled(true);
        webview.getSettings().setDatabasePath("/data/data/" + webview.getContext().getPackageName() + "/databases/");


        startWebView(url);

    }

    private void startWebView(String url) {
        pDialog.show();

        //Create new webview Client to show progress dialog
        //When opening a url or click on link
        webview.setWebViewClient(new WebViewClient() {

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d("Url : ",url);
                if(url.equals("https://pims.mynoida.in/Home/MainScreen")){
                    startWebView("http://pms.mynoida.in/");
                }

                pDialog.dismiss();
            }
        });

        //Load url in webview
        webview.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        String webUrl = webview.getUrl();
        if(webUrl.equals(url))
        {
            // Clear History URL
            webview.clearCache(true);
            webview.clearHistory();
            webview.destroy();
            super.onBackPressed();
            return;
        }

        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to go Exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
        }
    }
}
