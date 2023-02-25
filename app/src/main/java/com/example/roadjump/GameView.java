package com.example.roadjump;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    Bitmap background, sprite, wood, table, sushi, carpet;
    Rect rectBackground, rectSprite, rectWood, rectTable, rectSushi, rectCarpet;
    Context context;
    Handler handler;
    Runnable runnable;
    static int dWidth, dHeight;
    float spriteX, spriteY;
    float oldX;
    float oldSpriteX;

    public GameView(Context context) {
        super(context);
        this.context = context;
        background = BitmapFactory.decodeResource(getResources(), R.drawable.gameplays1background);
        sprite = BitmapFactory.decodeResource(getResources(), R.drawable.wood_tile_image); // needs to be changed
        wood = BitmapFactory.decodeResource(getResources(), R.drawable.wood_tile_image);
        table = BitmapFactory.decodeResource(getResources(), R.drawable.table_tile_image);
        sushi = BitmapFactory.decodeResource(getResources(), R.drawable.sushi_belt_tile_image);
        carpet = BitmapFactory.decodeResource(getResources(), R.drawable.carpet_tile_image);

        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = 2000;
        rectBackground = new Rect(0, 0, dWidth, dHeight);
        rectSprite = new Rect(dWidth / 2, dHeight / 2, dWidth / 2 + 50, dHeight / 2 + 50);
        rectWood = new Rect(dWidth / 2, dHeight / 2, dWidth / 2 + 50, dHeight / 2 + 50);
        rectTable = new Rect(dWidth / 2, dHeight / 2, dWidth / 2 + 50, dHeight / 2 + 50);
        rectSushi = new Rect(dWidth / 2, dHeight / 2, dWidth / 2 + 50, dHeight / 2 + 50);
        rectCarpet = new Rect(dWidth / 2, dHeight / 2, dWidth / 2 + 50, dHeight / 2 + 50);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        spriteX = dWidth / 2;
        spriteY = dHeight * 7 / 8;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background, null, rectBackground, null);

        drawRow(canvas, 0, 100, wood);
        drawRow(canvas, 100, 300, carpet);
        drawRow(canvas, 300, 500, wood);
        drawRow(canvas, 500, 650, sushi);
        drawRow(canvas, 650, 800, wood);
        drawRow(canvas, 800, 950, carpet);
        drawRow(canvas, 950, 1200, wood);
        drawRow(canvas, 1200, 1450, sushi);
        drawRow(canvas, 1450, 1550, wood);
        drawRow(canvas, 1550, 1650, carpet);
        drawRow(canvas, 1650, 2000, wood);

        canvas.drawBitmap(table, dWidth / 2 - 44, 0, null);
        //canvas.drawBitmap(sprite, spriteX, spriteY, null);
        handler.postDelayed(runnable, 30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        if (touchY >= spriteY) {
            int action = event.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                oldX = event.getX();
                oldSpriteX = spriteX;
            }
            if (action == MotionEvent.ACTION_MOVE) {
                float shift = oldX - touchX;
                float newSpriteX = oldSpriteX - shift;
                if (newSpriteX <= 0) {
                    spriteX = 0;
                } else if (newSpriteX >= dWidth - sprite.getWidth()) {
                    spriteX = dWidth - sprite.getWidth();
                } else {
                    spriteX = newSpriteX;
                }
            }
        }
        return true;
    }

    public void drawRow(Canvas canvas, int rowStart, int rowEnd, Bitmap image) {
        for (int row = rowStart; row < rowEnd; row += 88) {
            for (int col = 0; col < 1080; col += 88) {
                canvas.drawBitmap(image, col, row, null);
            }
        }
    }
}
