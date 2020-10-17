package cn.zkj.lk.sctruction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComTest1 implements Comparable {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public ComTest1(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "ComTest1{" +
                "i=" + i +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof  ComTest1){
            return i-((ComTest1) o).i;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<ComTest1> list = new ArrayList<>();

        list.add(new ComTest1(20));
        list.add(new ComTest1(100));
        list.add(new ComTest1(1));
        list.add(new ComTest1(13));
        list.add(new ComTest1(10));
        list.add(new ComTest1(9));

        Collections.sort(list);
        System.out.println(list);
    }
}
