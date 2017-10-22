package edu.gatech.seclass.gobowl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class CustomerInfoPromptActivity extends AppCompatActivity {
    String ID;
    String Name;
    String Email;

    private List<Customer> customers;

    private Spinner spinner;
    //editText3 Customer ID
    //editText4 Customer Email

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info_prompt);

        /// get customer list from database ///

        spinner = (Spinner)findViewById(R.id.ddlCustomers);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        /// add customers using below syntax ///
        ManagerService mgr = ManagerService.getManagerService(getApplicationContext());
        customers = mgr.getCustomerList();
        Log.d("How many customers :", String.valueOf(customers.size()));
        for (Customer c : customers) {
            spinnerAdapter.add(c.getId() + ", " + c.getName() + ", " + c.getEmail());
        }

        spinnerAdapter.notifyDataSetChanged();
    }

    public void buttonCancel_onClick(View view){
        Screens.ShowManagerActivity(this);
    }

    public void buttonNext_onClick(View view){
        Intent sourceIntent = this.getIntent();
        String action = sourceIntent.getStringExtra("action");

        int SelectedID = (int)spinner.getSelectedItemId();
        Customer c = customers.get(SelectedID);

        Bundle extras = sourceIntent.getExtras();
        extras.putSerializable("customer", c);

        if(action.contentEquals("edit")){
            Screens.ShowEditCustomerActivity(this, extras);
        }
        else if(action.contentEquals("print")){
            Screens.ShowPrintCustomerCardActivity(this, extras);
        }
        else{
            Screens.ShowManagerActivity(this);
        }
    }
}
