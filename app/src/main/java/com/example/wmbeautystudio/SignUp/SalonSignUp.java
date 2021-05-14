package com.example.wmbeautystudio.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wmbeautystudio.Login.ClientLogin;
import com.example.wmbeautystudio.Login.SalonLogin;
import com.example.wmbeautystudio.R;
import com.example.wmbeautystudio.UserHelperClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SalonSignUp extends AppCompatActivity {

    //Variables
    TextInputLayout regUserName, regEmail, regPhoneNo, regPassword;
    Button regBtn;
    TextView callLogin;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_sign_up);

        callLogin = findViewById(R.id.txt_log_in);

        //Call Salon Login
        callLogin.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick (android.view.View v){
                startActivity(new Intent(getApplicationContext(), SalonLogin.class));
            }
        });

        //Hooks to all xml element in activity_salon_sign_up.xml
        regUserName = findViewById(R.id.til_salon_name);
        regEmail = findViewById(R.id.til_salon_email);
        regPhoneNo = findViewById(R.id.til_salon_phoneNo);
        regPassword = findViewById(R.id.til_salon_password);
        regBtn = findViewById(R.id.btn_salon_registration);


        //Save data in FireBase on button click
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("salon");

                //Get all the values
                String username = regUserName.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phoneNo = regPhoneNo.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(username, email, phoneNo, password);

                reference.child(username).setValue(helperClass);
            }
        });
    }
}