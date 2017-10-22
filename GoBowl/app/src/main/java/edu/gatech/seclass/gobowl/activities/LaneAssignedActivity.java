package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.CustomerService;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class LaneAssignedActivity extends AppCompatActivity {

    int laneNumber = 9;
    CustomerService cs;
    ManagerService mgt;
    String customerID;
    int numberOfPlayers = 1;
    int count = 0;
    EditText value;
    String v;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lane_assigned);
        cs = CustomerService.getCustomerService(getApplicationContext());
        mgt = ManagerService.getManagerService(getApplicationContext());
        TextView tv = (TextView) findViewById(R.id.textViewLane);
        Bundle bundle = this.getIntent().getExtras();
        customerID = bundle.getString("RequestLaneCustomerID");
        laneNumber = cs.getAvailableLaneForRequestLane();
        tv.setText("You have been assigned to lane ".concat(Integer.toString(laneNumber)));

    }

    public void buttonCancelPlay_onClick(View view){

        Screens.ShowCustomerActivity(this);
    }

    public void buttonPlay_onClick(View view){
        if (!flag) {
            value  = (EditText) findViewById(R.id.numbers_players);
            v = value.getText().toString();
            if (v == null || v.equals("")) {
                Toast.makeText(this, "Please input number of players", Toast.LENGTH_LONG).show();
            } else {
                numberOfPlayers = Integer.parseInt(v);
                Log.d("numberOfPlayers :", String.valueOf(numberOfPlayers));
                int playersInSystem = mgt.getCustomerList().size();
                if (numberOfPlayers <= 0) {
                    Toast.makeText(this, "Please input a number that >= 1", Toast.LENGTH_LONG).show();
                } else if (numberOfPlayers > playersInSystem) {
                    Toast.makeText(this, "There are only " + playersInSystem + " in the System,please input a smaller number", Toast.LENGTH_LONG).show();
                } else {
                    flag = true;
                    value.setKeyListener(null);
                }
            }
        }
        //flag =false;
        if (flag) {
            if (cs.scanCode() || count >= numberOfPlayers - 1) {
                count++;
                if (count >= numberOfPlayers - 1) {
                    Toast.makeText(this, "all players scanned", Toast.LENGTH_LONG).show();
                    Bundle extras = new Bundle();
                    extras.putString("RequestLaneCustomerID2", customerID);
                    extras.putInt("LaneNumber", laneNumber);
                    extras.putInt("NumberOfPlayers", numberOfPlayers);
                    Screens.ShowThanksActivity(this, extras);
                } else {
                    //Log.d("System.out", "##################scanQRCode called##########################");
                    Toast.makeText(this, "one more Player is Scanned," + (numberOfPlayers - 1 - count) + " more players need to be scanned", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Code Scan failed, please try again", Toast.LENGTH_LONG).show();
            }
        }


    }
//Scan cards , may not need
//    public void buttonAddPlayer_onClick(View view){
//        Bundle extras = new Bundle();
//        extras.putString("action", "addPlayer");
//        extras.putInt("laneNumber", laneNumber);
//
//        Screens.ShowScanCustomerCardActivity(this, extras);
//    }
}
