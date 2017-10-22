package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.service.CustomerService;
import edu.gatech.seclass.gobowl.utility.CreditCard;

public class SwipeCreditCardActivity extends AppCompatActivity {
    int laneNumber = -1;
    int billSplit = 1;
    long checkOuttime = 0;
    Double totalBill = 0.0;
    CustomerService cs;
    ArrayList<CreditCard> swipsCards;
    List<CreditCard> transCations;
    DecimalFormat formater = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_credit_card);
        Bundle bundle = this.getIntent().getExtras();
        laneNumber = bundle.getInt("LaneNumberCheckOut2");
        cs = CustomerService.getCustomerService(getApplicationContext());
        totalBill = bundle.getDouble("TotalBill");
        billSplit = bundle.getInt("BillSplit");
        checkOuttime = bundle.getLong("CheckOuttime");
        List<Customer> players = cs.getPlayersList(laneNumber);
        cs.syncForPayment(players);
        //swipsCards = cs.readCard(billSplit, totalBill/billSplit);
        swipsCards = (ArrayList<CreditCard>) bundle.getSerializable("SwipCards");
        transCations = cs.tranSettlement(swipsCards,billSplit, totalBill/billSplit);
        if (swipsCards.size() >= 10001 || transCations.size() >= 10001) {
            Toast.makeText(this, "Swipe Cards or Transcation processing failed, please try again", Toast.LENGTH_LONG).show();
            Bundle extras = new Bundle();
            extras.putDouble("TotalBill", totalBill);
            extras.putInt("LaneNumberCheckOut2", laneNumber);
            extras.putInt("BillSplit", billSplit);
            extras.putLong("CheckOuttime", checkOuttime);
            Screens.ShowBillAmountVerificationActivity(this, extras);
        } else {
            cs.addCreditToRegisteredCustomer(laneNumber,totalBill);
            cs.deleteLane(laneNumber);

        }
    }



    public void buttonOkayCCDirections_onClick(View view){
        Screens.ShowMainActivity(this);
    }

    public void buttonViewCards_onClick(View view){
        StringBuffer buffer = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < swipsCards.size(); i++) {
            CreditCard c = swipsCards.get(i);
            String status = c.isSucessOrNot() == true ? "sucess" : "fail";
            buffer.append("***Credit Card Swiping " + (i + 1) + "***" +  "\n");
            buffer.append("Card number: " + c.getCcNumber() + "\n");
            buffer.append("Ower : " + c.getFirstName()+ " " + c.getLastNamer() + "\n");
            buffer.append("Expiration Date :" + df.format(c.getExpirationDate()) + "\n"  );
            buffer.append("Security Code :" + c.getSecurityCode() + "\n"  );
            buffer.append("Amount :" + formater.format(c.getAmount()) + "\n"  );
            buffer.append("Status : " + status  + "\n" );
        }
        showMessage("Swipe Credit Cards", buffer.toString());
        return;
    }

    public void buttonViewTranscations_onClick(View view){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < transCations.size(); i++) {
            CreditCard c = transCations.get(i);
            String status = c.getTransactionRecords() == true ? "sucess" : "fail";
            buffer.append("***Transcation Processing " + (i + 1) + "***" + "\n");
            buffer.append("Card number: " + c.getCcNumber() + "\n");
            buffer.append("Amount :" + formater.format(c.getAmount()) + "\n"  );
            buffer.append("Status : " + status  + "\n" );
        }
        showMessage("Transcation processing", buffer.toString());
        return;
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}
