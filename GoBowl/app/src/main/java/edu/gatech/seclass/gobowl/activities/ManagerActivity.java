package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;

public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
    }

    public void buttonManagerAddCustomer_onClick(View view){
        Screens.ShowAddNewCustomerActivity(this);
    }

    public void buttonManagerEditCustomer_onClick(View view){
        Bundle extras = new Bundle();
        extras.putString("action", "edit");
        Screens.ShowCustomerInfoPromptActivity(this, extras);
    }

    public void buttonManagerPrintCustomerCard_onClick(View view){
        Bundle extras = new Bundle();
        extras.putString("action", "print");
        Screens.ShowCustomerInfoPromptActivity(this, extras);
    }

    public void buttonManagerCancel_onClick(View view){
        Screens.ShowMainActivity(this);
    }
}
