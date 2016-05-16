package com.sumeet.quiz;

import com.sumeet.interviewquestions.R;
import com.sumeet.interviewquestions.myWebClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		// get rating bar object
		RatingBar bar = (RatingBar) findViewById(R.id.ratingBar1);
		ImageView imageView = (ImageView) findViewById(R.id.imageview);
		bar.setNumStars(5);
		//bar.setStepSize(0.5f);
		// get text view
		TextView t = (TextView) findViewById(R.id.textResult);
		// get score
		Bundle b = getIntent().getExtras();
		int score = b.getInt("score");
		// display score
		bar.setRating(score);

		switch (score) {
		case 1:
			t.setText("Your Score is " + score  + "\n" +  "\n" + "OHHHH NO <<<<< PLEASE TRY AGAIN <<<<<<");
			 imageView.setImageResource(R.drawable.image1);
			 
			break;
		case 2:
			t.setText("Your Score is " + score  + "\n" +  "\n" + "BETTER THIS <<<<< GO FOR ANOTHER ATTEMPT <<<<<<");
			imageView.setImageResource(R.drawable.image2);
			break;
		case 3:
			t.setText("Your Score is " + score  + "\n" +  "\n" + "50-50 <<<<< BETTER LUCK <<<<<<");
			imageView.setImageResource(R.drawable.image3);
			break;
		case 4:
			t.setText("Your Score is " + score  + "\n" + "\n" + " KEEP IT GOING <<<<< AWESOME <<<<<<");
			imageView.setImageResource(R.drawable.image4);
			break;
		case 5:
			t.setText("Your Score is " + score + "\n" +  "\n" + " BULLSEYE<<<<< U ROCK !!! <<<<<<");
			imageView.setImageResource(R.drawable.image5);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}

}
