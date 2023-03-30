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
    private Bitmap platos;
    private Rect rectBackground;
    private Context context;
    private Handler handler;
    private Runnable runnable;
    private final int livesWidth = 920;
    private Player player;

    private Vehicle[] vehicles = new Vehicle[14];

    private Plate[] plates = new Plate[6];
  
    private long globalTimer;
    private long lastClicked = 0;

    public GameView(Context context, Player player) {
        super(context);
        this.context = context;
        this.player = player;

        vehicles[0] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                0, player.getLowerBound() - player.getSpriteSize());
        vehicles[1] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                -8 * player.getSpriteSize(),
                player.getLowerBound() - player.getSpriteSize());
        vehicles[6] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                -4 * player.getSpriteSize(),
                player.getLowerBound() - 4 * player.getSpriteSize());
        vehicles[7] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                1080, player.getLowerBound() - 14 * player.getSpriteSize());
        vehicles[8] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                20 * player.getSpriteSize(),
                player.getLowerBound() - 14 * player.getSpriteSize());
        vehicles[2] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                0, player.getLowerBound() - 2 * player.getSpriteSize());
        vehicles[9] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                1080, player.getLowerBound() - 15 * player.getSpriteSize());
        vehicles[13] = new Vehicle(player.getSpriteSize() * 2, player.getSpriteSize(),
                1080 + 4 * player.getSpriteSize(),
                player.getLowerBound() - 17 * player.getSpriteSize());
        vehicles[3] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                0, player.getLowerBound() - 3 * player.getSpriteSize());
        vehicles[4] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                -5 * player.getSpriteSize(),
                player.getLowerBound() - 3 * player.getSpriteSize());
        vehicles[5] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                -10 * player.getSpriteSize(),
                player.getLowerBound() - 3 * player.getSpriteSize());
        vehicles[10] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                1080, player.getLowerBound() - 16 * player.getSpriteSize());
        vehicles[11] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                1080 + 5 * player.getSpriteSize(),
                player.getLowerBound() - 16 * player.getSpriteSize());
        vehicles[12] = new Vehicle(player.getSpriteSize(), player.getSpriteSize(),
                1080 + 10 * player.getSpriteSize(),
                player.getLowerBound() - 16 * player.getSpriteSize());

        // CREATING THE PLATES
        plates[0] = new Plate(player.getSpriteSize() * 2, player.getSpriteSize(),
                player.getScreenWidth() / 2 - 44, player.getScreenHeight() / 2);
        plates[1] = new Plate(player.getSpriteSize() * 2, player.getSpriteSize(),
                player.getScreenWidth() / 2 - 44, player.getScreenHeight() / 2 - player.getSpriteSize());
        plates[2] = new Plate(player.getSpriteSize() * 2, player.getSpriteSize(),
                player.getScreenWidth() / 2 - 44, player.getScreenHeight() / 2 - 2 * player.getSpriteSize());
        plates[3] = new Plate(player.getSpriteSize() * 2, player.getSpriteSize(),
                player.getScreenWidth() / 2 + 132, player.getScreenHeight() / 2 + 2 * player.getSpriteSize());
        plates[4] = new Plate(player.getSpriteSize() * 2, player.getSpriteSize(),
                player.getScreenWidth() / 2 + 132, player.getScreenHeight() / 2 + 3 * player.getSpriteSize());
        plates[5] = new Plate(player.getSpriteSize() * 2, player.getSpriteSize(),
                player.getScreenWidth() / 2 + 132, player.getScreenHeight() / 2 + 4 * player.getSpriteSize());
        //PLATES HAVE BEEN CREATED

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
        platos = BitmapFactory.decodeResource(getResources(), R.drawable.plate);
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
        canvas.drawBitmap(sprite, player.getxCoord() - player.getSpriteSize() / 2,
                player.getyCoord(), null);
      
        canvas.drawBitmap(doubleChef, vehicles[0].getxCoord(), vehicles[0].getyCoord(), null);
        canvas.drawBitmap(doubleChef, vehicles[1].getxCoord(), vehicles[1].getyCoord(), null);
        canvas.drawBitmap(doubleChef, vehicles[7].getxCoord(), vehicles[7].getyCoord(), null);
        canvas.drawBitmap(doubleChef, vehicles[8].getxCoord(), vehicles[8].getyCoord(), null);
        canvas.drawBitmap(rumya, vehicles[2].getxCoord(), vehicles[2].getyCoord(), null);
        canvas.drawBitmap(rumya, vehicles[6].getxCoord(), vehicles[6].getyCoord(), null);
        canvas.drawBitmap(rumyarev, vehicles[9].getxCoord(), vehicles[9].getyCoord(), null);
        canvas.drawBitmap(rumyarev, vehicles[13].getxCoord(), vehicles[13].getyCoord(), null);

        canvas.drawBitmap(seen, vehicles[3].getxCoord(), vehicles[3].getyCoord(), null);
        canvas.drawBitmap(seen, vehicles[4].getxCoord(), vehicles[4].getyCoord(), null);
        canvas.drawBitmap(seen, vehicles[5].getxCoord(), vehicles[5].getyCoord(), null);
        canvas.drawBitmap(seen, vehicles[10].getxCoord(), vehicles[10].getyCoord(), null);
        canvas.drawBitmap(seen, vehicles[11].getxCoord(), vehicles[11].getyCoord(), null);
        canvas.drawBitmap(seen, vehicles[12].getxCoord(), vehicles[12].getyCoord(), null);

        canvas.drawBitmap(platos, plates[0].getxCoord(), plates[0].getyCoord(), null);
        canvas.drawBitmap(platos, plates[1].getxCoord(), plates[1].getyCoord(), null);
        canvas.drawBitmap(platos, plates[2].getxCoord(), plates[2].getyCoord(), null);
        canvas.drawBitmap(platos, plates[3].getxCoord(), plates[3].getyCoord(), null);
        canvas.drawBitmap(platos, plates[4].getxCoord(), plates[4].getyCoord(), null);
        canvas.drawBitmap(platos, plates[5].getxCoord(), plates[5].getyCoord(), null);


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
        canvas.drawText(player.getUsername(), player.getLeftBound() - player.getSpriteSize(),
                player.getSpriteSize() / 2, paint);
        canvas.drawText("Score: " + player.getScore(),
                player.getLeftBound() - player.getSpriteSize(), player.getSpriteSize(), paint);

        if (!(SystemClock.elapsedRealtime() - globalTimer < 1)) {
            globalTimer = SystemClock.elapsedRealtime();
            vehicles[0].moveRight(2);
            vehicles[1].moveRight(2);
            vehicles[7].moveLeft(2);
            vehicles[8].moveLeft(2);
            vehicles[2].moveRight(5);
            vehicles[6].moveRight(5);
            vehicles[9].moveLeft(5);
            vehicles[3].moveRight(8);
            vehicles[4].moveRight(8);
            vehicles[5].moveRight(8);
            vehicles[10].moveLeft(8);
            vehicles[11].moveLeft(8);
            vehicles[12].moveLeft(8);
            vehicles[13].moveLeft(5);
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
