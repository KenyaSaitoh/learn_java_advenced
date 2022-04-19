package pro.kensait.java.thread.timer;

import static pro.kensait.java.thread.util.ThreadUtil.sleepAWhile;

public class TimerMain {

    boolean stopFlag = false;

    public static void main(String[] args) {
        System.out.println("[ TimerMain ] Start");
        new TimerMain().method();
    }

    private void method() {
        MonitorThread timer = new MonitorThread(this, 10000);
        timer.start();
        while (! stopFlag) {
            sleepAWhile(1000);
            System.out.println("[ TimerMain ] Execute something...");
        }
        System.out.println("[ TimerMain ] Finish");
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }
}

/* ======================================== */
class MonitorThread extends Thread {

    private TimerMain client;
    private long timer;

    public MonitorThread(TimerMain client, long timer) {
        this.client = client;
        this.timer = timer;
    }

    public void run() {
        System.out.println("[ MonitorThread ] Start Watching...");
        sleepAWhile(timer);
        System.out.println("[ MonitorThread ] Timeout!!!");
        client.setStopFlag(true);
    }
}