package com.nicoqueijo.cityskylinequiz.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nicoqueijo.cityskylinequiz.R;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
