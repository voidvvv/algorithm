package cn.zkj.algorithm.utils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/2/24
 * @version: 01
 */
public class SorterSelector {
    private static List<String> list = Arrays.asList("冒泡","选择","插入","希尔","快速","堆","归并","基数");
    public static void main(String[] args) {
        Random r = new SecureRandom();
        int i = r.nextInt(list.size());
        System.out.println("请写出"+list.get(i)+"排序：");
//        long l = System.currentTimeMillis();

    }
}
