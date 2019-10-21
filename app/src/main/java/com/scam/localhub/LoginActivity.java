package com.scam.localhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.login_button);
        final EditText et1=findViewById(R.id.login_name);
        final EditText et2=findViewById(R.id.login_number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if((et1.getText()!=null)&&(et2.getText()!=null)) {
                    Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    myIntent.putExtra("Name",et1.getText().toString());
                    LoginActivity.this.startActivity(myIntent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Please Enter all Input Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
