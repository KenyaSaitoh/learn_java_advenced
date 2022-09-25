package pro.kensait.java.advanced.lesson3_1_3.notify;

public class Main {
    public static void main(String[] args) throws Exception {
        // 共有インスタンスを生成する
        Shared shared = new Shared(0);

        // FooThreadを生成し、起動する
        new FooThread(shared).start();

        // BarThreadを生成し、起動する
        new BarThread(shared).start();
    }
}