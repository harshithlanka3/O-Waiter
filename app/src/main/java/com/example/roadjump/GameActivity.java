package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.animation.ObjectAnimator;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.example.roadjump.game_classes.Player;


public class GameActivity extends AppCompatActivity {

    private Button upBtn;

    private Button downBtn;

    private Button leftBtn;

    private Button rightBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);


        Intent intent = getIntent();

        int characterNum = intent.getIntExtra("character", 0);
        int difficultyNum = intent.getIntExtra("difficulty", 0);
        String inputUsername = intent.getExtras().getString("user");

        //ImageView backgroundImage = findViewById(R.id.characterSpriteImage);

        ImageView characterImage = findViewById(R.id.characterSpriteImage);
        TextView livesText = findViewById(R.id.livesNumTxt);
        TextView userText = findViewById(R.id.playerEnteredNameTxt);

        switch (characterNum) {
        case 1:
            characterImage.setImageResource(R.drawable.pengu);
            break;
        case 2:
            characterImage.setImageResource(R.drawable.pepe);
            break;
        default:
            characterImage.setImageResource(R.drawable.bunny);
            break;
        }

        Player currentGamePlayer = new Player(characterImage);

        switch (difficultyNum) {
        case 1:
            livesText.setText("<3 <3");
            break;
        case 2:
            livesText.setText("<3");
            break;
        default:
            livesText.setText("<3 <3 <3");
            break;
        }

        userText.setText(inputUsername);

        //making the character move buttons establishment

        // registering button
        upBtn = findViewById(R.id.upBtn);

        //handling the start button
        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setyCoord(currentGamePlayer.getyCoord() + 1);
            }
        });

        downBtn = findViewById(R.id.downBtn);

        //handling the start button
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setyCoord(currentGamePlayer.getyCoord() - 1);
            }
        });

        leftBtn = findViewById(R.id.leftBtn);

        //handling the start button
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setxCoord(currentGamePlayer.getxCoord() - 1);
            }
        });

        rightBtn = findViewById(R.id.rightBtn);

        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setxCoord(currentGamePlayer.getxCoord() + 1);
            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    public void startGame(View view) {
        GameView gameView = new GameView(this);
        setContentView(gameView);
    }
//
//        Intent intent = getIntent();
//
//        int characterNum = intent.getIntExtra("character", 0);
//        int difficultyNum = intent.getIntExtra("difficulty", 0);
//        String inputUsername = intent.getExtras().getString("user");
//
//        ImageView characterImage = findViewById(R.id.characterSpriteImage);
//        TextView livesText = findViewById(R.id.livesNumTxt);
//        TextView userText = findViewById(R.id.playerEnteredNameTxt);
//
//        switch (characterNum) {
//        case 1:
//            characterImage.setImageResource(R.drawable.pengu);
//            break;
//        case 2:
//            characterImage.setImageResource(R.drawable.pepe);
//            break;
//        default:
//            characterImage.setImageResource(R.drawable.bunny);
//            break;
//        }
//
//        switch (difficultyNum) {
//        case 1:
//            livesText.setText("<3 <3");
//            break;
//        case 2:
//            livesText.setText("<3");
//            break;
//        default:
//            livesText.setText("<3 <3 <3");
//            break;
//        }
//
//        userText.setText(inputUsername);
}
