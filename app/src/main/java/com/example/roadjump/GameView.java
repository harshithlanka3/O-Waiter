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
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    private Bitmap background;
    private Bitmap sprite;
    private Bitmap wood;
    private Bitmap table;
    private Bitmap sushi;
    private Bitmap carpet;
    private Rect rectBackground;
    private Context context;
    private Handler handler;
    private Runnable runnable;
    private float spriteX;
    private float spriteY;

    private int difficulty;

    private Player player;

    private String username;

    private final int spriteSize = 88;
    private final int screenWidth = 1080;

    private final int screenHeight = 1760;

    private final int textHeight = 40;

    private final int livesWidth = 920;

    public GameView(Context context, int spriteNum, int difficulty, String username) {
        super(context);
        this.context = context;
        this.difficulty = difficulty;
        this.username = username;

        switch (spriteNum) {
        case 1:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.pengu);
            sprite = Bitmap.createScaledBitmap(sprite, spriteSize, spriteSize, false);
            break;
        case 2:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.pepe);
            sprite = Bitmap.createScaledBitmap(sprite, spriteSize, spriteSize, false);
            break;
        default:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.maya);
            sprite = Bitmap.createScaledBitmap(sprite, spriteSize, spriteSize, false);
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
        rectBackground = new Rect(0, 0, screenWidth, screenHeight);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        spriteX = screenWidth / 2;
        spriteY = screenHeight;

        player = new Player(spriteX, spriteY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background, null, rectBackground, null);

        drawRow(canvas, 0, spriteSize * 3, wood);
        drawRow(canvas, spriteSize * 3, spriteSize * 7, carpet);
        drawRow(canvas, spriteSize * 7, spriteSize * 8, wood);
        drawRow(canvas, spriteSize * 8, spriteSize * 11, sushi);
        drawRow(canvas, spriteSize * 11, spriteSize * 12, wood);
        drawRow(canvas, spriteSize * 12, spriteSize * 15, sushi);
        drawRow(canvas, spriteSize * 15, spriteSize * 16, wood);
        drawRow(canvas, spriteSize * 16, spriteSize * 20, carpet);
        drawRow(canvas, spriteSize * 20, spriteSize * 22, wood);

        canvas.drawBitmap(table, screenWidth / 2 - spriteSize / 2, spriteSize, null);
        canvas.drawBitmap(sprite, player.getxCoord() - spriteSize / 2, player.getyCoord(), null);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        switch (difficulty) {
        case 1:
            canvas.drawText("<3 <3", livesWidth + 50, textHeight, paint);
            break;
        case 2:
            canvas.drawText("<3", livesWidth + 100, textHeight, paint);
            break;
        default:
            canvas.drawText("<3 <3 <3", livesWidth, textHeight, paint);
            break;
        }
        canvas.drawText(username, 10, textHeight, paint);


        handler.postDelayed(runnable, 30);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (!(player.getyCoord() <= y && y <= player.getyCoord() + spriteSize)) {
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
        for (int row = rowStart; row < rowEnd; row += spriteSize) {
            for (int col = 0; col < screenWidth; col += spriteSize) {
                canvas.drawBitmap(image, col, row, null);
            }
        }
    }

}
