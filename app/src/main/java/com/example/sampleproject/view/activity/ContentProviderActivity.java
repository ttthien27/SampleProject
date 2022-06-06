package com.example.sampleproject.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListView;

import com.example.sampleproject.R;
import com.example.sampleproject.adapter.ContactAdapter;
import com.example.sampleproject.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContentProviderActivity extends AppCompatActivity {

    public static final int REQUEST_READ_CONTACTS = 78;
    ListView list;
    List<Contact> mobileArray;
    ArrayList numberArray;
    RecyclerView recyclerViewContact;
    ContactAdapter contactAdapter;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        recyclerViewContact = findViewById(R.id.recycleView_content);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ContentProviderActivity.this);
        recyclerViewContact.setLayoutManager(linearLayoutManager);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            mobileArray = getAllContacts();

            contactAdapter = new ContactAdapter(mobileArray);
            recyclerViewContact.setAdapter(contactAdapter);


        } else {
            requestPermission();
        }

    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_CONTACTS)) {
            showMessageOKCancel("You need to allow access to Contacts",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(ContentProviderActivity.this, new String[]{android.Manifest.permission.READ_CONTACTS},
                                    REQUEST_READ_CONTACTS);
                        }
                    });
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS},
                REQUEST_READ_CONTACTS);
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ContentProviderActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @SuppressLint("Range")
    private List getAllContacts() {

        List<Contact> contactList = new ArrayList<>();
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

        if (cur != null) {
            if (cur.getCount() > 0) {
                while (cur != null && cur.moveToNext()) {
                    String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    //nameList.add(name);

                    int countPhoneN = cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                    if (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                        ArrayList<String> numberPhoneList = new ArrayList<>();
                        Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                        while (pCur.moveToNext()) {
                            String phoneNo = pCur.getString(pCur.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER));
                            if (phoneNo != null)
                                numberPhoneList.add(phoneNo);

                        }
                        String numPhones = "";
                        for (String s : numberPhoneList) {
                            numPhones = numPhones + " " + s;
                        }
                        //contactList.add(new Contact(name,numPhones));
                        Log.d("ContentProvider", "Phone: " + name + " " + numPhones);
                        contactList.add(new Contact(name, numPhones));
                        pCur.close();
                    }
                }
            }
            if (cur != null) {
                cur.close();
            }
        }
        return contactList;
    }

}