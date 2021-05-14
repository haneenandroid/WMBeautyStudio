package com.example.wmbeautystudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ContactUs2 extends AppCompatActivity {
    TextInputLayout _txtSubject, _txtMessage;
    Button _btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us2);

        _txtSubject = findViewById(R.id.til_subject);
        _txtMessage = findViewById(R.id.til_message);
        _btnSend = findViewById(R.id.btn_send);

        _btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = _txtSubject.getEditText().getText().toString().trim();
                String message = _txtMessage.getEditText().getText().toString().trim();
                String email = "mw.beautystudioa.pp@gmail.com";

                if(subject.isEmpty()){
                    Toast.makeText(ContactUs2.this, "Please add Subject", Toast.LENGTH_SHORT).show();
                }else if(message.isEmpty()){
                    Toast.makeText(ContactUs2.this, "Please add some Message", Toast.LENGTH_SHORT).show();
                }else{
                    String mail = "mailto:" + email +
                            "?&subject=" + Uri.encode(subject) +
                            "&body=" + Uri.encode(message);

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse(mail));

                    try{
                        startActivity(Intent.createChooser(intent, "Send Email.."));
                    }
                    catch (Exception e){
                        Toast.makeText(ContactUs2.this, "Exception: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}