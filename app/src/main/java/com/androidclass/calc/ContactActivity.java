package com.androidclass.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    TextView name, address, number;
    Switch showSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        showSwitch = findViewById(R.id.switch1);
        name = findViewById(R.id.textView8);
        address = findViewById(R.id.textView4);
        number = findViewById(R.id.textView5);

        showSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    name.setVisibility(View.VISIBLE);
                    address.setVisibility(View.VISIBLE);
                    number.setVisibility(View.VISIBLE);
                } else {
                    name.setVisibility(View.INVISIBLE);
                    address.setVisibility(View.INVISIBLE);
                    number.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
