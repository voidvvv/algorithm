package cn.zkj.algorithm;

import java.io.*;

/**
 * 稀疏数组练习
 * 一个11*11的棋盘，只有第2行（下标为1）第三列（下标为2）有值
 * 分别为1  2
 * 其余全为0，将其转为一个稀疏数组
 *
 * 然后再将稀疏数组转为 二维数组
 */

public class SparsearrayDemo {

    private static String pathName = "D:\\develop\\算法\\io\\array.data";
    public static void main(String[] args) throws IOException {
        SparsearrayDemo s = new SparsearrayDemo();
        int[][] arr =new int[11][11];
        arr[1][2]=1;
        arr[2][3]=2;
        int[][] ints = s.array2Sparsearray(arr);
        //写数据
        /*FileOutputStream fos = new FileOutputStream(pathName);
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(fos));
        for (int[] is :ints){
            for (int i:is){
                bf.write(i+"");
                bf.write("\t");
            }
            bf.newLine();
        }
        bf.close();*/

        FileInputStream fis = new FileInputStream(pathName);
        BufferedReader bw =new BufferedReader(new InputStreamReader(fis));

        //读数据
        String ss;
        while ((ss=bw.readLine())!=null){
            String[] s1 = ss.split("\\s");
            for (String intss:s1){
                System.out.println(intss);
            }
        }



    }
    //将二维数组转为稀疏数组
    public int[][] array2Sparsearray(int[][] array){
        int v =0;
        //1.先遍历二维数组，得到所有有效值的数量
        for (int[] is:array){
            for (int i:is){
                if (i!=0){
                    v++;
                }
            }
        }
        //2. 根据v创建二维数组
        int[][] sparse =new int[v+1][3];

        //3. 将二维数组中的有效数据存入稀疏中
        sparse[0][0] = array.length;
        sparse[0][1]=array[1].length;
        sparse[0][2]=v;

        //4. 将二维数组中的有效数据存入稀疏中
        v=0;
        for (int x=0;x<array.length;x++){
            for (int y =0;y<array[1].length;y++){
                if (array[x][y]!=0){
                    v++;
                    sparse[v][0]=x;
                    sparse[v][1]=y;
                    sparse[v][2]=array[x][y];

                }
            }
        }
        return sparse;

    }
    //将系数数组转为二维数组
    public int[][] sparsearray2Array(int[][] array){
        //1. 读取稀疏数组的第一行，根据第一行来创建二维数组
        int[][] arr = new int[array[0][0]][array[0][1]];
        //2. 读取后面的行，给二维数组赋值
        for (int i=1;i<array.length;i++){
            arr[array[i][0]][array[i][1]]=array[i][2];
        }
        return arr;
    }


}
