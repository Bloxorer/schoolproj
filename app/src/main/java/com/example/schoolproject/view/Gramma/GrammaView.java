package com.example.schoolproject.view.Gramma;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Gramma;
import com.example.schoolproject.model.Notebook;
import com.example.schoolproject.view.Notebook.AddNoteACtiv;
import com.example.schoolproject.view.Notebook.NotebookView;
import com.example.schoolproject.view.chosing;
import com.example.schoolproject.viewmodel.DatabaseHelperGramma;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;
import com.example.schoolproject.viewmodel.GrammaAdapter;
import com.example.schoolproject.viewmodel.NoteebokAdapter;

import java.util.ArrayList;
import java.util.List;

public class GrammaView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageButton addNote;
    private List<Gramma> grammaList;
    private DatabaseHelperGramma databaseHelperGramma;
    private GrammaAdapter grammaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramma);
        Button button = findViewById(R.id.backGramma);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GrammaView.this, chosing.class));
            }
        });
        recyclerView = findViewById(R.id.recycleGramma);
        addNote = findViewById(R.id.newActGramma);

        grammaList = new ArrayList<>();
        databaseHelperGramma = new DatabaseHelperGramma(this);

        fetchAllNotes();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        grammaAdapter = new GrammaAdapter(this, GrammaView.this, grammaList);
        recyclerView.setAdapter(grammaAdapter);
        addNote.setOnClickListener(listener);
    }
    public void fetchAllNotes(){
        Cursor cursor = databaseHelperGramma.readNotes();

        if (cursor.getCount() == 0){
            Toast.makeText(this, "заметок нет", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()){
                grammaList.add(new Gramma(cursor.getString(0), cursor.getString(1),cursor.getString(2)));
            }
        }
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(GrammaView.this, AddGramma.class));
        }
    };
}