package cn.zkj.lk.threads;

import java.util.concurrent.Semaphore;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/6/27
 * @version: 01
 */
public class Foo {
    private Semaphore semaphoreSecond;
    private Semaphore semaphoreThird;

    public Foo() {
        semaphoreSecond = new Semaphore(0);
        semaphoreThird = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphoreSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphoreSecond.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphoreThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphoreThird.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
