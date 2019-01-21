package com.example.joe.st_giorgis_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notification_onStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_on_start);

        Button home = findViewById(R.id.btn_open_home_noti);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notification_onStart.this, MainActivity.class);
                Notification_onStart.this.startActivity(intent);
            }
        });
    }
}
