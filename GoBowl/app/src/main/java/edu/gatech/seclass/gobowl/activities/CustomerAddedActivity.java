package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.persistentobject.Customer;

public class CustomerAddedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_added);
        Bundle bundle = getIntent().getExtras();
        TextView tv = (TextView)findViewById(R.id.lblCustomerAddedID);
        TextView tv1 = (TextView)findViewById(R.id.titileCustomer);
        String msg1 = bundle.getString("Title");
        String msg = bundle.getString("Message");
        tv1.setText(msg1);
        tv.setText(msg);
    }

    public void buttonCustomerAddedDone_onClick(View view){
        //Bundle extras = new Bundle();
        //Screens.ShowCustomerCardPrintConfirmationActivity(this,extras);
        Screens.ShowManagerActivity(this);
    }
}
