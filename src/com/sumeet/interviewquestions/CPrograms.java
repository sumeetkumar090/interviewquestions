package com.sumeet.interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class CPrograms extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.clang);
		prepareListData();

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data

		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				// Toast.makeText(getApplicationContext(),
				// listDataHeader.get(groupPosition) + " Expanded",
				// Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				// Toast.makeText(getApplicationContext(),
				// listDataHeader.get(groupPosition) + " Collapsed",
				// Toast.LENGTH_SHORT).show();

			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " : "
								+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition),
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(CPrograms.this, myWebClient.class);
				intent.putExtra("url", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
				startActivity(intent);
				return false;
			}
		});

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

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Swap two variables without using third variable. ");
		listDataHeader.add("What is difference between pass by value and pass by reference using Program? ");
		listDataHeader.add("Write a program to print fibonacci series without using recursion? ");
		listDataHeader.add(" Write a program to check armstrong number in C? ");
		listDataHeader.add("Write a program to reverse a given number in C? ");
		listDataHeader.add("How will you print numbers from 1 to 100 without using loop? ");
		listDataHeader.add("Write a c program to print Hello world without using any semicolon. ");

		// Adding child data
		List<String> p1 = new ArrayList<String>();
		p1.add("http://www.cquestions.com/2010/10/c-interview-questions-and-answers.html ");

		List<String> p2 = new ArrayList<String>();
		p2.add("http://www.cquestions.com/2010/10/c-interview-questions-and-answers.html ");

		List<String> p3 = new ArrayList<String>();
		p3.add("http://www.javatpoint.com/c-interview-questions ");

		List<String> p4 = new ArrayList<String>();
		p4.add("http://www.javatpoint.com/c-interview-questions ");

		List<String> p5 = new ArrayList<String>();
		p5.add("http://www.javatpoint.com/c-interview-questions ");

		List<String> p6 = new ArrayList<String>();
		p6.add("http://geeksquiz.com/commonly-asked-c-programming-interview-questions-set-2/ ");

		List<String> p7 = new ArrayList<String>();
		p7.add("http://www.cquestions.com/2010/10/c-interview-questions-and-answers.html ");

		listDataChild.put(listDataHeader.get(0), p1); // Header, Child data
		listDataChild.put(listDataHeader.get(1), p2);
		listDataChild.put(listDataHeader.get(2), p3);
		listDataChild.put(listDataHeader.get(3), p4);
		listDataChild.put(listDataHeader.get(4), p5);
		listDataChild.put(listDataHeader.get(5), p6);
		listDataChild.put(listDataHeader.get(6), p7);

	}

}
