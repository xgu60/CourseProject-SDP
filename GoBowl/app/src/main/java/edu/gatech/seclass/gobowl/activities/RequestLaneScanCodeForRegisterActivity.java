package edu.gatech.seclass.gobowl.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.CustomerService;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class RequestLaneScanCodeForRegisterActivity extends AppCompatActivity {

    ManagerService mgt;
    CustomerService cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mgt = ManagerService.getManagerService(getApplicationContext());
        mgt.syncCustomerStubList();
        setContentView(R.layout.activity_request_lane_scan_code_for_register);
    }

    private String customerID = null;

    public void Scan_onClick(View view){
        //scan customer card

        if (customerID == null || customerID == "No Customer exist" || customerID == "ERR") {
            cs = CustomerService.getCustomerService(getApplicationContext());
            customerID = cs.scanCardToGetCustomerID();
            if (customerID.equals("No Customer exist")) {
                Toast.makeText(this, "Customer not found,Please add Customer", Toast.LENGTH_LONG).show();

            } else if (customerID.equals("ERR")) {
                Toast.makeText(this, "Scan customer's card fail, please try again", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Customer:" + customerID + " is scanned,please click request lane", Toast.LENGTH_LONG).show();

            }
        }
        else {
            Toast.makeText(this, "Customer:" + customerID + " is scanned,please click request lane", Toast.LENGTH_LONG).show();
        }

    }

    public void RequestLane_onClick(View view){
        if (customerID == null || customerID == "No Customer exist" || customerID == "ERR") {
            Toast.makeText(this, "Please scan customer card", Toast.LENGTH_LONG).show();
        } else {
            Bundle extras = new Bundle();
            extras.putString("RequestLaneCustomerID", customerID);
            Screens.ShowLaneAssignedActivity(this,extras);
        }
    }

    public void Cancel_onClick(View view){
        Screens.ShowCustomerActivity(this);
    }
}
