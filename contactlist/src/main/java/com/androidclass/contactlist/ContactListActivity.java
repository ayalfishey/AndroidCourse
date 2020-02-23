package com.androidclass.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ContactListActivity extends AppCompatActivity {
    final int[] idPrefexs = {R.id.name,R.id.address,R.id.phone};
    final String[] dataPrefex = {"name","address","phone","email","age"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        LinearLayout linearLayout = findViewById(R.id.container);
        View view = LayoutInflater.from(this).inflate(R.layout.contact_header_layout, null);
        TextView userName  = view.findViewById(R.id.userName);
        userName.setText(getSharedPreferences("loginDetails",MODE_PRIVATE).getString("userName","Guest"));
        Button logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("loginDetails",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("userName");
                editor.remove("password");
                editor.apply();
                Intent intent = new Intent(getBaseContext(),SplashActivity.class);
                startActivity(intent);
                finish();
            }
        });
        linearLayout.addView(view);
        final ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Jeff", "233B st", "024445163", "jeff@bezos.com", "51"));
        contacts.add(new Contact("Tanya", "567H st", "027548596", "tanya@bezos.com", "32"));
        contacts.add(new Contact("Marni", "231R st", "024445163", "marni@bezos.com", "24"));
        contacts.add(new Contact("Hadar", "235Y st", "024445163", "hadar@bezos.com", "30"));
        contacts.add(new Contact("Ora", "129V st", "024445163", "ora@bezos.com", "28"));
        contacts.add(new Contact("Michel", "634F st", "024445163", "michel@bezos.com", "18"));
        contacts.add(new Contact("Nava", "638D st", "024445163", "nava@bezos.com", "68"));
        contacts.add(new Contact("Ari", "990N st", "024445163", "ari@bezos.com", "11"));
        inflateLayout(contacts);

    }

    private void inflateLayout(final ArrayList<Contact> contactList) {
        LinearLayout linearLayout = findViewById(R.id.container);
        for (int i = 1; i < contactList.size(); i++) {
            final int contactPos = i-1;
            View view = LayoutInflater.from(this).inflate(R.layout.single_contact_layout, null);
            for (int j = 0; j < 3 ; j++) {
                TextView txt = view.findViewById(idPrefexs[j]);
                txt.setText(contactList.get(i-1).getInfo(j));
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(),ContactActivity.class);
                    for (int j = 0; j < 5; j++) {
                        intent.putExtra(dataPrefex[j],contactList.get(contactPos).getInfo(j));
                    }
                    startActivity(intent);
                }
            });
            linearLayout.addView(view);
        }

    }
}




