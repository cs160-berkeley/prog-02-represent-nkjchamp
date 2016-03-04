package com.cs160.joleary.catnip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberActivity extends Activity {

    private TextView memberText;
    private Button moreInfoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moreInfoBtn = (Button) findViewById(R.id.info_btn);
        memberText = (TextView) findViewById(R.id.mem_text);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            String enterLoc = extras.getString("ENTER_LOC");

            if (enterLoc.equalsIgnoreCase("Sen1")) {

            }

//            memberText.setText(enterLoc.toString());

//            mFeedBtn.setText(enterLoc);
        }

        moreInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(getBaseContext(), WatchToPhoneService.class);
                startService(sendIntent);
            }
        });
    }
}