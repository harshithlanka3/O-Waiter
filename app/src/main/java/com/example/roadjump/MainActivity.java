package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // one buttons
    Button bStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // registering button
        bStart = findViewById(R.id.startAppBtn);

        //handling the start button
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this, ConfigActivity.class));
                //startActivity(new Intent(MainActivity.this, MyOtherActivity.class));
            }
        });


    }
}