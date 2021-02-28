package cn.zkj.algorithm.sort;


import cn.zkj.algorithm.utils.MyPrinter;

public class ShellSort {
    public static void main(String[] args) {
        ShellSort s= new ShellSort();

        MyPrinter.printDefaultArrays(s::shellSort10);


    }

    //希尔排序12.8
    public void shellSort(int[] arr){

        int m=2;//
        //以m个为一组，算出组数，向下取整，组数也为步数
        int n=arr.length/2;
//        int temp=0;
        while (n>0){
            //遍历所有组，以索引n处为基准，一直到n-1，就可视为遍历了所有组

            for (int x=n;x<(n*2);x++){
                /*for (int y=x;y<arr.length;y+=n){
                    if (arr[y-n]>arr[y]){
                        temp=arr[y];
                        arr[y]=arr[y-n];
                        arr[y-n]=temp;
                    }
                }*/
//          此时，开始循环第x-n+1 组， 将index1初始值设置为x，这样index1进行加减n的得到的都是本组内的数，可以进行插入排序
                int index1=x;
//                先判断index1，以防溢出
                while (index1<arr.length){
//                    将index前一位的索引取出，用以比较
                    int insertIndex=index1-n;
                    int insertVal=arr[index1];
                    while (insertIndex>=0&&insertVal<arr[insertIndex]){
                        arr[insertIndex+n]=arr[insertIndex];
                        insertIndex=insertIndex-n;
                    }
                    arr[insertIndex+n]=insertVal;
                    index1=index1+n;
                }

            }

            n=n/2;
        }

    }
    //2019.12.9自己写的希尔排序，每日一遍
    public void shellSort2(int[] arr){
        int n=arr.length/2;

        while (n>0){
            for (int x=n;x<n*2;x++){

                for (int y=x;y<arr.length;y+=n){

                    int val=arr[y];
                    int index =y-n;

                    while (index>=0&&arr[index]>val){
                        arr[index+n]=arr[index];
                        index=index-n;
                    }
                    arr[index+n]=val;

                }

            }
            n=n/2;
        }
    }
    //2019.12.10自己写的希尔排序，每日一遍
    public void shellSort3(int [] arr){
        //按两个一组来分
        int n =arr.length/2;

        while (n>0){
            for (int x=n;x<n*2;x++){
                for (int y=x;y<arr.length;y+=n){
                    int index =y-n;
                    int val = arr[y];
                    while (index>=0&&arr[index]>val){
                        arr[index+n]=arr[index];
                        index-=n;
                    }
                    arr[index+n]=val;

                }
            }
            n/=2;
        }

    }

    //2019.12.11
    public void shellSort4(int [] arr){
        //分组
        int n =arr.length/2;

        while (n>0){
            for (int x=n;x<n*2;x++){
                for (int i=x;i<arr.length;i+=n){
                    int val=arr[i];
                    int index=i-n;
                    while (index>=0&&arr[index]>val){
                        arr[index+n]=arr[index];
                        index-=n;
                    }
                    arr[index+n]=val;
                }

            }
            n=n/2;
        }
    }
    //2019.12.13
    public void shellSort5(int[]arr){
        int n =arr.length/2;
        while (n>0){
            for (int x=n;x<n*2;x++){
                for (int y =x;y<arr.length;y+=n){
                    int val = arr[y];
                    int index=y-n;
                    while (index>=0&&arr[index]>val){
                        arr[index+n]=arr[index];
                        index-=n;
                    }
                    arr[index+n]=val;
                }
            }
            n/=2;
        }
    }

    public void shellSort6(int[]arr){
        int n=arr.length/2;

        while (n>0){
            for (int x=n;x<n*2;x++){
                for (int y=x;y<arr.length;y+=n){
                    int val =arr[y];
                    int index=y-n;

                    while (index>=0&&arr[index]>val){
                        arr[index+n]=arr[index];
                        index-=n;
                    }
                    arr[index+n]=val;
                }
            }
            n/=2;
        }
    }

    //2020.1.15
    public void shellSort7(int[]arr){
        int n=arr.length/2;

        while (n>0){
            for (int x=n;x<2*n;x++){
                for (int y=x;y<arr.length;y+=n){
                    int val=arr[y];
                    int index =y-n;

                    while (index>=0&&arr[index]>val){
                        arr[index+n]=arr[index];
                        index=index-n;
                    }

                    arr[index+n]=val;
                }
            }
            n/=2;
        }
    }

    public void shellSort08(int[]arr){
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int x=gap;x<arr.length;x++){
                int y = x-gap;
                int curVal = arr[x];
                while (y>=0&&arr[y]>curVal){
                    arr[y+gap] = arr[y];
                    y-=gap;
                }
                arr[y+gap] = curVal;
            }
        }
    }

    public void shellSort09(int[] arr){
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int x=gap;x<arr.length;x++){
                int y = x-gap;
                int curVal = arr[x];
                while (y>=0&&arr[y]>curVal){
                    arr[y+gap] = arr[y];
                    y-=gap;
                }
                arr[y+gap] = curVal;
            }
        }
    }

    public void shellSort10(int[] arr){
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int x=gap;x<arr.length;x++){
                int y = x-gap;
                int curVal = arr[x];
                while (y>=0&&arr[y]>curVal){
                    arr[y+gap] = arr[y];
                    y-=gap;
                }
                arr[y+gap] = curVal;
            }
        }
    }
}
