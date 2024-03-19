package com.example.schoolproject.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Word;
import com.example.schoolproject.view.Notebook.UpdateActivity;
import com.example.schoolproject.view.Word.UpdateWordActivity;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private Context context;
    private Activity activity;
    private List<Word> wordList;
    private List<Word> newList;

    public WordAdapter(Context context, Activity activity, List<Word> wordList) {
        this.context = context;
        this.activity = activity;
        this.wordList = wordList;
        newList = new ArrayList<>(wordList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_recycle_view_word, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.describeWord.setText(wordList.get(position).getDefinition());
        holder.nameWord.setText(wordList.get(position).getWord());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateWordActivity.class);
                intent.putExtra("name", wordList.get(position).getWord());
                intent.putExtra("description", wordList.get(position).getDefinition());
                intent.putExtra("id", wordList.get(position).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameWord,describeWord;
        ConstraintLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameWord = itemView.findViewById(R.id.nameWord);
            layout = itemView.findViewById(R.id.wordlayout);
            describeWord = itemView.findViewById(R.id.describeWord);
        }
    }
}


