package pro.kensait.java.thread.immutable;

public class Task extends Thread {

    private SharedObject share;
    private int param;

    public Task(SharedObject share, int param) {
        this.share = share;
        this.param = param;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + " => " + share.getData());
        }
    }
}