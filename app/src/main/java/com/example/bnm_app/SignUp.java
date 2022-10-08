package com.example.bnm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    Button mNext;
    TextInputLayout mUserName,mContectNo,mEmail,mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Sign UP
        mNext = (Button) findViewById(R.id.signUpNextBtn);
        mUserName = findViewById(R.id.signupUnameTxt);
        mEmail = findViewById(R.id.signUpEmailTxt);
        mPassword = findViewById(R.id.signUpPasswordTxt);
        mContectNo = findViewById(R.id.signUpPhoneTxt);


        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignUp.this,SignUpNext.class);
                intent.putExtra("UserName", mUserName.getEditText().getText().toString());
                intent.putExtra("Contactno", mContectNo.getEditText().getText().toString());
                intent.putExtra("Email", mEmail.getEditText().getText().toString());
                intent.putExtra("P", mPassword.getEditText().getText().toString());
                startActivity(intent);
            }
        });
    }

    public void Go_to_SignIn(View view) {
        Intent intent = new Intent(getApplicationContext(), SignIn.class);
        startActivity(intent);
        finish();
    }
}