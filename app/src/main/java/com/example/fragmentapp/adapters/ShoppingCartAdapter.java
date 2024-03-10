package com.example.fragmentapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fragmentapp.model.ShoppingCartItem;


import com.example.fragmentapp.R;

import java.util.ArrayList;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    private ArrayList<ShoppingCartItem> items;

    public ShoppingCartAdapter(ArrayList<ShoppingCartItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopping_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShoppingCartItem item = items.get(position);
        holder.textViewItemName.setText(item.getItemName());
        holder.imageViewItemImage.setImageResource(item.getImageResource());
        holder.textViewQuantity.setText(String.valueOf(item.getQuantity()));

        holder.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = item.getQuantity();
                if (quantity > 0) {
                    quantity--;
                    item.setQuantity(quantity);
                    holder.textViewQuantity.setText(String.valueOf(quantity));
                }
            }
        });

        holder.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = item.getQuantity();
                quantity++;
                item.setQuantity(quantity);
                holder.textViewQuantity.setText(String.valueOf(quantity));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItemName;
        ImageView imageViewItemImage;
        TextView textViewQuantity;
        Button buttonMinus;
        Button buttonPlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewItemName = itemView.findViewById(R.id.textViewItemName);
            imageViewItemImage = itemView.findViewById(R.id.imageViewItemImage);
            textViewQuantity = itemView.findViewById(R.id.textViewQuantity);
            buttonMinus = itemView.findViewById(R.id.buttonMinus);
            buttonPlus = itemView.findViewById(R.id.buttonPlus);
        }
    }
}
