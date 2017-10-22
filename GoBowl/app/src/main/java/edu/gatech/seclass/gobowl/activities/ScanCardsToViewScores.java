package edu.gatech.seclass.gobowl.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.CustomerService;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class ScanCardsToViewScores extends AppCompatActivity {
    ManagerService mgt;
    CustomerService cs;
    private String customerID = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mgt = ManagerService.getManagerService(getApplicationContext());
        mgt.syncCustomerStubList();
        setContentView(R.layout.activity_scan_cards_to_view_scores);

    }

    public void buttonScanCards_onClick(View view) {
        cs = CustomerService.getCustomerService(getApplicationContext());
        customerID = cs.scanCardToGetCustomerID();
        if (customerID.equals("No Customer exist")) {
            Toast.makeText(this, "Customer not found,Please add Customer", Toast.LENGTH_LONG).show();

        } else if (customerID.equals("ERR")) {
            Toast.makeText(this, "Scan customer's card fail, please try again", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Customer:" + customerID + " is scanned", Toast.LENGTH_LONG).show();
            Bundle extras = new Bundle();
            extras.putString("CustomerIDViewScore",customerID);
            Screens.ShowViewScoresActivity(this,extras);

        }
    }

    public void buttonCancel_onClick(View view){
        Screens.ShowCustomerActivity(this);
    }



}
