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
import android.os.SystemClock;
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
    private Bitmap doubleChef;
    private Bitmap rumya;
    private Bitmap rumyarev;
    private Bitmap seen;
    private Rect rectBackground;
    private Context context;
    private Handler handler;
    private Runnable runnable;
    private final int livesWidth = 920;
    private Player player;
    private Vehicle doubleChef1;
    private Vehicle doubleChef2;
    private Vehicle doubleChef3;
    private Vehicle doubleChef4;
    private Vehicle rumya1;
    private Vehicle rumya2;
    private Vehicle seen1;
    private Vehicle seen2;
    private Vehicle seen3;
    private Vehicle seen4;
    private Vehicle seen5;
    private Vehicle seen6;
    private long globalTimer;
    private long lastClicked = 0;

    public GameView(Context context, Player player) {
        super(context);
        this.context = context;
        this.player = player;

        doubleChef1 = new Vehicle(500, player.getSpriteSize() * 2, player.getSpriteSize(),
                0, player.getLowerBound() - player.getSpriteSize());
        doubleChef2 = new Vehicle(500, player.getSpriteSize() * 2, player.getSpriteSize(),
                -8 * player.getSpriteSize(), player.getLowerBound() - player.getSpriteSize());

        doubleChef3 = new Vehicle(500, player.getSpriteSize() * 2, player.getSpriteSize(),
                1080, player.getLowerBound() - 14 * player.getSpriteSize());
        doubleChef4 = new Vehicle(500, player.getSpriteSize() * 2, player.getSpriteSize(),
                20 * player.getSpriteSize(), player.getLowerBound() - 14 * player.getSpriteSize());

        rumya1 = new Vehicle(500,player.getSpriteSize() * 2, player.getSpriteSize(),
                0, player.getLowerBound() - 2 * player.getSpriteSize());
        rumya2 = new Vehicle(500,player.getSpriteSize() * 2, player.getSpriteSize(),
                1080, player.getLowerBound() - 15 * player.getSpriteSize());

        seen1 = new Vehicle(500, player.getSpriteSize(), player.getSpriteSize(),
                0, player.getLowerBound() - 3 * player.getSpriteSize());
        seen2 = new Vehicle(500, player.getSpriteSize(), player.getSpriteSize(),
                -5 * player.getSpriteSize(), player.getLowerBound() - 3 * player.getSpriteSize());
        seen3 = new Vehicle(500, player.getSpriteSize(), player.getSpriteSize(),
                -10 * player.getSpriteSize(), player.getLowerBound() - 3 * player.getSpriteSize());

        switch (player.getImgClicked()) {
        case 1:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.pingu);
            sprite = Bitmap.createScaledBitmap(sprite, player.getSpriteSize(), player.getSpriteSize(), false);
            break;
        case 2:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.narshith);
            sprite = Bitmap.createScaledBitmap(sprite, player.getSpriteSize(), player.getSpriteSize(), false);
            break;
        default:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.podge);
            sprite = Bitmap.createScaledBitmap(sprite, player.getSpriteSize(), player.getSpriteSize(), false);
            break;
        }

        doubleChef = BitmapFactory.decodeResource(getResources(), R.drawable.double_chefs);
        rumya = BitmapFactory.decodeResource(getResources(), R.drawable.rumyachef);
        rumyarev = BitmapFactory.decodeResource(getResources(), R.drawable.rumyachefrev);
        seen = BitmapFactory.decodeResource(getResources(), R.drawable.seen);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.gameplays1background);
        wood = BitmapFactory.decodeResource(getResources(), R.drawable.wood_tile_image);
        table = BitmapFactory.decodeResource(getResources(), R.drawable.table_tile_image);
        sushi = BitmapFactory.decodeResource(getResources(), R.drawable.sushi_belt_tile_image);
        carpet = BitmapFactory.decodeResource(getResources(), R.drawable.carpet_tile_image);

        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        rectBackground = new Rect(0, 0, player.getScreenWidth(), player.getScreenHeight());
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background, null, rectBackground, null);

        drawRow(canvas, 0, player.getSpriteSize() * 3, wood);
        drawRow(canvas, player.getSpriteSize() * 3, player.getSpriteSize() * 7, carpet);
        drawRow(canvas, player.getSpriteSize() * 7, player.getSpriteSize() * 8, wood);
        drawRow(canvas, player.getSpriteSize() * 8, player.getSpriteSize() * 11, sushi);
        drawRow(canvas, player.getSpriteSize() * 11, player.getSpriteSize() * 12, wood);
        drawRow(canvas, player.getSpriteSize() * 12, player.getSpriteSize() * 15, sushi);
        drawRow(canvas, player.getSpriteSize() * 15, player.getSpriteSize() * 16, wood);
        drawRow(canvas, player.getSpriteSize() * 16, player.getSpriteSize() * 20, carpet);
        drawRow(canvas, player.getSpriteSize() * 20, player.getSpriteSize() * 22, wood);

        canvas.drawBitmap(table, player.getScreenWidth() / 2 - player.getSpriteSize() / 2, player.getSpriteSize(), null);
        canvas.drawBitmap(sprite, player.getxCoord() - player.getSpriteSize() / 2, player.getyCoord(), null);
        canvas.drawBitmap(doubleChef, doubleChef1.getxCoord(), doubleChef1.getyCoord(), null);
        canvas.drawBitmap(doubleChef, doubleChef2.getxCoord(), doubleChef2.getyCoord(), null);
        canvas.drawBitmap(doubleChef, doubleChef3.getxCoord(), doubleChef3.getyCoord(), null);
        canvas.drawBitmap(doubleChef, doubleChef4.getxCoord(), doubleChef4.getyCoord(), null);
        canvas.drawBitmap(rumya, rumya1.getxCoord(), rumya1.getyCoord(), null);
        canvas.drawBitmap(rumyarev, rumya2.getxCoord(), rumya2.getyCoord(), null);
        canvas.drawBitmap(seen, seen1.getxCoord(), seen1.getyCoord(), null);
        canvas.drawBitmap(seen, seen2.getxCoord(), seen2.getyCoord(), null);
        canvas.drawBitmap(seen, seen3.getxCoord(), seen3.getyCoord(), null);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        switch (player.getDifficulty()) {
        case 1:
            canvas.drawText("<3 <3", livesWidth + 50, player.getSpriteSize() / 2, paint);
            break;
        case 2:
            canvas.drawText("<3", livesWidth + 100, player.getSpriteSize() / 2, paint);
            break;
        default:
            canvas.drawText("<3 <3 <3", livesWidth, player.getSpriteSize() / 2, paint);
            break;
        }
        canvas.drawText(player.getUsername(), player.getLeftBound(), player.getSpriteSize() / 2, paint);
        canvas.drawText("Score: " + player.getScore(), player.getLeftBound(), player.getSpriteSize(), paint);

        if (!(SystemClock.elapsedRealtime() - globalTimer < 1)) {
            globalTimer = SystemClock.elapsedRealtime();
            doubleChef1.moveRight(2);
            doubleChef2.moveRight(2);
            doubleChef3.moveLeft(2);
            doubleChef4.moveLeft(2);
            rumya1.moveRight(5);
            rumya2.moveLeft(5);
            seen1.moveRight(8);
            seen2.moveRight(8);
            seen3.moveRight(8);
        }

        handler.postDelayed(runnable, 30);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (SystemClock.elapsedRealtime() - lastClicked < 300) {
            return true;
        }

        lastClicked = SystemClock.elapsedRealtime();

        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (!(player.getyCoord() <= y && y <= player.getyCoord() + player.getSpriteSize())) {
            if (y < player.getyCoord() && action == MotionEvent.ACTION_DOWN) {
                player.moveUp();
            } else if (y > player.getyCoord() && action == MotionEvent.ACTION_DOWN) {
                player.moveDown();
            }
        } else {
            if (x < player.getxCoord() && action == MotionEvent.ACTION_DOWN) {
                player.moveLeft();
            } else if (x > player.getxCoord() && action == MotionEvent.ACTION_DOWN) {
                player.moveRight();
            }
        }

        return true;
    }

    public void drawRow(Canvas canvas, int rowStart, int rowEnd, Bitmap image) {
        for (int row = rowStart; row < rowEnd; row += player.getSpriteSize()) {
            for (int col = 0; col < player.getScreenWidth(); col += player.getSpriteSize()) {
                canvas.drawBitmap(image, col, row, null);
            }
        }
    }
}
