package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.CustomerService;

public class LaneCheckoutActivity extends AppCompatActivity {

    CustomerService cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cs = CustomerService.getCustomerService(getApplicationContext());
        setContentView(R.layout.activity_lane_checkout);
    }

    public void buttonCancelCheckout_onClick(View view){
        Screens.ShowCustomerActivity(this);
    }

    public void buttonNextCheckout_onClick(View view){
        EditText value = (EditText) findViewById(R.id.laneNumber);
        String v = value.getText().toString();
        if (v == null || v.equals("")) {
            Toast.makeText(this, "Please input a lane number", Toast.LENGTH_LONG).show();
        } else {
            int laneNumber = Integer.parseInt(v);
            if (laneNumber < 0) {
                Toast.makeText(this, "Please input a lane number that >= 0", Toast.LENGTH_LONG).show();
            } else if (!cs.isLaneRequested(laneNumber)) {
                Toast.makeText(this, "The lane has not been requested before", Toast.LENGTH_LONG).show();
            } else {
                Bundle extras = new Bundle();
                extras.putInt("LaneNumberCheckOut", laneNumber);
                Screens.ShowLaneCheckoutSaveScoresPromptActivity(this, extras);
            }
        }
    }
}
