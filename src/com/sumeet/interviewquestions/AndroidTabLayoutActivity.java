package com.sumeet.interviewquestions;

import android.app.TabActivity;
import com.sumeet.quiz.*;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
public class AndroidTabLayoutActivity extends TabActivity {
    /** Called when the activity is first created. */
    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);
         
        TabHost tabHost = getTabHost();
         
        // Tab1
        TabSpec tab1 = tabHost.newTabSpec("Interview Questions");
        // setting Title and Icon for the Tab
        tab1.setIndicator("Questions", getResources().getDrawable(R.drawable.tabpic));
        Intent photosIntent = new Intent(AndroidTabLayoutActivity.this, Android.class);
        tab1.setContent(photosIntent);
         
        // Tab2
        TabSpec tab2 = tabHost.newTabSpec("Programs Links");        
        tab2.setIndicator("Programs Links", getResources().getDrawable(R.drawable.tabpic1));
        Intent songsIntent = new Intent(AndroidTabLayoutActivity.this, AndroidPrograms.class);
        tab2.setContent(songsIntent);
         
        // Tab3
        TabSpec tab3 = tabHost.newTabSpec("Links");
        tab3.setIndicator("Links", getResources().getDrawable(R.drawable.tabpic2));
        Intent videosIntent = new Intent(AndroidTabLayoutActivity.this, AndroidLinks.class);
        tab3.setContent(videosIntent);
        
     // Tab4
        TabSpec tab4 = tabHost.newTabSpec("Quiz");
        tab4.setIndicator("Quiz", getResources().getDrawable(R.drawable.tabpic2));
        Intent quiz = new Intent(AndroidTabLayoutActivity.this,  AndroidQuizActivity.class);
        tab4.setContent(quiz);
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(tab1); // Adding tab1
        tabHost.addTab(tab2); // Adding tab2
        tabHost.addTab(tab3); // Adding tab3
        tabHost.addTab(tab4);
    }
}