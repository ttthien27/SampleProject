package com.example.sampleproject.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sampleproject.R;

public class ComponentExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnService, btnBroadcast, btnFragment, btnContenProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_example);
        btnService = findViewById(R.id.btn_Component_Service);
        btnBroadcast = findViewById(R.id.btn_Component_Broadcast);
        btnFragment = findViewById(R.id.btn_Component_Fragment);
        btnContenProvider = findViewById(R.id.btn_Component_ContentProvider);

        btnService.setOnClickListener(this);
        btnBroadcast.setOnClickListener(this);
        btnFragment.setOnClickListener(this);
        btnContenProvider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_Component_Service:
                intent = new Intent(ComponentExampleActivity.this, ServiceExampleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Component_Broadcast:
                intent = new Intent(ComponentExampleActivity.this, BroadcastExampleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Component_Fragment:
                intent = new Intent(ComponentExampleActivity.this, FragmentExampleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Component_ContentProvider:
                intent = new Intent(ComponentExampleActivity.this, ContentProviderActivity.class);
                startActivity(intent);
                break;
        }
    }
}