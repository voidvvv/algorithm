package cn.zkj.algorithm;
//这是用链表模拟的栈
public class MyStack {

    private int maxSize;
    private NumListNode stack;
    private NumListNode temp;
    private int top;

    //构造器
    public MyStack(int x) throws Exception {
        if (x<=1){
            throw new Exception("输入的数字不合规范");
        }
        this.maxSize=x;
        this.top=-1;
        stack=new NumListNode(0);
        temp=stack;
    }
    //判断栈是否满了
    public boolean isFull(){
        return top>=maxSize-1;
    }
    //判断是否为空
    public boolean Empty(){
        return top<=-1;
    }

    //添加
    public void push(int x){
        if (isFull()){
            throw new RuntimeException("栈满了");
        }
        NumListNode numListNode = new NumListNode(x);
        numListNode.pre=temp;
        temp.next=numListNode;
        temp=temp.next;

        top++;
    }

    //弹出
    public int pop(){
        if (Empty()){
            throw new RuntimeException("栈为空，无法弹出");
        }
        int val = temp.val;
        temp=temp.pre;
        temp.next=null;
        top--;
        return val;
    }

}
