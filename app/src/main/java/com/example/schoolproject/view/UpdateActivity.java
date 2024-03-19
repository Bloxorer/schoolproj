package com.example.schoolproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        name = findViewById(R.id.editWord);
        describe = findViewById(R.id.definitionedit);
        upd = findViewById(R.id.upd);
        del = findViewById(R.id.del);
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