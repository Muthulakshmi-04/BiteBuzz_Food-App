package com.example.bitebuzz_foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

    private TextView tvUserInfo, tvOrderSummary;
    private Button btnConfirmOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        tvUserInfo = findViewById(R.id.tv_user_info);
        tvOrderSummary = findViewById(R.id.tv_order_summary);
        btnConfirmOrder = findViewById(R.id.btn_confirm_order);

        // Retrieve the data passed from ConfirmOrderActivity
        String userName = getIntent().getStringExtra("userName");
        String userPhone = getIntent().getStringExtra("userPhone");
        String userAddress = getIntent().getStringExtra("userAddress");
        String[] orderedItems = getIntent().getStringArrayExtra("orderedItems");
        int[] orderedPrices = getIntent().getIntArrayExtra("orderedPrices");

        // Display user info
        String userInfo = "Name: " + userName + "\nPhone: " + userPhone + "\nAddress: " + userAddress;
        tvUserInfo.setText(userInfo);

        // Display order summary
        StringBuilder orderSummary = new StringBuilder("Ordered Items:\n");
        for (int i = 0; i < orderedItems.length; i++) {
            orderSummary.append(orderedItems[i]).append(": $").append(orderedPrices[i]).append("\n");
        }
        tvOrderSummary.setText(orderSummary.toString());

        // Action for Confirm Order Button
        btnConfirmOrder.setOnClickListener(v -> {
            // Show success message
            Toast.makeText(OrderSummaryActivity.this, "Order placed successfully!", Toast.LENGTH_SHORT).show();

            // Redirect to LoginActivity (assuming you have one)
            Intent intent = new Intent(OrderSummaryActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Close the order summary activity
        });
    }
}
