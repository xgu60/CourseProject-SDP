package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;

public class CustomerCardPrintConfirmationActivity extends AppCompatActivity {
    String ID;
    String Name;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_card_print_confirmation);
        //ID = bundle.getString("ID");
        //Name = bundle.getString("Name");
        //Email = bundle.getString("Email");
    }

    public void buttonDone_onClick(View view){
        Bundle bundle = this.getIntent().getExtras();
        String flag = bundle.getString("printCardSuccessOrNot");
        if (flag != null && flag.equals("No")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Print Card Machine Issues");
            builder.setMessage("Print Card Machine has problem Please try again");
            builder.show();
        }
        Screens.ShowManagerActivity(this);
    }
}
