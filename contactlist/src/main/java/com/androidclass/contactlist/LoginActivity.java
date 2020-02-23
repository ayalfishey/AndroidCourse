package com.androidclass.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("loginDetails",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                EditText editText = findViewById(R.id.userName);
                editor.putString("userName" , editText.getText().toString());
                editText = findViewById(R.id.password);
                editor.putString("password",editText.getText().toString());
                Intent intent = new Intent(getBaseContext(),ContactListActivity.class);
                boolean commit = editor.commit();
                if (commit) {
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"failed pref",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
