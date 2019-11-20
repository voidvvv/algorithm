package cn.zkj.algorithm;

public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[]arr;

    ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }

    public boolean isFully(){
        return rear==maxSize-1;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public void add(int n){
        if (isFully()){
            throw new RuntimeException("队列已满，不能加入");
        }
        rear++;
        arr[rear]=n;
    }

    public int get(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取出");
        }
        front++;
        return arr[front];
    }

    public int seek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取出");
        }
        return arr[front+1];
    }
}
