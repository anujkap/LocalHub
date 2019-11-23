package com.scam.localhub;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final List<UserTask> homeTaskList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(Color.parseColor("#0497E7"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username=findViewById(R.id.username);
        SharedPreferences prefs = getSharedPreferences("LocalHub", MODE_PRIVATE);
        String uname= prefs.getString("name","User");
        username.setText(uname);
        UserTask a=new UserTask("Facebook",R.drawable.ic_facebook);
        UserTask b=new UserTask("Twitter",R.drawable.ic_twitter);
        UserTask c=new UserTask("Gmail",R.drawable.ic_gmail);
        UserTask d=new UserTask("Uber",R.drawable.ic_uber);
        UserTask e=new UserTask("Paytm",R.drawable.ic_paytm);
        UserTask f=new UserTask("UPI",R.drawable.ic_upi);
        homeTaskList.add(a);
        homeTaskList.add(b);
        homeTaskList.add(c);
        homeTaskList.add(f);
        homeTaskList.add(d);
        homeTaskList.add(e);
        final LinearLayout linearLayout=findViewById(R.id.homeRecyclerView);
        final MyRecyclerViewAdapter adapter =new MyRecyclerViewAdapter(getApplicationContext(),R.layout.recylerview_row,homeTaskList);

        int k=adapter.getCount();
        for (int i = 0; i <k ; i++)
        {
            final int l=i;
            View item=adapter.getView(i,null,null);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    TextView tv=view.findViewById(R.id.homeTextViewRecyclerView1);
                    String check=tv.getText().toString();
                    if(check.equalsIgnoreCase("Facebook")) {
                        Intent myIntent = new Intent(MainActivity.this,FragActivity.class);
                        myIntent.putExtra("Frag","Facebook");
                        MainActivity.this.startActivity(myIntent);
                    }
                    else if(check.equalsIgnoreCase("Twitter"))
                    {
                        Intent myIntent = new Intent(MainActivity.this,FragActivity.class);
                        myIntent.putExtra("Frag","Twitter");
                        MainActivity.this.startActivity(myIntent);
                    }
                    else if(check.equalsIgnoreCase("Gmail"))
                    {
                        Intent myIntent = new Intent(MainActivity.this,FragActivity.class);
                        myIntent.putExtra("Frag","Gmail");
                        MainActivity.this.startActivity(myIntent);
                    }
                    else if(check.equalsIgnoreCase("Paytm"))
                    {
                        Intent myIntent = new Intent(MainActivity.this,FragActivity.class);
                        myIntent.putExtra("Frag","Paytm");
                        MainActivity.this.startActivity(myIntent);
                    }
                    else if(check.equalsIgnoreCase("Uber"))
                    {
                        Intent myIntent = new Intent(MainActivity.this,FragActivity.class);
                        myIntent.putExtra("Frag","Uber");
                        MainActivity.this.startActivity(myIntent);
                    }
                    else if(check.equalsIgnoreCase("UPI"))
                    {
                        Intent myIntent = new Intent(MainActivity.this,FragActivity.class);
                        myIntent.putExtra("Frag","UPI");
                        MainActivity.this.startActivity(myIntent);
                    }
                }
            });
            linearLayout.addView(item);
        }
    }
}