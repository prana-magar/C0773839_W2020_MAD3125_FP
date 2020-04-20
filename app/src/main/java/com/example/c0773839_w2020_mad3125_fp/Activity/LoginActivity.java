package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c0773839_w2020_mad3125_fp.Model.Bill.InternetBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.R;
import com.example.c0773839_w2020_mad3125_fp.Util.ObjectManager;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.example.c0773839_w2020_mad3125_fp.Util.PasswordUtil;

public class LoginActivity extends AppCompatActivity {

    private String  PREFS_NAME = "REMEMBER_ME_PREF";
    TextInputEditText emailEditText,passwordEditText;
    SwitchMaterial rememberMeSwitch;
    Button loginBtn;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ObjectManager.getInstance().loadObjects();


        emailEditText = findViewById(R.id.EmailEditText);
        passwordEditText = findViewById(R.id.PasswordEditText);
        rememberMeSwitch = findViewById(R.id.remember_switch);
        loginBtn = findViewById(R.id.loginButton);

        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String email = pref.getString("email", "");
        String password = pref.getString("password", "");
        emailEditText.setText(email);
        passwordEditText.setText(password);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr = emailEditText.getText().toString();
                if(emailStr.equals("")){
                    emailEditText.setError("Email cant be empty");
                    return;
                }

                String passwordStr =passwordEditText.getText().toString();
                if(passwordStr.equals("")){
                    passwordEditText.setError("Email cant be empty");
                    return;
                }

                Customer[] customers = ObjectManager.getInstance().getCustomers();
                for(Customer customer: customers){
                    if(customer.getContact().getEmailId().equals(emailStr)){
                        if(PasswordUtil.validatePassword(passwordStr,
                                customer.getPassword(),
                                customer.getSalt())){

                            if(rememberMeSwitch.isActivated()){
                                getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                                        .edit()
                                        .putString("email", emailStr)
                                        .putString("password", passwordStr)
                                        .commit();
                            }
                            else{
                                getSharedPreferences("REMEMBER_ME_PREF",MODE_PRIVATE)
                                        .edit()
                                        .putString("email", "")
                                        .putString("password", "")
                                        .commit();
                            }
                            Intent intent = new Intent(LoginActivity.this,CustomerLister.class);
                            startActivity(intent);
                        }
                    }
                }

                Toast.makeText(LoginActivity.this,
                        "Username or Password didn't match",
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
