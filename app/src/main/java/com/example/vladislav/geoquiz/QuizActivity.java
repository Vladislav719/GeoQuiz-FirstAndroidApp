package com.example.vladislav.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends Activity {

    private Button trueBtn;
    private Button falseBtn;
    private Button nextBtn;
    private TextView textView;

    private TrueFalse[] questionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_asia, true)
    };

    private int currentIndex = 0;

    private void updateQuestion(){
        int question = questionBank[currentIndex].getQuestion();
        textView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = questionBank[currentIndex].isTrueQuestion();
        int msgResId = 0;
        if (userPressedTrue == answerIsTrue){
            msgResId = R.string.correct_toast;
        } else {
            msgResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, msgResId, Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trueBtn = (Button) findViewById(R.id.trueBtn);
        falseBtn = (Button) findViewById(R.id.falseBtn);
        textView = (TextView) findViewById(R.id.textView);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        updateQuestion();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    public void nextClick(View v){
        currentIndex = (currentIndex + 1) % questionBank.length;
        updateQuestion();
    }

    public void prevClick(View v){
        currentIndex = (currentIndex - 1) % questionBank.length;
        updateQuestion();
    }

    public void falseClick(View v){
//        Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        checkAnswer(false);
    }

    public void trueClick(View v){
//        Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        checkAnswer(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}