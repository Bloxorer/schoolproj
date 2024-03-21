package com.example.schoolproject.view.Word;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.schoolproject.R;
import com.example.schoolproject.view.Notebook.AddNoteACtiv;
import com.example.schoolproject.view.Notebook.NotebookView;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;
import com.example.schoolproject.viewmodel.DatabaseHelperWords;

public class AddWordActivity extends AppCompatActivity {
    private EditText addWord, addDescription;
    private ImageButton create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        addDescription = findViewById(R.id.definitionnew);
        addWord = findViewById(R.id.newWord);
        create = findViewById(R.id.createWord);
        Button button = findViewById(R.id.backaddword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddWordActivity.this, dictionary.class));
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelperWords databaseHelperWord = new DatabaseHelperWords(AddWordActivity.this);
                databaseHelperWord.addNotes(addWord.getText().toString(), addDescription.getText().toString());

                Intent intent = new Intent(AddWordActivity.this, dictionary.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}