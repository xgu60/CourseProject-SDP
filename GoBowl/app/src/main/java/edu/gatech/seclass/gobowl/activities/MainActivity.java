package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sync the QR Scan service to have the current customer list
        ManagerService mgr = ManagerService.getManagerService(getApplicationContext());
        //mgr.clearAllTablesForTesting();
        //Log.d("clearDBTEST", "Once");
        //mgr.syncCustomerStubList();
        //mgr.addDummyCustomersForTesting();
        //mgr.syncCustomerStubList();
    }

    public void buttonManager_onClick(View view){
        Screens.ShowManagerActivity(this);
    }

    public void buttonCustomer_onClick(View view){
        Screens.ShowCustomerActivity(this);
    }
}
