package com.example.roadjump;

import static com.example.roadjump.game_classes.CheckValidity.checkValidity;

import org.junit.Before;
import org.junit.Test;
import android.os.Looper;

import static org.junit.Assert.*;

import android.widget.EditText;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SelectTest {

    private String emptyString;
    private String nullString;
    private String normalString;

    @Before
    public void setup() {
        emptyString = "";
        nullString = null;
        normalString = "pinguThePenguino";

    }

    //test1: moving forward
    @Test
    public void testNullSpace() {
        assertFalse(checkValidity(nullString));
    }

    //test2: moving backwards
    @Test
    public void emptyString() {
        assertFalse(checkValidity(emptyString));
    }

    @Test
    public void normalString() {
        assertTrue(checkValidity(normalString));
    }


}