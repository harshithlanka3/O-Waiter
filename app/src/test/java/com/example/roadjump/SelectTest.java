package com.example.roadjump;

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

    private Player sample;

    @Before
    public void setup() {
        emptyString = "";
        nullString = null;
        normalString = "pinguThePenguino";
        sample = new Player();
    }

    //test1: moving forward
    @Test
    public void testNullSpace() {
        assertFalse(sample.checkValidity(nullString));
    }

    //test2: moving backwards
    @Test
    public void emptyString() {
        assertFalse(sample.checkValidity(emptyString));
    }

    @Test
    public void normalString() {
        assertTrue(sample.checkValidity(normalString));
    }


}