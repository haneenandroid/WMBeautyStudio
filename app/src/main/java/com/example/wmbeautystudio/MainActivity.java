package com.example.wmbeautystudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wmbeautystudio.Login.ClientLogin;
import com.example.wmbeautystudio.Login.SalonLogin;
import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MaterialButton clientUser, salonUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientUser = findViewById(R.id.btn_client_login);
        clientUser.setOnClickListener(this);


        salonUser = findViewById(R.id.btn_salons_login);
        salonUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == clientUser) {
            Intent clientUser = new Intent(MainActivity.this, ClientLogin.class);
            startActivity(clientUser);
        } else if (view == salonUser) {
            Intent salonUser = new Intent(MainActivity.this, SalonLogin.class);
            startActivity(salonUser);
        }
    }

}