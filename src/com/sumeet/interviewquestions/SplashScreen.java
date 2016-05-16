package com.sumeet.interviewquestions;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashScreen extends Activity {
	private static int SPLASH_TIME_OUT = 3000;
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;
	private SharedPreferences sharedPreference;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		startAnimation();
		sharedPreference = getSharedPreferences("InterviewUsers", Context.MODE_PRIVATE);
	}

	private void startAnimation() {
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.reset();
		RelativeLayout l = (RelativeLayout) findViewById(R.id.splashscreen);
		l.clearAnimation();
		l.startAnimation(anim);
		anim = AnimationUtils.loadAnimation(this, R.anim.tranlate);
		anim.reset();
		launchLoginScreen();
	}

	private void launchLoginScreen() {
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				String oldname = sharedPreference.getString("nameKey", "");
				String oldpassword = sharedPreference.getString("passwdkey", "");
				
				String oldname1 = sharedPreference.getString("nameKey1", "");
				String oldpassword1 = sharedPreference.getString("passwdkey1", "");
				
				
				if((oldname.isEmpty() && oldpassword.isEmpty()))
				{
					Intent intent = new Intent(SplashScreen.this, LoginScreen.class);
					startActivity(intent);
					
				}
				  
				
				else {
					Intent intent = new Intent(SplashScreen.this, DashBoard.class);
					startActivity(intent);
				}
				finish();
				// TODO Auto-generated method stub

			}
		}, SPLASH_TIME_OUT);
	}

}
