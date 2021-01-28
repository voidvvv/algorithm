package cn.zkj.algorithm.al;

/**
 * @Author: zhaoKaiJie
 * @Description: 力扣八皇后问题
 * @Date: 2020/10/17
 * @version: 01
 */
public class TotalNQueens {
    public int totalNQueens(int n) {
        for (int x=0;x<n;x++){
            int[][] queens = new int[n][n];

            int[] queenOne = queens[0];
            queenOne[x] = 1;

            for (int y=1;y<n;y++){


            }
        }

        return 0;

    }
}
