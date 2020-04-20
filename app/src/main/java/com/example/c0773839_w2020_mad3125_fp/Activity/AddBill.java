package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.c0773839_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddBill extends AppCompatActivity {
    String[] billType = new String[] {"Hydro","Internet","Mobile"};
    String[] InternetProvider = new String[] {"Bell","Rogers"};
    String[] MobileProvider = new String[] {"FIDO","Freedom","Public Mobile"};
    String[] HydroProvider = new String[] {"Just Energy","Bell Energy"};
    String[] currentProvider = InternetProvider;


    AutoCompleteTextView BillTypeAutoComplete,ProviderAutoComplete;
    TextInputEditText UnitUsedEditText,MinutesUsedEditText;
    Button CreateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        ArrayAdapter<String> billTypeAdapter =
                new ArrayAdapter<String>(
                        AddBill.this,
                        R.layout.dropdown_menu_popup_item,
                        billType);
        BillTypeAutoComplete = findViewById(R.id.BillTypeAutoComplete);
        BillTypeAutoComplete.setAdapter(billTypeAdapter);




        BillTypeAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        currentProvider = HydroProvider;
                        break;
                    case 1:
                        currentProvider = InternetProvider;
                        break;
                    default:
                        currentProvider = MobileProvider;
                }

                ArrayAdapter<String> providerAdapter =
                        new ArrayAdapter<String>(
                                AddBill.this,
                                R.layout.dropdown_menu_popup_item,
                                currentProvider);
                ProviderAutoComplete.setAdapter(providerAdapter);
            }
        });


        ArrayAdapter<String> providerAdapter =
                new ArrayAdapter<String>(
                        AddBill.this,
                        R.layout.dropdown_menu_popup_item,
                        currentProvider);
        ProviderAutoComplete = findViewById(R.id.ProviderAutoComplete);
        ProviderAutoComplete.setAdapter(providerAdapter);

    }
}
