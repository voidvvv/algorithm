package cn.zkj.algorithm;

public class Queen8 {
    private int max;

    private int arr[];

    private int count;

    public Queen8(int max) {
        this.max = max;
        this.arr = new int[max];
        count = 0;
    }

    public static void main(String[] args) {
        Queen8 q = new Queen8(8);
        q.check(0);
        System.out.println(q.count);
    }

    private void check(int n){
        if (n==max){
            print();
            return;
        }
        for (int x=0;x<max;x++){
            arr[n]=x;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        for (int x=0;x<n;x++){
            if (arr[x]==arr[n] || (Math.abs(n-x) == Math.abs(arr[n] - arr[x]))){
                return false;
            }
        }
        return true;
    }

    private void print(){
        for (int x=0;x<max;x++){
            System.out.print(arr[x]+"\t");
        }
        this.count++;
        System.out.println("");
    }
}
