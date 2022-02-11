package cn.zkj.algorithm;

public class Maze {
    public static void main(String[] args) throws InterruptedException {
        //迷宫由int的二维数组组成，其中，0代表未走过，1代表墙，2代表已走过，3代表已走过并标为的死路
        int[][] map = new int[8][7];

        for (int x=0;x<7;x++){
            //将迷宫上下两行设为墙
            map[0][x]=1;
            map[7][x]=1;
        }
        for (int x=1;x<8;x++){
//            将迷宫左右设为墙
            map[x][0]=1;
            map[x][6]=1;
        }
        //添加障碍
        map[3][1]=1;
        map[3][2]=1;
        for (int x=0;x<8;x++){
            for (int y=0;y<7;y++){
                System.out.print(map[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println("------------");
        Maze maze = new Maze();
        boolean b = maze.solveMaze(map, 1, 2);
        System.out.println(b);

        for (int x=0;x<8;x++){
            for (int y=0;y<7;y++){
                System.out.print(map[x][y]+" ");
            }
            System.out.println();
        }
    }


    public boolean solveMaze(int[][]map ,int x,int y) throws InterruptedException {
        if (map[6][5]==2){
            return true;
        }else if (map[x][y]==0){
            map[x][y]=2;
            if (map[6][5]==2){
                return true;
            }
            //移动策略：上下左右
            if (solveMaze(map,x-1,y)){
                System.out.println("向上走了:"+(x-1)+","+y);
                for (int m=0;m<8;m++){
                    for (int n=0;n<7;n++){
                        System.out.print(map[m][n]+" ");
                    }
                    System.out.println();
                }
                Thread.sleep(1000);
                return true;
            }else if (solveMaze(map,x+1,y)){
                System.out.println("向下走了:"+(x+1)+","+y);
                Thread.sleep(1000);
                for (int m=0;m<8;m++){
                    for (int n=0;n<7;n++){
                        System.out.print(map[m][n]+" ");
                    }
                    System.out.println();
                }
                return true;
            }else if (solveMaze(map,x,y-1)){
                System.out.println("向左走了:"+x+","+(y-1));
                for (int m=0;m<8;m++){
                    for (int n=0;n<7;n++){
                        System.out.print(map[m][n]+" ");
                    }
                    System.out.println();
                }
                Thread.sleep(1000);
                return true;
            }else if (solveMaze(map,x,y+1)){
                System.out.println("向右走了:"+x+","+(y+1));
                for (int m=0;m<8;m++){
                    for (int n=0;n<7;n++){
                        System.out.print(map[m][n]+" ");
                    }
                    System.out.println();
                }
                Thread.sleep(1000);
                return true;
            }else {
                map[x][y]=3;
                //System.out.println("死路，完蛋了:"+x+","+y);
                for (int m=0;m<8;m++){
                    for (int n=0;n<7;n++){
                        System.out.print(map[m][n]+" ");
                    }
                    System.out.println();
                }
                Thread.sleep(1000);
                return false;
            }
        }else {
            //System.out.println("这里是哪里，迷路了啊:"+x+","+y);
            for (int m=0;m<8;m++){
                for (int n=0;n<7;n++){
                    System.out.print(map[m][n]+" ");
                }
                System.out.println();
            }
            Thread.sleep(1000);
            return false;
        }
    }
}
