package com.example.joe.st_giorgis_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        TextView openReg = findViewById(R.id.sign_in_reg);
        openReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, Registration.class);
                SignIn.this.startActivity(intent);
            }
        });

        Button home = findViewById(R.id.btn_open_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, Notification_onStart.class);
                SignIn.this.startActivity(intent);
            }
        });
    }
}
