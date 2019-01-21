package com.example.joe.st_giorgis_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView openSign = findViewById(R.id.reg_sign_in);
        openSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, SignIn.class);
                Registration.this.startActivity(intent);
            }
        });

        Button home = findViewById(R.id.btn_open_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Notification_onStart.class);
                Registration.this.startActivity(intent);
            }
        });
    }
}
