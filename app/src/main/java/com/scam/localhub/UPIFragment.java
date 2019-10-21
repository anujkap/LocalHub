package com.scam.localhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class UPIFragment extends Fragment
{
    final List<UserTask> homeTaskList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_upi,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        UserTask a=new UserTask("Send",R.drawable.ic_system_update_24px);
        UserTask b=new UserTask("Receive",R.drawable.ic_system_update_alt_24px);
        UserTask c=new UserTask("Balance",R.drawable.ic_account_balance_24px);
        homeTaskList.add(a);
        homeTaskList.add(b);
        homeTaskList.add(c);
        final LinearLayout linearLayout=view.findViewById(R.id.upimainlin);
        final MyUPIAdapter adapter =new MyUPIAdapter(getContext(),R.layout.upimain_recyclerview,homeTaskList);
        int k=adapter.getCount();
        for (int i = 0; i <k ; i++)
        {
            final int l = i;
            View item = adapter.getView(i, null, null);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView tv=view.findViewById(R.id.upiTextViewRecyclerView1);
                    String check=tv.getText().toString();
                    if(check.equalsIgnoreCase("Send"))
                    {
                        Intent myIntent = new Intent(getContext(),UPIFragActivity.class);
                        myIntent.putExtra("Frag","Send");
                        myIntent.putExtra("CallNo","*99*");
                        getContext().startActivity(myIntent);
                    }
                    else if(check.equalsIgnoreCase("Twitter"))
                    {
                        Intent myIntent = new Intent(getContext(),UPIFragActivity.class);
                        myIntent.putExtra("Frag","Receive");
                        getContext().startActivity(myIntent);
                    }
                    else if(check.equalsIgnoreCase("Balance"))
                    {
                        Intent myIntent = new Intent(getContext(),UPIFragActivity.class);
                        myIntent.putExtra("Frag","Balance");
                        getContext().startActivity(myIntent);
                    }
                }
            });
            linearLayout.addView(item);
        }
    }
}
