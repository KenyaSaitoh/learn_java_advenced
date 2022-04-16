package pro.kensait.java.pattern.thread.notify;

import pro.kensait.java.thread.util.ThreadUtil;

public class SharedObject {

    private int data = 0;

    public synchronized int readProcess() {
        System.out.println("[ SharedObject#readProcess ] Start / data ---> " + data);

        try {
            // ロックを解放し、ウェイトセットに入る。
            System.out.println("[ SharedObject#readProcess ] Waiting for WriteProcess...");
            wait();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println("[ SharedObject#readProcess ] End / data ---> " + data);
        return data;
    }

    public synchronized void writeProcess() {
        System.out.println("[ SharedObject#writeProcess ] Start");

        // 意図的に5000ミリ秒スリープする。
        ThreadUtil.sleepAWhile(5000);

        // dataフィールドに値を書き込む。
        data = 10;

        // ReadThreadに通知を送る。
        System.out.println("[ SharedObject#writeProcess ] Notify to ReadProcess");
        notifyAll();

        System.out.println("[ SharedObject#writeProcess ] End / data ---> " + data);
    }
}
