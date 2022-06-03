package com.example.sampleproject.view.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sampleproject.R;
import com.example.sampleproject.service.NewService;

public class ServiceExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        start = (Button) findViewById(R.id.btn_Service_Start);
        stop = (Button) findViewById(R.id.btn_Service_Stop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Service_Start:
                Toast.makeText(ServiceExampleActivity.this, "Start Service", Toast.LENGTH_SHORT).show();
                startService(new Intent(this, NewService.class));
                break;
            case R.id.btn_Service_Stop:
                stopService(new Intent(this, NewService.class));
                break;
        }
    }
}