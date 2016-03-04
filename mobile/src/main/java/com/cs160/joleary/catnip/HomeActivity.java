package com.cs160.joleary.catnip;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Member;
import java.util.ArrayList;

import java.util.ArrayList;

public class HomeActivity extends Activity {

    private Button sen1;
    private TextView sen1Name;
    private TextView sen1Party;
    private ImageView sen1Image;
    private TextView sen1SOrR;

    private Button sen2;
    private TextView sen2Name;
    private TextView sen2Party;
    private ImageView sen2Image;
    private TextView sen2SOrR;

    private Button rep;
    private TextView repName;
    private TextView repParty;
    private ImageView repImage;
    private TextView repSOrR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Intent intent = this.getIntent();
//        Bundle extras = intent.getExtras();

//        ArrayList<MemberOfCongress> membersOfCongress = (ArrayList<MemberOfCongress>) intent.getSerializableExtra("MEMBERS");
//        intent.getSerializableExtra()
//        ArrayList<MemberOfCongress> membersOfCongress = new ArrayList<MemberOfCongress>(); // extras.getSerializable("MEMBERS");


        sen1 = (Button) findViewById(R.id.sen1_btn);
        sen1Name = (TextView) findViewById(R.id.sen1_name);
        sen1Party = (TextView) findViewById(R.id.sen1_party);
        sen1SOrR = (TextView) findViewById(R.id.sen1_sOrR);

        sen2 = (Button) findViewById(R.id.sen2_btn);
        sen2Name = (TextView) findViewById(R.id.sen2_name);
        sen2Party = (TextView) findViewById(R.id.sen2_party);
        sen2SOrR = (TextView) findViewById(R.id.sen2_sOrR);

        rep = (Button) findViewById(R.id.rep1_btn);
        repName = (TextView) findViewById(R.id.rep1_name);
        repParty = (TextView) findViewById(R.id.rep1_party);
        repSOrR = (TextView) findViewById(R.id.rep1_sOrR);
//
//
        ArrayList<MemberOfCongress> membersOfCongress = (ArrayList) getIntent().getSerializableExtra("membersInfo");

        final MemberOfCongress o_sen1 = membersOfCongress.get(0);
        final MemberOfCongress o_sen2 = membersOfCongress.get(1);
        final MemberOfCongress o_rep = membersOfCongress.get(2);
//
//        System.out.println(o_sen1);
//        System.out.println(o_sen1.getName());
        sen1Name.setText(o_sen1.getName().toString());
        sen1Party.setText(o_sen1.getParty());
//        sen1Image
        if(o_sen1.getSenOrRep()) {
            sen1SOrR.setText("Senator");
        } else {
            sen1SOrR.setText("Representative");
        }

        sen2Name.setText(o_sen2.getName().toString());
        sen2Party.setText(o_sen2.getParty());
//        sen2Image
        if(o_sen2.getSenOrRep()) {
            sen2SOrR.setText("Senator");
        } else {
            sen2SOrR.setText("Representative");
        }

        repName.setText(o_rep.getName().toString());
        repParty.setText(o_rep.getParty());
//        repImage
        if(o_rep.getSenOrRep()) {
            repSOrR.setText("Senator");
        } else {
            repSOrR.setText("Representative");
        }

//        for(MemberOfCongress memberOfCongress : membersOfCongress) {
//
//        }


        sen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sen1DetailedIntent = new Intent(getBaseContext(), DetailedActivity.class);
                sen1DetailedIntent.putExtra("membersInfo", o_sen1);
                startActivity(sen1DetailedIntent);

                Intent memberIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
                memberIntent.putExtra("MEMBER", "Sen1");
                startService(memberIntent);

            }
        });

        sen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sen2DetailedIntent = new Intent(getBaseContext(), DetailedActivity.class);
                sen2DetailedIntent.putExtra("membersInfo", o_sen2);
                startActivity(sen2DetailedIntent);

                Intent memberIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
                memberIntent.putExtra("MEMBER", "Sen2");
                startService(memberIntent);

            }
        });

        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent repDetailedIntent = new Intent(getBaseContext(), DetailedActivity.class);
                repDetailedIntent.putExtra("membersInfo", o_rep);
                startActivity(repDetailedIntent);

                Intent memberIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
                memberIntent.putExtra("MEMBER", "Rep");
                startService(memberIntent);

            }
        });






    }

}
