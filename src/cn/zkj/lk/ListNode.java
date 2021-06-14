package cn.zkj.lk;

import cn.zkj.bug.domain.BaseInfoDto;
import cn.zkj.dtos.Mm;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        Mm mm = new Mm("a",new BaseInfoDto());

        System.out.println(mm);
        ttttt(mm);
        System.out.println(mm);

    }

    public static void ttttt(Mm mm){
        String name = mm.getName();
        name = null;
        BaseInfoDto baseInfoDto = mm.getBaseInfoDto();
        baseInfoDto =null;
    }

    @Override
    public String toString() {
        return this.val+""+(this.next==null?"":this.next);
    }

    /**
     * 234. 回文链表
     * @description:
     * @author: Mr.Z
     * @Date: 2020/10/23
       * @param head
     * @return: boolean
     * @version : 01
     */
    public boolean isPalindrome(ListNode head) {
        if (head==null){
            return true;
        }
        ListNode headTemp = head;

        ListNode reverseListNode = null;

        while (headTemp!=null){
            if (reverseListNode==null){
                reverseListNode = new ListNode(headTemp.val);
            }else {
                ListNode myremain = reverseListNode;
                reverseListNode = new ListNode(headTemp.val);
                reverseListNode.next = myremain;

            }
            headTemp = headTemp.next;
        }
        headTemp = head;
        while (headTemp!=null&&reverseListNode!=null){
            if (headTemp.val!=reverseListNode.val){
                return false;
            }
            headTemp = headTemp.next;
            reverseListNode = reverseListNode.next;

        }

        return true;



    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int indexL =0;
        int indexR =0;
        ListNode tmpHead = head;
        ListNode tmpPre = head;
        ListNode tmpTail = head;
        ListNode tmpNext = head;
        while (indexL<left&&tmpHead!=null){
            tmpPre = tmpHead;
            tmpHead = tmpHead.next;
            indexL++;
            indexR++;
        }
        tmpTail = tmpHead;

        while (indexR<right&&tmpTail!=null){
            tmpTail = tmpTail.next;
            tmpNext = tmpTail.next;
            indexR++;
        }

        reverse(tmpHead,tmpTail,tmpPre,tmpNext);
        return head;
    }

    private void reverse(ListNode tmpHead, ListNode tmpTail, ListNode tmpPre, ListNode tmpNext) {
        ListNode head = tmpHead;
        ListNode realTail = tmpHead;
        ListNode nextTmpe = tmpHead.next;
        while (nextTmpe!=null&&head!=tmpTail){
            ListNode ttnext = nextTmpe;
            nextTmpe = nextTmpe.next;
            ttnext.next = head;
            head = ttnext;
        }
        tmpPre.next = head;
        realTail.next = tmpNext;
    }

    /**
     * 61. 旋转链表 截取法
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null){
            return null;
        }
        if (k==0){
            return head;
        }
        ListNode tNode = head;
        ListNode tTmp=head;
        int length = 1;
        while (tNode.next!=null){
            tNode = tNode.next;
            length++;
        }
        if (length==1){
            return head;
        }
        int mod = k%length;

        for (int x=1;x<length-mod;x++){
            tTmp = tTmp.next;
        }

        ListNode hNoded = tTmp.next;
        tTmp.next = null;
        tNode.next = head;
        return hNoded;
    }

    /**
     * 61. 旋转链表 环法
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight02(ListNode head, int k) {
        if (head==null||k==0){
            return head;
        }
        ListNode tNode = head;
        int length=1;
        while (tNode.next!=null){
            tNode = tNode.next;
            length++;
        }
        if(length==1){
            return head;
        }
        int mod = k%length;
        if (mod==0){
            return head;
        }
        tNode.next = head;

        ListNode tmp = head;

        for (int x=1;x<length-mod;x++){
            tmp = tmp.next;
        }

        ListNode res = tmp.next;
        tmp.next = null;
        return res;
    }
}
