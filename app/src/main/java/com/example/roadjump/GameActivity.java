package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

public class GameActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int numCharacter = intent.getIntExtra("key1", 0);

        ImageView img = findViewById(R.id.characterSpriteImage);
        //make varaibles for each image file
        //set drawable for each img.set to the correct image file varaible correspondign to each case

        switch (numCharacter) {
            case 1:
                //do something
                img.setImageResource(R.drawable.);
                break;
            case 2:
                //do something
                img.setImageResource(R.drawable.);
                break;
            default:
                //set to 0
                img.setImageResource(R.drawable.);
                break;
        }
    }
}
