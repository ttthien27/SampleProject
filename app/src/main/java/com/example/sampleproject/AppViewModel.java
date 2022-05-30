package com.example.sampleproject;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.Locale;

public class AppViewModel extends BaseObservable{
    private Model model;

    private String strToLowerCase = model.fullName.toLowerCase(Locale.ROOT);
    private String strUpperCase = model.fullName.toUpperCase(Locale.ROOT);

    private  String changeName;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getChangeName() {
        return changeName;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
    }



    public AppViewModel() {

        // instantiating object of
        // model class
        model = new Model("");
    }

    public void onChangeClicked(Boolean isChangeToLower) {
        if (isChangeToLower)
            setChangeName(strToLowerCase);
        else
            setChangeName(strUpperCase);
    }
}
