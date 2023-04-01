package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class ConfigActivity extends AppCompatActivity {
    private Button startJump;
    private int imgClicked;
    private ImageButton pinguButton;
    private ImageButton podgeButton;
    private ImageButton narshithButton;
    private EditText username;
    private SeekBar difficultyBar;
    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_select);

        startJump = findViewById(R.id.submitCharacter);
        pinguButton = findViewById(R.id.pingu_sprite);
        podgeButton = findViewById(R.id.podge_sprite);
        narshithButton = findViewById(R.id.narshith_sprite);
        username = findViewById(R.id.username);
        difficultyBar = findViewById(R.id.difficultyBar);

        player = new Player();

        startJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean userValid = player.checkValidity(username.getText().toString().trim());

                if (userValid) {
                    startGame(imgClicked, difficultyBar.getProgress(),
                            username.getText().toString().trim());

                } else {
                    username.setError("You have to enter a valid username. "
                            + "Can't be null or whitespace.");
                }
            }

        });

        podgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgClicked = 0;
            }
        });

        pinguButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgClicked = 1;
            }
        });

        narshithButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgClicked = 2;
            }
        });
    }

    public void startGame(int imgClicked, int difficulty, String username) {
        player.setUsername(username);
        player.setDifficulty(difficulty);
        player.setImg(imgClicked);
        GameView gameView = new GameView(this, player);
        setContentView(gameView);
    }




}