package com.example.punked.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class QuizActivity extends AppCompatActivity {

    private EditText q6, q10;
    private CheckBox q4a1, q4a2, q4a3, q4a4;
    private Button submit, quit;
    private int score;

    /* Preparing a variable to hold the false answers
     * 14 spots for 14 questions false for wrong answers,
      * true for right one. This data will be used in the
      * next activity to give more individual information
      * about every single wrong answer :)*/
    private boolean[] hints = new boolean[14];

    private Context context;
    private CharSequence text;
    private int duration;
    private Toast toast;
    private boolean hintsEnabled;
    private ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        context = getApplicationContext();
        score = 0;
        duration = Toast.LENGTH_SHORT;
        text = "Wrong! Think again :)"; //setting up hint text if the user tap on a wrong answer
        toast = Toast.makeText(context, text, duration);
        q4a1 = (CheckBox) findViewById(R.id.q4a1);
        q4a2 = (CheckBox) findViewById(R.id.q4a2);
        q4a3 = (CheckBox) findViewById(R.id.q4a3);
        q4a4 = (CheckBox) findViewById(R.id.q4a4);
        q6 = (EditText) findViewById(R.id.q6a1);
        q10 = (EditText) findViewById(R.id.q10a1);
        toggle = (ToggleButton) findViewById(R.id.toggle_hints); //button to activate/deactivate hints
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hintsEnabled = true;
                } else {
                    hintsEnabled = false;
                }
            }
        });

        //Setting a button to submit the data and send the false answers to next activity
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (q4a1.isChecked() && !q4a2.isChecked() && !q4a3.isChecked() && !q4a4.isChecked() ) {
                    score += 1;
                    hints[3] = true;
                } else {
                    hints[3] = false;
                }
                if (q6 != null && (q6.getText().toString().equals("2.0") || q6.getText().toString().equals(" 2.0 ") ||
                        q6.getText().toString().equals(" 2.0") || q6.getText().toString().equals("2.0 "))) {
                    score += 1;
                    hints[5] = true;
                } else {
                    hints[5] = false;
                }
                if (q10 != null && q10.getText().toString().equals("Green == true")) {
                    score += 1;
                    hints[9] = true;
                } else {
                    hints[9] = false;
                }
                toast = Toast.makeText(context, "Your score is: " + score, duration);
                toast.show();//Displaying the score in a toast
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("hints", hints); //passing the false answers to next activity
                intent.putExtra("score", score); // passing the data for the score
                startActivity(intent);
                finish();
            }
        });

        //Setting a button to close the app
        quit = (Button) findViewById(R.id.exit);
        quit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }


    /*
    * Method to check the selected answers for Question 1
    */
    public void checkQ1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1a1:
                if (checked)
                    if (hintsEnabled) {
                        hints[0] = false;
                        toast.show();
                    }
                break;
            case R.id.q1a2:
                if (checked)
                    if (hintsEnabled) {
                        hints[0] = false;
                        toast.show();
                    }
                break;
            case R.id.q1a3:
                if (checked)
                    if (hintsEnabled) {
                        hints[0] = false;
                        toast.show();
                    }
                break;
            case R.id.q1a4:
                if (checked)
                    score += 1;
                hints[0] = true;
                break;
            case R.id.q1a5:
                if (checked)
                    if (hintsEnabled) {
                        hints[0] = false;
                        toast.show();
                    }
                break;
        }
    }

    /*
    * Method to check the selected answers for Question 2
    */
    public void checkQ2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q2a1:
                if (checked)
                    if (hintsEnabled) {
                        hints[1] = false;
                        toast.show();
                    }
                break;
            case R.id.q2a2:
                if (checked)
                    if (hintsEnabled) {
                        hints[1] = false;
                        toast.show();
                    }
                ;
                break;
            case R.id.q2a3:
                if (checked)
                    if (hintsEnabled) {
                        hints[1] = false;
                        toast.show();
                    }
                break;
            case R.id.q2a4:
                if (checked)
                    score += 1;
                hints[1] = true;
                break;

        }
    }

    /*
    * Method to check the selected answers for Question 3
    */
    public void checkQ3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q3a1:
                if (checked)
                    if (hintsEnabled) {
                        hints[2] = false;
                        toast.show();
                    }
                break;
            case R.id.q3a2:
                if (checked)
                    if (hintsEnabled) {
                        hints[2] = false;
                        toast.show();
                    }
                break;
            case R.id.q3a3:
                if (checked)
                    if (hintsEnabled) {
                        hints[2] = false;
                        toast.show();
                    }
                break;
            case R.id.q3a4:
                if (checked)

                    score += 1;
                hints[2] = true;

                break;
            case R.id.q3a5:
                if (checked)
                    if (hintsEnabled) {
                        hints[2] = false;
                        toast.show();
                    }
                break;
            case R.id.q3a6:
                if (checked)
                    if (hintsEnabled) {
                        hints[2] = false;
                        toast.show();
                    }
                break;

        }
    }

    /*
    * Method to check the selected answers for Question 5
    */
    public void checkQ5(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q5a1:
                if (checked)
                    score += 1;
                hints[4] = true;
                break;
            case R.id.q5a2:
                if (checked)
                    if (hintsEnabled) {
                        hints[4] = false;
                        toast.show();
                    }
                break;
            case R.id.q5a3:
                if (checked)
                    if (hintsEnabled) {
                        hints[4] = false;
                        toast.show();
                    }
                break;

        }
    }

    /*
    * Method to check the selected answers for Question 7
    */
    public void checkQ7(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q7a1:
                if (checked)
                    score += 1;
                hints[6] = true;
                break;
            case R.id.q7a2:
                if (checked)
                    if (hintsEnabled) {
                        hints[6] = false;
                        toast.show();
                    }
                break;


        }
    }

    /*
    * Method to check the selected answers for Question 8
    */
    public void checkQ8(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q8a1:
                if (checked)
                    score += 1;
                hints[7] = true;
                break;
            case R.id.q8a2:
                if (checked)
                    if (hintsEnabled) {
                        hints[7] = false;
                        toast.show();
                    }
                break;


        }
    }

    /*
    * Method to check the selected answers for Question 9
    */
    public void checkQ9(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q9a1:
                if (checked)
                    if (hintsEnabled) {
                        hints[8] = false;
                        toast.show();
                    }

                break;
            case R.id.q9a2:
                if (checked)
                    score += 1;
                hints[8] = true;
                break;
            case R.id.q9a3:
                if (checked)
                    if (hintsEnabled) {
                        hints[8] = false;
                        toast.show();
                    }
                break;

        }
    }

    /*
    * Method to check the selected answers for Question 11
    */
    public void checkQ11(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q11a1:
                if (checked)
                    score += 1;
                hints[10] = true;
                break;
            case R.id.q11a2:
                if (checked)
                    if (hintsEnabled) {
                        hints[10] = false;
                        toast.show();
                    }
                break;
            case R.id.q11a3:
                if (checked)
                    if (hintsEnabled) {
                        hints[10] = false;
                        toast.show();
                    }
                break;


        }
    }

    /*
    * Method to check the selected answers for Question 12
    */
    public void checkQ12(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q12a1:
                if (checked)
                    if (hintsEnabled) {
                        hints[11] = false;
                        toast.show();
                    }

                break;
            case R.id.q12a2:
                if (checked)
                    score += 1;
                hints[11] = true;
                break;
            case R.id.q12a3:
                if (checked)
                    if (hintsEnabled) {
                        hints[11] = false;
                        toast.show();
                    }
                break;

        }
    }

    /*
    * Method to check the selected answers for Question 13
    */
    public void checkQ13(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q13a1:
                if (checked)
                    if (hintsEnabled) {
                        hints[12] = false;
                        toast.show();
                    }
                break;
            case R.id.q13a2:
                if (checked)
                    score += 1;
                hints[12] = true;
                break;


        }
    }

    /*
    * Method to check the selected answers for Question 14
    */
    public void checkQ14(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q14a1:
                if (checked)
                    if (hintsEnabled) {
                        hints[13] = false;
                        toast.show();
                    }
                break;
            case R.id.q14a2:
                if (checked)
                    score += 1;
                hints[13] = true;
                break;
            case R.id.q14a3:
                if (checked)
                    if (hintsEnabled) {
                        hints[13] = false;
                        toast.show();
                    }
                break;


        }
    }

}
