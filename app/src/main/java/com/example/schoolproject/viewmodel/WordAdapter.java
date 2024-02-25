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
import com.example.schoolproject.view.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private Context context;
    private Activity activity;
    private List<Word> wordlist;

    private List<Word> newWord;

    public WordAdapter(Context context, Activity activity, List<Word> wordlist) {
        this.context = context;
        this.activity = activity;
        this.wordlist = wordlist;
        newWord = new ArrayList<>(wordlist);
    }
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_words, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.word.setText(wordlist.get(position).getWord());
        holder.definition.setText(wordlist.get(position).getDefinition());

        holder.list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);

                intent.putExtra("word", wordlist.get(position).getWord());
                intent.putExtra("definition", wordlist.get(position).getDefinition());
                intent.putExtra("id", wordlist.get(position).getId());

                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return wordlist.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        TextView word, definition;
        ConstraintLayout list;
       ViewHolder(@NonNull View View) {
           super(View);
           word = View.findViewById(R.id.word);
           definition = View.findViewById(R.id.definition);
           list = View.findViewById(R.id.listlayout);
       }
   }
}
