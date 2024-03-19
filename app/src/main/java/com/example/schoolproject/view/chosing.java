package com.example.schoolproject.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.schoolproject.R;

public class chosing extends AppCompatActivity {
    private ImageButton dictionary, gramma, noteebok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosing);
        dictionary = findViewById(R.id.dictionary);
        gramma = findViewById(R.id.gramma);
        noteebok = findViewById(R.id.notebook);
        //listeners
        dictionary.setOnClickListener(dict_listener);
        gramma.setOnClickListener(gramma_list);
        noteebok.setOnClickListener(note_listener);

    }
    private final View.OnClickListener dict_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent dict = new Intent(getApplicationContext(), com.example.schoolproject.view.dictionary.class);
            dict.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(dict);
        }
    };
    private final View.OnClickListener gramma_list = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent gramma = new Intent(getApplicationContext(), GrammaView.class);
            gramma.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(gramma);
        }
    };
    private final View.OnClickListener note_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent note = new Intent(getApplicationContext(), NotebookView.class);
            note.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(note);
        }
    };

}