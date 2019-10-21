package com.scam.localhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {
    public static final String NAME = "com.scam.localhub.MESSAGE";
    EditText et1;
    EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.login_button);
        et1=findViewById(R.id.login_name);
        et2=findViewById(R.id.login_number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name=et1.getText().toString();
                if(TextUtils.isEmpty(name))
                {
                    Toast.makeText(LoginActivity.this, "Enter Valid Input", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    EditText editText = (EditText) findViewById(R.id.login_name);
                    String message = editText.getText().toString();
                    intent.putExtra("Hi", message);
                    startActivity(intent);
                }

            }
        });
        Button btn=findViewById(R.id.signup_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivityLog.class);
                startActivity(intent);
            }
        });
    }
}
