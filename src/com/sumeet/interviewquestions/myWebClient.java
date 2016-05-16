package com.sumeet.interviewquestions;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class myWebClient extends Activity {
	WebView web;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.webview);

		web = (WebView) findViewById(R.id.webview01);
		web.getSettings().setJavaScriptEnabled(true);
		String url = getIntent().getStringExtra("url");

		web.loadUrl(url);

		web.setWebViewClient(new WebViewClient() {

			ProgressDialog progressDialog;

			// Show loader on url load
			public void onLoadResource(WebView view, String url) {
				if (progressDialog == null) {
					// in standard case YourActivity.this
					progressDialog = new ProgressDialog(myWebClient.this);
					progressDialog.setMessage("Loading...");
					progressDialog.setCancelable(true);
					progressDialog.show();
				}
			}

			public void onPageFinished(WebView view, String url) {
				try {
					if (progressDialog.isShowing()) {
						progressDialog.dismiss();
						// progressDialog = null;
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO Auto-generated method stub
				super.onPageStarted(view, url, favicon);
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub

				view.loadUrl(url);
				return true;

			}

		});

	}

}
