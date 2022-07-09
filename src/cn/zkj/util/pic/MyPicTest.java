package cn.zkj.util.pic;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Classname MyPicTest
 * @Description
 * @Date 2022/6/27 19:54
 * @Created by zkj
 */
public class MyPicTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Timer tm = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("run!!!");
            }
        };

        tm.schedule(task,0,1000);
//        final long curTime = System.currentTimeMillis();
        Thread.sleep(5000);
//        tm.cancel();
//        tm.purge();
        task.cancel();
        tm.purge();
        System.out.println("cancel" + "+purge!");
//        task = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("run!!!");
//            }
//        };
//
//        Thread.sleep(5000);
//        tm.schedule(task,0,1000);
//        System.out.println("schedule!!!");
    }
}
