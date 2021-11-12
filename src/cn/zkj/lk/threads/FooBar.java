package cn.zkj.lk.threads;

import java.util.concurrent.Semaphore;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/6/27
 * @version: 01
 */
public class FooBar {
    private int n;
    private Semaphore semaphoreSecond;
    private Semaphore semaphoreThird;

    public FooBar(int n) {
        this.n = n;
        semaphoreSecond = new Semaphore(1);
        semaphoreThird = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        int a = 2;

        System.out.println(a+=2);
        for (int i = 0; i < n; i++) {
            semaphoreSecond.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreThird.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreThird.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreSecond.release();
        }
    }
}
