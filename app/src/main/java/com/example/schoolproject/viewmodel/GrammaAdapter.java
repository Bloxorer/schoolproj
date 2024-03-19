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
import com.example.schoolproject.model.Gramma;
import com.example.schoolproject.view.Gramma.UPDGramma;
import com.example.schoolproject.view.Notebook.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

public class GrammaAdapter extends RecyclerView.Adapter<GrammaAdapter.ViewHolder> {
    private Context context;
    private Activity activity;
    private List<Gramma> grammaList;
    private List<Gramma> newList;

    public GrammaAdapter(Context context, Activity activity, List<Gramma> grammaList) {
        this.context = context;
        this.activity = activity;
        this.grammaList = grammaList;
        newList = new ArrayList<>(grammaList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_recycle_view_gramma, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.describe.setText(grammaList.get(position).getDescription());
        holder.nameNote.setText(grammaList.get(position).getName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UPDGramma.class);
                intent.putExtra("name", grammaList.get(position).getName());
                intent.putExtra("description", grammaList.get(position).getDescription());
                intent.putExtra("id", grammaList.get(position).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return grammaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameNote,describe;
        ConstraintLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameNote = itemView.findViewById(R.id.nameGramma);
            layout = itemView.findViewById(R.id.Grammalayout);
            describe = itemView.findViewById(R.id.describeGramma);
        }
    }
}
