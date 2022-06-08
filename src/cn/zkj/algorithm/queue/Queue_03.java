package cn.zkj.algorithm.queue;

/**
 * @Classname Queue_03
 * @Description
 * @Date 2022/4/10 19:51
 * @Created by zkj
 */
public class Queue_03 {
    int[] nums ;
    int n ;

    public Queue_03(int n) {
        this.n = n;
        this.nums = new int[n];
    }


    public void check(int c){
        if (c==n){
            return;
        }

        for (int x=0;x<n;x++){
            nums[c] = x;
            if (judge(c)){
                check(c++);
            }
        }
    }

    private boolean judge(int c) {
        for (int x=0;x<n;x++){
            if (nums[x]==nums[n] || Math.abs(nums[x]-nums[n]) == Math.abs(x-n)){
                return false;
            }

        }
        return true;
    }
}
