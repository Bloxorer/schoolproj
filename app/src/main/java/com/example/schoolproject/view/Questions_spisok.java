package com.example.schoolproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Question;
import com.example.schoolproject.viewmodel.QuestAdapter;

import java.util.ArrayList;
import java.util.List;

public class Questions_spisok extends AppCompatActivity {
    Redact redact;
    List<Question> questions = new ArrayList<Question>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_spisok);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.quests_spisok);
        QuestAdapter adapter = new QuestAdapter(this.getLayoutInflater(), questions);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData(){
        questions.add(new Question("Whats your name", "1"));
        questions.add(new Question("How old are you", "2"));
        questions.add(new Question("How are you", "3"));
    }
}