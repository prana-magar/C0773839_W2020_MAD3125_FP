package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.c0773839_w2020_mad3125_fp.Model.Bill.BillType;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.HydroBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.InternetBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.MobileBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.HydroProvider;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.InternetProvider;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.CellPhoneProvider;

import com.example.c0773839_w2020_mad3125_fp.R;
import com.example.c0773839_w2020_mad3125_fp.Util.ObjectManager;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class AddBill extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    String[] billType = new String[] {"Hydro","Internet","Mobile"};
    String[] InternetProvider = new String[] {"Bell","Rogers"};
    String[] MobileProvider = new String[] {"FIDO","Freedom","Public Mobile"};
    String[] HydroProvider = new String[] {"Just Energy","Bell Energy"};
    String[] currentProvider = InternetProvider;
    Customer customer;

    AutoCompleteTextView BillTypeAutoComplete,ProviderAutoComplete;
    TextInputEditText UnitUsedEditText,MinutesUsedEditText,BillDateEditText;
    TextInputLayout ProviderTextInput,UnitUsedTextInput,MinutesUsedTextInput,BillDateTextInput;
    Button CreateButton;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
//        ObjectManager.getInstance().loadObjects();

        ArrayAdapter<String> billTypeAdapter =
                new ArrayAdapter<String>(
                        AddBill.this,
                        R.layout.dropdown_menu_popup_item,
                        billType);
        BillTypeAutoComplete = findViewById(R.id.BillTypeAutoComplete);
        BillTypeAutoComplete.setAdapter(billTypeAdapter);

        ProviderTextInput = findViewById(R.id.ProviderTextInput);
        UnitUsedTextInput = findViewById(R.id.UnitUsedTextInput);
        MinutesUsedTextInput = findViewById(R.id.MinutesUsedTextInput);
        BillDateTextInput = findViewById(R.id.BillDateTextInput);


        UnitUsedEditText = findViewById(R.id.UnitUsedEditText);
        MinutesUsedEditText = findViewById(R.id.MinutesUsedEditText);
        ProviderAutoComplete = findViewById(R.id.ProviderAutoComplete);
        BillDateEditText = findViewById(R.id.BillDateEditText);
        CreateButton = findViewById(R.id.CreateButton);

        final Intent intent = getIntent();
        Customer customer = (Customer) intent.getSerializableExtra("customer");
        this.customer = ObjectManager.getInstance().getCustomer(customer.getId());
        System.out.println("customer= "+customer);
        final MaterialDatePicker datePicker = new MaterialDatePicker();

        BillDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddBill.this,
                        AddBill.this,
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });

        // default hidden
        ProviderTextInput.setAlpha(0);
        UnitUsedTextInput.setAlpha(0);
        MinutesUsedTextInput.setAlpha(0);
        BillDateTextInput.setAlpha(0);



        CreateButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {


                String dateStr = BillDateEditText.getText().toString();
                if(dateStr.equals("")){
                    BillDateTextInput.setError("Date cant be empty");
                    return;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate billDateLocalDate = LocalDate.parse(dateStr,formatter);

                String unitConsumedStr = UnitUsedEditText.getText().toString();
                if(unitConsumedStr.equals("")){
                    UnitUsedTextInput.setError("Unit cant be empty");
                    return;
                }
                double unitConsumed = Double.parseDouble(unitConsumedStr);

                String providerStr = ProviderAutoComplete.getText().toString();
                if(providerStr.equals("")){
                    ProviderTextInput.setError("Cant be empty");
                    return;
                }
                System.out.println("provider= "+providerStr);

                BillType billType;
                switch (BillTypeAutoComplete.getText().toString()){
                    case "Hydro":
                        HydroProvider hydroProvider = ObjectManager.getInstance().getHydroProvider(providerStr);
                        HydroBill hydroBill = new HydroBill(ObjectManager.getInstance().getRandomId(),
                                billDateLocalDate,hydroProvider,unitConsumed
                                );
                        AddBill.this.customer.addBill(hydroBill);
                        ObjectManager.getInstance().hydroBillHashMap.put(hydroBill.getId(),hydroBill);
                        break;


                    case "Internet":
                        InternetProvider internetProvider = ObjectManager.getInstance().getInternetProvider(providerStr);
                        InternetBill internetBill = new InternetBill(ObjectManager.getInstance().getRandomId(),
                                billDateLocalDate,internetProvider,unitConsumed);
                        AddBill.this.customer.addBill(internetBill);
                        ObjectManager.getInstance().internetBillHashMap.put(internetBill.getId(),internetBill);
                        break;


                    default:
                        String usedMinutesStr = MinutesUsedEditText.getText().toString();
                        if(usedMinutesStr.equals("")){
                            MinutesUsedTextInput.setError("Minutes cant be empty");
                            return;
                        }
                        double usedMinutes = Double.parseDouble(usedMinutesStr);
                        CellPhoneProvider cellPhoneProvider = ObjectManager.getInstance().getCellProvider(providerStr);
                        MobileBill mobileBill = new MobileBill(ObjectManager.getInstance().getRandomId(),
                                billDateLocalDate,cellPhoneProvider,unitConsumed,usedMinutes);
                        AddBill.this.customer.addBill(mobileBill);
                        ObjectManager.getInstance().mobileBillHashMap.put(mobileBill.getId(),mobileBill);
                        break;
                }

                Intent intent1 = new Intent(AddBill.this, CustomerDetail.class);
                intent1.putExtra("obj",AddBill.this.customer);
                startActivity(intent1);

            }
        });


        BillTypeAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ProviderTextInput.setAlpha(1);
                ProviderAutoComplete.setText("");
                UnitUsedTextInput.setAlpha(1);
                BillDateTextInput.setAlpha(1);
                MinutesUsedTextInput.setAlpha(0);


                switch (i){
                    case 0:
                        currentProvider = HydroProvider;
                        break;
                    case 1:
                        currentProvider = InternetProvider;
                        break;
                    default:
                        currentProvider = MobileProvider;
                        MinutesUsedTextInput.setAlpha(1);

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

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String monthStr = String.valueOf(month+1);
        if(month+1 < 10){
            monthStr = "0"+monthStr;
        }
        String dayStr = String.valueOf(dayOfMonth);
        if(dayOfMonth < 10){
            dayStr = "0"+dayStr;
        }
        String dateStr = year+"/"+monthStr+"/"+dayStr;
        BillDateEditText.setText(dateStr);
    }
}
