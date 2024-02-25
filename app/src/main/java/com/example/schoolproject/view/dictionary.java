package com.example.schoolproject.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Word;
import com.example.schoolproject.viewmodel.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class dictionary extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageButton add;
    List<Word> words = new ArrayList<Word>();
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        databaseHelper = new DatabaseHelper(this);

    }
}