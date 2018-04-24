package com.yaming.programmingbook;

/**
 * Created by Administrator on 2018-4-24  0024.
 */

public class Question {

    private int mQuestion;
    private boolean mAnswer;

    public Question(int mQuestion, boolean mAnswer) {
        this.mQuestion = mQuestion;
        this.mAnswer = mAnswer;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
