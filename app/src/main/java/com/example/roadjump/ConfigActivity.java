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

    private ImageButton penguButton;
    private ImageButton bunnyButton;
    private ImageButton pepeButton;
    private EditText userName;

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
        userName = findViewById(R.id.username);
        difficultyBar = findViewById(R.id.difficultyBar);

        startJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userValid = checkValidity();

                if (userValid) {
//                    Intent playGame = new Intent(ConfigActivity.this, MainActivity.this);
//                    startActivity(playGame);
                } else {
                    userName.setError("You have to enter a valid username."
                            + "Can't be null or whitespace." + difficultyBar.getProgress());
                }
            }

        });
    }
    private boolean checkValidity() {
        if (userName == null || userName.length() == 0) {
            return false;
        } else {
            return userName.getText().toString().trim().length() != 0;
        }
    }

}