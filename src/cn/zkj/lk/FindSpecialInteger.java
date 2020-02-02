package cn.zkj.lk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//1287. 有序数组中出现次数超过25%的元素
/*
给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。

请你找到并返回这个整数

 

示例：

输入：arr = [1,2,2,6,6,6,6,7,10]
输出：6
 

提示：

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class FindSpecialInteger {
    public static void main(String[] args) {
        Iterator ii =new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };



    }
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i:arr){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        int result=-1;
        Set<Integer> integers = map.keySet();
        for (Integer integer:integers){
            if ((double)map.get(integer)/(double) arr.length>=arr.length*0.25){
                result=integer;
            }
        }
        return result;
    }

    public int findSpecialInteger2(int[] arr) {
        int count=0;
        int i=arr[0];
        for (int b:arr){
            if (i==b){
                count++;
            }else {
                if ((double)count>=arr.length*0.25){
                    break;
                }else {
                    count=0;
                    i=b;
                }
            }
        }

        return count;


    }
    //此方法是利用了数组的连续性。在解答中找的
    public static int findSpecialInteger3(int[] arr) {
        for (int i = 0, len = arr.length / 4; i < arr.length - len; i++)
            if (arr[i] == arr[i + len])
                return arr[i];
        return arr[0];
    }
}
