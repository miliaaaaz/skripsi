package com.example.weddingplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterGuest extends RecyclerView.Adapter<AdapterGuest.HolderData> {
    List<String> listData;
    LayoutInflater inflater;

    public AdapterGuest(Context context, List<String> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.guest_list, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.guestName.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        TextView guestName;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            guestName = itemView.findViewById(R.id.nama_guest);
        }
    }
}
