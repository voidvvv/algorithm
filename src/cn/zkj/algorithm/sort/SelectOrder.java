package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyArraysUtil;
import cn.zkj.algorithm.utils.MyPrinter;

public class SelectOrder {



    public void order(int[]arr){



        for (int x=0;x<arr.length;x++){
            int minIndex=x;
            int min=arr[x];
            for (int y=x;y<arr.length;y++){
                if(min>arr[y]){
                    min=arr[y];
                    minIndex=y;
                }

            }
            int temp=arr[x];
            arr[x]=min;
            arr[minIndex]=temp;
        }

    }


    public void selectOrder(int[]arr){
        for (int x=0;x<arr.length-1;x++){
            int min = arr[x];
            int minIndex = x;
            for (int y=x+1;y<arr.length;y++){
                if (arr[y]<min){
                    min = arr[y];
                    minIndex = y;
                }
            }
            MyArraysUtil.swapVal(arr,x,minIndex);
        }
    }

    public void selectSort02(int[] arr){
        for (int x=0;x<arr.length;x++){
            int curVal = arr[x];
            int minIndex = x;
            for (int y=x+1;y<arr.length;y++){
                if (arr[y]<curVal){
                    curVal = arr[y];
                    minIndex = y;
                }
            }
            MyArraysUtil.swapVal(arr,minIndex,x);
        }
    }

    public void selectSort03(int[] arr){
        for (int x=0;x<arr.length-1;x++){
            int cur = x;
            int curVal =arr[x];
            for (int y= x+1;y<arr.length;y++){
                if (arr[y]<curVal){
                    cur = y;
                    curVal = arr[y];
                }
            }
            MyArraysUtil.swapVal(arr,cur,x);
        }
    }

    public void selectSort04(int[] arr){
        for (int x=0;x<arr.length-1;x++){
            int minIndex = x;
            int min = arr[x];
            for (int y=x+1;y<arr.length;y++){
                if (arr[y]<min){
                    min = arr[y];
                    minIndex = y;
                }
            }
            MyArraysUtil.swapVal(arr,x,minIndex);
        }
    }

    public void selectSort05(int[] arr){
        for (int x=0;x<arr.length-1;x++){
            int minIndex = x;
            int min = arr[x];
            for (int y=x+1;y<arr.length;y++){
                if (arr[y]<min){
                    minIndex = y;
                    min = arr[y];

                }
            }
            MyArraysUtil.swapVal(arr,x,minIndex);
        }
    }

    // 3 2 5 6 1 24 9
    // 为每一位找到合适的数字。例如，从索引0开始，找最小的。遍历数组，找到最小的，最小的值与0号位互换，。然后从1开始，找到第二小的，与1互换。。。
    public void selectSort06(int[] arr){
        for (int x=0;x<arr.length-1;x++){
            int minIndex = x;
            int min = arr[x];

            for (int y = x+1;y<arr.length;y++){
                if (arr[y]<min){
                    minIndex = y;
                    min = arr[y];

                }

            }
            MyArraysUtil.swapVal(arr,x,minIndex);

        }
    }

    public void selectSort07(int[] arr) {
        for (int x=0;x<arr.length;x++){
            int min = x;
            int minValue = arr[x];
            for (int y=x+1;y<arr.length;y++){
                if (minValue>arr[y]){
                    min = y;
                    minValue = arr[y];
                }
            }
            MyArraysUtil.swapVal(arr,x,min);
        }
    }



    public void selectSort(int []arr){
        for (int x=0;x<arr.length;x++){
            int minIndex = x;
            int minVal = arr[x];

            for (int y = x+1;y<arr.length;y++){
                if (arr[y]<minVal){
                    minIndex = y;
                    minVal = arr[y];
                }

            }
            MyArraysUtil.swapVal(arr,x,minIndex);


        }

    }

    public void selectSort08(int[] arr){
        for (int x=0;x<arr.length;x++){
            int minVal = arr[x];
            int minIndex = x;
            for (int y = x+1;y<arr.length;y++){
                if (arr[y]<minVal){
                    minIndex = y;
                    minVal = arr[y];
                }

            }

            MyArraysUtil.swapVal(arr,x,minIndex);

        }

    }

    public void  selectSort09(int[] arr){
        for (int x=0;x<arr.length;x++){
            int minIndex =x;
            int minVal = arr[x];

            for (int y = x+1;y<arr.length;y++){
                if (arr[y]<minVal){
                    minIndex = y;
                    minVal = arr[y];
                }
            }

            MyArraysUtil.swapVal(arr,x,minIndex);

        }
    }



    public void selectSort10(int[] arr){
        for (int x=0;x<arr.length;x++){
            int minIndex = x;
            for (int y = x+1;y<arr.length;y++){
                if (arr[y]<arr[minIndex]){
                    minIndex = y;
                }

            }
            MyPrinter.swap(arr,x,minIndex);

        }
    }

    public void selectSort11(int[] arr){
        for (int x=0;x<arr.length;x++){
            int min = x;
            for (int y = x+1;y<arr.length;y++){
                if (arr[y]<arr[min]){
                    min = y;
                }
            }
            MyArraysUtil.swapVal(arr,min,x);
        }
    }

    public void selectSort12(int[] arr){
        for (int x=0;x<arr.length;x++){
            int minIndex = x;
            for (int y =x+1;y<arr.length;y++){
                if (arr[y]<arr[minIndex]){
                    minIndex = y;
                }
            }
            MyArraysUtil.swapVal(arr,x,minIndex);
        }
    }

    public static void main(String[] args) {
        SelectOrder s= new SelectOrder();

        MyPrinter.printDefaultArrays(s::selectSort12);
    }
}
