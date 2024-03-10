package com.example.fragmentapp.fragments;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmentapp.R;
import com.example.fragmentapp.activities.MainActivity;

import java.util.ArrayList;

public class FragmentOne extends Fragment {

    private ArrayList<String> userName;
    private ArrayList<String> userPass;

    public FragmentOne() {
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
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        EditText editTextUsername = view.findViewById(R.id.editTextUsername);
        EditText editTextPassword = view.findViewById(R.id.editTextPassword);

        Button button = view.findViewById(R.id.buttonLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (userName.contains(username) && userPass.contains(password)) {
                    // Username and password match, store the username and navigate to next fragment
                    storeUsername(username);
                    Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentTwo);
                } else {
                    // Username or password is incorrect, display a message
                    Toast.makeText(getContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button2 = view.findViewById(R.id.buttonNewUser);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentThree);
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
