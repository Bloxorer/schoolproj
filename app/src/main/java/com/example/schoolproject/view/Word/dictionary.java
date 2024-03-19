package com.example.schoolproject.view.Word;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Notebook;
import com.example.schoolproject.model.Word;
import com.example.schoolproject.view.Notebook.AddNoteACtiv;
import com.example.schoolproject.view.Notebook.NotebookView;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;
import com.example.schoolproject.viewmodel.DatabaseHelperWords;
import com.example.schoolproject.viewmodel.NoteebokAdapter;
import com.example.schoolproject.viewmodel.WordAdapter;

import java.util.ArrayList;
import java.util.List;

public class dictionary extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageButton addNote;
    private List<Word> words;
    private DatabaseHelperWords databaseHelperWords;
    private WordAdapter wordAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        recyclerView = findViewById(R.id.WordView);
        addNote = findViewById(R.id.newActWord);

        words = new ArrayList<>();
        databaseHelperWords = new DatabaseHelperWords(this);

        fetchAllNotes();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        wordAdapter = new WordAdapter(this, dictionary.this, words);
        recyclerView.setAdapter(wordAdapter);
        addNote.setOnClickListener(listener);
    }
    public void fetchAllNotes(){
        Cursor cursor = databaseHelperWords.readNotes();

        if (cursor.getCount() == 0){
            Toast.makeText(this, "заметок нет", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()){
                words.add(new Word(cursor.getString(0), cursor.getString(1),cursor.getString(2)));
            }
        }
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(dictionary.this, AddWordActivity.class));
        }
    };
}