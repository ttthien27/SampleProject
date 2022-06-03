package com.example.sampleproject.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleproject.R;
import com.example.sampleproject.model.Document;

import java.util.List;
import java.util.Locale;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {

    private List<Document> documentList;

    public DocumentAdapter(List<Document> documentList) {
        this.documentList = documentList;
    }

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_document, parent, false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {
        Document document = documentList.get(position);
        if (document == null)
            return;

        Log.d("-----------------------", String.valueOf(position));

        String title = document.getDocTitle();
        String des = document.getDocDescription().toUpperCase(Locale.ROOT);

        /*String desChange = "";
        if (des.length() > 78) {
            desChange = des.substring(0, 78) + "...";
            Log.d("Test ... ", "onBindViewHolder: " + desChange);
        } else {
            desChange = des;
        }*/

        holder.tv_Title.setText(title);
        holder.tv_Des.setText(des);

    }

    @Override
    public int getItemCount() {
        if (documentList != null) {
            return documentList.size();
        }
        return 0;
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_Title;
        private TextView tv_Des;

        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Title = itemView.findViewById(R.id.item_title);
            tv_Des = itemView.findViewById(R.id.item_des);
            //tv_Num = itemView.findViewById(R.id.tv_num);
        }

    }
}