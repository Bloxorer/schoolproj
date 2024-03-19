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
import com.example.schoolproject.view.Notebook.NotebookView;
import com.example.schoolproject.view.Notebook.UpdateActivity;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;
import com.example.schoolproject.viewmodel.DatabaseHelperWords;

public class UpdateWordActivity extends AppCompatActivity {
    private EditText name,describe;
    private ImageButton upd, del;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_word);
        Button button = findViewById(R.id.backUpdNote);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateWordActivity.this, dictionary.class));
            }
        });
        name = findViewById(R.id.editWord);
        describe = findViewById(R.id.definitionedit);
        upd = findViewById(R.id.updWord);
        del = findViewById(R.id.delWord);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        describe.setText(intent.getStringExtra("description"));
        id = intent.getStringExtra("id");

        upd.setOnClickListener(listener);
        del.setOnClickListener(listener);

    }
    private View.OnClickListener listener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DatabaseHelperWords databaseHelperWords = new DatabaseHelperWords(UpdateWordActivity.this);
            switch (v.getId()){
                case R.id.updWord:
                    databaseHelperWords.updateNotes(name.getText().toString(), describe.getText().toString(), id);
                    break;
                case R.id.delWord:
                    databaseHelperWords.deleteSingleItem(id);
                    break;
            }
            startActivity(new Intent(UpdateWordActivity.this, dictionary.class));
        }
    };
}