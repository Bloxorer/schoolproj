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
import com.example.schoolproject.model.Notebook;
import com.example.schoolproject.view.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

public class NoteebokAdapter extends RecyclerView.Adapter<NoteebokAdapter.ViewHolder> {
    private Context context;
    private Activity activity;
    private List<Notebook> notebooks;
    private List<Notebook> newList;

    public NoteebokAdapter(Context context, Activity activity, List<Notebook> notebooks) {
        this.context = context;
        this.activity = activity;
        this.notebooks = notebooks;
        newList = new ArrayList<>(notebooks);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_recycle_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.describe.setText(notebooks.get(position).getDescription());
        holder.nameNote.setText(notebooks.get(position).getName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("name", notebooks.get(position).getName());
                intent.putExtra("description", notebooks.get(position).getDescription());
                intent.putExtra("id", notebooks.get(position).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notebooks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameNote,describe;
        ConstraintLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameNote = itemView.findViewById(R.id.nameNote);
            layout = itemView.findViewById(R.id.notelayout);
            describe = itemView.findViewById(R.id.describeNote);
        }
    }
}
