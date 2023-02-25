package com.example.roadjump;

import static com.example.roadjump.game_classes.CheckValidity.checkValidity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class ConfigActivity extends AppCompatActivity {
    private Button startJump;

    private int imgClicked = 0;
    private ImageButton penguButton;
    private ImageButton mayaButton;
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
        mayaButton = findViewById(R.id.maya_sprite);
        pepeButton = findViewById(R.id.pepe_sprite);
        username = findViewById(R.id.username);
        difficultyBar = findViewById(R.id.difficultyBar);

        startJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userValid = checkValidity(username.getText().toString().trim());

                if (userValid) {
                    startGame(imgClicked, difficultyBar.getProgress(),
                            username.getText().toString().trim());

                } else {
                    username.setError("You have to enter a valid username. "
                            + "Can't be null or whitespace.");
                }
            }

        });



        mayaButton.setOnClickListener(new View.OnClickListener() {
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

    public void startGame(int imgClicked, int difficulty, String username) {
        GameView gameView = new GameView(this, imgClicked, difficulty, username);
        setContentView(gameView);
    }

}