package cn.zkj.lk;

/*
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。

 

示例：

输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SortArrayByParityII {

    public static void main(String[] args) {
        SortArrayByParityII s = new SortArrayByParityII();
        System.out.println(s.isEquaParity(2,4));
    }
    public int[] sortArrayByParityII(int[] A) {
        int nj =0;
        int no=0;

        for (int x=0;x<A.length;x++){
            if (!isEquaParity(x,A[x])){
                if (A[x]%2==0){
                    int temp=A[x];
                    A[x]=A[A.length-2-no];
                    A[A.length-2-no]=temp;
                    nj+=2;
                    x--;
                }else {
                    int temp=A[x];
                    A[x]=A[A.length-1-nj];
                    A[A.length-2-nj]=temp;
                    no+=2;
                    x--;
                }
            }

        }
        return A;
    }

    public boolean isEquaParity(int a,int b){
        boolean m=a%2==0;
        boolean n = b%2==0;

        return m==n;
    }
}
