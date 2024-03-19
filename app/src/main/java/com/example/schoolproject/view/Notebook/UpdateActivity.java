package com.example.schoolproject.view.Notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.schoolproject.R;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;

public class UpdateActivity extends AppCompatActivity {
    private EditText name,describe;
    private ImageButton upd, del;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Button button = findViewById(R.id.backUpdNote);
        name = findViewById(R.id.editNote);
        describe = findViewById(R.id.desbribeEdit);
        upd = findViewById(R.id.upd);
        del = findViewById(R.id.del);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        describe.setText(intent.getStringExtra("description"));
        id = intent.getStringExtra("id");

        upd.setOnClickListener(listener);
        del.setOnClickListener(listener);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateActivity.this, NotebookView.class));
            }
        });
    }
    private View.OnClickListener listener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DatabaseHelperNotebook databaseHelperNotebook = new DatabaseHelperNotebook(UpdateActivity.this);
            switch (v.getId()){
                case R.id.upd:
                    databaseHelperNotebook.updateNotes(name.getText().toString(), describe.getText().toString(), id);
                    break;
                case R.id.del:
                    databaseHelperNotebook.deleteSingleItem(id);
                    break;
            }
            startActivity(new Intent(UpdateActivity.this, NotebookView.class));
        }
    };
}