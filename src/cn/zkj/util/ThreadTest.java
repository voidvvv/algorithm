package cn.zkj.util;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ThreadTest
 * @Description
 * @Date 2022/2/25 20:34
 * @Created by zkj
 */
public class ThreadTest {
    public static void main(String[] args) {
        URI originalUri = URI.create("lb://host-test/asd/fff");
        System.out.println(originalUri.getHost());
    }
}
