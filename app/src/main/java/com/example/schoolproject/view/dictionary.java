package com.example.schoolproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Word;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;

import java.util.ArrayList;
import java.util.List;

public class dictionary extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageButton add;
    List<Word> words = new ArrayList<Word>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);


    }
}