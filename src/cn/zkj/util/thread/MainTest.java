package cn.zkj.util.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/28 17:24
 */
public class MainTest {
    private int i = 500000;

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test02(lock);
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test03(lock);
            }
        },"t2");


        t1.start();
        t2.start();

    }

    public static void test01() throws InterruptedException {
        MainTest m = new MainTest();
        CountDownLatch c = new CountDownLatch(4);
        new Thread(() -> {
            while (m.i>0){
                m.i--;
            }
            c.countDown();
        }).start();
        new Thread(() -> {
            while (m.i>0){
                m.i--;
            }
            c.countDown();
        }).start();
        new Thread(() -> {
            while (m.i>0){
                m.i--;
            }
            c.countDown();
        }).start();
        new Thread(() -> {
            while (m.i>0){
                m.i--;
            }
            c.countDown();
        }).start();
        c.await();

        System.out.println(m.i);
    }

    public static void test02(Object lock){

        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+" enter lock!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            System.out.println(Thread.currentThread().getName()+" leave lock!");
        }
    }

    public static void test03(Object lock){

        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+" enter lock!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            System.out.println(Thread.currentThread().getName()+" leave lock!");
        }
    }
}
