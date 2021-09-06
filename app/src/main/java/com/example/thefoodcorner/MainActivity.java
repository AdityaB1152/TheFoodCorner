package com.example.thefoodcorner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.thefoodcorner.Adapters.MainAdapter;
import com.example.thefoodcorner.Modals.MainModal;
import com.example.thefoodcorner.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModal> list = new ArrayList<>();
        list.add(new MainModal(R.drawable.burger , "Burger" , "5" , "Chicken burger with Cheese and Veggies"));
        list.add(new MainModal(R.drawable.pizza , "Pizza" ,"10"  , "Chicken burger with Cheese and Veggies"));
        list.add(new MainModal(R.drawable.biriyani , "Biriyani" , "15" , "Chicken burger with Cheese and Veggies"));
        list.add(new MainModal(R.drawable.tandoori , "Tandoori Pizza" , "15" , "Chicken burger with Cheese and Veggies"));
        list.add(new MainModal(R.drawable.burger , "Burger" , "5" , "Chicken burger with Cheese and Veggies"));

        MainAdapter adapter = new MainAdapter(list , this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                Intent intent = new Intent(MainActivity.this , OrderActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}