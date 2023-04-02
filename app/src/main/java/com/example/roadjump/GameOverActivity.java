package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    /**
     * The onCreate method, where we create our activity.
     *
     * @param savedInstanceState the game's savedInstance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Create the set of extras from ConfigActivity/GameView
        super.onCreate(savedInstanceState);

        //then, set the content view to gameplay.
        setContentView(R.layout.game_over_screen_layout);

        //Set the playerDied (1 if dead, 0 if won) by retrieving it from extras.
        // then set the finalScore.
        Intent intent = getIntent();
        int playerDied = intent.getIntExtra("playerDiedKey", 0);
        String finalScoreString = intent.getExtras().getString("finalScoreStringKey");

        //set the gameOverScreenIcon and finalScore views on the screen to whatever the value was.
        ImageView gameOverScreenIcon = findViewById(R.id.gameOverScreenIcon);
        TextView finalScoreText = findViewById(R.id.finalScoreTextGameOverScreen);

        if (playerDied == 1) {
            gameOverScreenIcon.setImageResource(R.drawable.youre_fired_icon);
        }
        if (playerDied == 0) {
            gameOverScreenIcon.setImageResource(R.drawable.delivered_icon);
        }

        finalScoreText.setText(finalScoreString);

        //create the restart button and the exit button variables.
        Button restartButton = findViewById(R.id.restartButtonGameOverScreen);
        Button exitButton = findViewById(R.id.exitButtonGameOverScreen);


        //set an onClickListener for restartButton where,
        // if the button is clicked, start the ConfigActivity
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameOverActivity.this, ConfigActivity.class));
            }
        });

        //set an onClickListener for restartButton where,
        // if the button is clicked, start the MainActivity

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameOverActivity.this, MainActivity.class));
            }
        });

    }
}
