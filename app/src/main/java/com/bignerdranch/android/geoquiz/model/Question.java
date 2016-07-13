package com.bignerdranch.android.geoquiz.model;

/**
 * Created by weyden.herrera on 7/6/2016.
 */
public class Question {
    private int mTestResId;
    private boolean mAnswerTrue;

    public Question(int mTestResId, boolean mAnswerTrue) {
        this.mTestResId = mTestResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getTestResId() {
        return mTestResId;
    }

    public void setTestResId(int testResId) {
        mTestResId = testResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
