package cn.zkj.lk.threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/6/27
 * @version: 01
 */
public class ZeroEvenOdd {
    private int n;
    int odd=1;
    int even =2;
    private Semaphore semaphoreZero;
    private Semaphore semaphoreOdd;
    private Semaphore semaphoreEven;
    public ZeroEvenOdd(int n) {
        this.n = n;
        semaphoreZero = new Semaphore(1);
        semaphoreOdd = new Semaphore(0);
        semaphoreEven=new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        semaphoreZero.acquire();
        printNumber.accept(0);
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(even+=2);
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(odd+=2);
    }
}
