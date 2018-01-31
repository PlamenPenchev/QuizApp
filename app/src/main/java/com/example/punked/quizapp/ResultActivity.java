package com.example.punked.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button show, quit;
    private boolean[] hints; //Saving the received value
    private int score;
    String j;
    private CharSequence[] result; //setting up information for each individual question
    private CharSequence wrongAnswers, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", score);
        result = new CharSequence[14];
        wrongAnswers = "You have "+score+" points \nYour wrong answers are: \n";
        result[0] = "Q1. \\where\\ is not a keyword in java \n";
        result[1] = "Q2. method type of void does nto require a return value\n";
        result[2] = "Q3. Integer.MAX_VALUE + 1 equals Integer.MIN_VALUE\n";
        result[3] = "Q4. The answer is \\654321\\ if you checked more than 1 or wrong answer you got 0 points :)\n";
        result[4] = "Q5. True AND false OR false is false\n";
        result[5] = "Q6. Right answer is 2.0\n";
        result[6] = "Q7. Try System.out.println(arrayName instanceof Object); :) \n";
        result[7] = "Q8. It is true as a Rabbit is a child of LiveStock\n";
        result[8] = "Q9. private String andMe() {}; has no return statement\n";
        result[9] = "Q10. !IsItGreen will return truw and the first block will be compiled only\n";
        result[10] = "Q11. (false && false)^true will end up true :D\n";
        result[11] = "Q12. The output is random integer from 0 to 10\n";
        result[12] = "Q13. Yes it is a recursion function\n";
        result[13] = "Q14. Bubble sort :) you can google it, it's interesting :)";

        hints = (boolean[]) intent.getSerializableExtra("hints");
        for (int i=0; i<hints.length; i ++){
            if (hints[i]==false){
                wrongAnswers = wrongAnswers + result[i].toString();
            }
        }
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
