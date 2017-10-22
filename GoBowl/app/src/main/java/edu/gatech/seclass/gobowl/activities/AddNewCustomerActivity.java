package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.seclass.services.PrintingService;
import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.service.ManagerService;

public class AddNewCustomerActivity extends AppCompatActivity {

    Customer customer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);



    }

    public void buttonAdd_onClick(View view){
        EditText nameET = (EditText)findViewById(R.id.tbAddCustomerName);
        EditText emailET = (EditText)findViewById(R.id.tbAddCustomerEmail);
        String name = nameET.getText().toString();
        String email = emailET.getText().toString();

        if (name == null || email == null|| name.equals("") || email.equals("")) {
            Toast.makeText(this, "name and email can't be empty", Toast.LENGTH_LONG).show();
        } else {
            ManagerService mgr = ManagerService.getManagerService(getApplicationContext());
            boolean isSucess = mgr.addCustomer(name, email);
            if (isSucess) {
                ///// initiate card printing ////
                this.customer = mgr.getCustomerByEmail(email);
                String hexID = this.customer.getId();
                boolean printedCard = false;
                for(int i = 0; i < 3 && !printedCard; i++) {
                    printedCard = PrintingService.printCard(name, email, hexID);
                }
                if (!printedCard) {
                    Toast.makeText(this, "Customer Added, but card printing failed, please use the print cards service to try again", Toast.LENGTH_LONG).show();
                    Screens.ShowManagerActivity(this);
                } else {
                    Bundle extras = new Bundle();
                    //extras.putSerializable("customer", this.customer);

                    String title = "Customer Added";
                    String message = "Customer # " + customer.getId() + " has been successfully added and the customer card has" + (printedCard ? "" : " NOT ") + " printed.";
                    //Screens.ShowMessage(this, title, message, ManagerActivity.class);
                    extras.putString("Title",title);
                    extras.putString("Message",message);
                    Screens.ShowCustomerAddedActivity(this, extras);
                }
            } else {
                Toast.makeText(this, "The customer's email exists", Toast.LENGTH_LONG).show();

            }
        }
    }
    public void buttonCancel_onClick(View view){
        Screens.ShowManagerActivity(this);
    }

}
