package cn.zkj.lk;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname NewSolution
 * @Description
 * @Date 2022/4/27 21:34
 * @Created by zkj
 */
public class NewSolution {
    public static void printArray(int[][] arr){
        for(int y =0;y<arr.length;y++){
            for(int x=0;x<arr[y].length;x++){
                System.out.print(arr[y][x]+"\t");
            }
            System.out.println();
        }
        System.out.println("================");
    }
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] visit = new int[heights.length][heights[0].length];
        List<List<Integer>> ans = new ArrayList<>();

        // 1 上左  2 下右
        for(int y=0;y<heights.length;y++){
            for(int x=0;x<heights[0].length;x++){
                if(x==0 || y==0  ){
                    callBack(y,x,visit,heights,1);
                }
                if (x==heights[0].length-1 || y== heights.length -1){
                    callBack(y,x,visit,heights,2);
                }
            }
            printArray(visit);
        }

        for(int y=0;y<heights.length;y++){
            for(int x=0;x<heights[0].length;x++){
                if(visit[y][x] == 3){
                    ans.add(Arrays.asList(y,x));
                }
            }
        }

        return ans;
    }

    public void callBack(int y,int x,int[][] visit,int[][] heights,int cur){
        if(y<0 || x<0 || y>= heights.length || x>=heights[0].length){
            return ;
        }
        if(visit[y][x] == cur){
            return ;
        }

        visit[y][x]|=cur;

        cur = visit[y][x];

        for(int[] dir :dirs){
            if(callBackAble(y,x,dir,visit,heights)){
                callBack(y,x,visit,heights,cur);
            }
        }
    }

    public boolean callBackAble(int y,int x,int[] dir,int[][] visit,int[][] heights){
        int tmpY = y+dir[0];
        int tmpX = x+dir[1];

        if(tmpY<0 || tmpX <0 || tmpY>=heights.length || tmpX>=heights[0].length){
            return false;
        }

        return heights[y][x] <= heights[tmpY][tmpX];
    }

    public static void main(String[] args) {

    }

//    private static int[][] generateArray2(String s) {
//        JSONArray objects = JSONObject.parseArray(s);
//
//        int size = objects.size();
//        int[][] tmp = new int[size][];
//        for(int x=0;x<size;x++){
//            JSONArray jsonArray = objects.getJSONArray(x);
//            tmp[x] = new int[jsonArray.size()];
//            Iterator<Object> iterator = jsonArray.stream().iterator();
//            int i =0;
//            while (iterator.hasNext()){
//                tmp[x][i++]=(Integer) iterator.next();
//            }
//        }
//        return tmp;
//    }
}
