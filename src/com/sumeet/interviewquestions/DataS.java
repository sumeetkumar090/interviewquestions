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

public class DataS extends Activity {

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
		listDataHeader.add("What are various data-structures available?");// 1
		listDataHeader.add("What are the criteria of algorithm analysis?");// 2
		listDataHeader.add("What is asymptotic analysis of an algorithm? ");// 3
		listDataHeader.add("What is linear data strucutre?");// 4
		listDataHeader.add("What is a linked-list?");// 5
		listDataHeader.add("What is stack? ");// 6
		listDataHeader.add("Why do we use stacks? ");// 7
		listDataHeader.add("What is binary search? ");// 8
		listDataHeader.add("What is selection sort? ");// 9
		listDataHeader.add("How quick sort works?");// 10
		listDataHeader.add("What is a graph? ");// 11
		listDataHeader.add("How depth first traversal works?");// 12
		listDataHeader.add("How breadth first traversal works? ");// 13
		listDataHeader.add("What is a binary search tree? ");// 14
		listDataHeader.add("What is an AVL Tree?");// 15
		listDataHeader.add("What is a spanning tree? ");// 16
		listDataHeader.add("How Kruskal's algorithm works? ");// 17
		listDataHeader.add("How Prim's algorithm finds spanning tree? ");// 18
		listDataHeader.add("What is a heap in data structure? ");// 19
		listDataHeader.add("What is tower of hanoi? ");// 20
		listDataHeader.add(" What is fibonacci series?");// 21
		listDataHeader.add("What is hashing? ");// 22
		listDataHeader.add("What is interpolation search technique? ");// 23
		listDataHeader.add("What is data-structure? ");// 24
		listDataHeader.add("What is algorithm? ");// 25
		listDataHeader.add("What are common operations that can be performed on a data-structure? ");// 26
		listDataHeader.add("Why do we use queues? ");// 27
		listDataHeader.add("Tell me something about 'insertion sort'? ");// 28
		listDataHeader.add("How insertion sort and selection sorts are different?");// 30
		listDataHeader.add("What is shell sort?");// 31
	 	listDataHeader.add("What is a tree?");// 32
		listDataHeader.add("What is a recursive function?");// 33
		listDataHeader.add("How do you reference all the elements in a one-dimension array? ");// 34
		listDataHeader.add("Which data structures is applied when dealing with a recursive function? ");// 35
		listDataHeader.add("What are multidimensional arrays? ");// 36
		listDataHeader.add("Are linked lists considered linear or non-linear data structures? ");// 37
		listDataHeader.add(" What is merge sort? ");// 38
		listDataHeader.add("Differentiate NULL and VOID. ");// 39
		listDataHeader.add("What is the difference between a PUSH and a POP? ");// 41
		listDataHeader.add(" How does variable declaration affect memory allocation? ");// 42
		listDataHeader.add("What is the advantage of the heap over a stack? ");// 43
		listDataHeader.add("How do you insert a new item in a binary search tree? ");// 44
		listDataHeader.add("How do signed and unsigned numbers affect memory? ");// 45
		listDataHeader.add("What is the minimum number of nodes that a binary tree can have? ");// 46
		listDataHeader.add("In what data structures are pointers applied?");// 47
		listDataHeader.add("What is the minimum number of queues needed when implementing a priority queue? ");// 48
		listDataHeader.add(" Differentiate STACK from ARRAY.");// 49
		listDataHeader.add("Which sorting algorithm is considered the fastest? ");// 50

		// 1
		List<String> q1 = new ArrayList<String>();
		q1.add("Data structure availability may vary by programming languages. Commonly available data structures are list, arrays, stack, queues, graph, tree etc.");
		// 2
		List<String> q2 = new ArrayList<String>();
		q2.add("An algorithm are generally analyzed on two factors  time and space. That is, how much execution time and how much extra space required by the algorithm.");
		// 3
		List<String> q3 = new ArrayList<String>();
		q3.add("Asymptotic analysis of an algorithm, refers to defining the mathematical boundation/framing of its run-time performance. Using asymptotic analysis, we can very well conclude the best case, average case and worst case scenario of an algorithm.");
		// 4
		List<String> q4 = new ArrayList<String>();
		q4.add("A linear data-strucutre has sequentially arranged data items. The next time can be located in the next memory address. It is stored and accessed in a sequential manner. Array and list are example of linear data structure.");
		// 5
		List<String> q5 = new ArrayList<String>();
		q5.add("A linked-list is a list of data-items connected with links i.e. pointers or references. Most modern high-level programming language does not provide the feature of directly accessing memory location, therefore, linked-list are not supported in them or available in form of inbuilt functions.");
		// 6
		List<String> q6 = new ArrayList<String>();
		q6.add("In data-structure, stack is an Abstract Data Type (ADT) used to store and retrieve values in Last In First Out method.");
		// 7
		List<String> q7 = new ArrayList<String>();
		q7.add("Stacks follows LIFO method and addition and retrieval of a data item takes only n time. Stacks are used where we need to access data in the reverse order or their arrival. Stacks are used commonly in recursive function calls, expression parsing, depth first traversal of graphs etc.");
		// 8
		List<String> q8 = new ArrayList<String>();
		q8.add("A binary search works only on sorted lists or arrays. This search selects the middle which splits the entire list into two parts. First the middle is compared. This search first compares the target value to the mid of the list. If it is not found, then it takes decision on whether.");
		// 9
		List<String> q9 = new ArrayList<String>();
		q9.add("Selection sort is in-place sorting technique. It divides the data set into two sub-lists: sorted and unsorted. Then it selects the minimum element from unsorted sub-list and places it into the sorted list. This iterates unless all the elements from unsorted sub-list are consumed into sorted sub-list.");
		// 10
		List<String> q10 = new ArrayList<String>();
		q10.add("Quick sort uses divide and conquer approach. It divides the list in smaller 'partitions' using 'pivot'. The values which are smaller than the pivot are arranged in the left partition and greater values are arranged in the right partition. Each partition is recursively sorted using quick sort.");
		// 11
		List<String> q11 = new ArrayList<String>();
		q11.add("A graph is a pictorial representation of a set of objects where some pairs of objects are connected by links. The interconnected objects are represented by points termed as vertices, and the links that connect the vertices are called edges.");
		// 12
		List<String> q12 = new ArrayList<String>();
		q12.add("Depth First Search algorithm(DFS) traverses a graph in a depthward motion and uses a stack to remember to get the next vertex to start a search when a dead end occurs in any iteration.");
		// 13
		List<String> q13 = new ArrayList<String>();
		q13.add("Breadth First Search algorithm(BFS) traverses a graph in a breadthwards motion and uses a queue to remember to get the next vertex to start a search when a dead end occurs in any iteration.");
		// 14
		List<String> q14 = new ArrayList<String>();
		q14.add("A binary search tree is a binary tree with a special provision where a node's left child must have value less than its parent's value and node's right child must have value greater than it's parent value.");
		// 15
		List<String> q15 = new ArrayList<String>();
		q15.add("AVL trees are height balancing binary search tree. AVL tree checks the height of left and right sub-trees and assures that the difference is not more than 1. This difference is called Balance Factor");
		// 16
		List<String> q16 = new ArrayList<String>();
		q16.add("A spanning tree is a subset of Graph G, which has all the vertices covered with minimum possible number of edges. A spanning tree does not have cycles and it can not be disconnected.");
		// 17
		List<String> q17 = new ArrayList<String>();
		q17.add("This algorithm treats the graph as a forest and every node it as an individual tree. A tree connects to another only and only if it has least cost among all available options and does not violate MST properties.");
		// 18
		List<String> q18 = new ArrayList<String>();
		q18.add("Prim's algorithm treats the nodes as a single tree and keeps on adding new nodes to the spanning tree from the given graph.");
		// 19
		List<String> q19 = new ArrayList<String>();
		q19.add("Heap is a special balanced binary tree data structure where root-node key is compared with its children and arranged accordingly. A min-heap, a parent node has key value less than its childs and a max-heap parent node has value greater than its childs.");
		// 20
		List<String> q20 = new ArrayList<String>();
		q20.add("Tower of Hanoi, is a mathematical puzzle which consists of three tower (pegs) and more than one rings. All rings are of different size and stacked upon each other where the large disk is always below the small disk. The aim is to move the tower of disk from one peg to another, without breaking its properties.");
		// 21
		List<String> q21 = new ArrayList<String>();
		q21.add("Fibonacci Series generates subsequent number by adding two previous numbers. For example  0 1 1 2 3 5 8 13.");
		// 22
		List<String> q22 = new ArrayList<String>();
		q22.add("Hashing is a technique to convert a range of key values into a range of indexes of an array. By using hash tables, we can create an associative data storage where data index can be find by providing its key values.");
		// 23
		List<String> q23 = new ArrayList<String>();
		q23.add("Interpolation search is an improved variant of binary search. This search algorithm works on the probing position of required value.");
		// 24
		List<String> q24 = new ArrayList<String>();
		q24.add("Data structure is a way of defining, storing & retriving of data in a structural & systemetic way. A data structure may contain different type of data items.");
		// 25
		List<String> q25 = new ArrayList<String>();
		q25.add("Algorithm is a step by step procedure, which defines a set of instructions to be executed in certain order to get the desired output.");
		// 26
		List<String> q26 = new ArrayList<String>();
		q26.add("The following operations are commonly performed on any data-structure Insertion  adding a data item, Deletion  removing a data item , Traversal  accessing and/or printing all data items, Searching  finding a particular data item, Sorting  arranging data items in a pre-defined sequence");
		// 27
		List<String> q27 = new ArrayList<String>();
		q27.add("As queues follows FIFO method, they are used when we need to work on data-items in exact sequence of their arrival. Every operating system maintains queues of various processes. Priority queues and breadth first traversal of graphs are some examples of queues.");
		// 28
		List<String> q28 = new ArrayList<String>();
		q28.add("Insertion sort divides the list into two sub-list, sorted and unsorted. It takes one element at time and finds it appropriate location in sorted sub-list and insert there. The output after insertion is a sorted sub-list. It iteratively works on all the elements of unsorted sub-list and inserts them to sorted sub-list in order.");
		// 30
		List<String> q30 = new ArrayList<String>();
		q30.add("Both sorting techniques maintains two sub-lists, sorted and unsorted and both take one element at a time and places it into sorted sub-list. Insertion sort works on the current element in hand and places it in the sorted array at appropriate location maintaining the properties of insertion sort. Whereas, selection sort searches the minimum from the unsorted sub-list and replaces it with the current element in hand.");
		// 31
		List<String> q31 = new ArrayList<String>();
		q31.add("Shell sort can be said a variant of insertion sort. Shell sort divides the list into smaller sublist based on some gap variable and then each sub-list is sorted using insertion sort.");
		// 32
		List<String> q32 = new ArrayList<String>();
		q32.add("A tree is a minimally connected graph having no loops and circuits.");
		// 33
		List<String> q33 = new ArrayList<String>();
		q33.add("A recursive function is one which calls itself, directly or calls a function that in turn calls it. Every recursive function follows the recursive properties  base criteria where functions stops calling itself and progressive approach where the functions tries to meet the base criteria in each iteration.");
		// 34
		List<String> q34 = new ArrayList<String>();
		q34.add("To do this, an indexed loop is used, such that the counter runs from 0 to the array size minus one. In this manner, we are able to reference all the elements in sequence by using the loop counter as the array subscript.");
		// 35
		List<String> q35 = new ArrayList<String>();
		q35.add("Recursion, which is basically a function that calls itself based on a terminating condition, makes use of the stack. Using LIFO, a call to a recursive function saves the return address so that it knows how to return to the calling function after the call terminates");
		// 36
		List<String> q36 = new ArrayList<String>();
		q36.add("Multidimensional arrays make use of multiple indexes to store data. It is useful when storing data that cannot be represented using a single dimensional indexing, such as data representation in a board game, tables with data stored in more than one column.");
		// 37
		List<String> q37 = new ArrayList<String>();
		q37.add("It actually depends on where you intend to apply linked lists. If you based it on storage, a linked list is considered non-linear. On the other hand, if you based it on access strategies, then a linked list is considered linear.");
		// 38
		List<String> q38 = new ArrayList<String>();
		q38.add("Merge sort takes a divide-and-conquer approach to sorting data. In a sequence of data, adjacent ones are merged and sorted to create bigger sorted lists. These sorted lists are then merged again to form an even bigger sorted list, which continuous until you have one single sorted list.");
		// 39
		List<String> q39 = new ArrayList<String>();
		q39.add("Null is actually a value, whereas Void is a data type identifier. A variable that is given a Null value simply indicates an empty value. Void is used to identify pointers as having no initial size.");
		// 41
		List<String> q41 = new ArrayList<String>();
		q41.add("Pushing and popping applies to the way data is stored and retrieved in a stack. A push denotes data being added to it, meaning data is being “pushed” into the stack. On the other hand, a pop denotes data retrieval, and in particular refers to the topmost data being accessed.");
		// 42
		List<String> q42 = new ArrayList<String>();
		q42.add("The amount of memory to be allocated or reserved would depend on the data type of the variable being declared. For example, if a variable is declared to be of integer type, then 32 bits of memory storage will be reserved for that variable.");
		// 43
		List<String> q43 = new ArrayList<String>();
		q43.add("Basically, the heap is more flexible than the stack. That’s because memory space for the heap can be dynamically allocated and de-allocated as needed. However, memory of the heap can at times be slower when compared to that stack.");
		// 44
		List<String> q44 = new ArrayList<String>();
		q44.add("Assuming that the data to be inserted is a unique value (that is, not an existing entry in the tree), check first if the tree is empty. If it’s empty, just insert the new item in the root node. If it’s not empty, refer to the new item’s key. If it’s smaller than the root’s key, insert it into the root’s left subtree, otherwise, insert it into the root’s right subtree.");
		// 45
		List<String> q45 = new ArrayList<String>();
		q45.add("In the case of signed numbers, the first bit is used to indicate whether positive or negative, which leaves you with one bit short. With unsigned numbers, you have all bits available for that number. The effect is best seen in the number range (unsigned 8 bit number has a range 0-255, while 8-bit signed number has a range -128 to +127.");
		// 46
		List<String> q46 = new ArrayList<String>();
		q46.add("A binary tree can have a minimum of zero nodes, which occurs when the nodes have NULL values. Furthermore, a binary tree can also have 1 or 2 nodes.");
		// 47
		List<String> q47 = new ArrayList<String>();
		q47.add("Pointers that are used in linked list have various applications in data structure. Data structures that make use of this concept include the Stack, Queue, Linked List and Binary Tree.");
		// 48
		List<String> q48 = new ArrayList<String>();
		q48.add("The minimum number of queues needed in this case is two. One queue is intended for sorting priorities while the other queue is intended for actual storage of data.");
		// 49
		List<String> q49 = new ArrayList<String>();
		q49.add("Data that is stored in a stack follows a LIFO pattern. This means that data access follows a sequence wherein the last data to be stored will the first one to be extracted. Arrays, on the other hand, does not follow a particular order and instead can be accessed by referring to the indexed element within the array.");
		// 50
		List<String> q50 = new ArrayList<String>();
		q50.add("There are many types of sorting algorithms: quick sort, bubble sort, balloon sort, radix sort, merge sort, etc. Not one can be considered the fastest because each algorithm is designed for a particular data structure and data set. It would depend on the data set that you would want to sort.");
		 

		listDataChild.put(listDataHeader.get(0), q1);  
		listDataChild.put(listDataHeader.get(1), q2);
		listDataChild.put(listDataHeader.get(2), q3);
		listDataChild.put(listDataHeader.get(3), q4);
		listDataChild.put(listDataHeader.get(4), q5);
		listDataChild.put(listDataHeader.get(5), q6);
		listDataChild.put(listDataHeader.get(6), q7);
		listDataChild.put(listDataHeader.get(7), q8);
		listDataChild.put(listDataHeader.get(8), q9);
		listDataChild.put(listDataHeader.get(9), q10);
		listDataChild.put(listDataHeader.get(10), q11);
		listDataChild.put(listDataHeader.get(11), q12);
		listDataChild.put(listDataHeader.get(12), q13);
		listDataChild.put(listDataHeader.get(13), q14);
		listDataChild.put(listDataHeader.get(14), q15);
		listDataChild.put(listDataHeader.get(15), q16);
		listDataChild.put(listDataHeader.get(16), q17);
		listDataChild.put(listDataHeader.get(17), q18);
		listDataChild.put(listDataHeader.get(18), q19);
		listDataChild.put(listDataHeader.get(19), q20);
		listDataChild.put(listDataHeader.get(20), q21);
		listDataChild.put(listDataHeader.get(21), q22);
		listDataChild.put(listDataHeader.get(22), q23);
		listDataChild.put(listDataHeader.get(23), q24);
		listDataChild.put(listDataHeader.get(24), q25);
		listDataChild.put(listDataHeader.get(25), q26);
		listDataChild.put(listDataHeader.get(26), q27);
		listDataChild.put(listDataHeader.get(27), q28);
		listDataChild.put(listDataHeader.get(28), q30);
		listDataChild.put(listDataHeader.get(29), q31);
		listDataChild.put(listDataHeader.get(30), q32);
		listDataChild.put(listDataHeader.get(31), q33);
		listDataChild.put(listDataHeader.get(32), q34);
		listDataChild.put(listDataHeader.get(33), q35);
		listDataChild.put(listDataHeader.get(34), q36);
		listDataChild.put(listDataHeader.get(35), q37);
		listDataChild.put(listDataHeader.get(36), q38);
		listDataChild.put(listDataHeader.get(37), q39);
		listDataChild.put(listDataHeader.get(38), q41);
		listDataChild.put(listDataHeader.get(39), q42);
		listDataChild.put(listDataHeader.get(40), q43);
		listDataChild.put(listDataHeader.get(41), q44);
		listDataChild.put(listDataHeader.get(42), q45);
		listDataChild.put(listDataHeader.get(43), q46);
		listDataChild.put(listDataHeader.get(44), q47);
		listDataChild.put(listDataHeader.get(45), q48);
		listDataChild.put(listDataHeader.get(46), q49);
		listDataChild.put(listDataHeader.get(47), q50);
	}
}
