package com.example.schoolproject.view.Gramma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.schoolproject.R;
import com.example.schoolproject.view.Notebook.NotebookView;
import com.example.schoolproject.view.Notebook.UpdateActivity;
import com.example.schoolproject.viewmodel.DatabaseHelperGramma;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;

public class UPDGramma extends AppCompatActivity {
    private EditText name,describe;
    private ImageButton upd, del;
    private String id;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_updgramma);
        button = findViewById(R.id.backUPDGR);
        name = findViewById(R.id.editGramma);
        describe = findViewById(R.id.desbribeEditGramma);
        upd = findViewById(R.id.updGramma);
        del = findViewById(R.id.delGramma);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        describe.setText(intent.getStringExtra("description"));
        id = intent.getStringExtra("id");

        upd.setOnClickListener(listener);
        del.setOnClickListener(listener);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UPDGramma.this, GrammaView.class));
            }
        });
    }
    private View.OnClickListener listener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DatabaseHelperGramma databaseHelperGramma = new DatabaseHelperGramma(UPDGramma.this);
            switch (v.getId()){
                case R.id.updGramma:
                    databaseHelperGramma.updateNotes(name.getText().toString(), describe.getText().toString(), id);
                    Toast.makeText(UPDGramma.this, "заметок нет", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UPDGramma.this, GrammaView.class));
                case R.id.delGramma:
                    databaseHelperGramma.deleteSingleItem(id);
                    Toast.makeText(UPDGramma.this, "заметок нет", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(UPDGramma.this, GrammaView.class));
            }
            //startActivity(new Intent(UPDGramma.this, GrammaView.class));
        }
    };
}