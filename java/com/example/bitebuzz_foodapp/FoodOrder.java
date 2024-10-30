package com.example.bitebuzz_foodapp;

public class FoodOrder {
    private String foodName;
    private int count;

    public FoodOrder(String foodName, int count) {
        this.foodName = foodName;
        this.count = count;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCount() {
        return count;
    }
}
