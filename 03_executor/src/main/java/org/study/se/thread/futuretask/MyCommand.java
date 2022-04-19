package org.study.se.thread.futuretask;

import java.util.concurrent.Callable;

import org.study.se.thread.util.ThreadUtil;

public class MyCommand implements Callable<String> {

    private String name;

    public MyCommand(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.println("[ MyCommand#run ] Start (" + name + ")");

        // 意図的に3000ミリ秒～20000秒（ランダムに決定）スリープする。
        try {
            ThreadUtil.sleepRandomTime(3000, 20000);
        } catch(RuntimeException re) {
        }

        System.out.println("[ MyCommand#run ] End (" + name + ")");
        return "MyCommand(" + name + ") is finished";
    }

    public String getValue() {
        return name;
    }
}