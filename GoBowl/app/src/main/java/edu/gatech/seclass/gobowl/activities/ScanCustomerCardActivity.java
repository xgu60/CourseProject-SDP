package edu.gatech.seclass.gobowl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;

public class ScanCustomerCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_customer_card);
    }

    public void buttonScanCustomerCard_onClick(View view) {
        Intent intent = getIntent();
        String action = intent.getStringExtra("action");
        int laneNumber;

        if(action.contentEquals("addPlayer")){
            if(intent.hasExtra("laneNumber")){
                laneNumber = intent.getIntExtra("laneNumber",0);
                Bundle extras = new Bundle();
                extras.putInt("laneNumber", laneNumber);
                Screens.ShowLaneAssignedActivity(this, extras);
            }
            else{
                Screens.ShowCustomerActivity(this);
            }
        }
        else {
            Screens.ShowCustomerActivity(this);
        }
    }
}
