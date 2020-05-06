package se.hkr.grp02.da216b.utilities;

public class Timer {
    private long startTime, stopTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        stopTime = System.nanoTime();
    }

    public long getTime() { return (stopTime - startTime);}

    public String toString() {
        long time = getTime();
        return String.valueOf(time);
    }
}
