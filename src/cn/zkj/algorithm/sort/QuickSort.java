package cn.zkj.algorithm.sort;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int [] arr =new int[20];
        for (int x=0;x<arr.length;x++){
            arr[x]=(int)(Math.random()*100);
        }
//        SimpleDateFormat sim=new SimpleDateFormat("hh:mm:ss");
        System.out.println(Arrays.toString(arr));


        q.quickSort4(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    //12.10
    public void quickSort(int[] arr,int left,int right){
        int le=left;
        int r=right;

        int pivot = (left+right)/2;
        int pval = arr[pivot];

        while (le<r){
            while (arr[le]<pval){
                le++;
            }
            while (arr[r]>pval){
                r--;
            }

            if(le>=r){
                break;
            }

            int temp = arr[le];
            arr[le]=arr[r];
            arr[r]=temp;

            if (arr[le]==pval){
                r--;
            }
            if (arr[r]==pval){
                le++;
            }



        }
        if (r==le){
            le++;
            r--;
        }
        if (le<right){
            quickSort(arr,le,right);
        }

        if (left<r){
            quickSort(arr,left,r);
        }
    }
    //12.10
    public void quickSort2(int[] arr,int left,int right){
        int le =left;
        int r = right;

        int pivot = arr[(left+right)/2];
        while (le<r){
            while (arr[le]<pivot){
                le++;
            }
            while (arr[r]>pivot){
                r--;
            }

            if (le>=r){
                break;
            }

            int temp = arr[le];
            arr[le]=arr[r];
            arr[r]=temp;

            if (arr[le]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                le++;
            }
        }
        if (le==r){
            le++;
            r--;
        }
        if (r>left){
            quickSort2(arr,left,r);
        }
        if (le<right){
            quickSort2(arr,le,right);
        }


    }
    //12.11
    public void quickSort3(int[] arr,int left,int right){
        int le=left;
        int r= right;

        int pivot=arr[(left+right)/2];
        int temp = 0;
        while (le<r){
            while (arr[le]<pivot){
                le++;
            }
            while (arr[r]>pivot){
                r--;
            }

            if (le>=r){
                break;
            }
            temp=arr[le];
            arr[le]=arr[r];
            arr[r]=temp;

            if (arr[le]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                le++;
            }

        }
        if (le==r){
            le++;
            r--;
        }

        if (le<right){
            quickSort3(arr,le,right);
        }
        if (r>left){
            quickSort3(arr,left,r);
        }
    }

    public void quickSort4(int[] arr,int left,int right){
        int le= left;
        int r= right;

        int pivot=arr[(left+right)/2];
        int temp;
        while (le<r){
            while (arr[le]<pivot){
                le++;
            }
            while (arr[r]>pivot){
                r--;
            }

            if (le>=r){
                break;
            }

            temp=arr[le];
            arr[le]=arr[r];
            arr[r]=temp;

            if (arr[le]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                le++;
            }
        }
        if (le==r){
            le++;
            r--;
        }
        if (le<right){
            quickSort4(arr,le,right);
        }
        if (r>left){
            quickSort4(arr,left,r);
        }
    }

}
