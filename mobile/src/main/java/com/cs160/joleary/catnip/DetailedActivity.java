package com.cs160.joleary.catnip;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Button;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class DetailedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        MemberOfCongress member = null;
        String memFromWatch = null;

//        if (extras != null) {
//            member = (MemberOfCongress) intent.getSerializableExtra("membersInfo");
//            Log.d("EXTRA", "member" + member.getName());
//            memFromWatch = (String) extras.getString("MEMBER");
//            Log.d("EXTRA", "memFromWatch" + memFromWatch);
//        }

        if(member == null) {

        }




    }

}
