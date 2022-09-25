package pro.kensait.java.advanced.lesson3_1_1.sleep;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ SleepMain ] start");
        try {
            Thread.sleep(5000); // 5000ミリ秒間、一時停止
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        System.out.println("[ SleepMain ] Finish");
    }
}