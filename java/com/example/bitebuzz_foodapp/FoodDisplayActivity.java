package com.example.bitebuzz_foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodDisplayActivity extends AppCompatActivity {

    private GridView gridView;
    private Button btnConfirmOrder;
    private ArrayList<ItemFoodActivity> foodItems;
    private ArrayList<FoodOrder> foodOrders; // This will store the selected food orders

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_display);

        gridView = findViewById(R.id.grid_view);
        btnConfirmOrder = findViewById(R.id.btn_confirm_order);

        // Initialize food items and set up the GridView
        foodItems = new ArrayList<>();
        // Add food items to the list
        foodItems.add(new ItemFoodActivity("Burger", 50, R.drawable.burger));
        foodItems.add(new ItemFoodActivity("Pizza", 75, R.drawable.pizza));
        foodItems.add(new ItemFoodActivity("Dosa", 40, R.drawable.dosa));
        foodItems.add(new ItemFoodActivity("Noodles", 80, R.drawable.noodles));

        FoodAdapter foodAdapter = new FoodAdapter(this, foodItems);
        gridView.setAdapter(foodAdapter);

        // When clicking the confirm order button, go to the ConfirmOrderActivity
        btnConfirmOrder.setOnClickListener(v -> {
            Intent intent = new Intent(FoodDisplayActivity.this, ConfirmOrderActivity.class);
            startActivity(intent);
        });
    }
}
