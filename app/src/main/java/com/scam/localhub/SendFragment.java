package com.scam.localhub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SendFragment extends Fragment {
    String msg,to,amt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_send,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText et1=view.findViewById(R.id.sendET1);
        final EditText et2=view.findViewById(R.id.sendET2);
        Button button=view.findViewById(R.id.sendBTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to=et1.getText().toString();
                amt=et2.getText().toString();
                sendCall();
            }
        });
    }
    public void sendCall()
    {
        String ussd = "*99*1*3"+ Uri.encode("#");
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussd)));
    }
}
