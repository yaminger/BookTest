package com.yaming.programmingbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestion_tv;
    private Button mTrueBtn;
    private Button mFalseBtn;
    private ImageButton mNextBtn;
    private ImageButton mBackBtn;

    private int currentIndex = 0;

    private Question[] questions = new Question[]{
            new Question(R.string.q_1, true),
            new Question(R.string.q_2, true),
            new Question(R.string.q_3, false),
            new Question(R.string.q_4, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueBtn = (Button) findViewById(R.id.true_btn);
        mTrueBtn.setOnClickListener(this);
        mFalseBtn = (Button) findViewById(R.id.false_btn);
        mFalseBtn.setOnClickListener(this);
        mNextBtn = (ImageButton) findViewById(R.id.next_btn);
        mNextBtn.setOnClickListener(this);
        mBackBtn = (ImageButton) findViewById(R.id.back_btn);
        mBackBtn.setOnClickListener(this);
        mQuestion_tv = (TextView) findViewById(R.id.question);
        mQuestion_tv.setOnClickListener(this);
        setQuestion_tvText();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.true_btn:
                checkAnswer(true);
                break;
            case R.id.false_btn:
                checkAnswer(false);
                break;
            case R.id.next_btn:
                nextQuestion();
                break;
            case R.id.question:
                nextQuestion();
                break;
            case R.id.back_btn:
                backQuestion();
                break;
        }
    }

    private void backQuestion() {
        if (currentIndex == 0) {
            currentIndex = questions.length - 1;
        } else {
            currentIndex = (currentIndex - 1) % questions.length;
        }
        setQuestion_tvText();
    }

    private void checkAnswer(boolean result) {
        boolean currentResult = questions[currentIndex].getAnswer();
        int toastID = 0;
        if (currentResult == result) {
            toastID = R.string.toast_correct;
        } else {
            toastID = R.string.toast_incorrect;
        }
        Toast.makeText(this, toastID, Toast.LENGTH_SHORT).show();
    }

    private void nextQuestion() {
        currentIndex = (currentIndex + 1) % questions.length;
        setQuestion_tvText();
    }

    private void setQuestion_tvText() {
        int question_id = questions[currentIndex].getQuestion();  //同样的方式，没必要写的很重复
        mQuestion_tv.setText(question_id);
    }
}
