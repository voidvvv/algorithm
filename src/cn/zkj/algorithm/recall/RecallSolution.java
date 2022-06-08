package cn.zkj.algorithm.recall;

import java.util.List;

/**
 * @Classname RecallSolution
 * @Description 回溯
 * @Date 2022/4/24 19:09
 * @Created by zkj
 */
public class RecallSolution {
    static int COUNT=0;
    public static void printArray(int[][] array){
        for (int x=0;x<array.length;x++){
            for (int y =0;y<array[x].length;y++){
                System.out.print(array[x][y]+"\t");
            }
            System.out.println();
        }
        System.out.println("============================");
    }

    static String regex = "^[A-Z]{2,4}\\s[0-9]{8}$";

    public static void main(String[] args) {
        RecallSolution r1 = new RecallSolution();
        long start = System.currentTimeMillis();
        int[][] ints = r1.knightTraverse(8, 8, 3, 1);
        long end = System.currentTimeMillis();
        System.out.printf("共耗时: %s 毫秒",end-start);
        System.out.println();
        printArray(ints);

    }

    /**
     * 骑士周游问题
     * @param row
     * @param col
     * @param x
     * @param y
     * @return
     */
    int[][] dirs = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
    public int[][] knightTraverse(int row,int col,int x,int y){
        int[][] res = new int[row][col];

        knightTraverseRecall(res,y,x,1);
        return res;
    }

    private boolean knightTraverseRecall(int[][] res, int y, int x, int i) {
        res[y][x] = i;
//        System.out.println(COUNT++);
//        System.out.println(i);
//        printArray(res);
        if (i==res.length*res[0].length){
            for(int[] dir:dirs){
                if (couldReachOffset(res,y+dir[0],x+dir[1])){
                    printArray(res);
                    return true;
                }
            }
            res[y][x] = 0;
            printArray(res);
            return false;
        }


        for(int[] dir:dirs){
//            if (i==1){
////                System.out.println("dir: "+Arrays.toString(dir));
//            }


            if(walkable(res,y+dir[0],x+dir[1]) && knightTraverseRecall(res,y+dir[0],x+dir[1],i+1)){

                return true;
            }
        }



        res[y][x] = 0;
        return false;
    }

    private void sort(List<PointCountMap> greedyList) {
        greedyList.sort((a,b)->b.count-a.count);
    }

    class PointCountMap{
        int[] arr;
        int count;

        public PointCountMap(int[] arr, int count) {
            this.arr = arr;
            this.count = count;
        }
    }

    private boolean walkable(int[][] res, int y, int x) {
        if (y<0 || x<0 || y>=res.length || x>=res[0].length){
            return false;
        }
        return res[y][x] == 0;
    }

    private boolean couldReachOffset(int[][] res, int y, int x){
        if (y<0 || x<0 || y>=res.length || x>=res[0].length){
            return false;
        }
        return res[y][x] == 1;
    }


}
