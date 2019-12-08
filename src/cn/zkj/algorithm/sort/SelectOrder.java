package cn.zkj.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectOrder {

    public static void main(String[] args) {
        SelectOrder s= new SelectOrder();
        int[]arr = new int[100000];
        for (int x=0;x<arr.length;x++){
            arr[x]=(int)(Math.random()*90000);
        }
        SimpleDateFormat sim=new SimpleDateFormat("hh:mm:ss");
        System.out.println(sim.format(new Date()));
        s.order(arr);
        System.out.println(sim.format(new Date()));
    }

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
}
