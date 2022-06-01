package com.example.sampleproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.example.sampleproject.R;

public class LifeCycleExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_example);
        Log.d("LifeCycleExample", " -------- onCreate -------- ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycleExample", " -------- onStart -------- ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycleExample", " -------- onRestart -------- ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycleExample", " -------- onResume -------- ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycleExample", " -------- onPause -------- ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycleExample", " -------- onStop -------- ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycleExample", " -------- onDestroy -------- ");
    }
}