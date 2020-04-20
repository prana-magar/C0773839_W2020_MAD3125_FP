package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.c0773839_w2020_mad3125_fp.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText emailEditText,passwordEditText;
    SwitchMaterial rememberMeSwitch;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.EmailEditText);
        passwordEditText = findViewById(R.id.PasswordEditText);
        rememberMeSwitch = findViewById(R.id.remember_switch);
        loginBtn = findViewById(R.id.loginButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailEditText.getText().toString().equals("")){
                    emailEditText.setError("Email cant be empty");
                    return;
                }
                if(passwordEditText.getText().toString().equals("")){
                    passwordEditText.setError("Email cant be empty");
                    return;
                }
            }
        });

    }
}
