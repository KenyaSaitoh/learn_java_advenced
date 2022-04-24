package pro.kensait.java.lambda.functional.consumer;

import java.util.function.Consumer;

// Consumerを引数に受け取るAPIを新規作成するケース
public class ConsumerMain2 {

    public static void main(String[] args) {
        new ConsumerMain2().process();
    }

    private void process() {
        // コンソールに出力する（Consumerオブジェクトを渡す）
        printSomething("Foo", new Consumer<String>() {
            public void accept(String param) {
                System.out.println(param);
            }
        });

        // コンソールに出力する（ラムダ式を渡す）
        printSomething("Foo", param -> System.out.println(param));

        // コンソールに出力する（メソッド参照を渡す）
        printSomething("Foo", System.out::println);
    }

    private void printSomething(String param, Consumer<String> consumer) {
        consumer.accept(param);
    }
}