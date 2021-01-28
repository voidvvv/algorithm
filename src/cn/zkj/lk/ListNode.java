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
}
