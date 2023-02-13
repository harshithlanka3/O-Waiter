package com.example.roadjump;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class GameActivity extends AppCompatActivity {
    private Image characterSprite;
    protected void onCreate(Bundle savedInstanceState) {
        int numCharacter = 0;
        switch (numCharacter) {
            case 1:
                characterSprite = setImageResource(R.id.bunny_sprite);
                break;
            case 2:
                characterSprite = findViewById(R.id.pepe_sprite);
                break;
            default:
                characterSprite = findViewById(R.id.pengu_sprite);
                break;
        }
    }
}