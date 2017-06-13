package pl.edu.agh.xp.timer;


public class TimerController {

    private long tStart;

    public void startMonitoringTime() {
        tStart = System.currentTimeMillis();
    }

    public long stopMonitoringTime() {
        long tEnd = System.currentTimeMillis();
        long result = tEnd - tStart;
        if (result >= 0) {
            return result/1000;
        }
        return -1;
    }

    public String formTime(long timeInSecs) {
        long minutes = timeInSecs / 60;
        long sec = timeInSecs % 60;
        return minutes + ":" + sec;
    }
}
