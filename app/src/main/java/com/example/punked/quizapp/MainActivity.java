package com.example.punked.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button start,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up the start button to launch the Quiz activity
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,QuizActivity.class);
            startActivity(intent);
            finish();
            }
        });

        //In case the users are bored and don't like my app :)
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });



    }

}
