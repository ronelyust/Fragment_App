package com.example.fragmentapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentapp.adapters.ShoppingCartAdapter;
import com.example.fragmentapp.model.ShoppingCartItem;
import com.example.fragmentapp.R;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {

    private RecyclerView recyclerView;
    private ShoppingCartAdapter adapter;

    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewShoppingCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get initial items from data model
        ArrayList<ShoppingCartItem> items = ShoppingCartItem.getInitialItems();

        // Set up the adapter with the initial items
        adapter = new ShoppingCartAdapter(items);
        recyclerView.setAdapter(adapter);

        // Set greeting text
        TextView textViewGreeting = view.findViewById(R.id.textViewGreeting);
        textViewGreeting.setText(getGreetingMessage());

        return view;
    }

    // Method to retrieve the username from SharedPreferences
    private String getUsername() {
        SharedPreferences preferences = getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        return preferences.getString("username", "");
    }

    // Method to construct the greeting message
    private String getGreetingMessage() {
        String username = getUsername();
        return "Hello " + username;
    }
}
