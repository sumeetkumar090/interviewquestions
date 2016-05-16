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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class JavaPrograms extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.java);

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();

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

				Intent intent = new Intent(JavaPrograms.this, myWebClient.class);
				intent.putExtra("url", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
				startActivity(intent);
				return false;
			}
		});

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

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Java program to print multiplication table");
		listDataHeader.add("Java program to print Floyd's triangle");
		listDataHeader.add("Java program to transpose matrix");
		listDataHeader.add("Java program to open Notepad");
		listDataHeader.add("Java program to find all substrings of a string");
		listDataHeader.add("Write a program to find out duplicate characters in a string");
		listDataHeader.add("Write a program to print bubble sorting in Java ");
		listDataHeader.add("Write a program to find the sum of the first 1000 prime numbers. ");
		listDataHeader.add("Write a program to Longest Substring without repeating characters");
		listDataHeader.add("Write a program to implement hashcode and equals.");

		// Adding child data
		List<String> p1 = new ArrayList<String>();
		p1.add("http://www.programmingsimplified.com/java/source-code/java-program-print-multiplication-table");

		List<String> p2 = new ArrayList<String>();
		p2.add("http://www.programmingsimplified.com/java/source-code/java-program-print-Floyds-triangle");

		List<String> p3 = new ArrayList<String>();
		p3.add("http://www.programmingsimplified.com/java/source-code/java-program-transpose-matrix");

		List<String> p4 = new ArrayList<String>();
		p4.add("http://www.programmingsimplified.com/java/source-code/java-program-open-notepad");

		List<String> p5 = new ArrayList<String>();
		p5.add("http://www.programmingsimplified.com/java/source-code/java-program-find-substrings-of-string");

		List<String> p6 = new ArrayList<String>();
		p6.add("http://www.java2novice.com/java-interview-programs/duplicate-string-character-count/");

		List<String> p7 = new ArrayList<String>();
		p7.add("http://www.java2novice.com/java-interview-programs/bubble-sort/");

		List<String> p8 = new ArrayList<String>();
		p8.add("http://www.java2novice.com/java-interview-programs/prime-sum/");

		List<String> p9 = new ArrayList<String>();
		p9.add("http://www.java2novice.com/java-interview-programs/longest-substring/");

		List<String> p10 = new ArrayList<String>();
		p10.add("http://www.java2novice.com/java-interview-programs/equals-hashcode/");

		listDataChild.put(listDataHeader.get(0), p1);
		listDataChild.put(listDataHeader.get(1), p2);
		listDataChild.put(listDataHeader.get(2), p3);
		listDataChild.put(listDataHeader.get(3), p4);
		listDataChild.put(listDataHeader.get(4), p5);
		listDataChild.put(listDataHeader.get(5), p6);
		listDataChild.put(listDataHeader.get(6), p7);
		listDataChild.put(listDataHeader.get(7), p8);
		listDataChild.put(listDataHeader.get(8), p9);
		listDataChild.put(listDataHeader.get(9), p10);

	}
}
