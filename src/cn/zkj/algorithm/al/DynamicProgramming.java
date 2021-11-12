package cn.zkj.algorithm.al;


import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {
    public static void main(String[] args) {
        char a= 'a';
        System.out.println();
        char c = (char) (a + 0);
        String s=""+c;
        System.out.println(s);
    }

    public static void Dynamic(int[] ispace, int[] value, int space) {
        // table[i][j]表示在前i个物品中，能够装入容量为欸j的背包的最大价值
        int[][] table = new int[space + 1][ispace.length + 1];
        //应当将table的首行和首列初始化为0，这里可以省略

        // 动态方程： table[i][j] = max{table[i-1][j],value[i]+table[i-1][space-ispace[i]]}
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                if (ispace[i - 1] <= j) {
                    table[i][j] = Math.max(table[i - 1][j], value[i - 1] + table[i - 1][j - ispace[i - 1]]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table[x].length; y++) {
                System.out.print(table[x][y] + "\t");
            }
            System.out.println();
        }

        System.out.println("最大价值为：" + table[table.length - 1][table[0].length - 1]);

    }

    /**
     * 474. 一和零
     * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
     * <p>
     * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
     * <p>
     * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs 阿斯顿
     * @param m 十大
     * @param n 打发十分
     * @return a
     */
    public int
    findMaxForm( String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        printarray(dp);

        for (String str : strs) {
            int[] zerosones = getZerosones(str);

            for (int one = n;one>=zerosones[1];one--){
                for (int zero =m;zero>=zerosones[0];zero--){

                    dp[zero][one] = Math.max(1+ dp[zero-zerosones[0]][one-zerosones[1]],dp[zero][one]);

                }

            }
            printarray(dp);

        }

        System.out.println(dp[m][n]);
        return dp[m][n];

    }

    private int[] getZerosones(String str) {
        int[] result = new int[2];
        for (int y = 0; y < str.length(); y++)
            result[str.charAt(y) - '0']++;

        return result;
    }

    private void printarray(int[][] dp){
        System.out.println("=============");
        for (int[] a :dp){
            for (int b:a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
        System.out.println("=============");
    }

    /**
     * 300. 最长上升子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int result =1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int x=1;x<nums.length;x++){
            dp[x] = 1;
            for (int y=0;y<x;y++){
                if (nums[x]>nums[y]){
                    dp[x] = Math.max(dp[x],1+dp[y]);
                }

            }
            result = Math.max(result,dp[x]);
        }
        return result;
    }

    /**
     * 787. K 站中转内最便宜的航班
     *
     * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
     *
     * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int price = -1;

        for (int x=0;x<flights.length;x++){
            if (flights[x][0]==src){

            }

        }
        return 0;
    }

    /**
     * 198. 打家劫舍 数组方式
     * @description:
     * @author: Mr.Z
     * @Date: 2020/10/14
       * @param nums
     * @return: int
     * @version : 01
     */
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int n = nums.length;
        // 定义dp数组，按照状态转移方程递推。
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int x=2;x<nums.length;x++){
            dp[x] = Math.max(dp[x-2]+nums[x],dp[x-1]);
        }

        return dp[n-1];
    }

    /**
     * 198. 打家劫舍  O(1)
     * @description:
     * @author: Mr.Z
     * @Date: 2020/10/14
       * @param nums
     * @return: int
     * @version : 01
     */
    public int rob2(int[] nums){
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int n = nums.length;
        int a = 0,b = 0,c = 0;
        for (int i=0;i<n;i++){
            c=Math.max(a,b+nums[i]);

            b = a;
            a = c;
        }
        return c;
    }


    /**
     * 1002. 查找常用字符
     * @description:
     * @author: Mr.Z
     * @Date: 2020/10/14
       * @param A
     * @return: java.util.List<java.lang.String>
     * @version : 01
     */
    public List<String> commonChars(String[] A) {
        int[][] arr= new int[A.length][26];

        for (int x=0;x<A.length;x++){
            int[] t = arr[x];

            String target = A[x];
            char[] chars = target.toCharArray();
            for (Character c:chars){
                t[c-'a'] =  (t[c-'a']+1);
            }

        }
        List<String> result = new ArrayList<>();

        a:for (int x=0;x<26;x++){
            int cc = arr[0][x];
            for (int[] cs:arr){
                cc = Math.min(cc,cs[x]);
            }

            for (int m=0;m<cc;m++){
                result.add(char2String((char)(x+'a')));
            }

        }
        return result;
    }

    public String char2String(char a){
        return ""+a;
    }
}
