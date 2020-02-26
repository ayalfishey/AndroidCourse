package com.androidclass.contactlist;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Person> people = getPeople();

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_contact_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.name.setText("Age = " + people.get(position).getAge());
        holder.adress.setText("Gender = " + people.get(position).getGender());
        if (people.get(position).getGender() == 'M') {
            if (!(people.get(position).getAge() < 65))
                holder.img.setBackgroundColor(Color.RED);
            else
                holder.img.setBackgroundColor(Color.BLUE);
        }else{
            if (!(people.get(position).getAge() < 67))
                holder.img.setBackgroundColor(Color.GREEN);
            else
                holder.img.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
    public ArrayList<Person> getPeople(){
        Random random = new Random();
        ArrayList<Person> arrayList = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            arrayList.add(new Person ("First " + i, "Last "+ i, random.nextInt(101)-1 ));
                arrayList.get(i).setGender(i%3 ==0);
        }
        return arrayList;
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
