package com.sameer.firstlightapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Modern Edge-to-Edge System Bar styling
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        webView.setWebChromeClient(new android.webkit.WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/www/index.html");

        setContentView(webView);

        // Handle Back button gracefully
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // If a modal/sheet is open in the web app, let javascript close it
                webView.evaluateJavascript("(function(){ if (window.handleAppBack) { return window.handleAppBack(); } return false; })()", value -> {
                    if ("true".equals(value)) {
                        // JavaScript closed a sheet/modal
                        return;
                    }
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        setEnabled(false);
                        getOnBackPressedDispatcher().onBackPressed();
                    }
                });
            }
        });
    }
}

