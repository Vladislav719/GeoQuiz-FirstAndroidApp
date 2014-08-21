package com.example.vladislav.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by vladislav on 21.08.14.
 */
public class CheatActivity extends Activity {

    private boolean answerIsTrue;

    private TextView answerTextView;
    private Button showAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        setAnswerShownResult(false);

        answerTextView = (TextView) findViewById(R.id.answerTextView);
        showAnswerButton = (Button) findViewById(R.id.showAnswerButton);

        answerIsTrue = getIntent().getBooleanExtra("isTrueAns", false);
    }

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra("isAnsShown", isAnswerShown);
        setResult(RESULT_OK, data);
    }

    public void showAnsClick(View view) {
        if (answerIsTrue){
            answerTextView.setText(R.string.question_answer_true);
        } else {
            answerTextView.setText(R.string.question_answer_false);
        }
        setAnswerShownResult(true);
    }


}
