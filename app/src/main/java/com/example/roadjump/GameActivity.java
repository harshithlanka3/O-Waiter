package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
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
