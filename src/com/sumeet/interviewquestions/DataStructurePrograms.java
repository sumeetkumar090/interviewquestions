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

public class DataStructurePrograms extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.data);

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
				Intent intent = new Intent(DataStructurePrograms.this, myWebClient.class);
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
		listDataHeader.add("Find a Peak Element in Array ");// 1
		listDataHeader.add("Check if Binary Tree is Height Balanced? ");// 2
		listDataHeader.add("Find Largest Area Triangle from 2D Matrix");// 3
		listDataHeader.add("Find out if there is cycle in Directed graph ");// 4
		listDataHeader.add(
				"What data str should we use to store restaurants(having location info), So that we can easily find the list of restaurants near my current location ?");// 5
		listDataHeader.add(
				"Merge two sorted singly linked lists into one sorted singly linked list. Allocate no extra node. ");// 6

		// Adding child data
		List<String> q1 = new ArrayList<String>();
		q1.add("http://www.crazyforcode.com/find-peak-element-array/ ");
		List<String> q2 = new ArrayList<String>();
		q2.add("http://www.crazyforcode.com/check-binary-tree-height-balanced/ ");
		List<String> q3 = new ArrayList<String>();
		q3.add("http://www.crazyforcode.com/find-largest-area-triangle-2d-matrix/ ");
		List<String> q4 = new ArrayList<String>();
		q4.add("https://www.careercup.com/question?id=5191830875406336 ");
		List<String> q5 = new ArrayList<String>();
		q5.add("https://www.careercup.com/question?id=5631887822290944 ");
		List<String> q6 = new ArrayList<String>();
		q6.add("https://www.careercup.com/question?id=4920053481865216 ");

		listDataChild.put(listDataHeader.get(0), q1); // Header, Child data
		listDataChild.put(listDataHeader.get(1), q2);
		listDataChild.put(listDataHeader.get(2), q3);
		listDataChild.put(listDataHeader.get(3), q4);
		listDataChild.put(listDataHeader.get(4), q5);
		listDataChild.put(listDataHeader.get(5), q6);

	}
}
