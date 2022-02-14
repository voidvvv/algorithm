package cn.zkj.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 * Author: KJ.ZHAO
 * Date: 2021/11/11 13:23
 */
public class MyTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(null);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
    }
}
