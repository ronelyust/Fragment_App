package com.example.fragmentapp.model;

import com.example.fragmentapp.R;

import java.util.ArrayList;

public class ShoppingCartItem {
    private String itemName;
    private int imageResource;
    private int quantity;

    public ShoppingCartItem(String itemName, int imageResource, int quantity) {
        this.itemName = itemName;
        this.imageResource = imageResource;
        this.quantity = quantity;
    }

    // Getter method for itemName
    public String getItemName() {
        return itemName;
    }

    // Getter method for imageResource
    public int getImageResource() {
        return imageResource;
    }

    // Getter method for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter method for quantity (if needed)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Static method to provide initial items
    public static ArrayList<ShoppingCartItem> getInitialItems() {
        ArrayList<ShoppingCartItem> items = new ArrayList<>();
        items.add(new ShoppingCartItem("Bracelet", R.drawable.bracelet, 0));
        items.add(new ShoppingCartItem("Diamond", R.drawable.diamond, 0));
        items.add(new ShoppingCartItem("Emerald", R.drawable.emerald, 0));
        items.add(new ShoppingCartItem("Heart", R.drawable.heart, 0));
        items.add(new ShoppingCartItem("Necklace", R.drawable.necklace, 0));
        items.add(new ShoppingCartItem("Piercing", R.drawable.piercing, 0));
        items.add(new ShoppingCartItem("Ring", R.drawable.ring, 0));
        items.add(new ShoppingCartItem("Ruby", R.drawable.ruby, 0));
        items.add(new ShoppingCartItem("Silver Ring", R.drawable.silver, 0));
        items.add(new ShoppingCartItem("Topaz", R.drawable.topaz, 0));

        return items;
    }
}
