package com.example.retrofitassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private Context context;
    private List<Monster> monsterList;
    private Monster monster;
    String image;
    private Intent intent;
    public RecyclerAdapter(Context context, List list){
        this.context = context;
        this.monsterList = list;
        Collections.sort(monsterList);
        this.intent = new Intent(context, InfoActivity.class);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        monster = monsterList.get(position);
        holder.text.setText(monster.getName().toUpperCase());
        image = monster.getImage();
        Picasso.with(context).load(image).into(holder.img);

    }
    @Override
    public int getItemCount() {
        return monsterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView text;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.list_item);
            img = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this::onClick);
        }


        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            intent.putExtra("id", monsterList.get(position).getId());
            context.startActivity(intent);

        }
    }
}
