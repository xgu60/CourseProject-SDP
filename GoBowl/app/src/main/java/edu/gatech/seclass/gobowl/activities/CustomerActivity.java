package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        TextView tv = (TextView)findViewById(R.id.textViewRegistration);
        //tv.setText("You are registered as a player in lane 09.");
        //tv.setText("You are not registered to any lane.");
        // we aren't supposed to have scanned a card yet, so we can't know if the
        // customer has registered to a lane.
        tv.setText("");
    }

    public void buttonLaneRequest_onClick(View view){
        Screens.showRequestLaneScanCodeForRegisterActivity(this);
    }

    public void buttonLaneCheckout_onClick(View view){
        Screens.ShowLaneCheckoutActivity(this);
    }

    public void buttonViewScores_onClick(View view){
        Screens.ShowScanCardsToViewScores(this);
    }

    public void buttonCancelCustomer_onClick(View view){
        Screens.ShowMainActivity(this);
    }
}
