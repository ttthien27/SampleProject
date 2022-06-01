package com.example.sampleproject.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sampleproject.R;

public class CustomDialog extends Dialog {

    public Context context;
    private Button buttonOK;
    private Button buttonCancel;

    //private CustomDialog.FullNameListener listener;

    public CustomDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_custom_dialog);

        this.buttonOK = (Button) findViewById(R.id.button_ok);
        this.buttonCancel  = (Button) findViewById(R.id.button_cancel);

        this.buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buttonOKClick();
            }
        });
        this.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCancelClick();
            }
        });
    }

    // User click "Cancel" button.
    private void buttonCancelClick()  {
        this.dismiss();
    }
}
