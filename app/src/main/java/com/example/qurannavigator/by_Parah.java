package com.example.qurannavigator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class by_Parah extends AppCompatActivity {
    RecyclerView recycle ;
    ArrayList<selection> dataHolder;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String selectedFormt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_parah);
        Intent intent = getIntent();
        selectedFormt = intent.getStringExtra("format");
        recycle=(RecyclerView)findViewById(R.id.recyclerView);
        dataHolder=new ArrayList<>();
        layoutManager = new LinearLayoutManager(by_Parah.this);
        recycle.setLayoutManager(layoutManager);
        if(selectedFormt.equals("parah"))
        {
            for (int i=0;i<30;i++)
            {
                selection s1=new selection();
                s1.format="parah";
                s1.number=i+1;
                dataHolder.add(s1);

            }
        }
        else
        {

        }
        adapter = new myRecyclerViewAdapter(dataHolder) ;
        recycle.setAdapter(adapter);

    }
}