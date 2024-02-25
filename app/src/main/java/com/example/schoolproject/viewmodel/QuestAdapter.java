package com.example.schoolproject.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Question;
import com.example.schoolproject.model.Word;
import com.example.schoolproject.view.Redact;

import java.util.List;

public class QuestAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Question> quests;

    public QuestAdapter(LayoutInflater inflater, List<Question> quests) {
        this.inflater = inflater;
        this.quests = quests;
    }


    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_words, parent, false);
        return new WordAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WordAdapter.ViewHolder holder, int position) {
        Question question = quests.get(position);
        holder.name.setText(question.getQuest());
        holder.definition.setText(question.getNum());
    }

    @Override
    public int getItemCount() {
        return quests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView quest;
        final TextView num;

        public ViewHolder(View view) {
            super(view);
            quest = view.findViewById(R.id.question);
            num = view.findViewById(R.id.number);
        }
    }
}
