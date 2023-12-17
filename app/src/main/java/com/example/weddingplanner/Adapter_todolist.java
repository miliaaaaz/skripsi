package com.example.weddingplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Adapter_todolist extends RecyclerView.Adapter<Adapter_todolist.HolderData> {
    List<String> listData;
    LayoutInflater inflater;

    public Adapter_todolist (Context context, List<String> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.todolist_category, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.nama_kategori.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        TextView nama_kategori;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            nama_kategori = itemView.findViewById(R.id.nama_kategori);
        }
    }
}
