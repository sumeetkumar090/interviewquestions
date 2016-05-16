package com.sumeet.interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class CLang extends Activity {

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
		listDataHeader.add("What is a pointer on pointer?");// 1
		listDataHeader.add("Distinguish between malloc() & calloc() memory allocation. ");// 2
		listDataHeader.add("What is keyword auto for?");// 3
		listDataHeader.add("What are the valid places for the keyword break to appear. ");// 4
		listDataHeader.add("What is a static variable?");// 5
		listDataHeader.add("What is a NULL pointer?");// 6
		listDataHeader.add("Explain the purpose of the function sprintf().");// 7
		listDataHeader.add(" What is the meaning of base address of the array?");// 8
		listDataHeader.add("What is a dangling pointer? ");// 9
		listDataHeader.add("What is the purpose of the keyword typedef? ");// 10
		listDataHeader.add("What is the difference between actual and formal parameters? ");// 11
		listDataHeader.add("Can a program be compiled without main() function? ");// 12
		listDataHeader.add("What is the advantage of declaring void pointers? ");// 13
		listDataHeader.add("Where an automatic variable is stored? ");// 14
		listDataHeader.add("What is the difference between variable declaration and variable definition? ");// 15
		listDataHeader.add("Explain modular programming. ");// 16
		listDataHeader.add("What is a preprocessor? ");// 17
		listDataHeader.add("What are bit fields? ");// 18
		listDataHeader.add("What are command line arguments? ");// 19
		listDataHeader.add("Where the address of operator (&) cannot be used? ");// 20
		listDataHeader.add("Which key word is used to perform unconditional branching?");// 21
		listDataHeader.add("What is a NULL statement?");// 22
		listDataHeader.add("What is a static function? ");// 23
		listDataHeader.add("What are enumerations? ");// 24
		listDataHeader.add("Which operator can be used to determine the size of a data type or variable? ");// 25
		listDataHeader.add("How does bitwise operator XOR works. ");// 26
		listDataHeader.add("What is an infinite loop? ");// 27
		listDataHeader.add("Can a pointer access the array? ");// 28
		listDataHeader.add("Explain about ‘stdin’. ");// 29
		listDataHeader.add("What is the purpose of #undef preprocessor? ");// 30
		listDataHeader.add("What is typecasting? ");// 31
		listDataHeader.add("How can we determine whether a file is successfully opened or not using fopen() function? ");// 32
		listDataHeader.add("When the macros gets expanded? ");// 33
		listDataHeader.add("What is a constant pointer? ");// 34
		listDataHeader.add("Is there a way to compare two structure variables? ");// 35
		listDataHeader.add("What is difference between far and near pointers? ");// 36
		listDataHeader.add("Can we use just the tag name of structures to declare the variables for the same? ");// 37
		listDataHeader.add(" What is a stack?");// 38
		listDataHeader.add("What is a sequential access file? ");// 39
		listDataHeader.add("Differentiate Source Codes from Object Codes ");// 40
	 
		// 1
		List<String> c1 = new ArrayList<String>();
		c1.add("It’s a pointer variable which can hold the address of another pointer variable. It de-refers twice to point to the data held by the designated pointer variable.");
		// 2
		List<String> c2 = new ArrayList<String>();
		c2.add("Both allocates memory from heap area/dynamic memory. By default calloc fills the allocated memory with 0’s.");
		// 3
		List<String> c3 = new ArrayList<String>();
		c3.add("By default every local variable of the function is automatic (auto). In the below function both the variables ‘i’ and ‘j’ are automatic variables.");
		// 4
		List<String> c5 = new ArrayList<String>();
		c5.add("Break can appear only with in the looping control and switch statement. The purpose of the break is to bring the control out from the said blocks.");
		// 5
		List<String> c6 = new ArrayList<String>();
		c6.add("A static local variables retains its value between the function call and the default value is 0. The following function will print 1 2 3 if called thrice.");
		// 6
		List<String> c7 = new ArrayList<String>();
		c7.add("A pointer pointing to nothing is called so. Eg: char *p=NULL;");
		// 7
		List<String> c8 = new ArrayList<String>();
		c8.add("Prints the formatted output onto the character array.");
		// 8
		List<String> c10 = new ArrayList<String>();
		c10.add("The starting address of the array is called as the base address of the array.");
		// 9
		List<String> c11 = new ArrayList<String>();
		c11.add("A pointer initially holding valid address, but later the held address is released or freed. Then such a pointer is called as dangling pointer.");
		// 10
		List<String> c13 = new ArrayList<String>();
		c13.add("It is used to alias the existing type. Also used to simplify the complex declaration of the type.");
		// 11
		List<String> c14 = new ArrayList<String>();
		c14.add("The parameters sent to the function at calling end are called as actual parameters while at the receiving of the function definition called as formal parameters.");
		// 12
		List<String> c16 = new ArrayList<String>();
		c16.add("Yes, it can be but cannot be executed, as the execution requires main() function definition.");
		// 13
		List<String> c17 = new ArrayList<String>();
		c17.add("When we do not know what type of the memory address the pointer variable is going to hold, then we declare a void pointer for such.");
		// 14
		List<String> c18 = new ArrayList<String>();
		c18.add("Every local variable by default being an auto variable is stored in stack memory.");
		// 15
		List<String> c19 = new ArrayList<String>();
		c19.add("Declaration associates type to the variable whereas definition gives the value to the variable.");
		// 16
		List<String> c20 = new ArrayList<String>();
		c20.add("Dividing the program in to sub programs (modules/function) to achieve the given task is modular approach. More generic functions definition gives the ability to re-use the functions, such as built-in library functions.");
		// 17
		List<String> c21 = new ArrayList<String>();
		c21.add("Preprocessor is a directive to the compiler to perform certain things before the actual compilation process begins.");
		// 18
		List<String> c22 = new ArrayList<String>();
		c22.add("We can create integer structure members of differing size apart from non-standard size using bit fields. Such structure size is automatically adjusted with the multiple of integer size of the machine.");
		// 19
		List<String> c23 = new ArrayList<String>();
		c23.add("The arguments which we pass to the main() function while executing the program are called as command line arguments. The parameters are always strings held in the second argument (below in args) of the function which is array of character pointers. First argument represents the count of arguments (below in count) and updated automatically by operating system.");
		// 20
		List<String> c24 = new ArrayList<String>();
		c24.add("It cannot be used on constants.It cannot be used on variable which are declared using register storage class.");
		// 21
		List<String> c25 = new ArrayList<String>();
		c25.add("goto");
		// 22
		List<String> c26 = new ArrayList<String>();
		c26.add("A null statement is no executable statements such as ; (semicolon).");
		// 23
		List<String> c27 = new ArrayList<String>();
		c27.add("A function’s definition prefixed with static keyword is called as a static function. You would make a function static if it should be called only within the same source code.");
		// 24
		List<String> c28 = new ArrayList<String>();
		c28.add("Enumerations are list of integer constants with name. Enumerators are defined with the keyword enum.");
		// 25
		List<String> c29 = new ArrayList<String>();
		c29.add("sizeof");
		// 26
		List<String> c30 = new ArrayList<String>();
		c30.add("If both the corresponding bits are same it gives 0 else 1.");
		// 27
		List<String> c31 = new ArrayList<String>();
		c31.add("A loop executing repeatedly as the loop-expression always evaluates to true such as");
		// 28
		List<String> c32 = new ArrayList<String>();
		c32.add("Pointer by holding array’s base address can access the array.");
		// 29
		List<String> c33 = new ArrayList<String>();
		c33.add("stdin in a pointer variable which is by default opened for standard input device.");
		// 30
		List<String> c35 = new ArrayList<String>();
		c35.add("It be used to undefine an existing macro definition.");
		// 31
		List<String> c36 = new ArrayList<String>();
		c36.add("Typecasting is a way to convert a variable/constant from one type to another type.");
		// 32
		List<String> c37 = new ArrayList<String>();
		c37.add("On failure fopen() returns NULL, otherwise opened successfully.");
		// 33
		List<String> c38 = new ArrayList<String>();
		c38.add("At the time of preprocessing.");
		// 34
		List<String> c39 = new ArrayList<String>();
		c39.add("A pointer which is not allowed to be altered to hold another address after it is holding one.");
		// 35
		List<String> c40 = new ArrayList<String>();
		c40.add("There is no such. We need to compare element by element of the structure variables.");
		// 36
		List<String> c41 = new ArrayList<String>();
		c41.add("In first place they are non-standard keywords. A near pointer can access only 2^15 memory space and far pointer can access 2^32 memory space. Both the keywords are implementation specific and are non-standard.");
		// 37
		List<String> c42 = new ArrayList<String>();
		c42.add("No, we need to use both the keyword ‘struct’ and the tag name.");
		// 38
		List<String> c43 = new ArrayList<String>();
		c43.add("A stack is one form of a data structure. Data is stored in stacks using the FILO (First In Last Out) approach. At any particular instance, only the top of the stack is accessible, which means that in order to retrieve data that is stored inside the stack, those on the upper part should be extracted first. Storing data in a stack is also referred to as a PUSH, while data retrieval is referred to as a POP.");
		// 39
		List<String> c44 = new ArrayList<String>();
		c44.add("When writing programs that will store and retrieve data in a file, it is possible to designate that file into different forms. A sequential access file is such that data are saved in sequential order: one data is placed into the file after another. To access a particular data within the sequential access file, data has to be read one data at a time, until the right one is reached.");
		// 40
		List<String> c45 = new ArrayList<String>();
		c45.add("Source codes are codes that were written by the programmer. It is made up of the commands and other English-like keywords that are supposed to instruct the computer what to do. However, computers would not be able to understand source codes. Therefore, source codes are compiled using a compiler. The resulting outputs are object codes, which are in a format that can be understood by the computer processor. In C programming, source codes are saved with the file extension .C, while object codes are saved with the file extension .OBJ");
		 

		listDataChild.put(listDataHeader.get(0), c1);  
		listDataChild.put(listDataHeader.get(1), c2); 
		listDataChild.put(listDataHeader.get(2), c3); 
		listDataChild.put(listDataHeader.get(3), c5); 
		listDataChild.put(listDataHeader.get(4), c6); 
		listDataChild.put(listDataHeader.get(5), c7); 
		listDataChild.put(listDataHeader.get(6), c8); 
		listDataChild.put(listDataHeader.get(7), c10); 
		listDataChild.put(listDataHeader.get(8), c11); 
		listDataChild.put(listDataHeader.get(9), c13); 
		listDataChild.put(listDataHeader.get(10), c14); 
		listDataChild.put(listDataHeader.get(11), c16); 
		listDataChild.put(listDataHeader.get(12), c17); 
		listDataChild.put(listDataHeader.get(13), c18); 
		listDataChild.put(listDataHeader.get(14), c19); 
		listDataChild.put(listDataHeader.get(15), c20); 
		listDataChild.put(listDataHeader.get(16), c21); 
		listDataChild.put(listDataHeader.get(17), c22); 
		listDataChild.put(listDataHeader.get(18), c23); 
		listDataChild.put(listDataHeader.get(19), c24); 
		listDataChild.put(listDataHeader.get(20), c25); 
		listDataChild.put(listDataHeader.get(21), c26); 
		listDataChild.put(listDataHeader.get(22), c27); 
		listDataChild.put(listDataHeader.get(23), c28); 
		listDataChild.put(listDataHeader.get(24), c29); 
		listDataChild.put(listDataHeader.get(25), c30); 
		listDataChild.put(listDataHeader.get(26), c31); 
		listDataChild.put(listDataHeader.get(27), c32); 
		listDataChild.put(listDataHeader.get(28), c33); 
		listDataChild.put(listDataHeader.get(29), c35); 
		listDataChild.put(listDataHeader.get(30), c36); 
		listDataChild.put(listDataHeader.get(31), c37); 
		listDataChild.put(listDataHeader.get(32), c38); 
		listDataChild.put(listDataHeader.get(33), c39); 
		listDataChild.put(listDataHeader.get(34), c40); 
		listDataChild.put(listDataHeader.get(35), c41); 
		listDataChild.put(listDataHeader.get(36), c42); 
		listDataChild.put(listDataHeader.get(37), c43); 
		listDataChild.put(listDataHeader.get(38), c44); 
		listDataChild.put(listDataHeader.get(39), c45); 
		 

	}

}
