package com.cs160.joleary.catnip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends Activity {

    ViewPager viewPager;

    private TextView mTextView;
    private Button mFeedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        viewPager = (ViewPager) findViewById(R.id.view_pager);
        //FragmentPagerAdapter or FragmentStatePagerAdapter


        mFeedBtn = (Button) findViewById(R.id.feed_btn);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            String member = extras.getString("MEMBER");

            if (member.equalsIgnoreCase("Sen1")) {

            }

            mFeedBtn.setText(member);
        }

        mFeedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(getBaseContext(), WatchToPhoneService.class);
                sendIntent.putExtra("MEMBER", "Sen1");
                startService(sendIntent);
            }
        });
    }
}
