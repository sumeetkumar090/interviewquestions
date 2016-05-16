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

public class JavaQuestion extends Activity {

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
		listDataHeader.add("Why is Java Architectural Neutral?");// 1
		listDataHeader.add("How Java enabled High Performance?");// 2
		listDataHeader.add("Why Java is considered dynamic? ");// 3
		listDataHeader.add(" What is Java Virtual Machine and how it is considered in context of Java’s platform independent feature?");// 4
		listDataHeader.add("What do you mean by Object? ");// 5
		listDataHeader.add("Define class?");// 6
		listDataHeader.add("What is a Local Variable? ");// 7
		listDataHeader.add("What is a Instance Variable?  ");// 8
		listDataHeader.add("What is Singleton class?");// 9
		listDataHeader.add("What do you mean by Constructor? ");// 10
		listDataHeader.add(" List the three steps for creating an Object for a class?");// 11
		listDataHeader.add("What is the default value of byte datatype in Java? ");// 12
		listDataHeader.add("What is a static variable? ");// 13
		listDataHeader.add("What do you mean by Access Modifier? ");// 14
		listDataHeader.add("What do you mean by synchronized Non Access Modifier?");// 15
		listDataHeader.add("According to Java Operator precedence, which operator is considered to be with highest precedence?");// 16
		listDataHeader.add("Variables used in a switch statement can be used with which datatypes? ");// 17
		listDataHeader.add("Why is String class considered immutable? ");// 18
		listDataHeader.add("Why is StringBuffer called mutable? ");// 19
		listDataHeader.add("What is the difference between StringBuffer and StringBuilder class?");// 20
		listDataHeader.add("java.util.regex consists of which classes?");// 21
		listDataHeader.add("What is finalize() method?");// 22
		listDataHeader.add("What is an Exception? ");// 23
		listDataHeader.add("When throws keyword is used?");// 24
		listDataHeader.add("When throw keyword is used? ");// 25
		listDataHeader.add("How finally used under Exception Handling? ");// 26
		listDataHeader.add("When super keyword is used? ");// 27
		listDataHeader.add("What is Abstract class?");// 28
		listDataHeader.add("What is the primary benefit of Encapsulation? ");// 29
		listDataHeader.add("What is an Interface?");// 30
		listDataHeader.add("Why Packages are used? ");// 31
		listDataHeader.add("What do you mean by Multithreaded program? ");// 32
		listDataHeader.add("What is an applet? ");// 33
		listDataHeader.add("Explain garbage collection in Java?");// 34
		listDataHeader.add("Define immutable object?");// 35
		listDataHeader.add("Explain the usage of this() with constructors? ");// 36
		listDataHeader.add("Explain Set Interface?");// 37
		listDataHeader.add("Explain TreeSet? ");// 38
		listDataHeader.add("What is Comparable Interface?");// 39
		listDataHeader.add("Difference between throw and throws?");// 40
		listDataHeader.add("Define JRE i.e. Java Runtime Environment?");// 41
		listDataHeader.add("What is JAR file? ");// 42
		listDataHeader.add("Define JIT compiler? ");// 43
		listDataHeader.add("What is static block? ");// 44
		listDataHeader.add("Define composition? ");// 45
		listDataHeader.add("What is function overloading? ");// 46
		listDataHeader.add("What is function overriding? ");// 47
		listDataHeader.add("What is final class? ");// 48
		listDataHeader.add("What is NullPointerException?");// 49
		listDataHeader.add("What are the ways in which a thread can enter the waiting state? ");// 50
		listDataHeader.add("How does multi-threading take place on a computer with a single CPU? ");// 51
		 

		// 1
		List<String> a1 = new ArrayList<String>();
		a1.add("It’s compiler generates an architecture-neutral object file format, which makes the compiled code to be executable on many processors, with the presence of Java runtime system.");
		// 2
		List<String> a2 = new ArrayList<String>();
		a2.add("Java uses Just-In-Time compiler to enable high performance. Just-In-Time compiler is a program that turns Java bytecode, which is a program that contains instructions that must be interpreted into instructions that can be sent directly to the processor.");
		// 3
		List<String> a3 = new ArrayList<String>();
		a3.add("It is designed to adapt to an evolving environment. Java programs can carry extensive amount of run-time information that can be used to verify and resolve accesses to objects on run-time.");
		// 4
		List<String> a4 = new ArrayList<String>();
		a4.add("When Java is compiled, it is not compiled into platform specific machine, rather into platform independent byte code. This byte code is distributed over the web and interpreted by virtual Machine (JVM) on whichever platform it is being run");
		// 5
		List<String> a5 = new ArrayList<String>();
		a5.add("Object is a runtime entity and it’s state is stored in fields and behavior is shown via methods. Methods operate on an object's internal state and serve as the primary mechanism for object-to-object communication.");
		// 6
		List<String> a6 = new ArrayList<String>();
		a6.add("A class is a blue print from which individual objects are created. A class can contain fields and methods to describe the behavior of an object.");
		// 7
		List<String> a7 = new ArrayList<String>();
		a7.add("Variables defined inside methods, constructors or blocks are called local variables. The variable will be declared and initialized within the method and it will be destroyed when the method has completed.");
		// 8
		List<String> a8 = new ArrayList<String>();
		a8.add("Instance variables are variables within a class but outside any method. These variables are instantiated when the class is loaded.");
		// 9
		List<String> a9 = new ArrayList<String>();
		a9.add("Singleton class control object creation, limiting the number to one but allowing the flexibility to create more objects if the situation changes.");
		// 10
		List<String> a10 = new ArrayList<String>();
		a10.add("Constructor gets invoked when a new object is created. Every class has a constructor. If we do not explicitly write a constructor for a class the java compiler builds a default constructor for that class.");
		// 11
		List<String> a11 = new ArrayList<String>();
		a11.add("An Object is first declared, then instantiated and then it is initialized.");
		// 12
		List<String> a12 = new ArrayList<String>();
		a12.add("Default value of byte datatype is 0.");
		// 13
		List<String> a13 = new ArrayList<String>();
		a13.add("Class variables also known as static variables are declared with the static keyword in a class, but outside a method, constructor or a block.");
		// 14
		List<String> a14 = new ArrayList<String>();
		a14.add("Java provides access modifiers to set access levels for classes, variables, methods and constructors. A member has package or default accessibility when no accessibility modifier is specified.");
		// 15
		List<String> a15 = new ArrayList<String>();
		a15.add("Java provides these modifiers for providing functionalities other than Access Modifiers, synchronized used to indicate that a method can be accessed by only one thread at a time.");
		// 16
		List<String> a16 = new ArrayList<String>();
		a16.add("Postfix operators i.e () [] . is at the highest precedence.");
		// 17
		List<String> a17 = new ArrayList<String>();
		a17.add("Variables used in a switch statement can only be a string, enum, byte, short, int, or char.");
		// 18
		List<String> a18 = new ArrayList<String>();
		a18.add("The String class is immutable, so that once it is created a String object cannot be changed. Since String is immutable it can safely be shared between many threads ,which is considered very important for multithreaded programming.");
		// 19
		List<String> a19 = new ArrayList<String>();
		a19.add("The String class is considered as immutable, so that once it is created a String object cannot be changed. If there is a necessity to make alot of modifications to Strings of characters then StringBuffer should be used.");
		// 20
		List<String> a20 = new ArrayList<String>();
		a20.add("Use StringBuilder whenever possible because it is faster than StringBuffer. But, if thread safety is necessary then use StringBuffer objects.");
		// 21
		List<String> a21 = new ArrayList<String>();
		a21.add("java.util.regex consists of three classes  Pattern class, Matcher class and PatternSyntaxException class.");
		// 22
		List<String> a22 = new ArrayList<String>();
		a22.add("It is possible to define a method that will be called just before an object's final destruction by the garbage collector. This method is called finalize( ), and it can be used to ensure that an object terminates cleanly.");
		// 23
		List<String> a23 = new ArrayList<String>();
		a23.add("An exception is a problem that arises during the execution of a program. Exceptions are caught by handlers positioned along the thread's method invocation stack.");
		// 24
		List<String> a24 = new ArrayList<String>();
		a24.add("If a method does not handle a checked exception, the method must declare it using the throwskeyword. The throws keyword appears at the end of a method's signature.");
		// 25
		List<String> a25 = new ArrayList<String>();
		a25.add("An exception can be thrown, either a newly instantiated one or an exception that you just caught, by using throw keyword.");
		// 26
		List<String> a26 = new ArrayList<String>();
		a26.add("The finally keyword is used to create a block of code that follows a try block. A finally block of code always executes, whether or not an exception has occurred.");
		// 27
		List<String> a27 = new ArrayList<String>();
		a27.add("If the method overrides one of its superclass's methods, overridden method can be invoked through the use of the keyword super. It can be also used to refer to a hidden field.");
		// 28
		List<String> a28 = new ArrayList<String>();
		a28.add("These classes cannot be instantiated and are either partially implemented or not at all implemented. This class contains one or more abstract methods which are simply method declarations without a body.");
		// 29
		List<String> a29 = new ArrayList<String>();
		a29.add("The main benefit of encapsulation is the ability to modify our implemented code without breaking the code of others who use our code. With this Encapsulation gives maintainability, flexibility and extensibility to our code.");
		// 30
		List<String> a30 = new ArrayList<String>();
		a30.add("An interface is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.");
		// 31
		List<String> a31 = new ArrayList<String>();
		a31.add("Packages are used in Java in-order to prevent naming conflicts, to control access, to make searching/locating and usage of classes, interfaces, enumerations and annotations, etc., easier.");
		// 32
		List<String> a32 = new ArrayList<String>();
		a32.add("A multithreaded program contains two or more parts that can run concurrently. Each part of such a program is called a thread, and each thread defines a separate path of execution.");
		// 33
		List<String> a33 = new ArrayList<String>();
		a33.add("An applet is a Java program that runs in a Web browser. An applet can be a fully functional Java application because it has the entire Java API at its disposal.");
		// 34
		List<String> a34 = new ArrayList<String>();
		a34.add("It uses garbage collection to free the memory. By cleaning those objects that is no longer reference by any of the program.");

		// 35
		List<String> a35 = new ArrayList<String>();
		a35.add("An immutable object can’t be changed once it is created.");
		// 36
		List<String> a36 = new ArrayList<String>();
		a33.add("It is used with variables or methods and used to call constructer of same class.");
		// 37
		List<String> a37 = new ArrayList<String>();
		a37.add("It is a collection of element which cannot contain duplicate elements. The Set interface contains only methods inherited from Collection and adds the restriction that duplicate elements are prohibited.");
		// 38
		List<String> a38 = new ArrayList<String>();
		a38.add("It is a Set implemented when we want elements in a sorted order.");
		// 39
		List<String> a39 = new ArrayList<String>();
		a39.add("It is used to sort collections and arrays of objects using the collections.sort() and java.utils. The objects of the class implementing the Comparable interface can be ordered.");
		// 40
		List<String> a40 = new ArrayList<String>();
		a40.add("Throw is used to trigger an exception where as throws is used in declaration of exception., Without throws, Checked exception cannot be handled where as checked exception can be propagated with throws.");
		// 41
		List<String> a41 = new ArrayList<String>();
		a41.add("Java Runtime Environment is an implementation of the Java Virtual Machine which executes Java programs. It provides the minimum requirements for executing a Java application;");
		// 42
		List<String> a42 = new ArrayList<String>();
		a42.add("JAR files is Java Archive fles and it aggregates many files into one. It holds Java classes in a library. JAR files are built on ZIP file format and have .jar file extension.");
		// 43
		List<String> a43 = new ArrayList<String>();
		a43.add("It improves the runtime performance of computer programs based on bytecode.");
		// 44
		List<String> a44 = new ArrayList<String>();
		a44.add("It is used to initialize the static data member, It is excuted before main method at the time of classloading.");
		// 45
		List<String> a45 = new ArrayList<String>();
		a45.add("Holding the reference of the other class within some other class is known as composition.");
		// 46
		List<String> a46 = new ArrayList<String>();
		a46.add("If a class has multiple functions by same name but different parameters, it is known as Method Overloading.");
		// 47
		List<String> a47 = new ArrayList<String>();
		a47.add("If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding.");
		// 48
		List<String> a48 = new ArrayList<String>();
		a48.add("Final classes are created so the methods implemented by that class cannot be overridden. It can’t be inherited.");
		// 49
		List<String> a49 = new ArrayList<String>();
		a49.add("A NullPointerException is thrown when calling the instance method of a null object, accessing or modifying the field of a null object etc.");
		// 50
		List<String> a50 = new ArrayList<String>();
		a50.add("A thread can enter the waiting state by invoking its sleep() method, by blocking on IO, by unsuccessfully attempting to acquire an object's lock, or by invoking an object's wait() method. It can also enter the waiting state by invoking its (deprecated) suspend() method.");
		// 51
		List<String> a51 = new ArrayList<String>();
		a51.add("The operating system's task scheduler allocates execution time to multiple tasks. By quickly switching between executing tasks, it creates the impression that tasks execute sequentially.");
		 
		 
		listDataChild.put(listDataHeader.get(0), a1);
		listDataChild.put(listDataHeader.get(1), a2);
		listDataChild.put(listDataHeader.get(2), a3);
		listDataChild.put(listDataHeader.get(3), a4);
		listDataChild.put(listDataHeader.get(4), a5);
		listDataChild.put(listDataHeader.get(5), a6);
		listDataChild.put(listDataHeader.get(6), a7);
		listDataChild.put(listDataHeader.get(7), a8);
		listDataChild.put(listDataHeader.get(8), a9);
		listDataChild.put(listDataHeader.get(9), a10);
		listDataChild.put(listDataHeader.get(10), a11);
		listDataChild.put(listDataHeader.get(11), a12);
		listDataChild.put(listDataHeader.get(12), a13);
		listDataChild.put(listDataHeader.get(13), a14);
		listDataChild.put(listDataHeader.get(14), a15);
		listDataChild.put(listDataHeader.get(15), a16);
		listDataChild.put(listDataHeader.get(16), a17);
		listDataChild.put(listDataHeader.get(17), a18);
		listDataChild.put(listDataHeader.get(18), a19);
		listDataChild.put(listDataHeader.get(19), a20);
		listDataChild.put(listDataHeader.get(20), a21);
		listDataChild.put(listDataHeader.get(21), a22);
		listDataChild.put(listDataHeader.get(22), a23);
		listDataChild.put(listDataHeader.get(23), a24);
		listDataChild.put(listDataHeader.get(24), a25);
		listDataChild.put(listDataHeader.get(25), a26);
		listDataChild.put(listDataHeader.get(26), a27);
		listDataChild.put(listDataHeader.get(27), a28);
		listDataChild.put(listDataHeader.get(28), a29);
		listDataChild.put(listDataHeader.get(29), a30);
		listDataChild.put(listDataHeader.get(30), a31);
		listDataChild.put(listDataHeader.get(31), a32);
		listDataChild.put(listDataHeader.get(32), a33);
		listDataChild.put(listDataHeader.get(33), a34);
		listDataChild.put(listDataHeader.get(34), a35);
		listDataChild.put(listDataHeader.get(35), a36);
		listDataChild.put(listDataHeader.get(36), a37);
		listDataChild.put(listDataHeader.get(37), a38);
		listDataChild.put(listDataHeader.get(38), a39);
		listDataChild.put(listDataHeader.get(39), a40);
		listDataChild.put(listDataHeader.get(40), a41);
		listDataChild.put(listDataHeader.get(41), a42);
		listDataChild.put(listDataHeader.get(42), a43);
		listDataChild.put(listDataHeader.get(43), a44);
		listDataChild.put(listDataHeader.get(44), a45);
		listDataChild.put(listDataHeader.get(45), a46);
		listDataChild.put(listDataHeader.get(46), a47);
		listDataChild.put(listDataHeader.get(47), a48);
		listDataChild.put(listDataHeader.get(48), a49);
		listDataChild.put(listDataHeader.get(49), a50);
		listDataChild.put(listDataHeader.get(50), a51);
		

	}
}
