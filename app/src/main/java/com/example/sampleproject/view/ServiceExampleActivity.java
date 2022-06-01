package com.example.sampleproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;



import android.os.Bundle;
import android.widget.Button;

import com.example.sampleproject.R;
import com.example.sampleproject.databinding.ActivityMainBinding;
import com.example.sampleproject.databinding.ActivityServiceBinding;
import com.example.sampleproject.databinding.ActivityServiceBinding;
import com.example.sampleproject.viewmodel.ServiceViewModel;

public class ServiceExampleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


    }


}