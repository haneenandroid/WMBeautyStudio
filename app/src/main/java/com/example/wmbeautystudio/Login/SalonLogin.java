package com.example.wmbeautystudio.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wmbeautystudio.LoginHelperClass;
import com.example.wmbeautystudio.Profile.ClientProfile;
import com.example.wmbeautystudio.R;
import com.example.wmbeautystudio.SignUp.ClientSignUp;
import com.example.wmbeautystudio.SignUp.SalonSignUp;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SalonLogin extends AppCompatActivity {
    TextInputLayout logUserName, logPassword;
    TextView callSignUp;
    private DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_login);

        logUserName = findViewById(R.id.til_salon_name);
        logPassword = findViewById(R.id.til_salon_password);

        callSignUp = findViewById(R.id.txt_create_account);

        //Call Client Login
        callSignUp.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick (android.view.View v){
                startActivity(new Intent(getApplicationContext(), SalonSignUp.class));
            }
        });

        ref = FirebaseDatabase.getInstance().getReference().child("users");

    }
    String Password;

    public void btnLogin_Click(View view) {

        String userName = logUserName.getEditText().toString();
        Password = logPassword.getEditText().toString();

         if (ref.child(userName) != null) {
             ref.child(userName).addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {
                     LoginHelperClass student = snapshot.getValue(LoginHelperClass.class);
                     if (Password.equals(student.getPassword())) {
                         Toast.makeText(SalonLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                         Intent start = new Intent(SalonLogin.this, ClientProfile.class);
                         startActivity(start);
                     } else {
                         Toast.makeText(SalonLogin.this, "Enter Correct Password", Toast.LENGTH_SHORT).show();
                     }
                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                 }
             });
         } else {
             Toast.makeText(SalonLogin.this, "User Doesn't Exist", Toast.LENGTH_LONG).show();
         }
    }
}