package pro.kensait.java.lesson6_1_3.delayed;

public class Main {
    static boolean infoLevel = true;

    public static void main(String[] args) {
        // ログを出力する（ラムダ式を渡す）
        info(() -> "THIS IS INFO LOG.");
    }

    static void info(LogSupplier ls) {
        if (infoLevel) {
            System.out.println("[ INFO ] " + ls.getLog());
        }
    }
}