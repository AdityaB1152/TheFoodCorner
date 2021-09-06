package com.example.thefoodcorner.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thefoodcorner.DeatilActivity;
import com.example.thefoodcorner.Modals.MainModal;
import com.example.thefoodcorner.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    ArrayList<MainModal> list;
    Context context;

    public MainAdapter(ArrayList<MainModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_main_food , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        final MainModal modal = list.get(position);
        holder.foodImage.setImageResource(modal.getImg());
        holder.mainName.setText(modal.getName());
        holder.price.setText(modal.getPrice());
        holder.description.setText(modal.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DeatilActivity.class);
                intent.putExtra("image" , modal.getImg());
                intent.putExtra("price" , modal.getPrice());
                intent.putExtra("desc" , modal.getDescription());
                intent.putExtra("name" , modal.getName());
                intent.putExtra("type" , 1);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView mainName , price , description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.imageview);
            mainName = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.orderprice);
            description = itemView.findViewById(R.id.description);
        }
    }
}
