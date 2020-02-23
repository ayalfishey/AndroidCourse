package com.androidclass.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    double no1, no2, temp;
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.textView2);
        no1 = 0;
        no2 = 0;
        temp = 0;

        HashMap<Character, Button> buttons = new HashMap<>();

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof Button) {
                    Button b = (Button) v;
                    String txt = b.getText().toString();
                    temp = (Double.parseDouble(txt) / 10 + temp) * 10;
                    screen.setText(String.valueOf(temp));
                }
            }
        };

        View.OnClickListener actionListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v instanceof Button){
                    Button b = (Button) v;
                    no2 = no1;
                    no1 = temp;
                    switch (b.getText().toString()){
                        case "+":
                            temp = no1+no2;
                            break;
                        case "-":
                            temp = no2-no1;
                            break;
                        case "/":
                            temp = no2/no1;
                            break;
                        case "x":
                            temp = no2*no1;
                            break;
                        case "c":
                            no1=0;
                            no2=0;
                            temp=0;
                            break;
                        case "b" :
                            int del = (int) temp/10;
                            temp = del;
                            break;
                        case "=":
                            no1 = temp;
                            no2 = 0;
                            screen.setText(String.valueOf(no1));
                            break;

                    }
                    screen.setText(String.valueOf(temp));
                 }
            }
        };

        for (int i = 0; i < 20; i++) {
            int id = getResources().getIdentifier("button" + i, "id", getPackageName());
            Button button = findViewById(id);
            if (i < 10) {
                button.setOnClickListener(numberListener);
            } else {
                button.setOnClickListener(actionListener);
            }
            
            buttons.put(button.getText().toString().charAt(0), button);
        }


    }
}
