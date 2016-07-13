package com.bignerdranch.android.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";
    private static final String CHEATED = "cheated";


    private boolean mAnswerIsTrue;
    private Button mShowAnswer;
    private TextView mAnswerTextview;
    private boolean mAnswerIsShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null){
            mAnswerIsShown = savedInstanceState.getBoolean(CHEATED);
            setAnswerShownResult(mAnswerIsShown);
        }

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);

        mAnswerTextview = (TextView) findViewById(R.id.answerTextView);

        mShowAnswer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue){
                    mAnswerTextview.setText(R.string.true_button);
                }else{
                    mAnswerTextview.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(CHEATED, mAnswerIsShown);
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }


    public static Intent newIntent(Context packageContent, boolean answer){
        Intent i = new Intent(packageContent, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answer);
        return i;
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        mAnswerIsShown = isAnswerShown;
        setResult(RESULT_OK, data);
    }
}
