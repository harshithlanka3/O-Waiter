package com.example.roadjump;

public class Collide {
    int playerWH;
    int xCoordPlayer;
    int xPlayerEnd;
    int yPlayerEnd;
    int yCoordPlayer;
    int xCoordPlate;
    int yCoordPlate;
    int plateWidth;
    int plateH;
    int xplateEnd;
    int yplateEnd;

    public Collide(Player player, Plate plate) {
        playerWH = player.getSpriteSize();
        xCoordPlayer = player.getxCoord() - playerWH;
        xPlayerEnd = player.getxCoord() + playerWH;
        yPlayerEnd = player.getyCoord() + playerWH;
        yCoordPlayer = player.getyCoord();

        xCoordPlate = plate.getxCoord();
        yCoordPlate = plate.getyCoord();
        plateWidth = plate.getWidthSprite();
        plateH = plate.getHeightSprite();
        xplateEnd = plate.getxCoord() + plateWidth;
        yplateEnd = plate.getyCoord() + plateH;

        //System.out.println(xPlayerEnd + "xend" +  xCoordPlate + "xplate" +  xCoordPlayer + "xplayer" + xplateEnd + "platend");
        //System.out.println(yPlayerEnd + "yend" +  yCoordPlate + "yplate" +  yCoordPlayer + "yplayer" + yplateEnd + "yplateend");
    }

    public boolean collideWater(Player player) {
        xCoordPlayer = player.getxCoord();
        xPlayerEnd = player.getxCoord() + playerWH;
        yPlayerEnd = player.getyCoord() + playerWH;
        yCoordPlayer = player.getyCoord() + playerWH;
        System.out.println(xCoordPlayer + "X");
        System.out.println(yCoordPlayer + "Y");

        if (xPlayerEnd < xCoordPlate || xCoordPlayer > xplateEnd) {
            //xbounds no match
            //System.out.println(xPlayerEnd + "<" +  xCoordPlate + "||" +  xCoordPlayer + ">" + xplateEnd);
            return false;
        } else if (yCoordPlayer > yplateEnd || yPlayerEnd < yCoordPlate) {
            //ybound no match
            //System.out.println(yPlayerEnd + "<" +  yCoordPlate + "||" +  yCoordPlayer + ">" + yplateEnd);
            return false;
        }
        return true;
    }

//    public boolean collideCar() {
//
//    }
}
