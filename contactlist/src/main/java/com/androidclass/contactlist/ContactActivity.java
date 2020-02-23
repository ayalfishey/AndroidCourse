package com.androidclass.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Contact contact = new Contact(
        getIntent().getStringExtra("name"),
        getIntent().getStringExtra("address"),
        getIntent().getStringExtra("phone"),
        getIntent().getStringExtra("email"),
        getIntent().getStringExtra("age"));

        for (int i = 1; i < 6; i++) {
            TextView txt = findViewById(getResources().getIdentifier("textView" + i,"id",getPackageName()));
            txt.setText(contact.getInfo(i-1));
        }
    }
}
