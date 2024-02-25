package com.example.schoolproject.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolproject.R;
import com.example.schoolproject.model.Word;
import com.example.schoolproject.view.Redact;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    public final List<Word> words;

    public WordAdapter(LayoutInflater inflater, List<Word> words) {
        this.inflater = inflater;
        this.words = words;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_words, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Word word = words.get(position);
        holder.name.setText(word.getWord());
        holder.definition.setText(word.getDefinition());
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView name;
        final TextView definition;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.word);
            definition = view.findViewById(R.id.definition);
        }
    }
}
