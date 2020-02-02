package cn.zkj.algorithm.find;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;

public class BindarySearch {
    public static void main(String[] args) {

        Hashtable hashtable=new Hashtable();

        PrintStream out = System.out;

        BindarySearch b =new BindarySearch();
        int[] a={1,8,10,89,1000,1234,1234,1234,1234,1234};

        int i = b.bindarySearch(a, 1234, 0, a.length - 1);
        ArrayList<Integer> integers = b.bindarySearchNew(a, 12345, 0, a.length - 1);
        System.out.println(integers);
    }

    public int bindarySearch(int[] arr,int val,int left,int right){
        int mid=(left+right)/2;
        int midVal=arr[mid];

        if (left>right){
            return -1;
        }

        if (val<midVal){
            return bindarySearch(arr,val,left,mid-1);
        }else if (val>midVal){
            return bindarySearch(arr,val,mid+1,right);
        }else {
            return mid;
        }
    }

    public ArrayList<Integer> bindarySearchNew(int[] arr, int val, int left, int right){
        int mid=(left+right)/2;
        int midVal=arr[mid];

        if (left>right){
            return new ArrayList<Integer>();
        }

        if (val<midVal){
            return bindarySearchNew(arr,val,left,mid-1);
        }else if (val>midVal){
            return bindarySearchNew(arr,val,mid+1,right);
        }else {
            ArrayList list =new ArrayList();
            int temp=mid;
            while (temp>=0&&arr[temp]==val){
                list.add(temp);
                temp--;
            }
            temp=mid+1;
            while (temp<arr.length&&arr[temp]==val){
                list.add(temp);
                temp++;
            }
            return list;
        }
    }

    public int bindarySearch1(int[] arr,int val,int left,int right){
        if (left<right){
            return -1;
        }

        int mid=(left+right)/2;
        int midVal=arr[mid];

        if (midVal<val){
            return bindarySearch1(arr,val,mid+1,right);
        }else if (mid>val){
            return bindarySearch1(arr,val,left,mid-1);
        }else {
            return mid;
        }

    }
}
