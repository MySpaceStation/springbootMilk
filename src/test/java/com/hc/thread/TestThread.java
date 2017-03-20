package com.hc.thread;

import org.junit.Test;

/**
 * Created by milk.huchan on 2017/3/14.
 */
public class TestThread implements Runnable{
    private int count = 15;

    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void out(){

    }

    @Test
    public void test(){
        TestThread t1 = new TestThread();
        new Thread(t1, "A").start();
        new Thread(t1, "B").start();
    }
}
