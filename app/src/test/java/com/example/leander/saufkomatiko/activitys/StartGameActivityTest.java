package com.example.leander.saufkomatiko.activitys;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Leander on 20.02.2017.
 */
@Ignore
public class StartGameActivityTest {

    @Test
    public void stringGetsReturned() throws Exception {
        StartGameActivity activity = new StartGameActivity();

        assertEquals("Mach was", activity.getRandomTask());
    }

}