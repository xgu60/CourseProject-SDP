package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.database.CustomerDataSource;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class EditCustomerActivity extends AppCompatActivity {
    Customer customer = null;
    EditText nameET;
    EditText emailET;
    TextView hexIdTV;
    CustomerDataSource dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);

        Bundle bundle = this.getIntent().getExtras();
        this.customer = (Customer)bundle.getSerializable("customer");

        nameET = (EditText)findViewById(R.id.tbAddCustomerName);
        emailET = (EditText)findViewById(R.id.tbAddCustomerEmail);
        hexIdTV = (TextView)findViewById(R.id.lblEditCustomerID);

        UpdateUIFromCustomer();
    }

    public void buttonCancelEdit_onClick(View view) {
        Screens.ShowManagerActivity(this);
    }

    public void buttonEditCustomerSave_onClick(View view) {
        String message = "", title = "";
        ManagerService mgr = ManagerService.getManagerService(getApplicationContext());

        String name = nameET.getText().toString();
        String email = emailET.getText().toString();
        Boolean dataChanged = false;

        // Check if the user has modified the Customer's information
        if(!this.customer.getName().equals(name)) {
            dataChanged = true;
            this.customer.setName(name);
        }

        if(!this.customer.getEmail().equals(email)) {
            dataChanged = true;
            this.customer.setEmail(email);
        }

        // If the user didn't change the information, there's no need to save
        if(dataChanged) {
            mgr.editCustomer(this.customer);

            Bundle bundle = this.getIntent().getExtras();
            bundle.putSerializable("customer", this.customer);

            message = "Customer # " + customer.getId() + "'s information has been updated.";
            title = "Customer Updated";

        }
        else{
            message = "No change was made as the information provided is already up-to-date.";
            title = "Customer Not Changed";
        }
        Bundle extras = new Bundle();
        extras.putString("Title",title);
        extras.putString("Message",message);
        Screens.ShowCustomerAddedActivity(this, extras);
        //Screens.ShowMessage(this, title, message, ManagerActivity.class);
    }

    private void UpdateUIFromCustomer()
    {
        nameET.setText(this.customer.getName());
        emailET.setText(this.customer.getEmail());
        hexIdTV.setText("Customer # " + this.customer.getId());
    }
}
