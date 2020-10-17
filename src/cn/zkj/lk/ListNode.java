package cn.zkj.lk;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return this.val+""+(this.next==null?"":this.next);
    }
}
