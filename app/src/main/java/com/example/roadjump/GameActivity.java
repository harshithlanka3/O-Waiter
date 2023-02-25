package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.*;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.animation.ObjectAnimator;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.example.roadjump.game_classes.Player;


public class GameActivity extends AppCompatActivity {
    //Initialize variable

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
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) characterImage.getLayoutParams();
        /*
        // registering button
        upBtn = findViewById(R.id.upBtn);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) characterImage.getLayoutParams();

        //handling the start button
        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentGamePlayer.setyCoord(currentGamePlayer.getyCoord() + 10);


                layoutParams.topMargin = layoutParams.topMargin - 88;
                //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                characterImage.setLayoutParams(layoutParams);
            }
        });
        */

        upBtn = findViewById(R.id.upBtn);


        //Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) characterImage.getLayoutParams();
        //RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) characterImage.getLayoutParams();

        //handling the start button
        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutParams.topMargin - 352 > -4200) {
                    currentGamePlayer.setyCoord(currentGamePlayer.getyCoord() - 10);
                    layoutParams.topMargin = layoutParams.topMargin - 352;
                    layoutParams.bottomMargin = layoutParams.bottomMargin + 88;
                    //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                    characterImage.setLayoutParams(layoutParams);
                }
>>>>>>> origin/main
            }
        });

        downBtn = findViewById(R.id.downBtn);


        //Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) characterImage.getLayoutParams();
        //RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) characterImage.getLayoutParams();

        //handling the start button
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (layoutParams.bottomMargin - 88 > -100) {
                    currentGamePlayer.setyCoord(currentGamePlayer.getyCoord() - 10);
                    layoutParams.bottomMargin = layoutParams.bottomMargin - 88;
                    layoutParams.topMargin = layoutParams.topMargin + 352;
                    //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                    characterImage.setLayoutParams(layoutParams);
                }

>>>>>>> origin/main
            }
        });

        leftBtn = findViewById(R.id.leftBtn);

        //handling the start button
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (layoutParams.leftMargin - 88 > -350) {
                    currentGamePlayer.setxCoord(currentGamePlayer.getxCoord() - 10);
                    layoutParams.leftMargin = layoutParams.leftMargin - 88;
                    layoutParams.rightMargin = layoutParams.rightMargin + 88;
                    //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                    characterImage.setLayoutParams(layoutParams);
                }
>>>>>>> origin/main
            }
        });

        rightBtn = findViewById(R.id.rightBtn);

        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (layoutParams.rightMargin - 88 > -350) {
                    currentGamePlayer.setxCoord(currentGamePlayer.getxCoord() + 10);
                    layoutParams.rightMargin = layoutParams.rightMargin - 88;
                    layoutParams.leftMargin = layoutParams.leftMargin + 88;
                    //layoutParams.bottomMargin = (int) currentGamePlayer.getyCoord();//your bottom margin value
                    characterImage.setLayoutParams(layoutParams);
                }
>>>>>>> origin/main
            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    SwipeListener swipeDetect;

    private class SwipeListener implements View.OnTouchListener {
        //Variables

        GestureDetector swipeDetect;

        //Constructor
        SwipeListener (View view) {
            //thresholds
            int threshold = 100;
            int velocity_threshold = 100;
        }

        GestureDetector.SimpleOnGestureListener listen =
                new GestureDetector.SimpleOnGestureListener() {
                    public boolean onDown(MotionEvent m) {

                    }

                }
        public boolean onTouch(View view, MotionEvent mEvent) {


        }

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
