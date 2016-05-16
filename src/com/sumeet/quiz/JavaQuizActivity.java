package com.sumeet.quiz;

import java.util.List;

import com.sumeet.interviewquestions.R;
import com.sumeet.quiz.CDbHelper;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class JavaQuizActivity extends Activity {
	List<Question> quesList;
	int score = 0;
	int qid = 0;
	Question currentQ;
	TextView txtQuestion;
	RadioButton rda, rdb, rdc;
	Button butNext;
	RadioGroup grp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		JavaDbHelper db = new JavaDbHelper(this);
		quesList = db.getAllQuestions();
		currentQ = quesList.get(qid);
		txtQuestion = (TextView) findViewById(R.id.textView1);
		rda = (RadioButton) findViewById(R.id.radio0);
		rdb = (RadioButton) findViewById(R.id.radio1);
		rdc = (RadioButton) findViewById(R.id.radio2);
		butNext = (Button) findViewById(R.id.button1);
		setQuestionView();
		butNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				grp = (RadioGroup) findViewById(R.id.radioGroup1);

				if (grp.getCheckedRadioButtonId() == -1) {
					Toast.makeText(getApplicationContext(), "Please select Choice", Toast.LENGTH_SHORT).show();
				} else {
					RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
					Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
					if (currentQ.getANSWER().equals(answer.getText())) {
						score++;
						Log.d("score", "Your score" + score);
					}
					if (qid < 5) {
						currentQ = quesList.get(qid);
						setQuestionView();
					} else {
						Intent intent = new Intent(JavaQuizActivity.this, ResultActivity.class);
						Bundle b = new Bundle();
						b.putInt("score", score); // Your score
						intent.putExtras(b); // Put your score to your next
												// Intent
						startActivity(intent);
						finish();
					}

				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}

	private void setQuestionView() {
		txtQuestion.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		qid++;
	}
}
