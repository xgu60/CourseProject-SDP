package edu.gatech.seclass.gobowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.gobowl.R;
import edu.gatech.seclass.gobowl.Screens;

public class LaneCheckoutSaveScoresPromptActivity extends AppCompatActivity {

    int laneNumber = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
        laneNumber = bundle.getInt("LaneNumberCheckOut");
        setContentView(R.layout.activity_lane_checkout_save_scores_prompt);
    }

    public void buttonYesScoring_onClick(View view){
        Bundle extras = new Bundle();
        extras.putInt("LaneNumberCheckOut2", laneNumber);
        Screens.ShowEnterScoresListActivity(this,extras);
    }

    public void buttonNoScoring_onClick(View view){
        Bundle extras = new Bundle();
        extras.putInt("LaneNumberCheckOut2", laneNumber);
        Screens.ShowBillActivity(this,extras);
    }
}
