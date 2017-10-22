package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.CustomerService;

public class EnterIndividualScoreActivity extends AppCompatActivity {

    int laneNumber = -1;
    CustomerService cs;
    String customerID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
        laneNumber = bundle.getInt("LaneNumberCheckOut2");
        customerID = bundle.getString("CustomerID");
        cs = CustomerService.getCustomerService(getApplicationContext());
        setContentView(R.layout.activity_enter_individual_score);
    }

    public void buttonCancelSaveScore_onClick(View view){
        Bundle extras = new Bundle();
        extras.putInt("LaneNumberCheckOut2", laneNumber);
        //Screens.ShowBillActivity(this,extras);
        Screens.ShowEnterScoresListActivity(this,extras);
    }

    public void buttonSaveScore_onClick(View view){
        EditText value = (EditText) findViewById(R.id.inputScore);
        String v = value.getText().toString();
        if (v == null || v.equals("")) {
            Toast.makeText(this, "Please input a score", Toast.LENGTH_LONG).show();
        } else {
            int score = Integer.parseInt(v);
            cs.addScore(customerID, score);
            Bundle extras = new Bundle();
            extras.putInt("LaneNumberCheckOut2", laneNumber);
            Screens.ShowEnterScoresListActivity(this, extras);
        }
    }
}
