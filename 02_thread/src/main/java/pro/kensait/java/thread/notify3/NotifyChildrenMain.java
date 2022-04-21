package pro.kensait.java.thread.notify3;

import static pro.kensait.java.thread.util.ThreadUtil.*;

import java.util.concurrent.CountDownLatch;

public class NotifyChildrenMain {

    public static void main(String[] args) {
        ParentThread parent = new ParentThread();
        parent.start();
    }
}

/* ======================================== */
class ParentThread extends Thread {

    // アクティブな子スレッド数
    private CountDownLatch countDownLatch = new CountDownLatch(3);

    public void run() {
        System.out.println("[ ParentThread ] Start");

        // スレッド1を開始する
        System.out.println("[ ParentThread ] Start child-1");
        ChildThread child1 = new ChildThread(this, "child-1", 5000);
        child1.start();

        // スレッド2を開始する
        System.out.println("[ ParentThread ] Start child-2");
        ChildThread child2 = new ChildThread(this, "child-2", 10000);
        child2.start();

        // スレッド3を開始する
        System.out.println("[ ParentThread ] Start child-3");
        ChildThread child3 = new ChildThread(this, "child-3", 15000);
        child3.start();

        //
        System.out.println("[ ParentThread ] Waiting...");
        try {
            countDownLatch.await();
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        // すべてのスレッドが終了したら、以下を実行する
        System.out.println("[ ParentThread ] Finish, count => " +
                countDownLatch.getCount());
    }

    public void minusChildThreadCount() {
        // 子スレッド数を減らす
        countDownLatch.countDown();
        System.out.println("[ ParentThread ] count => " + countDownLatch.getCount());
    }
}

/* ======================================== */
class ChildThread extends Thread {

    private ParentThread parent;
    private String property;
    private long timer;

    public ChildThread(ParentThread parent, String property, long timer) {
        this.parent = parent;
        this.property = property;
        this.timer = timer;
    }

    public void run() {
        System.out.println("[ ChildThread(" + property + ") ] Start");
        sleepAWhile(timer);
        System.out.println("[ ChildThread(" + property + ") ] Finish");

        // 子スレッドが終了したので、親スレッドが保持する子スレッド数を減らす
        parent.minusChildThreadCount();
    }
}