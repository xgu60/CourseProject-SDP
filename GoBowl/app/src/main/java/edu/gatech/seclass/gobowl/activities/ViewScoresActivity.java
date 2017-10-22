package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;
import edu.gatech.seclass.gobowl.persistentobject.Customer;
import edu.gatech.seclass.gobowl.persistentobject.Score;
import edu.gatech.seclass.gobowl.service.CustomerService;

public class ViewScoresActivity extends AppCompatActivity {
    CustomerService cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scores);
        TextView tv = (TextView)findViewById(R.id.scoreTitle);
        cs = CustomerService.getCustomerService(getApplicationContext());
        Bundle bundle = this.getIntent().getExtras();
        String customerID = bundle.getString("CustomerIDViewScore");
        EditText scores = (EditText) findViewById(R.id.editTextScores);
        List<Score> scoreList = cs.getScores(customerID);
        Customer customer = cs.getCustomer(customerID);
        StringBuffer sb = new StringBuffer();
        String isVIP = customer.getVIP()? "I am a VIP" : "I am not a VIP";
        sb.append("Customer ID : " + customer.getId()  + "\n" );
        sb.append("Customer Name : " + customer.getName()  + "\n" );
        sb.append("Email : " + customer.getEmail()  + "\n" );
        sb.append("VIP status : " + isVIP  + "\n" );
        DecimalFormat formater = new DecimalFormat("#.##");
        sb.append("Credits for this Year : " + formater.format(customer.getCreditForThisYear()) + " / 500"  + "\n" );
        sb.append("           Your Scores       :");
        tv.setText(sb.toString());
        StringBuffer sb2 = new StringBuffer();

        for (int i = 0 ; i < scoreList.size(); i++) {
            Score s = scoreList.get(i);
            sb2.append(s.getDate().toString() + " : " + s.getScore() + "\n");
        }
        //scores.setText("6/30/2016: 100\r\n6/29/2016: 90\r\n6/28/2016: 80");
        scores.setText(sb2.toString());
        //set to not editable
        scores.setKeyListener(null);

    }

    public void buttonOkay_onClick(View view){
        Screens.ShowCustomerActivity(this);
    }
}
