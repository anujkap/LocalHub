package com.scam.localhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class UPIFragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upifrag);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String frag=null;
        if(b!=null)
        {
            frag=(String) b.get("Frag");
        }
        Fragment fragment=null;
        if("Send".equalsIgnoreCase(frag))
        {
            fragment=new SendFragment();
        }
        else if("Request".equalsIgnoreCase(frag))
        {
            fragment=new RequestFragment();
        }
        else if("Balance".equalsIgnoreCase(frag))
        {
            fragment=new BalanceFragment();
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Screen_Area1,fragment);
        fragmentTransaction.commit();
    }
}