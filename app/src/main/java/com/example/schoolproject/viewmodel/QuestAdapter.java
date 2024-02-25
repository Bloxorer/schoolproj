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

public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    public List<Question> quests;

    public List<Question> getQuests() {
        return quests;
    }
    public void setQuests(List<Question> quests) {
        this.quests = quests;
    }

    public QuestAdapter(LayoutInflater inflater, List<Question> quests) {
        this.inflater = inflater;
        this.quests = quests;
    }


    @Override
    public QuestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.quest_list, parent, false);
        return new QuestAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuestAdapter.ViewHolder holder, int position) {
        Question question = quests.get(position);
        holder.quest.setText(question.getQuest());

    }

    @Override
    public int getItemCount() {
        return quests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView quest;


        public ViewHolder(View view) {
            super(view);
            quest = view.findViewById(R.id.question);

                    }
    }
}
