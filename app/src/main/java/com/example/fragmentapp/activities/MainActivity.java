package com.example.fragmentapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentapp.R;

import java.util.ArrayList; // Import ArrayList

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> userName = new ArrayList<>(); // Initialize ArrayList for usernames
    private ArrayList<String> userPass = new ArrayList<>(); // Initialize ArrayList for passwords

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add sample usernames and passwords to the arrays
        userName.add("Ronel");
        userPass.add("Yust");
        userName.add("Nitzan");
        userPass.add("Azbel");
        // Add more usernames and passwords as needed
    }

    // Getter method for userName array
    public ArrayList<String> getUserName() {
        return userName;
    }

    // Getter method for userPass array
    public ArrayList<String> getUserPass() {
        return userPass;
    }
}
