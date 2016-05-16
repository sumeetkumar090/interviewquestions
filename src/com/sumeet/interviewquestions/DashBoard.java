package com.sumeet.interviewquestions;

import java.util.HashMap;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DashBoard extends ActionBarActivity {

	SharedPreferences.Editor editor;
	SharedPreferences sharedpreferences;
	String login = "";
	String passwd = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		sharedpreferences = getSharedPreferences("InterviewUsers", Context.MODE_PRIVATE);
		Editor editor = sharedpreferences.edit();
		login = sharedpreferences.getString("nameKey1", "");
		passwd = sharedpreferences.getString("passwdkey1", "");

	}

	// C Language function
	public void CLang(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(DashBoard.this, CTabLayoutActivity.class);
		startActivity(intent);
	}

	public void Java(View view) {
		// TODO Auto-generated method stub

		Intent intent = new Intent(DashBoard.this, JavaTabLayoutActivity.class);
		startActivity(intent);
	}

	public void Android(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(DashBoard.this, AndroidTabLayoutActivity.class);
		startActivity(intent);
	}

	public void DataS(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(DashBoard.this, DSTabLayoutActivity.class);
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
				editor = sharedpreferences.edit();
				editor.clear();
				editor.commit();
				editor.putString("nameKey1", login);
				editor.putString("passwdkey1", passwd);
				editor.commit();
				
				Intent intent = new Intent(DashBoard.this, LoginScreen.class);
				startActivity(intent);
				finish();

			}
		});
		AlertDialog alert = builder.create();
		alert.show();
		alert.setCancelable(true);
	}

}
