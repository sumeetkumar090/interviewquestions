package com.sumeet.interviewquestions;

import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInstaller.Session;
import android.net.Uri;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sumeet.interviewquestions.SessionManager;;

public class Register extends ActionBarActivity {

	Button register;
	String url;

	String str_Name, str_Password, str_RePassword, str_Email, str_Mobile, random;

	EditText edt_Name, edt_Password, edt_RePassword, edt_Email, edt_Mobile;

	public static final String MyPREFERENCES = "InterviewUsers";
	public static final String Name = "nameKey";
	public static final String Password = "passwdkey";
	public static final String Phone = "phoneKey";
	public static final String Email = "emailKey";
	public static final String Name1 = "nameKey1";
	public static final String Password1 = "passwdkey1";

	SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SessionManager session = new SessionManager(getApplicationContext());
		setContentView(R.layout.register);

		register = (Button) findViewById(R.id.btn_register);
		edt_Name = (EditText) findViewById(R.id.edt_Rname);
		edt_Password = (EditText) findViewById(R.id.edt_Rpassword);
		edt_RePassword = (EditText) findViewById(R.id.edt_RRepassword);
		edt_Mobile = (EditText) findViewById(R.id.edt_Rmobile);
		edt_Email = (EditText) findViewById(R.id.edt_email);
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	}

	 @Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		 
	}

	public void Registration(View v) {
		// TODO Auto-generated method stub
		str_Name = edt_Name.getText().toString();
		str_Password = edt_Password.getText().toString();
		str_RePassword = edt_RePassword.getText().toString();
		str_Mobile = edt_Mobile.getText().toString();
		str_Email = edt_Email.getText().toString();

		SharedPreferences.Editor editor = sharedpreferences.edit();
		editor.putString(Name, str_Name);
		editor.putString(Password, str_Password);
		editor.putString(Phone, str_Mobile);
		editor.putString(Email, str_Email);
		editor.putString(Name1, str_Name);
		editor.putString(Password1, str_Password);
		editor.commit();

		if (str_Name.length() == 0 & str_Password.length() == 0 & str_RePassword.length() == 0
				& str_Mobile.length() == 0) {
			Toast.makeText(getApplicationContext(), "All fields are mandatory to fill", Toast.LENGTH_LONG).show();
		} else if (str_Name.length() == 0) {
			Toast.makeText(getApplicationContext(), "Please enter your Name", Toast.LENGTH_LONG).show();
		} else if (str_Password.length() == 0) {
			Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
		} else if (str_RePassword.length() == 0) {
			Toast.makeText(getApplicationContext(), "Please Re-enter your Password", Toast.LENGTH_LONG).show();
		}

		else if (!str_Email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
			Toast.makeText(getApplicationContext(), "Please enter your Email Id", Toast.LENGTH_LONG).show();
		}

		else if (str_Password.contains(str_RePassword) != str_RePassword.contains(str_Password)) {
			Toast.makeText(getApplicationContext(), "Confirm Password does not match", Toast.LENGTH_LONG).show();

		} else if ((str_Mobile.length() == 0) || (str_Mobile.length() == 1) || (str_Mobile.length() == 2)
				|| (str_Mobile.length() == 3) || (str_Mobile.length() == 4) || (str_Mobile.length() == 5)
				|| (str_Mobile.length() == 8) || (str_Mobile.length() == 9)) {

			Toast.makeText(getApplicationContext(), "Please enter your mobile number", Toast.LENGTH_LONG).show();

		}

		else {
			Intent sendtoLogin = new Intent(getApplicationContext(), LoginScreen.class);

			Toast.makeText(getApplicationContext(), "You have successfully registered", Toast.LENGTH_LONG).show();

			// SmsManager.getDefault().sendTextMessage(str_Mobile, null, "You
			// have successfully registered.\n Thanks and Regards \n Sumeet
			// Kumar ", null, null);

			 

			startActivity(sendtoLogin);
		}

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
				finish();

			}
		});
		AlertDialog alert = builder.create();
		alert.show();
		alert.setCancelable(true);
	}

}
