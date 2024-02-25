package com.example.schoolproject.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.schoolproject.R;
import com.example.schoolproject.viewmodel.QuestAdapter;

public class Redact extends AppCompatActivity {
    public int i = 1;

    private ImageButton spisok;
    private ImageButton delword;
    private ImageButton delquest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redact);
        spisok = findViewById(R.id.listofquest);
        delquest = findViewById(R.id.deletallquest);
        delword = findViewById(R.id.deletallword);
        spisok.setOnClickListener(spisok_listener);
    }
    private View.OnClickListener spisok_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Questions_spisok.class);
            intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
    };
    private View.OnClickListener delword_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            i = 2;
        }
    };
}