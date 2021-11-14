package cn.zkj.lk.dp;

import cn.zkj.algorithm.utils.MyArraysUtil;
import cn.zkj.algorithm.utils.MyPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 动态规划练习
 * Author: KJ.ZHAO
 * Date: 2021/11/12 15:06
 */
public class DPSolution {

    public static void main(String[] args) {
        DPSolution dp = new DPSolution();
        int l = 10;
//        int[][] grid = new int[l][l];
//        for (int x=0;x<grid.length;x++){
//            grid[x] = MyArraysUtil.newArray(l,30);
//        }

        int[][] grid = {{-37,51,-36,34,-22},
                {82,4,30,14,38},
                {-68,-52,-92,65,-85},
                {-49,-3,-77,8,-19},
                {-60,-71,-21,-62,-73}};

        // [[-37,51,-36,34,-22],[82,4,30,14,38],[-68,-52,-92,65,-85],[-49,-3,-77,8,-19],[-60,-71,-21,-62,-73]]
        System.out.println("before:");
        MyPrinter.printBinaryArray(grid);
        dp.minFallingPathSum03(grid);
    }


    /**
     * 62. 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtwu06/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] maze = new int[m][n];

        for (int x=0;x<m;x++){
            for (int y=0;y<n;y++){

                if (y==0||x==0){
                    maze[x][y] = 1;
                    continue;
                }
                maze[x][y] = maze[x-1][y]+maze[x][y-1];

            }
        }
        return maze[m-1][n-1];
    }


    /**
     * 63. 不同路径 II
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rt1hg6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dy = new int[m][n];

        for (int x=0;x<m;x++){
            for (int y=0;y<n;y++){
                if (obstacleGrid[x][y]==1){
                    continue;
                }
                if (x==0&&y==0){
                    dy[x][y] = 1;
                    continue;
                }
                if (x==0){
                    dy[x][y] = dy[x][y-1];
                    continue;
                }
                if (y==0){
                    dy[x][y] = dy[x-1][y];
                    continue;
                }
                dy[x][y] = dy[x-1][y]+dy[x][y-1];
            }
        }
        return dy[m-1][n-1];
    }

    /**
     * 64. 最小路径和
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][]dy = new int[m][n];
        for (int x=0;x<m;x++){
            for (int y =0;y<n;y++){
                if (x==0&&y==0){
                    dy[0][0] = grid[0][0];
                    continue;
                }
                if (x==0){
                    dy[x][y] = grid[x][y]+dy[x][y-1];
                    continue;
                }
                if (y==0){
                    dy[x][y] = grid[x][y]+dy[x-1][y];
                    continue;
                }
                dy[x][y] = grid[x][y] +  Math.min(dy[x-1][y],dy[x][y-1]);
            }
        }
        return dy[m-1][n-1];
    }

    /**
     * 计算最小路径同时记录路径
     * @param grid
     * @return
     */
    public int minPathSum02(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][]dy = new int[m][n];
        int[][] path = new int[m][n];
        for (int x=0;x<m;x++){
            for (int y =0;y<n;y++){
                if (x==0&&y==0){
                    dy[0][0] = grid[0][0];
                    continue;
                }
                if (x==0){
                    path[x][y] = 1;
                    dy[x][y] = grid[x][y]+dy[x][y-1];
                    continue;
                }
                if (y==0){
                    path[x][y] = 2;
                    dy[x][y] = grid[x][y]+dy[x-1][y];
                    continue;
                }
                if (dy[x-1][y]<dy[x][y-1]){
                    path[x][y] = 2;
                    dy[x][y] = grid[x][y] +dy[x-1][y];
                }else {
                    path[x][y] = 1;
                    dy[x][y] = grid[x][y] +dy[x][y-1];
                }
//                  Math.min(dy[x-1][y],dy[x][y-1]);
            }
        }
        int tx = m-1;
        int ty = n-1;
        Stack<String> stack = new Stack<>();
        while (tx>0||ty>0){
            stack.push("x:"+tx+" - y:"+ty);
            if (path[tx][ty]==1){
                ty--;
            }else if(path[tx][ty]==2){
                tx--;
            }else {
                break;
            }
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
        //aa
        return dy[m-1][n-1];
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtfiiv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> listArray[] = new ArrayList[2];
        int mod = 0;

        for (int x=0;x<triangle.size();x++){
            List<Integer> list = new ArrayList<>();
            List<Integer> integers = triangle.get(x);
            for (int y = 0; y< integers.size(); y++){
                int integer = integers.get(y);
                if (x==0){
                    list.add(integer);
                    continue;
                }
                if (y==0){

                    List<Integer> listTmp = listArray[mod];
                    int t = listTmp.get(0);
                    list.add(t+integer);

                }else if ( y<x){
                    List<Integer> listTmp = listArray[mod];
                    int t1 = listTmp.get(y-1);
                    int t2 = listTmp.get(y);
                    int tz = Math.min(t1,t2);
                    list.add(tz+integer);
                }else {
                    List<Integer> listTmp = listArray[mod];
                    list.add(listTmp.get(y-1)+integer);
                }

            }
            mod= (mod+1) % 2 ;
            listArray[mod] = list;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> listTmp =listArray[mod];
        for (int x=0;x<listTmp.size();x++){
            min = Math.min(min,listTmp.get(x));
        }
        return min;
    }

    /**
     * 931. 下降路径最小和
     *
     * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
     *
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     *
     *  
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/r85adr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;
        for (int x=0;x<n;x++){
            for (int y =0;y<n;y++){
                if (x==0){
                    dp[x][y] = matrix[x][y];

                }else {
                    if (y==0){
                        dp[x][y] = Math.min(dp[x-1][y],dp[x-1][y+1]) + matrix[x][y];
                    }else if (y==n-1){
                        dp[x][y] = Math.min(dp[x-1][y-1],dp[x-1][y]) + matrix[x][y];
                    }else {
                        dp[x][y] = Math.min(Math.min(dp[x-1][y-1],dp[x-1][y]),dp[x-1][y+1]) + matrix[x][y];
                    }

                }
                if (x==n-1){
                    min = Math.min(min,dp[x][y]);
                }
            }
        }
        return min;
    }

    /**
     * 1289. 下降路径最小和 II
     * todo 题意理解错误，应该是每一行任取一个，并不非要是相邻列的
     * 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
     *
     * 请你返回非零偏移下降路径数字和的最小值。
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/r8oh2h/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int minFallingPathSum02(int[][] grid) {
        int n = grid.length;
        if ( n==1){
            return grid[0][0];
        }
        int[][] dp = new int[2][n];
        int mod = 0;
        int modPre = 0;
        int min = Integer.MAX_VALUE;
        for (int x=0;x<n;x++){
            mod = (mod+1)%2;
            for (int y =0;y<n;y++){
                if (x==0){
                    dp[mod][y] = grid[x][y];
                }else if (y==0){
                    dp[mod][y] = dp[modPre][y+1]+grid[x][y];
                }else if (y==n-1){
                    dp[mod][y] = dp[modPre][y-1]+grid[x][y];
                }else {
                    dp[mod][y] = Math.min(dp[modPre][y-1],dp[modPre][y+1])+grid[x][y];
                }
                grid[x][y] = dp[mod][y];
                if (x==n-1){
                    min = Math.min(min, dp[mod][y]);
                }
            }
            System.out.println("第"+(x+1)+"次！");
            MyPrinter.printBinaryArray(grid);
            modPre = mod;

        }
        return min;
    }

    /**
     * 1289. 下降路径最小和 II (重写)
     *
     * 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
     *
     * 请你返回非零偏移下降路径数字和的最小值。
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/r8oh2h/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int minFallingPathSum03(int[][] grid) {
        int n = grid.length;
        if ( n==1){
            return grid[0][0];
        }
        int[][] dp = new int[2][n];
        int mod = 0;
        int[][] minArr = {{Integer.MAX_VALUE,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE}};
        int[][] index ={{-1,-1},{-1,-1}};
        int min = Integer.MAX_VALUE;
        for (int x=0;x<n;x++){
            mod = mod^1;
            minArr[mod^1] = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
            index[mod^1] = new int[]{-1,-1};
            for (int y =0;y<n;y++){
                if (x==0){
                    dp[mod][y] = grid[x][y];

                }else  {
                    dp[mod][y] = (index[mod][0]==y?minArr[mod][1]:minArr[mod][0])  +grid[x][y];
                }
                if (dp[mod][y]<minArr[mod^1][0]){
                    minArr[mod^1][1] = minArr[mod^1][0];
                    index[mod^1][1] = index[mod^1][0];
                    index[mod^1][0] = y;
                    minArr[mod^1][0] = dp[mod][y];
                }else if (dp[mod^1][y]<minArr[mod^1][1]){
                    index[mod^1][1] = y;
                    minArr[mod^1][1] = dp[mod][y];
                }
                grid[x][y] = dp[mod][y];

                if (x==n-1){
                    min = Math.min(min, dp[mod][y]);
                }
            }
            System.out.println("第"+(x+1)+"次！");
            MyPrinter.printBinaryArray(grid);

        }
        return min;
    }
}
