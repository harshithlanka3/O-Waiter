package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gameplay);

        Intent intent = getIntent();

        int numCharacter = intent.getIntExtra("key1", 0);
        int difficultySet = intent.getIntExtra("key2", 0);
        String actualUsername = intent.getExtras().getString("usernameString");

        ImageView img = findViewById(R.id.characterSpriteImage);
        TextView lives = findViewById(R.id.livesNumTxt);
        TextView usernameText = findViewById(R.id.playerEnteredNameTxt);

        switch (numCharacter) {
        case 1:
            //do something
            img.setImageResource(R.drawable.bunny);
            break;
        case 2:
            //do something
            img.setImageResource(R.drawable.pepe);
            break;
        default:
            //set to 0
            img.setImageResource(R.drawable.pengu);
            break;
        }

        switch (difficultySet) {
        case 1:
            lives.setText("<3 <3");
            break;
        case 2:
            lives.setText("<3");
            break;
        default:
            lives.setText("<3 <3 <3");
            break;
        }

        usernameText.setText(actualUsername);
    }
}
