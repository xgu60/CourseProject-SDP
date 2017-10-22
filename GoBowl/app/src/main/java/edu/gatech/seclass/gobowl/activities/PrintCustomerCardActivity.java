package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class PrintCustomerCardActivity extends AppCompatActivity {
    String ID;
    String Name;
    String Email;

    Customer customer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_customer_card);

        Bundle bundle = this.getIntent().getExtras();
        this.customer = (Customer)bundle.getSerializable("customer");

        TextView nameTV = (TextView)findViewById(R.id.tvName);
        TextView emailTV = (TextView)findViewById(R.id.tvEmail);
        TextView hexTV = (TextView)findViewById(R.id.lblEditCustomerID);
        nameTV.setText("Name: " + this.customer.getName());
        emailTV.setText("Email: " + this.customer.getEmail());
        hexTV.setText("Customer #: " + this.customer.getId());
    }

    public void buttonCancelPrint_onClick(View view){
        Screens.ShowManagerActivity(this);
    }

    public void buttonPrint_onClick(View view){

        ManagerService mgr = ManagerService.getManagerService(getApplicationContext());
        Boolean check = mgr.printCustomerCard(this.customer);
        String flag = "Yes";
        if (!check)
            flag = "No";
        Bundle extras = new Bundle();
        extras.putString("printCardSuccessOrNot", flag);
        Screens.ShowCustomerCardPrintConfirmationActivity(this,extras);
    }
}
