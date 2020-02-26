package com.androidclass.contactlist;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_contact_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.name.setText(position + "");
        if(position%2==0)
            holder.img.setBackgroundColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return 50;
    }
}

class ContactViewHolder extends RecyclerView.ViewHolder{
    ImageView img;
    TextView name, adress, phone;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        name = itemView.findViewById(R.id.name);
        adress = itemView.findViewById(R.id.address);
        phone = itemView.findViewById(R.id.phone);
    }
}
