package com.sumeet.interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class Android extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.android);

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
//				Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded",
//						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
//				Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Collapsed",
//						Toast.LENGTH_SHORT).show();

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
		listDataHeader.add("What is Android?");// 1
		listDataHeader.add("Describe Android application Architecture?");// 2
		listDataHeader.add("What is An Activity?");// 3
		listDataHeader.add("What is the APK format?");// 4
		listDataHeader.add("What is An Intent?");// 5
		listDataHeader.add("What is an explicit Intent?");// 6
		listDataHeader.add("What is an implicit Intent?");// 7
		listDataHeader.add("What is An android manifest file?");// 8
		listDataHeader.add("What language does android support to develop an application?");// 9
		listDataHeader.add("What do ADT stands for?");// 10
		listDataHeader.add("What are the tools are placed in An Android SDK?");// 11
		listDataHeader.add("What is viewGroup in android?");// 12
		listDataHeader.add("What is a service in android?");// 13
		listDataHeader.add("What is a content provider in android?");// 14
		listDataHeader.add("What are the notifications available in android?");// 15
		listDataHeader.add("What is ANR in android?");// 16
		listDataHeader.add("What is shared preferences in android?");// 17
		listDataHeader.add("What is nine-patch images tool in android?");// 18
		listDataHeader.add("What is the order of dialog-box in android?");// 19
		listDataHeader.add("What are the different storages available in android?");// 20
		listDataHeader.add("What is a Sticky Intent in android?");// 21
		listDataHeader.add("Why can't you run java byte code on Android?");// 22
		listDataHeader.add("How to launch an activity in android?");// 23
		listDataHeader.add("What is singleton class in android?");// 24
		listDataHeader.add("What is fragment in android?");// 25
		listDataHeader.add("How to update UI from a service in android?");// 26
		listDataHeader.add("What is drawable folder in android?");// 27
		listDataHeader.add("How do you find any view element into your program?");// 28
		listDataHeader.add("What are the type of flags to run an application in android?");// 29
		listDataHeader.add("What is an Adapter in android?");// 30
		listDataHeader.add("How to Translate in Android?");// 31
		listDataHeader.add("What is NDK?");// 32
		listDataHeader.add("Name some exceptions in android?");// 33
		listDataHeader.add(" What is the importance of having an emulator within the Android environment?");// 34
		listDataHeader.add("Differentiate Activities from Services.");// 35
		listDataHeader.add(" What are containers?");// 36
		listDataHeader.add("What is Orientation?");// 37
		listDataHeader.add("What do you think are some disadvantages of Android?");// 38
		listDataHeader.add(" How are escape characters used as attribute?");// 39
		listDataHeader.add("What is the function of an intent filter?");// 40
		listDataHeader.add("How can the ANR be prevented?");// 41
		listDataHeader.add("What role does Dalvik play in Android development?");// 42
		listDataHeader.add("What is the AndroidManifest.xml?");// 43
		listDataHeader.add("What is the importance of Default Resources?");// 44
		listDataHeader.add("What is AIDL?");// 45
		listDataHeader.add("What is a visible activity?");// 46
		listDataHeader.add("When is the best time to kill a foreground activity?");// 47
		listDataHeader.add("How do you remove icons and widgets from the main screen of the Android device?");// 48
		listDataHeader.add("What is the difference between a regular bitmap and a nine-patch image?");// 49
		listDataHeader.add("What is portable wi-fi hotspot?");// 50
		// Adding child data 1
		List<String> comingSoon1 = new ArrayList<String>();
		comingSoon1.add(
				"Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine.");
		// 2
		List<String> comingSoon2 = new ArrayList<String>();
		comingSoon2.add(
				"Android application architecture has the following components.They are as follows  Services  It will perform background functionalities , Intent  It will perform the inter connection between activities and the data passing mechanism ,  Resource Externalization  strings and graphics , Notification light,sound,icon,notification,dialog box,and toast , Content Providers  It will share the data between applications");
		// 3
		List<String> comingSoon3 = new ArrayList<String>();
		comingSoon3.add(
				"Activity performs actions on the screen.If you want to do any operations, we can do with activity");
		// 4
		List<String> comingSoon4 = new ArrayList<String>();
		comingSoon4.add(
				"The Android packaging key is compressed with classes,UI's, supportive assets and manifest.All files are compressed to a single file is called APK.");
		// 5
		List<String> comingSoon5 = new ArrayList<String>();
		comingSoon5.add(
				"It is connected to either the external world of application or internal world of application ,Such as, opening a pdf is an intent and connect to the web browser.etc.");
		// 6
		List<String> comingSoon6 = new ArrayList<String>();
		comingSoon6.add(
				"Android Explicit intent specifies the component to be invoked from activity. In other words, we can call another activity in android by explicit intent.");
		// 7
		List<String> comingSoon7 = new ArrayList<String>();
		comingSoon7.add(
				"Implicit Intent doesn't specifiy the component. In such case, intent provides information of available components provided by the system that is to be invoked.");
		// 8

		List<String> comingSoon8 = new ArrayList<String>();
		comingSoon8.add(
				"Every application must have an AndroidManifest.xml file (with precisely that name) in its root directory. The manifest file presents essential information about your app to the Android system, information the system must have before it can run any of the app's code");
		// 9
		List<String> comingSoon9 = new ArrayList<String>();
		comingSoon9.add("Android applications has written using the java(Android SDK) and C/C++(Android NDK).");
		// 10
		List<String> comingSoon10 = new ArrayList<String>();
		comingSoon10.add(
				"ADT stands for Android development tool,This is useful to develop the applications and test the applications.");
		// 11
		List<String> comingSoon11 = new ArrayList<String>();
		comingSoon11.add(
				"Android SDK collaborated with Android Emulator,DDMS(Dalvik Debug Monitoring Services),AAPT(Android Asset Packaging tool) and ADB(Android debug bridge)");
		// 12
		List<String> comingSoon12 = new ArrayList<String>();
		comingSoon12.add(
				"View group is a collection of views and other child views, it is an invisible part and the base class for layouts.");
		// 13
		List<String> comingSoon13 = new ArrayList<String>();
		comingSoon13.add("The Service is like as an activity to do background functionalities without UI interaction.");
		// 14
		List<String> comingSoon14 = new ArrayList<String>();
		comingSoon14.add(
				"A content provider component supplies data from one application to others on request. Such requests are handled by the methods of the ContentResolver class. A content provider can use different ways to store its data and the data can be stored in a database, in files, or even over a network.");
		// 15
		List<String> comingSoon15 = new ArrayList<String>();
		comingSoon15.add(
				"Toast Notification  It will show a pop up message on the surface of the window , Status Bar Notification  It will show notifications on status bar, Dialogue Notification  It is an activity related notification.");
		// 16
		List<String> comingSoon16 = new ArrayList<String>();
		comingSoon16.add(
				"ANR stands for application is not responding, basically it is a dialog box that appears when the application is not responding.");
		// 17
		List<String> comingSoon17 = new ArrayList<String>();
		comingSoon17.add("Shared preferences are the simplest mechanism to store the data in XML documents.");
		// 18
		List<String> comingSoon18 = new ArrayList<String>();
		comingSoon18.add("We can change bitmap images in nine sections as four corners,four edges and an axis");
		// 19
		List<String> comingSoon19 = new ArrayList<String>();
		comingSoon19.add("AlertDialog, ProgressDialog,DatePickerDialog, and TimePickerDialog");
		// 20
		List<String> comingSoon20 = new ArrayList<String>();
		comingSoon20
				.add("Shared Preferences,Internal Storage,External Storage,SQLite Databases and Network Connection");
		// 21
		List<String> comingSoon21 = new ArrayList<String>();
		comingSoon21.add(
				"Sticky Intent is also a type of intent which allows the communication between a function and a service for example,sendStickyBroadcast() is perform the operations after completion of intent also.");
		// 22
		List<String> comingSoon22 = new ArrayList<String>();
		comingSoon22.add(
				"Android uses DVM (Dalvik Virtual Machine ) rather using JVM(Java Virtual Machine), if we want, we can get access to .jar file as a library.");
		// 23
		List<String> comingSoon23 = new ArrayList<String>();
		comingSoon23.add("Using with intent, we can launch an activity.");
		// 24
		List<String> comingSoon24 = new ArrayList<String>();
		comingSoon24
				.add("A class which can create only an object, that object can be share able to all other classes.");
		// 25

		List<String> comingSoon25 = new ArrayList<String>();
		comingSoon25.add(
				"Fragment is a piece of activity, if you want to do turn your application 360 degrees, you can do this by fragment.");
		// 26
		List<String> comingSoon26 = new ArrayList<String>();
		comingSoon26.add(
				"Use a dynamic broadcast receiver in the activity, and send a broadcast from the service. Once the dynamic receiver is triggered update UI from that receiver");
		// 27
		List<String> comingSoon27 = new ArrayList<String>();
		comingSoon27.add("A compiled visual resource that can used as a backgrounds,banners, icons,splash screen etc.");
		// 28
		List<String> comingSoon28 = new ArrayList<String>();
		comingSoon28.add("Using with findViewById we can find view element.");
		// 29

		List<String> comingSoon29 = new ArrayList<String>();
		comingSoon29.add("FLAG_ACTIVITY_NEW_TASK  , FLAG_ACTIVITY_CLEAR_TOP.");
		// 30
		List<String> comingSoon30 = new ArrayList<String>();
		comingSoon30.add("The Adapter is used to create child views to represent the parent view items.");

		// 31
		List<String> comingSoon31 = new ArrayList<String>();
		comingSoon31.add(
				"Android uses Google translator to translate data from one language into another language and placed as a string while development");

		// 32
		List<String> comingSoon32 = new ArrayList<String>();
		comingSoon32.add(
				"NDK stands for Native Development Kit. By using NDK, you can develop a part of app using native language such as C/C++ to boost the performance.");

		// 33
		List<String> comingSoon33 = new ArrayList<String>();
		comingSoon33.add(
				"Inflate Exception, Surface.OutOfResourceException, SurfaceHolder.BadSurfaceTypeException, WindowManager.BadTokenException");

		// 34
		List<String> comingSoon34 = new ArrayList<String>();
		comingSoon34.add(
				"The emulator lets developers “play” around an interface that acts as if it were an actual mobile device. They can write and test codes, and even debug. Emulators are a safe place for testing codes especially if it is in the early design phase.");

		// 35
		List<String> comingSoon35 = new ArrayList<String>();
		comingSoon35.add(
				"Activities can be closed, or terminated anytime the user wishes. On the other hand, services are designed to run behind the scenes, and can act independently. Most services run continuously, regardless of whether there are certain or no activities being executed.");

		// 36
		List<String> comingSoon36 = new ArrayList<String>();
		comingSoon36.add(
				"Containers, as the name itself implies, holds objects and widgets together, depending on which specific items are needed and in what particular arrangement that is wanted. Containers may hold labels, fields, buttons, or even child containers, as examples.");

		// 37
		List<String> comingSoon37 = new ArrayList<String>();
		comingSoon37.add(
				"Orientation, which can be set using setOrientation(), dictates if the LinearLayout is represented as a row or as a column. Values are set as either HORIZONTAL or VERTICAL.");

		// 38
		List<String> comingSoon38 = new ArrayList<String>();
		comingSoon38.add(
				"Given that Android is an open-source platform, and the fact that different Android operating systems have been released on different mobile devices, there’s no clear cut policy to how applications can adapt with various OS versions and upgrades. One app that runs on this particular version of Android OS may or may not run on another version. Another disadvantage is that since mobile devices such as phones and tabs come in different sizes and forms, it poses a challenge for developers to create apps that can adjust correctly to the right screen size and other varying features and specs.");

		// 39
		List<String> comingSoon39 = new ArrayList<String>();
		comingSoon39.add("Escape characters are preceded by double backslashes. For example, a newline character is created using ‘\n’");

		// 40
		List<String> comingSoon40 = new ArrayList<String>();
		comingSoon40.add("Because every component needs to indicate which intents they can respond to, intent filters are used to filter out intents that these components are willing to receive. One or more intent filters are possible, depending on the services and activities that is going to make use of it.");

		// 41
		List<String> comingSoon41 = new ArrayList<String>();
		comingSoon41.add("One technique that prevents the Android system from concluding a code that has been responsive for a long period of time is to create a child thread. Within the child thread, most of the actual workings of the codes can be placed, so that the main thread runs with minimal periods of unresponsive times.");

		// 42
		List<String> comingSoon42 = new ArrayList<String>();
		comingSoon42.add("Dalvik serves as a virtual machine, and it is where every Android application runs. Through Dalvik, a device is able to execute multiple virtual machines efficiently through better memory management.");

		// 43
		List<String> comingSoon43 = new ArrayList<String>();
		comingSoon43.add("This file is essential in every application. It is declared in the root directory and contains information about the application that the Android system must know before the codes can be executed.");

		// 44
		List<String> comingSoon44 = new ArrayList<String>();
		comingSoon44.add("When default resources, which contain default strings and files, are not present, an error will occur and the app will not run. Resources are placed in specially named subdirectories under the project res/ directory.");

		// 45
		List<String> comingSoon45 = new ArrayList<String>();
		comingSoon45.add("AIDL, or Android Interface Definition Language, handles the interface requirements between a client and a service so both can communicate at the same level through interprocess communication or IPC. This process involves breaking down objects into primitives that Android can understand. This part is required simply because a process cannot access the memory of the other process.");

		// 46
		List<String> comingSoon46 = new ArrayList<String>();
		comingSoon46.add("A visible activity is one that sits behind a foreground dialog. It is actually visible to the user, but not necessarily being in the foreground itself.");

		// 47
		List<String> comingSoon47 = new ArrayList<String>();
		comingSoon47.add("The foreground activity, being the most important among the other states, is only killed or terminated as a last resort, especially if it is already consuming too much memory. When a memory paging state has been reach by a foreground activity, then it is killed so that the user interface can retain its responsiveness to the user.");

		// 48
		List<String> comingSoon48 = new ArrayList<String>();
		comingSoon48.add("To remove an icon or shortcut, press and hold that icon. You then drag it downwards to the lower part of the screen where a remove button appears.");

		// 49
		List<String> comingSoon49 = new ArrayList<String>();
		comingSoon49.add("In general, a Nine-patch image allows resizing that can be used as background or other image size requirements for the target device. The Nine-patch refers to the way you can resize the image: 4 corners that are unscaled, 4 edges that are scaled in 1 axis, and the middle one that can be scaled into both axes.");

		// 50
		List<String> comingSoon50 = new ArrayList<String>();
		comingSoon50.add("Portable Wi-Fi Hotspot allows you to share your mobile internet connection to other wireless device. For example, using your Android-powered phone as a Wi-Fi Hotspot, you can use your laptop to connect to the Internet using that access point.");

		 

		// Header, Child data
		listDataChild.put(listDataHeader.get(0), comingSoon1);
		listDataChild.put(listDataHeader.get(1), comingSoon2);
		listDataChild.put(listDataHeader.get(2), comingSoon3);
		listDataChild.put(listDataHeader.get(3), comingSoon4);
		listDataChild.put(listDataHeader.get(4), comingSoon5);
		listDataChild.put(listDataHeader.get(5), comingSoon6);
		listDataChild.put(listDataHeader.get(6), comingSoon7);
		listDataChild.put(listDataHeader.get(7), comingSoon8);
		listDataChild.put(listDataHeader.get(8), comingSoon9);
		listDataChild.put(listDataHeader.get(9), comingSoon10);
		listDataChild.put(listDataHeader.get(10), comingSoon11);
		listDataChild.put(listDataHeader.get(11), comingSoon12);
		listDataChild.put(listDataHeader.get(12), comingSoon13);
		listDataChild.put(listDataHeader.get(13), comingSoon14);
		listDataChild.put(listDataHeader.get(14), comingSoon15);
		listDataChild.put(listDataHeader.get(15), comingSoon16);
		listDataChild.put(listDataHeader.get(16), comingSoon17);
		listDataChild.put(listDataHeader.get(17), comingSoon18);
		listDataChild.put(listDataHeader.get(18), comingSoon19);
		listDataChild.put(listDataHeader.get(19), comingSoon20);
		listDataChild.put(listDataHeader.get(20), comingSoon21);
		listDataChild.put(listDataHeader.get(21), comingSoon22);
		listDataChild.put(listDataHeader.get(22), comingSoon23);
		listDataChild.put(listDataHeader.get(23), comingSoon24);
		listDataChild.put(listDataHeader.get(24), comingSoon25);
		listDataChild.put(listDataHeader.get(25), comingSoon26);
		listDataChild.put(listDataHeader.get(26), comingSoon27);
		listDataChild.put(listDataHeader.get(27), comingSoon28);
		listDataChild.put(listDataHeader.get(28), comingSoon29);
		listDataChild.put(listDataHeader.get(29), comingSoon30);
		listDataChild.put(listDataHeader.get(30), comingSoon31);
		listDataChild.put(listDataHeader.get(31), comingSoon32);
		listDataChild.put(listDataHeader.get(32), comingSoon33);
		listDataChild.put(listDataHeader.get(33), comingSoon34);
		listDataChild.put(listDataHeader.get(34), comingSoon35);
		listDataChild.put(listDataHeader.get(35), comingSoon36);
		listDataChild.put(listDataHeader.get(36), comingSoon37);
		listDataChild.put(listDataHeader.get(37), comingSoon38);
		listDataChild.put(listDataHeader.get(38), comingSoon39);
		listDataChild.put(listDataHeader.get(39), comingSoon40);
		listDataChild.put(listDataHeader.get(40), comingSoon41);
		listDataChild.put(listDataHeader.get(41), comingSoon42);
		listDataChild.put(listDataHeader.get(42), comingSoon43);
		listDataChild.put(listDataHeader.get(43), comingSoon44);
		listDataChild.put(listDataHeader.get(44), comingSoon45);
		listDataChild.put(listDataHeader.get(45), comingSoon46);
		listDataChild.put(listDataHeader.get(46), comingSoon47);
		listDataChild.put(listDataHeader.get(47), comingSoon48);
		listDataChild.put(listDataHeader.get(48), comingSoon49);
		listDataChild.put(listDataHeader.get(49), comingSoon50);

	}
}
