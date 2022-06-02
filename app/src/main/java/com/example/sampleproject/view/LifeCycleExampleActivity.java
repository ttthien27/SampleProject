package com.example.sampleproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sampleproject.R;

public class LifeCycleExampleActivity extends AppCompatActivity {

    private Button btnDialog;
    private Dialog dialog;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_example);
        Log.d("LifeCycleExample", " -------- onCreate -------- ");

        btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buttonShowClicked();
                FragmentManager fm = getSupportFragmentManager();
                CustomDialog userInfoDialog = new CustomDialog();
                userInfoDialog.show(fm, null);

            }
        });
    }

    /*private void buttonOpenDialogClicked()  {
        final CustomDialog dialog = new CustomDialog(this);
        dialog.show();
    }*/



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