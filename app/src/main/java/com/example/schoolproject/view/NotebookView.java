package com.example.schoolproject.view;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Notebook;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;
import com.example.schoolproject.viewmodel.NoteebokAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotebookView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageButton addNote;
    private List<com.example.schoolproject.model.Notebook> notebookList;
    private DatabaseHelperNotebook databaseHelperNotebook;
    private NoteebokAdapter noteebokAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);

        recyclerView = findViewById(R.id.recycleNotebook);
        addNote = findViewById(R.id.addNote);

        notebookList = new ArrayList<>();
        databaseHelperNotebook = new DatabaseHelperNotebook(this);

        fetchAllNotes();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteebokAdapter = new NoteebokAdapter(this, NotebookView.this, notebookList);
        recyclerView.setAdapter(noteebokAdapter);
        addNote.setOnClickListener(listener);
    }
    public void fetchAllNotes(){
        Cursor cursor = databaseHelperNotebook.readNotes();

        if (cursor.getCount() == 0){
            Toast.makeText(this, "заметок нет", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()){
                notebookList.add(new Notebook(cursor.getString(0), cursor.getString(1),cursor.getString(2)));
            }
        }
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(NotebookView.this, AddNoteACtiv.class));
        }
    };
}