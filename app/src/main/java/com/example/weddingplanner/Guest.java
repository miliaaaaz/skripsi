package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Guest extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterGuest adapterGuest;
    List<String> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        recyclerView = findViewById(R.id.guestlist);
        listData = new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterGuest = new AdapterGuest(this, listData);
        recyclerView.setAdapter(adapterGuest);
        adapterGuest.notifyDataSetChanged();
    }
}