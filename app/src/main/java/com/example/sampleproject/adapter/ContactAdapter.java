package com.example.sampleproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleproject.R;
import com.example.sampleproject.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> contactList;

    public ContactAdapter(List<Contact> listContact) {
        this.contactList = listContact;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contact contact = contactList.get(position);
        if (contact == null)
            return;
        String name = contact.getName();
        String num = contact.getNumberPhone();

        holder.textName.setText("Name: " + name);
        holder.textNumber.setText("Number Phone: " + num);
    }

    @Override
    public int getItemCount() {
        if (contactList != null) {
            return contactList.size();
        }
        return 0;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView textName, textNumber;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.item_name);
            textNumber = itemView.findViewById(R.id.item_number);

        }
    }
}
