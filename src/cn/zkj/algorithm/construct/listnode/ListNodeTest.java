package cn.zkj.algorithm.construct.listnode;

import cn.zkj.lk.ListNode;

/**
 * @Classname ListNodeTest
 * @Description
 * @Date 2022/2/20 12:24
 * @Created by zkj
 */
public class ListNodeTest {



    public void addNode(ListNode listNode, int val){
        ListNode p = null;
        ListNode c = listNode;
        while (c!=null){
            p = c;
            c=c.next;
        }

        if (p!=null){
            p.next = new ListNode(val);
        }
    }


    public ListNode reserveListNode(ListNode listNode){
        ListNode newHead = null;

        while (listNode!=null){
            ListNode next = listNode.next;
            ListNode tmp = newHead;
            newHead = listNode;
            newHead.next = tmp;
            listNode = next;
        };
        return newHead;
    }

    public void printNode(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val+"\t");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNodeTest t = new ListNodeTest();
        ListNode head= new ListNode(1);

        for (int x=2;x<20;x++){
            t.addNode(head,x);
        }
        t.printNode(head);
        System.out.println("=========");
        ListNode listNode = t.reserveListNode(head);
        t.printNode(head);

    }
}
