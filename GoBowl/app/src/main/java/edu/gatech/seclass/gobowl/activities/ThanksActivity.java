package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.CustomerService;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class ThanksActivity extends AppCompatActivity {

    CustomerService cs;
    ManagerService mgt;
    String customerID;
    int laneNumber;
    int numberOfPlayers = 1;
    List<String> players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cs = CustomerService.getCustomerService(getApplicationContext());
        mgt = ManagerService.getManagerService(getApplicationContext());
        Bundle bundle = this.getIntent().getExtras();
        customerID = bundle.getString("RequestLaneCustomerID2");
        laneNumber = bundle.getInt("LaneNumber");
        numberOfPlayers = bundle.getInt("NumberOfPlayers");
        players = cs.getNumbersOfPlayersForPlaying(numberOfPlayers,customerID);
        cs.saveLaneInformationToDBForCheckOutLater(laneNumber,customerID,numberOfPlayers,players);
        setContentView(R.layout.activity_thanks);
    }

    public void View_onClick(View view) {

            StringBuffer buffer = new StringBuffer();
            buffer.append("Lane Number: " + laneNumber + "\n");
            buffer.append("Register Customer: " + customerID + "\n");
            buffer.append("Player ID List (Customer ID : Customer Name): " + "\n ");
            for (int i = 0; i < players.size(); i++) {
                buffer.append(players.get(i).replaceAll("#_#"," : ") + "\n ");
            }
            showMessage("Lane Information", buffer.toString());
            return;


        }

    public void buttonThanksDone_onClick(View view){
        Screens.ShowMainActivity(this);
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


}
