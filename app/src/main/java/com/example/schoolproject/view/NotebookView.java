package com.example.schoolproject.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolproject.R;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;

import java.util.ArrayList;
import java.util.List;

public class NotebookView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageButton addNote;
    private List<com.example.schoolproject.model.Notebook> notebookList;
    private DatabaseHelperNotebook databaseHelperNotebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);

        recyclerView = findViewById(R.id.recycleNotebook);
        addNote = findViewById(R.id.addNote);

        notebookList = new ArrayList<>();
        databaseHelperNotebook = new DatabaseHelperNotebook(this);

    }
}