package com.example.schoolproject.view.Gramma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolproject.R;
import com.example.schoolproject.viewmodel.DatabaseHelperGramma;
import com.example.schoolproject.viewmodel.DatabaseHelperNotebook;

public class AddGramma extends AppCompatActivity {
    private EditText addGramma, adddesscrGramma;
    private ImageButton create;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gramma);
        adddesscrGramma = findViewById(R.id.DescribenewGramma);
        addGramma = findViewById(R.id.newGramma);
        create = findViewById(R.id.createGramma);
        button = findViewById(R.id.backAddGramma);
        button.setOnClickListener(listener);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelperGramma databaseHelperGramma = new DatabaseHelperGramma(AddGramma.this);
                databaseHelperGramma.addNotes(addGramma.getText().toString(), adddesscrGramma.getText().toString());

                Intent intent = new Intent(AddGramma.this, GrammaView.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
    private View.OnClickListener listener  = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(AddGramma.this, GrammaView.class));
        }
    };
}