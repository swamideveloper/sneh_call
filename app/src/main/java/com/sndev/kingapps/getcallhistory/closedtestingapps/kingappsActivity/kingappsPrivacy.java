package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity;

import static com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsActivity.kingappsSplash.key_Privacy;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.sndev.kingapps.getcallhistory.closedtestingapps.R;


public class kingappsPrivacy extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kingappsprivacy);

        progressBar = findViewById(R.id.progressBar);
        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });

        webView.loadUrl(key_Privacy);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
