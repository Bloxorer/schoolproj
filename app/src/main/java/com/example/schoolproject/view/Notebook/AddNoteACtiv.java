package com.example.schoolproject.view.Notebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolproject.R;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;

public class AddNoteACtiv extends AppCompatActivity {
    private EditText addWord, addDescription;
    private ImageButton create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        addDescription = findViewById(R.id.Describenew);
        addWord = findViewById(R.id.newNote);
        create = findViewById(R.id.createNote);
        Button button = findViewById(R.id.backAddNote);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNoteACtiv.this, NotebookView.class));
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelperNotebook databaseHelperNotebook = new DatabaseHelperNotebook(AddNoteACtiv.this);
                databaseHelperNotebook.addNotes(addWord.getText().toString(), addDescription.getText().toString());

                Intent intent = new Intent(AddNoteACtiv.this, NotebookView.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}