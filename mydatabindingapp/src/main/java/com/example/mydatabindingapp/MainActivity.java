package com.example.mydatabindingapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mydatabindingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // or
        // ActivityMainBinding binding1 = ActivityMainBinding.inflate(this.getLayoutInflater());

        User user = new User("Eido", "Askayo");
        binding.setUser(user);
    }
}
