package com.example.schoolproject.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.schoolproject.R;

public class chosing extends AppCompatActivity {
    private ImageButton dictionary;
    private ImageButton test;
    private ImageButton question;
    private ImageButton redact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosing);
        dictionary = findViewById(R.id.dictionary);
        test = findViewById(R.id.test);
        question = findViewById(R.id.question);
        redact = findViewById(R.id.redact);
        //listeners
        dictionary.setOnClickListener(dict_listener);
        test.setOnClickListener(test_listener);
        question.setOnClickListener(quest_listener);
        redact.setOnClickListener(redact_listener);
    }
    private final View.OnClickListener dict_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent dict = new Intent(getApplicationContext(), com.example.schoolproject.view.dictionary.class);
            dict.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(dict);
        }
    };
    private final View.OnClickListener test_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent test = new Intent(getApplicationContext(), com.example.schoolproject.view.test.class);
            test.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(test);
        }
    };
    private final View.OnClickListener quest_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent quest = new Intent(getApplicationContext(), com.example.schoolproject.view.question.class);
            quest.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(quest);
        }
    };
    private final View.OnClickListener redact_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent redact = new Intent(getApplicationContext(), com.example.schoolproject.view.Redact.class);
            redact.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(redact);
        }
    };
}