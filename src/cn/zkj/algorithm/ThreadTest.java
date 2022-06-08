package cn.zkj.algorithm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

public class ThreadTest extends Thread {
    String locka;
    String lockb;
    String name;

    public ThreadTest(String name, String a, String b) {
        locka = a;
        lockb = b;
        this.name = name;
    }

    public void run() {
        synchronized (locka) {
            System.out.println(this.name + "执行---持有" + locka);
            try {

                Thread.sleep(4000);
                synchronized (lockb) {
                    System.out.println(this.name + "睡着啦，需要" + lockb);
                }
            } catch (Exception e) {

            }

        }
    }

    public static void main(String[] args) {
//        String s1 = "lockaaa";
//        String s2="lockbbb";
//        ThreadTest t1=new ThreadTest("一号",s1,s2);
//        ThreadTest t2=new ThreadTest("二号",s2,s1);
//        t1.start();
//        t2.start();
//        LocalDate now = LocalDate.now();
//
//        System.out.println(now.getYear());
//        System.out.println(now.getMonthValue());
//        System.out.println(now.plusMonths(-1).lengthOfMonth());

//        LocalDate lastMonthDate = LocalDate.now(); // 上个月
//
//        int i = lastMonthDate.lengthOfMonth();
//        System.out.println(LocalDateTime.of(LocalDate.of(lastMonthDate.getYear(),lastMonthDate.getMonth(),1), LocalTime.MIN));

//        LocalDate of = LocalDate.of(2022, 1, 1);
//
//        System.out.println(of.plusMonths(-1));
//
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        TreeMap<String,String> map = new TreeMap<>();
//        map.tailMap()
        System.out.println(test().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public static LocalDateTime test(){
        LocalDate lastMonthDate = LocalDate.now().plusMonths(-1); // 上个月

        int i = lastMonthDate.lengthOfMonth();

        return LocalDateTime.of(LocalDate.of(lastMonthDate.getYear(),lastMonthDate.getMonth(),i), LocalTime.MAX);
    }
}
