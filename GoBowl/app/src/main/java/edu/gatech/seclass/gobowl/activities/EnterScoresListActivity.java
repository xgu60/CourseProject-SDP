package edu.gatech.seclass.gobowl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.service.CustomerService;

public class EnterScoresListActivity extends AppCompatActivity {
    private Spinner spinner;
    int laneNumber = -1;
    CustomerService cs;
    List<Customer> customers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
        cs = CustomerService.getCustomerService(getApplicationContext());
        laneNumber = bundle.getInt("LaneNumberCheckOut2");
        customers = cs.getPlayersList(laneNumber);
        setContentView(R.layout.activity_enter_scores_list);

        /// get player list from database ///

        spinner = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        /// add customers using below syntax ///

        /// need to list players of THIS game, not ALL customers ///
        for (Customer c : customers) {
            spinnerAdapter.add(c.getId()+ ":" + c.getName());
        }
        //spinnerAdapter.add("Fred Thompson");
        //spinnerAdapter.add("Hubert Li");
        //spinnerAdapter.add("Tom Baker");
        spinnerAdapter.notifyDataSetChanged();
    }

    public void buttonSavePlayerScore_onClick(View view){
        int SelectedID = (int)spinner.getSelectedItemId();
        Customer c = customers.get(SelectedID);
        Intent sourceIntent = this.getIntent();
        Bundle extras = sourceIntent.getExtras();
        extras.putString("CustomerID", c.getId());
        extras.putInt("LaneNumberCheckOut2", laneNumber);
        Screens.ShowEnterIndividualScoreActivity(this, extras);
    }

    public void buttonCancelScoring_onClick(View view){

        Bundle extras = new Bundle();
        extras.putInt("LaneNumberCheckOut2", laneNumber);
        Screens.ShowBillActivity(this, extras);
    }
}
