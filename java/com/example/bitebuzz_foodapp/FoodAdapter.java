package com.example.bitebuzz_foodapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ItemFoodActivity> foodItems; // Use ArrayList of ItemFoodActivity
    private LayoutInflater inflater;

    public FoodAdapter(Context context, ArrayList<ItemFoodActivity> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return foodItems.size(); // Return the number of food items
    }

    @Override
    public Object getItem(int position) {
        return foodItems.get(position); // Return the food item at the given position
    }

    @Override
    public long getItemId(int position) {
        return position; // Return the position as ID
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_item_food, parent, false); // Inflate the item_food layout
        }

        // Find the views
        ImageView foodImage = convertView.findViewById(R.id.food_image);
        TextView foodName = convertView.findViewById(R.id.food_name);
        TextView foodPrice = convertView.findViewById(R.id.food_price);

        // Get the current food item
        ItemFoodActivity currentItem = foodItems.get(position);

        // Set the image, name, and price from the currentItem
        foodImage.setImageResource(currentItem.getImageResource());
        foodName.setText(currentItem.getFoodName());
        foodPrice.setText("$" + currentItem.getPrice()); // Assuming price is stored as an integer

        return convertView; // Return the completed view to render on screen
    }
}
