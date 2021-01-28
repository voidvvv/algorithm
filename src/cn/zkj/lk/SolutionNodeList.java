package cn.zkj.lk;

/**
 * @Author: zhaoKaiJie
 * @Description: 力扣链表相关题
 * @Date: 2020/10/18
 * @version: 01
 */
public class SolutionNodeList {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeLenth = 0;
        if (head==null){
            return null;
        }
        ListNode headTemp = head;
        while (headTemp!=null){
            headTemp = headTemp.next;
            nodeLenth++;
        }
        if (n>nodeLenth){
            return null;
        }
        if (n==nodeLenth){
            return head.next;
        }
        int count = nodeLenth-n;
        ListNode nodeTemp = head;
        ListNode nodebefore = null;
        for (int x=0;x<count;x++){
            nodebefore = nodeTemp;
            nodeTemp = nodeTemp.next;

        }
        nodebefore.next = nodeTemp.next;
        return head;
    }

    /**
     * @description: 链表
     * @author: Mr.Z
     * @Date: 2020/10/18
       * @param null
     * @return:
     * @version : 01
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
