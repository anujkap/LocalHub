package com.scam.localhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class FragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String frag=null;
        if(b!=null)
        {
            frag=(String) b.get("Frag");
        }
        Fragment fragment=null;
        if("Facebook".equalsIgnoreCase(frag))
        {
            fragment=new FacebookFragment();
        }
        else if("Twitter".equalsIgnoreCase(frag))
        {
            fragment=new TwitterFragment();
        }
        else if("Gmail".equalsIgnoreCase(frag))
        {
            fragment=new Gmail();
        }
        else if("UPI".equalsIgnoreCase(frag))
        {
            fragment=new UPIFragment();
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Screen_Area,fragment);
        fragmentTransaction.commit();
    }
}
