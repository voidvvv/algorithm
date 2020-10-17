package cn.zkj.algorithm;

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
        String s1 = "lockaaa";
        String s2="lockbbb";
        ThreadTest t1=new ThreadTest("一号",s1,s2);
        ThreadTest t2=new ThreadTest("二号",s2,s1);
        t1.start();
        t2.start();
    }
}
