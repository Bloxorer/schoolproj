package com.example.schoolproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.schoolproject.R;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;

public class AddNoteACtiv extends AppCompatActivity {
    private EditText addWord, addDescription;
    private ImageButton create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        addDescription = findViewById(R.id.definitionnew);
        addWord = findViewById(R.id.newWord);
        create = findViewById(R.id.create);

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