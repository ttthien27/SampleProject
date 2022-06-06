package com.example.sampleproject.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.sampleproject.R;
import com.example.sampleproject.databinding.ActivityMainBinding;
import com.example.sampleproject.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLife, btnComponent, btnNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();

        btnLife = findViewById(R.id.btn_Main_Lifecycle);
        btnComponent = findViewById(R.id.btn_Main_Component);
        btnNavigation = findViewById(R.id.btn_Main_Navigation);

        btnLife.setOnClickListener(this);
        btnComponent.setOnClickListener(this);
        btnNavigation.setOnClickListener(this);

    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_Main_Lifecycle:
                intent = new Intent(MainActivity.this, LifeCycleExampleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Main_Component:
                intent = new Intent(MainActivity.this, ComponentExampleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Main_Navigation:
                intent = new Intent(MainActivity.this, NavigationExampleActivity.class);
                startActivity(intent);
                break;

        }
    }
}
