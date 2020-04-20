package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c0773839_w2020_mad3125_fp.Adapter.BillListAdapter;
import com.example.c0773839_w2020_mad3125_fp.R;
import com.example.c0773839_w2020_mad3125_fp.Util.PasswordUtil;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.example.c0773839_w2020_mad3125_fp.Util.Validation;

public class AddCustomer extends AppCompatActivity {


    TextInputEditText FirstNameEditText,LastNameEditText,GenderEditText,EmailEditText,PhoneEditText,DobEditText,PasswordEditText;
    TextInputLayout FirstNameTextInput,GenderTextInput,EmailTextInput,PhoneTextInput,DobTextInput,PasswordTextInput;

    Button CreateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        FirstNameEditText = findViewById(R.id.FirstNameEditText);
        LastNameEditText = findViewById(R.id.LastNameEditText);
        GenderEditText = findViewById(R.id.GenderEditText);
        EmailEditText = findViewById(R.id.EmailEditText);
        PhoneEditText = findViewById(R.id.PhoneEditText);
        DobEditText = findViewById(R.id.DobEditText);
        PasswordEditText = findViewById(R.id.PasswordEditText);
        CreateButton = findViewById(R.id.CreateButton);

        FirstNameTextInput = findViewById(R.id.FirstNameTextInput);
        GenderTextInput = findViewById(R.id.GenderTextInput);
        EmailTextInput = findViewById(R.id.EmailTextInput);
        PhoneTextInput = findViewById(R.id.PhoneTextInput);
        DobTextInput = findViewById(R.id.DobTextInput);
        PasswordTextInput = findViewById(R.id.PasswordTextInput);




        CreateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reset();

                        String firstNameStr = FirstNameEditText.getText().toString();
                        if(firstNameStr.equals("")){
                            FirstNameTextInput.setError("First Name cant be Empty");
                            return;
                        }

                        String genderStr = GenderEditText.getText().toString();
                        if(genderStr.equals("")){
                            GenderTextInput.setError("Gender cant be Empty");
                            return;
                        }

                        String emailStr = EmailEditText.getText().toString();
                        if(emailStr.equals("")){
                            EmailTextInput.setError("Email cant be Empty");
                            return;
                        }

                        if(!Validation.Email(emailStr)){
                            EmailTextInput.setError("Email not Valid");
                            return;
                        }




                        String phoneStr = PhoneEditText.getText().toString();
                        if(phoneStr.equals("")){
                            PhoneTextInput.setError("PhoneNo cant be Empty");
                            return;
                        }

                        String dobStr = DobEditText.getText().toString();
                        if(dobStr.equals("")){
                            DobTextInput.setError("Date of Birth cant be Empty");
                            return;
                        }

                        String passwordStr = PasswordEditText.getText().toString();
                        if(passwordStr.equals("")){
                            PasswordTextInput.setError("Password cant be Empty");
                            return;
                        }


                    }
                }
        );



    }

    void reset(){
        FirstNameTextInput.setError("");
        GenderTextInput.setError("");

        EmailTextInput.setError("");
        PhoneTextInput.setError("");
        DobTextInput.setError("");
        PasswordTextInput.setError("");
    }

}
