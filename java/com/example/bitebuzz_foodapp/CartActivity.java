

package com.example.bitebuzz_foodapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private TextView tvTotalPrice;
    private Button btnConfirmOrder;

    // Example data - replace this with actual data from your cart
    private ArrayList<String> cartItems;
    private double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize views
        cartListView = findViewById(R.id.cart_list);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        btnConfirmOrder = findViewById(R.id.btn_confirm_order);

        // Sample data - replace with your actual cart data
        cartItems = new ArrayList<>();
        cartItems.add("Burger - $5.00");
        cartItems.add("Pizza - $8.00");
        cartItems.add("Brownie - $3.00");

        // Calculate total price
        calculateTotalPrice();

        // Set up ListView with cart items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        cartListView.setAdapter(adapter);

        // Display total price
        tvTotalPrice.setText(String.format("Total: $%.2f", totalPrice));

        // Set up confirm order button
        btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOrder();
            }
        });
    }

    // Method to calculate total price from cart items
    private void calculateTotalPrice() {
        // Sample calculation - replace with your actual logic
        totalPrice = 0.0;
        for (String item : cartItems) {
            String[] parts = item.split(" - \\$");
            if (parts.length == 2) {
                totalPrice += Double.parseDouble(parts[1]);
            }
        }
    }

    // Method to confirm the order
    private void confirmOrder() {
        // Here you can add the logic to process the order, like saving to database, etc.
        Toast.makeText(this, "Order Confirmed! Total: $" + totalPrice, Toast.LENGTH_SHORT).show();
        // You can navigate to another activity for order details or success
    }
}

