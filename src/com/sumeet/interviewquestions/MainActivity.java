package com.sumeet.interviewquestions;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;

import javax.security.auth.PrivateCredentialPermission;

 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText text, text1;
	Button login, register;
	public static final String MY_FILE = "InterviewUsers";
	private String name;
	private String passwd;

	private SharedPreferences sharedPreference;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sharedPreference = getSharedPreferences(MY_FILE, Context.MODE_PRIVATE);
		
		text = (EditText) findViewById(R.id.edittext1);
		text1 = (EditText) findViewById(R.id.edittext2);
	}

	public void LoginButton(View view) {

		String textview1 = text.getText().toString();
		String password1 = text1.getText().toString();
		Editor editor = sharedPreference.edit();

		String oldname = sharedPreference.getString("nameKey", name);
		String oldpassword = sharedPreference.getString("passwdkey", "");
		if (TextUtils.isEmpty(textview1)) {
			Toast.makeText(MainActivity.this, "Please Enter UserName", 0).show();
			editor.putBoolean("isLoggedIn", false);
		} else if (TextUtils.isEmpty(password1)) {
			Toast.makeText(MainActivity.this, "Please Enter Password", 0).show();
			editor.putBoolean("isLoggedIn", false);
		}

		else {
			if (textview1.equals(oldname) && password1.equals(oldpassword)) {
				editor.putBoolean("isLoggedIn", true);
				Intent i = new Intent(MainActivity.this, Login.class);
				startActivity(i);
				finish();
			} else {
				editor.putBoolean("isLoggedIn", false);
				Toast.makeText(MainActivity.this, "Error", 0).show();
			}
		}
		editor.commit();

	}

	public void Register(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this, Register.class);
		startActivity(intent);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.logout) {
			SignOut();
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

	public void SignOut() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Do You Really Want to Quit?");
		builder.setCancelable(true);
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// do nothing, since setCancelable is true, canceling is enabled
			}
		});
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				finish();

			}
		});
		AlertDialog alert = builder.create();
		alert.show();
		alert.setCancelable(true);
	}

}
