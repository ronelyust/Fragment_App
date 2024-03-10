package com.example.fragmentapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.fragmentapp.R;
import com.example.fragmentapp.activities.MainActivity;

import java.util.ArrayList;

public class FragmentThree extends Fragment {

    private ArrayList<String> userName;
    private ArrayList<String> userPass;

    public FragmentThree() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            userName = mainActivity.getUserName();
            userPass = mainActivity.getUserPass();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        EditText editTextUsername = view.findViewById(R.id.editTextUsername);
        EditText editTextPassword = view.findViewById(R.id.editTextPassword);
        EditText editTextPhone = view.findViewById(R.id.editTextPhone);

        Button buttonRegister = view.findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String phone = editTextPhone.getText().toString();

                if (userName.contains(username)) {
                    // Username already exists, display a message
                    Toast.makeText(getContext(), "Username already exists", Toast.LENGTH_SHORT).show();
                } else {
                    // Add the new username, password, and phone number to the arrays in MainActivity
                    userName.add(username);
                    userPass.add(password);
                    // Store the username in SharedPreferences
                    storeUsername(username);
                    // Here you can store the phone number in a database or SharedPreferences
                    // For demonstration, I'll just display a toast message with the phone number
                    Toast.makeText(getContext(), "User registered successfully\nPhone: " + phone, Toast.LENGTH_SHORT).show();
                    // Navigate to next fragment
                    Navigation.findNavController(view).navigate(R.id.action_fragmentThree_to_fragmentTwo);
                }
            }
        });

        return view;
    }

    // Method to store the username in SharedPreferences
    private void storeUsername(String username) {
        SharedPreferences preferences = getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.apply();
    }
}
