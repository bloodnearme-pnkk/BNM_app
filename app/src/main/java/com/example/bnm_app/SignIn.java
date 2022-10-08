package com.example.bnm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        TextInputLayout email = findViewById(R.id.signinEmail);
        TextInputLayout pass = findViewById(R.id.signinPassword);
        Button SignIn = (Button) findViewById(R.id.SignIn);
        Button SignInUp = (Button) findViewById(R.id.signInUp);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SignINemail = email.getEditText().getText().toString();
                String SignINpass = pass.getEditText().getText().toString();

                if(!SignINemail.isEmpty()){
                    if(!SignINpass.isEmpty()){

                    }
                    else {
                        pass.setError("Please Enter Email");
                    }
                }
                else {
                    email.setError("Please Enter Email");
                }
                Intent intent = new Intent(SignIn.this,DashBoard.class);
                startActivity(intent);
            }
        });

        SignInUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });
    }
}