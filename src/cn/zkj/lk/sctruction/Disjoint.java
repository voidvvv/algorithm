package cn.zkj.lk.sctruction;

import java.util.Arrays;

/**
 * @Author: zhaoKaiJie
 * @Description: 并查集
 * @Date: 2021/1/28
 * @version: 01
 */
public class Disjoint {
    public static void main(String[] args) {
        Disjoint d= new Disjoint(7);
        System.out.println(d);

        d.merge(2,3);
        d.merge(5,3);
        boolean relative1 = d.relative(1, 2);
        boolean relative = d.relative(2, 5);
        System.out.println(relative1);
        System.out.println(relative);
        System.out.println(d);
    }

    private int [] pre;
    private int [] rank;
    private int size;

    public Disjoint(int size){
        pre = new int[size];
        rank = new int[size];
        this.size = size;

        for (int x=0;x<pre.length;x++){
            pre[x] = x;
        }
    }

    public Disjoint(){
        this(20);
    }

    public int preFind(int x){
        if (pre[x]==x){
            return x;
        }

        return pre[x] = preFind(pre[x]);
    }

    @Override
    public String toString() {
        return "Disjoint{" +
                "pre=" + Arrays.toString(pre) +
                ", rank=" + Arrays.toString(rank) +
                '}';
    }

    public void merge(int x, int y){
        int xF = preFind(x);
        int yF = preFind(y);

        if (xF!=yF){
            if (rank[xF]>rank[yF]){
                pre[yF] = xF;
            }else {
                if (rank[xF]==rank[yF]){
                    pre[yF] = xF;
                    rank[xF]++;
                }else {
                    pre[xF] = yF;
                }
            }
        }
    }

    public boolean relative(int x,int y){
        int i = preFind(x);
        int i1 = preFind(y);
        return i==i1;
    }
}
