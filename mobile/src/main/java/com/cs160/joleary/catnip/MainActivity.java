package com.cs160.joleary.catnip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import java.lang.reflect.Member;
import java.util.List;

public class MainActivity extends Activity {
    //there's not much interesting happening. when the buttons are pressed, they start
    //the PhoneToWatchService with the cat name passed in.

    EditText zipCode;
    private Button enterZipCode;
    private Button currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        zipCode = (EditText) findViewById(R.id.zip_text);
        enterZipCode = (Button) findViewById(R.id.zip_btn);
        currentLocation = (Button) findViewById(R.id.currloc_btn);

        MemberOfCongress sen1 = new MemberOfCongress("Name1", "Democrat", "", true);
        MemberOfCongress sen2 = new MemberOfCongress("Name2", "Democrat", "", true);
        MemberOfCongress rep = new MemberOfCongress("Name3", "Democrat", "", false);

        final ArrayList<MemberOfCongress> membersOfCongress = new ArrayList<MemberOfCongress>();

        membersOfCongress.add(sen1);
        membersOfCongress.add(sen2);
        membersOfCongress.add(rep);



        enterZipCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //enter code for using the zip code
                Intent homeIntent = new Intent(getBaseContext(), HomeActivity.class);
                homeIntent.putExtra("membersInfo", membersOfCongress);
                startActivity(homeIntent);

                Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
                sendIntent.putExtra("MEMBER", "Sen1");
                startService(sendIntent);
            }
        });

        currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homeIntent = new Intent(getBaseContext(), HomeActivity.class);
                homeIntent.putExtra("membersInfo", membersOfCongress);
                startActivity(homeIntent);

                Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
                sendIntent.putExtra("MEMBER", "Sen1");
                startService(sendIntent);

//                Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
//                sendIntent.putExtra("CAT_NAME", "Current Location");
//                startService(sendIntent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
