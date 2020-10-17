package cn.zkj.lk;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(0);
        ListNode header = head;
        for (int x=0;x<20;x++){
            ListNode temp = new ListNode(x+1);
            head.next = temp;
            head=head.next;
        }
        System.out.println(header);
        System.out.println(solution.swapPairs(header));

    }

    /**
     * 24. 两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode next = head.next;
        if (head.next==null){
            return head;
        }

        ListNode next1 = next.next;


        next.next = head;
        head.next = next1;
        if (next1==null){
            return head;
        }
        swapPairs(next1);
        return next;

    }
}
