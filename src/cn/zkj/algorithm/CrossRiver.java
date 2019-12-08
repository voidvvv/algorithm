package cn.zkj.algorithm;

public class CrossRiver {
    int[] cat;
    int[] mouse;

    public CrossRiver(){
        cat=new int[3];
        mouse=new int[3];
    }

    public void cross(){
        if (tof()){
            System.out.println(cat);
            System.out.println(mouse);
            return;
        }



    }

    public boolean tof(){

        //0代表在左边，1代表在右边全在右边了表示通过，返回true

        for (int i:cat){
            if (i==0){
                return false;
            }
        }
        for (int i:mouse){
            if (i==0){
                return false;
            }
        }
        return true;
    }

    public boolean fail(){
        int cy=0;
        int cz=0;
        int my=0;
        int mz=0;
        for (int i :cat){
            if (i==0){
                cz++;
            }else {
                cy++;
            }
        }
        for (int i:mouse){
            if (i==0){
                mz++;
            }else {
                my++;
            }
        }

        return cy>my||cz>mz;
    }


}
