package com.example.wmbeautystudio.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wmbeautystudio.Login.ClientLogin;
import com.example.wmbeautystudio.R;
import com.example.wmbeautystudio.UserHelperClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientSignUp extends AppCompatActivity {
    //Variables
    TextInputLayout regUserName, regEmail, regPhoneNo, regPassword;
    Button regBtn;
    TextView callLogin;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_sign_up);
        callLogin = findViewById(R.id.txt_log_in);

        //Call Client Login
        callLogin.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick (android.view.View v){
                startActivity(new Intent(getApplicationContext(), ClientLogin.class));
            }
        });


        //Hooks to all xml element in activity_client_sign_up.xml
        regUserName = findViewById(R.id.til_client_user_name);
        regEmail = findViewById(R.id.til_client_user_email);
        regPhoneNo = findViewById(R.id.til_client_user_phoneNo);
        regPassword = findViewById(R.id.til_client_user_password);
        regBtn = findViewById(R.id.btn_client_user_registration);

        //Save data in FireBase on button click
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

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