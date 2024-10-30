package com.example.bitebuzz_foodapp;
public class ItemFoodActivity {
    private String foodName;
    private int price;
    private int imageResource;

    public ItemFoodActivity(String foodName, int price, int imageResource) {
        this.foodName = foodName;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }
}
