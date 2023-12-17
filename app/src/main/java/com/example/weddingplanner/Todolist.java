package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Todolist extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Adapter_todolist adapter_todolist;
    List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        recyclerView = findViewById(R.id.category_todolist);
        listData = new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter_todolist = new Adapter_todolist(this, listData);
        recyclerView.setAdapter(adapter_todolist);
        adapter_todolist.notifyDataSetChanged();
    }
}