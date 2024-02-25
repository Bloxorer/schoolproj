package com.example.schoolproject.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.schoolproject.R;

public class MainActivity extends AppCompatActivity {
    ImageButton start;
    ImageButton exit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        exit = findViewById(R.id.exitbutton);
        exit.setOnClickListener(exitlist);
        start.setOnClickListener(startlist);
    }
    private View.OnClickListener startlist = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent chosingIntent = new Intent(getApplicationContext(), chosing.class);
            chosingIntent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(chosingIntent);
        }
    };
    private  View.OnClickListener exitlist = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}