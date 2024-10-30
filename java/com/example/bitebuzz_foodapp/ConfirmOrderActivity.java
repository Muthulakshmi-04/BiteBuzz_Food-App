package com.example.bitebuzz_foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmOrderActivity extends AppCompatActivity {

    private EditText etName, etPhone, etAddress;
    private Button btnViewOrderSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etAddress = findViewById(R.id.et_address);
        btnViewOrderSummary = findViewById(R.id.btn_view_order_summary);

        // Action for View Order Summary Button
        btnViewOrderSummary.setOnClickListener(v -> {
            String userName = etName.getText().toString();
            String userPhone = etPhone.getText().toString();
            String userAddress = etAddress.getText().toString();

            // Example order summary data
            String[] orderedItems = {"Burger", "Pizza"}; // Replace with actual items
            int[] orderedPrices = {50, 75}; // Replace with actual prices

            Intent intent = new Intent(ConfirmOrderActivity.this, OrderSummaryActivity.class);
            intent.putExtra("userName", userName);
            intent.putExtra("userPhone", userPhone);
            intent.putExtra("userAddress", userAddress);
            intent.putExtra("orderedItems", orderedItems);
            intent.putExtra("orderedPrices", orderedPrices);
            startActivity(intent);
        });
    }
}
