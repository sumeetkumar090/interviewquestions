package com.sumeet.interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import android.support.v4.app.FragmentTransaction;

public class CQuestion extends AppCompatActivity implements ActionBar.TabListener {

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
				Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Collapsed",
						Toast.LENGTH_SHORT).show();

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
				return false;
			}
		});

		
	}
	
//	ActionBar ab = getSupportActionBar();
//	ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//	ab.addTab(ab.newTab().setText("General Ques.").setTabListener(this));
//	ab.addTab(ab.newTab().setText("Tab 2").setTabListener(this));
//	ab.addTab(ab.newTab().setText("Tab 3").setTabListener(this));

//
//	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//
//		// Called when a tab is selected
//		int nTabSelected = tab.getPosition();
//		switch (nTabSelected) {
//		case 0:
//			setContentView(R.layout.actionbar_tab_1);
//			break;
//		case 1:
//			setContentView(R.layout.actionbar_tab_2);
//			break;
//		case 2:
//			setContentView(R.layout.actionbar_tab_3);
//			break;
//		}
//	}

//	@Override
//	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//		// Called when a tab unselected.
//	}
//
//	@Override
//	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//
//		// Called when a tab is selected again.
//	}

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

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("What is Java?");
		listDataHeader.add("What is OOPS?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");
		listDataHeader.add("Why Java is Used?");

		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("The Shawshank Redemptionsdasdassssssssssss\nasdsadasddddddd");

		List<String> nowShowing = new ArrayList<String>();
		nowShowing.add("The Conjuring");

		List<String> comingSoon = new ArrayList<String>();
		comingSoon.add("2 Guns");

		List<String> comingSoon1 = new ArrayList<String>();
		comingSoon1.add("2 Guns");

		List<String> comingSoon12 = new ArrayList<String>();
		comingSoon12.add("2 Guns");

		List<String> comingSoon2 = new ArrayList<String>();
		comingSoon2.add("2 Guns");

		List<String> comingSoon3 = new ArrayList<String>();
		comingSoon3.add("2 Guns");

		List<String> comingSoon4 = new ArrayList<String>();
		comingSoon4.add("2 Guns");

		List<String> comingSoon5 = new ArrayList<String>();
		comingSoon5.add("2 Guns");

		List<String> comingSoon6 = new ArrayList<String>();
		comingSoon6.add("2 Guns");

		listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
		listDataChild.put(listDataHeader.get(1), nowShowing);
		listDataChild.put(listDataHeader.get(2), comingSoon);
		listDataChild.put(listDataHeader.get(3), comingSoon1);
		listDataChild.put(listDataHeader.get(4), comingSoon12);
		listDataChild.put(listDataHeader.get(5), comingSoon3);
		listDataChild.put(listDataHeader.get(6), comingSoon4);
		listDataChild.put(listDataHeader.get(7), comingSoon5);
		listDataChild.put(listDataHeader.get(8), comingSoon6);

	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}
