package com.example.sampleproject.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;


import com.example.sampleproject.R;
import com.example.sampleproject.databinding.ActivityMainBinding;
import com.example.sampleproject.viewmodel.LoginViewModel;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @BindingAdapter({"toastMessage_2"})
    public static void runMe_2(View view, String message) {
        if (message != null)
            if(message.equals("Login was successful")){
                //Toast.makeText(view.getContext(), message.toUpperCase(Locale.ROOT), Toast.LENGTH_SHORT).show();
                view.getContext().startActivity(new Intent(view.getContext(), LifeCycleExampleActivity.class));
            }
        else{
                Toast.makeText(view.getContext(), message.toUpperCase(Locale.ROOT), Toast.LENGTH_SHORT).show();
            }

    }
}