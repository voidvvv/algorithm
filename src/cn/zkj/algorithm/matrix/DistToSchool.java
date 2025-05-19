package cn.zkj.algorithm.matrix;

import java.util.Comparator;
import java.util.TreeSet;

public class DistToSchool {

    public int calculate (int n, int[] dist, int[] juice, int distance, int initialEnergy) {
        int ans = 0;
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // sort by juice quality. the last one is the max quality one
                return juice[o1] - juice[o2];
            }
        });

        int cur = 0;
        int i = 0; // now, the count of passed juice
        int lastEnergy = initialEnergy;
        while (cur < distance) {
            cur += lastEnergy;
            lastEnergy = 0;
            for (int x = i; x< n; x++) {
                if (dist[x] <= cur) {
                    i++;
                    treeSet.add(x);
                }
            }
            if (cur < distance) {
                // try to drink
                if (treeSet.isEmpty()) {
                    return -1;
                }
                Integer juiceNeed = treeSet.pollLast();
                cur += juice[juiceNeed];
                ans++;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        DistToSchool e = new DistToSchool();
        int calculate = e.calculate(4, new int[]{5, 7, 8, 10}, new int[]{2, 3, 1, 5}, 15, 5);
        System.out.println(calculate);
    }
}
