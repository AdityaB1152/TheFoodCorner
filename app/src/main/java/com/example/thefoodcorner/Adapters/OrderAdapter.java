package com.example.thefoodcorner.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thefoodcorner.DBHelper;
import com.example.thefoodcorner.DeatilActivity;
import com.example.thefoodcorner.Modals.OrderModal;
import com.example.thefoodcorner.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder> {
    ArrayList <OrderModal> list;
    Context context;

    public OrderAdapter(ArrayList<OrderModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull

    @Override
    public viewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.viewHolder holder, int position) {
        final  OrderModal orderModal = list.get(position);
        holder.orderImage.setImageResource(orderModal.getOrderImg());
        holder.soldItemName.setText(orderModal.getSoldItemName());
        holder.orderNumber.setText(orderModal.getOrderNumber());
        holder.price.setText(orderModal.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DeatilActivity.class);
                intent.putExtra("id" , orderModal.getOrderNumber());
                intent.putExtra("type" , 2);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Cancel Order!")
                        .setMessage("Are you sure to cancel the order??")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper helper = new DBHelper(context);
                                if(helper.deleteOrder(orderModal.getOrderNumber())>0){
                                    Toast.makeText(context, "Order Cancelled", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView orderImage;
        TextView soldItemName , orderNumber , price;


        public viewHolder(@NonNull  View itemView) {
            super(itemView);
            orderImage = itemView.findViewById(R.id.orderimage);
            soldItemName = itemView.findViewById(R.id.orderitemname);
            orderNumber = itemView.findViewById(R.id.ordernumber);
            price = itemView.findViewById(R.id.orderprice2);
        }
    }
}
