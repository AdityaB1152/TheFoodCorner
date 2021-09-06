package com.example.thefoodcorner;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.thefoodcorner.databinding.ActivityDeatilBinding;

public class DeatilActivity extends AppCompatActivity {

    ActivityDeatilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeatilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper dbHelper = new DBHelper(this);
        if(getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String desc = getIntent().getStringExtra("desc");

            binding.detailimage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.namebox.setText(name);
            binding.detaildescription.setText(desc);





            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = dbHelper.insertOrder(
                            binding.customername.getText().toString(),
                            binding.phonebox.getText().toString(),
                            price,
                            image,
                            Integer.parseInt(binding.quantity.getText().toString()),
                            binding.detaildescription.getText().toString(),
                            binding.namebox.getText().toString()
                    );
                    if (isInserted) {
                        Toast.makeText(DeatilActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DeatilActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }else{
            int id = getIntent().getIntExtra("id",2);
            Cursor cursor = dbHelper.getOrderById(id);
            binding.detailimage.setImageResource(cursor.getInt(4));
            binding.priceLbl.setText(cursor.getString(3));
            binding.namebox.setText(cursor.getString(7));
            binding.detaildescription.setText(cursor.getString(6));

            binding.customername.setText(cursor.getString(1));
            binding.phonebox.setText(cursor.getString(2));
            binding.button.setText("Update Now");
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  boolean isUpdated =   dbHelper.updateOrder(
                            binding.customername.getText().toString(),
                            binding.phonebox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                          cursor.getInt(4),
                            1,
                            binding.detaildescription.getText().toString(),
                            binding.namebox.getText().toString(),
                            id
                    );
                  if(isUpdated){
                      Toast.makeText(DeatilActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                  }
                  else {
                      Toast.makeText(DeatilActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                  }

                }
            });
        }
    }
}