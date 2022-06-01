package com.example.sampleproject.viewmodel;

import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.sampleproject.model.NewService;
import com.example.sampleproject.view.LifeCycleExampleActivity;

public class ServiceViewModel extends BaseObservable {

    private NewService newService;

    @Bindable
    public NewService getNewService() {
        return newService;
    }

    @Bindable
    public void setNewService(NewService newService) {
        this.newService = newService;
    }

    public ServiceViewModel() {
        this.newService = new NewService();
    }

    public void onStartClicked(View view) {
        view.getContext().startService(new Intent(view.getContext(), NewService.class));
    }

    public void onStopClicked(View view) {
        view.getContext().stopService(new Intent(view.getContext(), NewService.class));
    }
}
