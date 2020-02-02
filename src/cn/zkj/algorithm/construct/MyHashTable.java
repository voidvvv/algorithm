package cn.zkj.algorithm.construct;

import cn.zkj.lk.MyLinkedList;

public class MyHashTable {
    private EmpLinkList[] empLinkLists;
    private int size;

    public MyHashTable(int i){
        empLinkLists=new EmpLinkList[i];
        for (int x=0;x<i;x++){
            empLinkLists[x]=new EmpLinkList();
        }
        size=i;
    }

    public void add(Emp emp){
        int no =hashFun(emp.id);

        empLinkLists[no].add(emp);
        System.out.println("添加完成");
    }

    public int hashFun(int id){
        return id%size;
    }

    public void list(){
        for (int x=0;x<size;x++){
            empLinkLists[x].list(x);
            System.out.println();
        }
    }

    public void findById(int id){
        int no = hashFun(id);

        Emp empTemp = empLinkLists[no].findById(id);
        if (empTemp==null){
            System.out.println("找不到");
        }else {
            System.out.println("在"+no+"条链表找到了id为"+id+"的");
        }
    }

    public void delById(int id){
        int i = hashFun(id);

        empLinkLists[i].delById(id);
    }

}
