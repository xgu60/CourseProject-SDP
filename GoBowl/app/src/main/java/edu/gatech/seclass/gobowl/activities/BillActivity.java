package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Calendar;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.CustomerService;

public class BillActivity extends AppCompatActivity {

    int laneNumber = -1;
    int billSplit = 1;
    long checkOuttime = 0;
    Double totalBill = 0.0;
    CustomerService cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        TextView tv = (TextView)findViewById(R.id.totalCost);
        Bundle bundle = this.getIntent().getExtras();
        laneNumber = bundle.getInt("LaneNumberCheckOut2");
        cs = CustomerService.getCustomerService(getApplicationContext());
        totalBill = cs.calCulateCostAccordingToDate(laneNumber, 1);
        DecimalFormat formater = new DecimalFormat("#.##");
        tv.setText("$" + String.valueOf(formater.format(totalBill)));
        checkOuttime = Calendar.getInstance().getTime().getTime();
        //tv.setText("$" + String.valueOf(totalBill));

    }

    public void buttonCancelBill_onClick(View view){
        Screens.ShowCustomerActivity(this);
    }

    public void buttonPayCC_onClick(View view){
        EditText value = (EditText) findViewById(R.id.billsplit);
        String v = value.getText().toString();
        if (v == null || v.equals("")) {
            Toast.makeText(this, "Please input a bill Split", Toast.LENGTH_LONG).show();
        } else {
            int billSplit = Integer.parseInt(v);
            int numberOfPlayers = cs.getPlayersList(laneNumber).size();
            if (billSplit > numberOfPlayers) {
                Toast.makeText(this, "There are only " + numberOfPlayers + " players,please input a bill split smaller than or equal to " + numberOfPlayers, Toast.LENGTH_LONG).show();

            } else if (billSplit <= 0) {
                Toast.makeText(this, "Please input a vaild bill split number", Toast.LENGTH_LONG).show();
            } else {
                Bundle extras = new Bundle();
                extras.putDouble("TotalBill", totalBill);
                extras.putInt("LaneNumberCheckOut2", laneNumber);
                extras.putInt("BillSplit", billSplit);
                extras.putLong("CheckOuttime", checkOuttime);
                Screens.ShowBillAmountVerificationActivity(this, extras);
            }
        }
    }
}
