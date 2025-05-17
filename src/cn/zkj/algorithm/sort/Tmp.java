package cn.zkj.algorithm.sort;

import static cn.zkj.algorithm.utils.MyPrinter.swap;

public class Tmp {
    private int getPivot0517(int[] nums, int l, int r) {
        while (l < r) {
            while (l < r && nums[r] >= nums[l]) {
                r--;
            }
            swap(nums, l, r);
            while (l < r && nums[l] <= nums[r]) {
                l++;
            }
            swap(nums, l, r);

        }
        return l;
    }
}
