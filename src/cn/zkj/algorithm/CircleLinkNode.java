package cn.zkj.algorithm;

public class CircleLinkNode {
    private Boy first ;
    private int size;

    public void add(int num){
        if (num<=1){
            System.out.println("输入的数字不正确");
            return;
        }
        this.size =num;

        Boy temp1 = null;

        for (int x=1;x<=num;x++){
            Boy boy = new Boy(x);
            if (x==1){
                first=boy;
                first.next=first;
                temp1=first;
            }else {
                temp1.next=boy;
                boy.next=first;
                temp1=boy;
            }
        }
    }

    public int size(){
        return this.size;
    }

    public void show(){
        if (first==null){
            System.out.println("链表为空");
            return;
        }
        Boy temp = first;
        while (temp!=null){
            System.out.println("小孩子"+temp.id);
            temp=temp.next;
            if (temp==first){
                break;
            }
        }
    }

    public void yosephu(int m){
        if (m<1||m>size){
            System.out.println("输入的数字不合法");
            return;
        }
        int n =1;
        Boy temp = first;
        while (temp!=null){
            n=n%m;
            System.out.println("现在是"+temp.id+"号boy叫到了"+n);
            if (n==m-1){
                n++;
                if (temp.next==temp){

                    System.out.println(temp.id+"号boy叫到了"+n+"出局，循环完成");
                    temp=null;
                    return;
                }
                System.out.println(temp.next.id+"号boy叫到了"+n+"出局");
                temp.next=temp.next.next;

            }
            n++;
            temp=temp.next;
        }
    }

}
