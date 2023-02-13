package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class ConfigActivity extends AppCompatActivity {
    private Button startJump;

    private int imgClicked = 0;
    private ImageButton penguButton;
    private ImageButton bunnyButton;
    private ImageButton pepeButton;

    private EditText username;

    private SeekBar difficultyBar;

    private boolean userValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_select);

        startJump = findViewById(R.id.submitCharacter);
        penguButton = findViewById(R.id.pengu_sprite);
        bunnyButton = findViewById(R.id.bunny_sprite);
        pepeButton = findViewById(R.id.pepe_sprite);
        username = findViewById(R.id.username);
        difficultyBar = findViewById(R.id.difficultyBar);

        startJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userValid = checkValidity();

                if (userValid) {
                    Intent playGame = new Intent(ConfigActivity.this, GameActivity.class);
                    playGame.putExtra("character", imgClicked);
                    playGame.putExtra("difficulty", difficultyBar.getProgress());
                    playGame.putExtra("user", username.getText().toString().trim());
                    startActivity(playGame);
                } else {
                    username.setError("You have to enter a valid username. "
                            + "Can't be null or whitespace.");
                }
            }

        });

        bunnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgClicked = 0;
            }
        });

        penguButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgClicked = 1;
            }
        });

        pepeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgClicked = 2;
            }
        });
    }
    private boolean checkValidity() {
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return username.getText().toString().trim().length() != 0;
        }
    }

}