package com.cs160.joleary.catnip;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

    private Button sen1;
    private Button sen2;
    private Button rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sen1 = (Button) findViewById(R.id.sen1_btn);
        sen2 = (Button) findViewById(R.id.sen2_btn);
        rep = (Button) findViewById(R.id.rep1_btn);

        sen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sen1DetailedIntent = new Intent(getBaseContext(), DetailedActivity.class);
                startActivity(sen1DetailedIntent);

            }
        });

        sen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sen2DetailedIntent = new Intent(getBaseContext(), DetailedActivity.class);
                startActivity(sen2DetailedIntent);

            }
        });

        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent repDetailedIntent = new Intent(getBaseContext(), DetailedActivity.class);
                startActivity(repDetailedIntent);

            }
        });






    }

}
