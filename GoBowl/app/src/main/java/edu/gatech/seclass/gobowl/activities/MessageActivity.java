package edu.gatech.seclass.gobowl.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.gatech.seclass.gobowl.R;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Bundle bundle = this.getIntent().getExtras();

        if(bundle.containsKey("title")){
            String title = bundle.getString("title");
            TextView lblTitle = (TextView)findViewById(R.id.lblMessageTitle);
            lblTitle.setText(title);
        }

        if(bundle.containsKey("message")){
            String msg = bundle.getString("message");
            TextView lblMessage = (TextView)findViewById(R.id.lblMessageText);
            lblMessage.setText(msg);
        }

    }

    protected void buttonMessageOkay_onClick(View view){
        Bundle bundle = this.getIntent().getExtras();
        if(bundle.containsKey("nextActivity")){
            Class<?> next = (Class<?>)bundle.getSerializable("nextActivity");
            Intent intent = new Intent(this, next);
            startActivity(intent);
        }
    }
}
