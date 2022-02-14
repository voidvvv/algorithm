package cn.zkj.lk.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2022/1/27
 * @version: 01
 */
public class DiningPhilosophers {
    private List<ReentrantLock> forkLocks = null;
    private ReentrantLock eatLock ;

    public DiningPhilosophers() {
        forkLocks = Arrays.asList(new ReentrantLock(true),
                new ReentrantLock(true),
                new ReentrantLock(true),
                new ReentrantLock(true),
                new ReentrantLock(true));
        eatLock = new ReentrantLock(true);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        eatLock.lock();
        forkLocks.get(philosopher).lock();
        forkLocks.get((philosopher+1)%5).lock();
        eatLock.unlock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forkLocks.get(philosopher).unlock();
        forkLocks.get((philosopher+1)%5).unlock();
    }
}
