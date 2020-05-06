package se.hkr.grp02.da216b.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    Timer timer = new Timer();

    @Test
    void startTimer() {
    }

    @Test
    void stopTimer() {
    }

    @Test
    void getTime() {
        try {
            timer.startTimer();
            Thread.sleep(1);
            timer.stopTimer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(1, timer.getTime() / 1000000);
    }

    @Test
    void testToString() {
    }
}