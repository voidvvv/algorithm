package cn.zkj.lk;


import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","d");

        list.stream().forEach(n->{
            if (n.equals("c")){
                throw new RuntimeException("a");
            }
            System.out.println(n);

        });
    }
}
