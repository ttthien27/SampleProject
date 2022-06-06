package com.example.sampleproject.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.sampleproject.R;
import com.example.sampleproject.view.fragment.FragmentFirstFragment;
import com.example.sampleproject.view.fragment.FragmentSecondFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationExampleActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_example);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_first:
                        navController.navigate(R.id.fragmentFirstFragment);
                        return true;
                    case R.id.navigation_second:
                        navController.navigate(R.id.fragmentSecondFragment);
                        return true;
                    case R.id.navigation_third:
                        navController.navigate(R.id.fragmentHomeFragment3);
                        return true;
                }
                return false;
            }
        });
    }

}