package cn.zkj.algorithm.construct;

public class EmpLinkList {
    Emp head;

    public void add(Emp emp){
        if (head==null){
            head=emp;
        }else {
            Emp temp =head;

            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=emp;
        }
        System.out.println("添加成功");
    }

    public void list(int i){
        if (head==null){
            System.out.print("第"+i+ "条链表为空");
            return;
        }
        Emp temp =head;
        System.out.print("第"+i+ "条链表的数据为");
        while (temp!=null){
            System.out.print(temp);
            temp=temp.next;
        }
    }

    public Emp findById(int id){
        Emp temp = head;
        while (temp!=null){
            if (temp.id==id){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }

    public void delById(int id){
        if (head==null){
            System.out.println("链表都没东西，你删除个瘠薄啊");
            return;
        }
        if (head.id==id){
            head=head.next;
            System.out.println("删除成功");
            return;
        }
        Emp temp =head;

        while (temp.next!=null){
            if (temp.next.id==id){
                temp.next=temp.next.next;
                System.out.println("删除成功");
                return;
            }
        }

        System.out.println("没找到你想要的删除的ID");
    }
}
