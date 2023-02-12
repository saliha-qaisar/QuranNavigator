package com.example.qurannavigator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class by_Parah extends AppCompatActivity {
    RecyclerView recycle ;
    ArrayList<selection> dataHolder;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String selectedFormt;
    ArrayList<String> surahs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_parah);
        Intent intent = getIntent();
        selectedFormt = intent.getStringExtra("format");
        recycle=(RecyclerView)findViewById(R.id.recyclerView);
        dataHolder=new ArrayList<>();
        surahs=new ArrayList<>() ;
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
            try{
                JSONObject obj=new JSONObject(loadJson());
                JSONArray array=obj.getJSONArray("data");
                for (int i=0;i<array.length();i++)
                {
                    JSONObject sbj=array.getJSONObject(i);
                    if(!surahs.contains(sbj.getString("englishName")))
                    {
                        surahs.add(sbj.getString("englishName"));

                    }


                }

                Log.d("array","lenth"+surahs.size());

            }
            catch (JSONException e)
            {

            }

        }
        adapter = new myRecyclerViewAdapter(dataHolder) ;
        recycle.setAdapter(adapter);

    }
     public String loadJson(){
        String json=null;
        try{
            InputStream in=getAssets().open("QuranMetaData.json");
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            json=new String(buffer,"UTF-8");
            Log.d("array","Done");


        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        return json;
     }
}