package com.example.roadjump;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    Bitmap background, sprite, wood, table, sushi, carpet;
    Rect rectBackground;
    Context context;
    Handler handler;
    Runnable runnable;
    static int dWidth, dHeight;
    float spriteX, spriteY;
    float oldX;
    float oldSpriteX;

    int difficulty;

    Player player;

    String username;

    public final int SPRITE_SIZE = 88;
    public final int SCREEN_WIDTH = 1080;

    public final int SCREEN_HEIGHT = 1760;

    public final int TEXT_HT = 40;

    public final int LIVES_WDTH = 920;

    public GameView(Context context, int spriteNum, int difficulty, String username) {
        super(context);
        this.context = context;
        this.difficulty = difficulty;
        this.username = username;

        switch (spriteNum) {
            case 1:
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.pengu);
                sprite = Bitmap.createScaledBitmap(sprite, SPRITE_SIZE, SPRITE_SIZE, false);
                break;
            case 2:
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.pepe);
                sprite = Bitmap.createScaledBitmap(sprite, SPRITE_SIZE, SPRITE_SIZE, false);
                break;
            default:
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.maya);
                sprite = Bitmap.createScaledBitmap(sprite, SPRITE_SIZE, SPRITE_SIZE, false);
                break;
        }

        background = BitmapFactory.decodeResource(getResources(), R.drawable.gameplays1background);
        wood = BitmapFactory.decodeResource(getResources(), R.drawable.wood_tile_image);
        table = BitmapFactory.decodeResource(getResources(), R.drawable.table_tile_image);
        sushi = BitmapFactory.decodeResource(getResources(), R.drawable.sushi_belt_tile_image);
        carpet = BitmapFactory.decodeResource(getResources(), R.drawable.carpet_tile_image);

        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        rectBackground = new Rect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        spriteX = SCREEN_WIDTH / 2;
        spriteY = SCREEN_HEIGHT;

        player = new Player(spriteX, spriteY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background, null, rectBackground, null);

        drawRow(canvas, 0, SPRITE_SIZE * 3, wood);
        drawRow(canvas, SPRITE_SIZE * 3, SPRITE_SIZE * 7, carpet);
        drawRow(canvas, SPRITE_SIZE * 7, SPRITE_SIZE * 8, wood);
        drawRow(canvas, SPRITE_SIZE * 8, SPRITE_SIZE * 11, sushi);
        drawRow(canvas, SPRITE_SIZE * 11, SPRITE_SIZE * 12, wood);
        drawRow(canvas, SPRITE_SIZE * 12, SPRITE_SIZE * 15, sushi);
        drawRow(canvas, SPRITE_SIZE * 15, SPRITE_SIZE * 16, wood);
        drawRow(canvas, SPRITE_SIZE * 16, SPRITE_SIZE * 20, carpet);
        drawRow(canvas, SPRITE_SIZE * 20, SPRITE_SIZE * 22, wood);

        canvas.drawBitmap(table, SCREEN_WIDTH / 2 - SPRITE_SIZE/2, SPRITE_SIZE, null);
        canvas.drawBitmap(sprite, player.getxCoord() - SPRITE_SIZE/2, player.getyCoord(), null);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        switch (difficulty) {
            case 1:
                canvas.drawText("<3 <3", LIVES_WDTH + 50, TEXT_HT, paint);
                break;
            case 2:
                canvas.drawText("<3", LIVES_WDTH + 100, TEXT_HT, paint);
                break;
            default:
                canvas.drawText("<3 <3 <3", LIVES_WDTH, TEXT_HT, paint);
                break;
        }
        canvas.drawText(username, 10, TEXT_HT, paint);


        handler.postDelayed(runnable, 30);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (!(player.getyCoord() <= y && y <= player.getyCoord() + SPRITE_SIZE)) {
            if (y < player.getyCoord() && action == MotionEvent.ACTION_DOWN) {
                player.moveUp();
                spriteX = player.getxCoord();
                spriteY = player.getyCoord();
            } else if (y > player.getyCoord() && action == MotionEvent.ACTION_DOWN) {
                player.moveDown();
                spriteX = player.getxCoord();
                spriteY = player.getyCoord();
            }
        } else {
            if (x < player.getxCoord() && action == MotionEvent.ACTION_DOWN) {
                player.moveLeft();
                spriteX = player.getxCoord();
                spriteY = player.getyCoord();
            } else if (x > player.getxCoord() && action == MotionEvent.ACTION_DOWN) {
                player.moveRight();
                spriteX = player.getxCoord();
                spriteY = player.getyCoord();
            }
        }

        return true;
    }

    public void drawRow(Canvas canvas, int rowStart, int rowEnd, Bitmap image) {
        for (int row = rowStart; row < rowEnd; row += SPRITE_SIZE) {
            for (int col = 0; col < SCREEN_WIDTH; col += SPRITE_SIZE) {
                canvas.drawBitmap(image, col, row, null);
            }
        }
    }

}
