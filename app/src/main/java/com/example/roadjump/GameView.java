package com.example.roadjump;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
    private Bitmap platos;
    private Rect rectBackground;
    private Context context;
    private Handler handler;
    private Runnable runnable;

    private final int livesWidth = 920;
    private Player player;

    private Vehicle[][] vehicles = new Vehicle[8][];
    private Vehicle[] row1 = new Vehicle[2];
    private Vehicle[] row2 = new Vehicle[1];
    private Vehicle[] row3 = new Vehicle[3];
    private Vehicle[] row4 = new Vehicle[1];
    private Vehicle[] row5 = new Vehicle[2];
    private Vehicle[] row6 = new Vehicle[1];
    private Vehicle[] row7 = new Vehicle[3];
    private Vehicle[] row8 = new Vehicle[1];

    private Plate[] plates = new Plate[10];

    private long globalTimer;
    private long lastClicked = 0;

    public GameView(Context context, Player player) {
        super(context);
        this.context = context;
        this.player = player;

        row1[0] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                0, 1);
        row1[1] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                -8 * player.getSpriteSize(),
                 1);
        row4[0] = new Vehicle(player.getSpriteSize() * 3, player.getSpriteSize(),
                -4 * player.getSpriteSize(),
                4);
        row5[0] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                1080, 14);
        row5[1] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                20 * player.getSpriteSize(),
                14);
        row2[0] = new Vehicle(player.getSpriteSize() * 3, player.getSpriteSize(),
                0, 2);
        row6[0] = new Vehicle(player.getSpriteSize() * 3, player.getSpriteSize(),
                1080,  15);
        row8[0] = new Vehicle(player.getSpriteSize() * 3, player.getSpriteSize(),
                1080 + 4 * player.getSpriteSize(),
                 17);
        row3[0] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                0, 3);
        row3[1] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                -5 * player.getSpriteSize(),
                3);
        row3[2] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                -10 * player.getSpriteSize(),
                3);
        row7[0] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                1080, 16);
        row7[1] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                1080 + 5 * player.getSpriteSize(),
                16);
        row7[2] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                1080 + 10 * player.getSpriteSize(),
                 16);

        vehicles[0] = row1;
        vehicles[1] = row2;
        vehicles[2] = row3;
        vehicles[3] = row4;
        vehicles[4] = row5;
        vehicles[5] = row6;
        vehicles[6] = row7;
        vehicles[7] = row8;

        plates[0] = new Plate(player.getSpriteSize() * 3, player.getSpriteSize(),
                0, 6);
        plates[1] = new Plate(player.getSpriteSize() * 3, player.getSpriteSize(),
                player.getScreenWidth() / 2, 7);
        plates[2] = new Plate(player.getSpriteSize() * 3, player.getSpriteSize(),
                player.getScreenWidth(), 8);
        plates[3] =  new Plate(player.getSpriteSize() * 3, player.getSpriteSize(),
                0, 10);
        plates[4] = new Plate(player.getSpriteSize() * 3, player.getSpriteSize(),
                player.getScreenWidth() / 2, 11);
        plates[5] = new Plate(player.getSpriteSize() * 3, player.getSpriteSize(),
                player.getScreenWidth(), 12);

        switch (player.getImgClicked()) {
        case 1:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.pingu);
            sprite = Bitmap.createScaledBitmap(sprite, player.getSpriteSize(),
                    player.getSpriteSize(), false);
            break;
        case 2:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.narshith);
            sprite = Bitmap.createScaledBitmap(sprite, player.getSpriteSize(),
                    player.getSpriteSize(), false);
            break;
        default:
            sprite = BitmapFactory.decodeResource(getResources(), R.drawable.podge);
            sprite = Bitmap.createScaledBitmap(sprite, player.getSpriteSize(),
                    player.getSpriteSize(), false);
            break;
        }

        doubleChef = BitmapFactory.decodeResource(getResources(), R.drawable.double_chefs);
        rumya = BitmapFactory.decodeResource(getResources(), R.drawable.rumyachef);
        rumyarev = BitmapFactory.decodeResource(getResources(), R.drawable.rumyachefrev);
        seen = BitmapFactory.decodeResource(getResources(), R.drawable.seen);
        platos = BitmapFactory.decodeResource(getResources(), R.drawable.plate3);
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
        drawRow(canvas, player.getSpriteSize() * 3,
                player.getSpriteSize() * 7, carpet);
        drawRow(canvas, player.getSpriteSize() * 7,
                player.getSpriteSize() * 8, wood);
        drawRow(canvas, player.getSpriteSize() * 8,
                player.getSpriteSize() * 11, sushi);
        drawRow(canvas, player.getSpriteSize() * 11,
                player.getSpriteSize() * 12, wood);
        drawRow(canvas, player.getSpriteSize() * 12,
                player.getSpriteSize() * 15, sushi);
        drawRow(canvas, player.getSpriteSize() * 15,
                player.getSpriteSize() * 16, wood);
        drawRow(canvas, player.getSpriteSize() * 16,
                player.getSpriteSize() * 20, carpet);
        drawRow(canvas, player.getSpriteSize() * 20,
                player.getSpriteSize() * 22, wood);
        canvas.drawBitmap(table, player.getScreenWidth() / 2 - player.getSpriteSize() / 2,
                player.getSpriteSize(), null);

        canvas.drawBitmap(platos, plates[0].getxCoord(),
                player.getScreenHeight() - player.getSpriteSize() * 6, null);
        canvas.drawBitmap(platos, plates[1].getxCoord(),
                player.getScreenHeight() - player.getSpriteSize() * 7, null);
        canvas.drawBitmap(platos, plates[2].getxCoord(),
                player.getScreenHeight() - player.getSpriteSize() * 8, null);
        canvas.drawBitmap(platos, plates[3].getxCoord(),
                player.getScreenHeight() - player.getSpriteSize() * 10, null);
        canvas.drawBitmap(platos, plates[4].getxCoord(),
                player.getScreenHeight() - player.getSpriteSize() * 11, null);
        canvas.drawBitmap(platos, plates[5].getxCoord(),
                player.getScreenHeight() - player.getSpriteSize() * 12, null);

        canvas.drawBitmap(sprite, player.getxCoord() - player.getSpriteSize() / 2,
                player.getyCoord(), null);

        canvas.drawBitmap(doubleChef, vehicles[0][0].getxCoord(),
                player.getScreenHeight() - 1 * player.getSpriteSize(), null);
        canvas.drawBitmap(doubleChef, vehicles[0][1].getxCoord(),
                player.getScreenHeight() - 1 * player.getSpriteSize(), null);
        canvas.drawBitmap(doubleChef, vehicles[4][0].getxCoord(),
                player.getScreenHeight() - 14 * player.getSpriteSize(), null);
        canvas.drawBitmap(doubleChef, vehicles[4][1].getxCoord(),
                player.getScreenHeight() - 14 * player.getSpriteSize(), null);
        canvas.drawBitmap(rumya, vehicles[1][0].getxCoord(),
                player.getScreenHeight() - 2 * player.getSpriteSize(), null);
        canvas.drawBitmap(rumya, vehicles[3][0].getxCoord(),
                player.getScreenHeight() - 4 * player.getSpriteSize(), null);
        canvas.drawBitmap(rumyarev, vehicles[5][0].getxCoord(),
                player.getScreenHeight() - 15 * player.getSpriteSize(), null);
        canvas.drawBitmap(rumyarev, vehicles[7][0].getxCoord(),
                player.getScreenHeight() - 17 * player.getSpriteSize(), null);

        canvas.drawBitmap(seen, vehicles[2][0].getxCoord(),
                player.getScreenHeight() - 3 * player.getSpriteSize(), null);
        canvas.drawBitmap(seen, vehicles[2][1].getxCoord(),
                player.getScreenHeight() - 3 * player.getSpriteSize(), null);
        canvas.drawBitmap(seen, vehicles[2][2].getxCoord(),
                player.getScreenHeight() - 3 * player.getSpriteSize(), null);
        canvas.drawBitmap(seen, vehicles[6][0].getxCoord(),
                player.getScreenHeight() - 16 * player.getSpriteSize(), null);
        canvas.drawBitmap(seen, vehicles[6][1].getxCoord(),
                player.getScreenHeight() - 16 * player.getSpriteSize(), null);
        canvas.drawBitmap(seen, vehicles[6][2].getxCoord(),
                player.getScreenHeight() - 16 * player.getSpriteSize(), null);



        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        canvas.drawText((player.getDifficulty() == 0 ? "<3" : ""), livesWidth,
                player.getSpriteSize() / 2, paint);
        canvas.drawText((player.getDifficulty() <= 1 ? "<3" : ""), livesWidth + 50,
                player.getSpriteSize() / 2, paint);
        canvas.drawText("<3", livesWidth + 95, player.getSpriteSize() / 2, paint);
        canvas.drawText(player.getUsername(), player.getLeftBound() - player.getSpriteSize(),
                player.getSpriteSize() / 2, paint);
        canvas.drawText("Score: " + player.getScore(),
                player.getLeftBound() - player.getSpriteSize(), player.getSpriteSize(), paint);

        if (!(SystemClock.elapsedRealtime() - globalTimer < 1)) {
            globalTimer = SystemClock.elapsedRealtime();
            vehicles[0][0].moveRight(2, player);
            vehicles[0][1].moveRight(2, player);
            vehicles[4][0].moveLeft(2, player);
            vehicles[4][1].moveLeft(2, player);
            vehicles[1][0].moveRight(5, player);
            vehicles[3][0].moveRight(5, player);
            vehicles[5][0].moveLeft(5, player);
            vehicles[7][0].moveLeft(5, player);
            vehicles[2][0].moveRight(8, player);
            vehicles[2][1].moveRight(8, player);
            vehicles[2][2].moveRight(8, player);
            vehicles[6][0].moveLeft(8, player);
            vehicles[6][1].moveLeft(8, player);
            vehicles[6][2].moveLeft(8, player);

            plates[0].moveRight(4, player);
            plates[1].moveLeft(8, player);
            plates[2].moveRight(4, player);
            plates[3].moveRight(4, player);
            plates[4].moveLeft(8, player);
            plates[5].moveRight(4, player);
        }




        handler.postDelayed(runnable, 20);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /*if (SystemClock.elapsedRealtime() - lastClicked < 150) {
            return true;
        }
        */
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

        checkPlayerStatus();

        return true;
    }

    public void drawRow(Canvas canvas, int rowStart, int rowEnd, Bitmap image) {
        for (int row = rowStart; row < rowEnd; row += player.getSpriteSize()) {
            for (int col = 0; col < player.getScreenWidth(); col += player.getSpriteSize()) {
                canvas.drawBitmap(image, col, row, null);
            }
        }
    }
    private void checkPlayerStatus() {
        //case 1: the player has died.
        if (player.getDifficulty() == 3) {
            Intent newIntent = new Intent(context, GameOverActivity.class);

            String finalScoreStr = String.valueOf(player.getScore());
            newIntent.putExtra("finalScoreStringKey", finalScoreStr);
            newIntent.putExtra("playerDiedKey", 1);

            context.startActivity(newIntent);
        }

        //case 2: the player has reached the goal tile!
        if (player.getRow() == 19
                && player.getxCoord() >= player.getScreenWidth() / 2 - player.getSpriteSize()
                && player.getxCoord() <= player.getScreenWidth() / 2 + player.getSpriteSize()) {

            Intent newIntent = new Intent(context, GameOverActivity.class);

            String finalScoreStr = String.valueOf(player.getScore());
            newIntent.putExtra("finalScoreStringKey", finalScoreStr);
            newIntent.putExtra("playerDiedKey", 0);

            context.startActivity(newIntent);
        }
    }


}
