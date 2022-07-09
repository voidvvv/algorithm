package cn.zkj.thread;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Classname ThreadMainApp
 * @Description
 * @Date 2022/6/11 17:17
 * @Created by zkj
 */
public class ThreadMainApp {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        lock.lock();;
        readLock.lock();
        writeLock.lock();;
    }
}
