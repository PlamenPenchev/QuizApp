package com.example.punked.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private Button show;
    private Button quit;
    private boolean[] hints; //Saving the received value
    private int score;
    private CharSequence[] result; //setting up information for each individual question
    private CharSequence wrongAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", score);
        result = new CharSequence[14];
        //Loading up the strings for the wrong answers from the resources
        wrongAnswers = getResources().getString(R.string.score_wrong, score);
        result[0] = getResources().getString(R.string.result1);
        result[1] = getResources().getString(R.string.result2);
        result[2] = getResources().getString(R.string.result3);
        result[3] = getResources().getString(R.string.result4);
        result[4] = getResources().getString(R.string.result5);
        result[5] = getResources().getString(R.string.result6);
        result[6] = getResources().getString(R.string.result7);
        result[7] = getResources().getString(R.string.result8);
        result[8] = getResources().getString(R.string.result9);
        result[9] = getResources().getString(R.string.result10);
        result[10] = getResources().getString(R.string.result11);
        result[11] = getResources().getString(R.string.result12);
        result[12] = getResources().getString(R.string.result13);
        result[13] = getResources().getString(R.string.result14);

        hints = (boolean[]) intent.getSerializableExtra("hints");
        for (int i = 0; i < hints.length; i++) {
            //Check if the answer was answered wrong -> show the right info
            if (!hints[i]) {
                wrongAnswers = wrongAnswers + result[i].toString() + "\n\n";
            }
        }

        //Show the result and the answers of the wrong answered questions
        show = (Button) findViewById(R.id.showMe);
        show.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TextView mtv = (TextView) findViewById(R.id.showHints);
                mtv.setText(wrongAnswers.toString());
            }
        });
        quit = (Button) findViewById(R.id.exit);
        quit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

}
