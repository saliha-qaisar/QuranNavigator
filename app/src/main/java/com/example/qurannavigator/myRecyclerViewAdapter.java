package com.example.qurannavigator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {
    ArrayList<selection> logs;
    Context context;

    public myRecyclerViewAdapter(ArrayList<selection> dataHolder, Context context) {
        this.logs=dataHolder;
        this.context=context;
    }

    public myRecyclerViewAdapter(ArrayList<selection> dataHolder) {
        this.logs=dataHolder;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlerow, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data=logs.get(position);
        holder.format.setText(holder.data.format);
        if(holder.data.format.equals("parah"))
            holder.name.setText(String.valueOf((holder.data.number)));
        else
            holder.name.setText(String.valueOf((holder.data.name)));




    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    public class MyVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView format;
        TextView  name;
        selection data;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener( this);
            context = itemView.getContext();
            format = itemView.findViewById(R.id.NameView);
            name = itemView.findViewById(R.id.number);

        }

        @Override
        public void onClick(View view) {
            android.util.Log.d("Clicked","RecyleView");
            int position=this.getAdapterPosition();
            selection data=logs.get(position);
            android.util.Log.d("Clicked",""+data);
            String id= String.valueOf(data.format);
            String name=data.name;
            Integer number=data.number;


//            Intent intent = new Intent(context,Edit.class);
//            intent.putExtra("name", name);
//            intent.putExtra("id", id);
//            intent.putExtra("sabaq", sabaq);
//            intent.putExtra("sabqi", sabqi);
//            intent.putExtra("manzil", manzil);
//            intent.putExtra("date", date);
//            context.startActivity(intent);

        }

    }
}
