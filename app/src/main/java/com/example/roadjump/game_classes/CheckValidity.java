package com.example.roadjump.game_classes;

public class CheckValidity {

    public static boolean checkValidity(String username) {
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return username.length() != 0;
        }
    }
}
