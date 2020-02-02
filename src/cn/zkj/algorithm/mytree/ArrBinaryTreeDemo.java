package cn.zkj.algorithm.mytree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7};

        ArrBinaryTree arrBinaryTree =new ArrBinaryTree(arr);

        arrBinaryTree.midPrint(0);
    }
}

class ArrBinaryTree{
    private int[]arr;
    public void setArr(int[]arr){
        this.arr=arr;
    }

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void prePrint(int index){
        if (arr==null||arr.length==0){
            System.out.println("啥都没有遍历啥啊？" );
            return;
        }
        if (index>arr.length-1||index<0){
            System.out.println("你在为难我");
            return;
        }

        System.out.println(arr[index]);

        if (index*2+1<=arr.length-1){
            prePrint(index*2+1);
        }
        if (index*2+2<=arr.length-1){
            prePrint(index*2+2);
        }
    }

    public void midPrint(int index){
        if (arr==null||arr.length==0){
            System.out.println("啥都没有遍历啥啊？" );
            return;
        }
        if (index>arr.length-1||index<0){
            System.out.println("你在为难我");
            return;
        }



        if (index*2+1<=arr.length-1){
            midPrint(index*2+1);
        }

        System.out.println(arr[index]);

        if (index*2+2<=arr.length-1){
            midPrint(index*2+2);
        }
    }
}


