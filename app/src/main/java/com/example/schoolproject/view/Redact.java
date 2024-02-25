package com.example.schoolproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.schoolproject.R;

public class Redact extends AppCompatActivity {
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

    }
    private View.OnClickListener spisok_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}