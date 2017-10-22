package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.service.CustomerService;
import edu.gatech.seclass.gobowl.utility.CreditCard;

public class BillAmountVerificationActivity extends AppCompatActivity {

    int laneNumber = -1;
    int billSplit = 1;
    long checkOuttime = 0;
    Double totalBill = 0.0;
    CustomerService cs;
    ArrayList<CreditCard> swipsCards;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_amount_verification);
        TextView tv = (TextView)findViewById(R.id.billsplitamout);
        Bundle bundle = this.getIntent().getExtras();
        laneNumber = bundle.getInt("LaneNumberCheckOut2");
        cs = CustomerService.getCustomerService(getApplicationContext());
        totalBill = bundle.getDouble("TotalBill");
        billSplit = bundle.getInt("BillSplit");
        checkOuttime = bundle.getLong("CheckOuttime");
        DecimalFormat formater = new DecimalFormat("#.##");
        swipsCards = new ArrayList<CreditCard>();
        tv.setText("$" + String.valueOf(formater.format(totalBill/billSplit)));
    }

    public void buttonOkayVerified_onClick(View view){
        CreditCard card = cs.readCardEachTime(totalBill/billSplit);
        swipsCards.add(card);
        if (card.isSucessOrNot()) {
            count++;
            if (count < billSplit) {
                Toast.makeText(this, "one Credit card is Swiped successfully, " + (billSplit - count) + " more required", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "All the bills paid successfully", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Fail to scan the credit card, please try again", Toast.LENGTH_LONG).show();
        }

        if (count >= billSplit) {
            Bundle extras = new Bundle();
            extras.putDouble("TotalBill", totalBill);
            extras.putInt("LaneNumberCheckOut2", laneNumber);
            extras.putInt("BillSplit", billSplit);
            extras.putLong("CheckOuttime", checkOuttime);
            extras.putSerializable("SwipCards", swipsCards);
            Screens.ShowSwipeCreditCardActivity(this, extras);
        }
    }

}
