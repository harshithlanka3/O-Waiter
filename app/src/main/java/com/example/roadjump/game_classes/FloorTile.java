package com.example.roadjump.game_classes;

<<<<<<< Updated upstream
public class FloorTile {
=======
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.roadjump.R;

public class FloorTile extends Tile {
    Bitmap floorTile;
    int tileX, tileY;
    private boolean isSafe = true;
    public boolean getIsSafe() {
        return isSafe;
    }

    public FloorTile(Context context) {
        floorTile = BitmapFactory.decodeResource(context.getResources(), R.drawable.wood_tile_image);
    }


>>>>>>> Stashed changes
}
