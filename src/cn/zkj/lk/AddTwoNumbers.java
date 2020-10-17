package cn.zkj.lk;

import java.util.Random;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers s = new AddTwoNumbers();
        Random random = new Random();
        ListNode l1 = new ListNode((random.nextInt(9))+1);
        ListNode temp = l1;
        for (int x=0;x<2;x++){
            temp.next = new ListNode((random.nextInt(9))+1);
            temp = temp.next;
        }

        ListNode l2 = new ListNode((random.nextInt(9))+1);
        ListNode temp2 = l2;
        for (int x=0;x<3;x++){
            temp2.next = new ListNode((random.nextInt(9))+1);
            temp2 = temp2.next;
        }
        System.out.println(l1);
        System.out.println(l2);
//        System.out.println(s.addTwoNumbers(l1,l1));
        System.out.println(s.addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode sumHeader = null;

        while (l1!=null||l2!=null){
            int sumcount =0;
            if (l1!=null){
                sumcount+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sumcount+=l2.val;
                l2 = l2.next;
            }

            if (sum==null){
                sum = new ListNode(sumcount);
                sumHeader = sum;
            }else {
                sum.next = new ListNode(sumcount);
                sum = sum.next;
            }


        }
        System.out.println(sumHeader);
        ListNode result = null;
        ListNode resultHeader = null;
        ListNode temp =null;
        int a= 0;
        while (true){
            if (sumHeader==null){
                if (a==0){
                    break;
                }else {
                    if (result==null){
                        result= new ListNode((a)%10);
                        resultHeader = result;
                        temp = result;
                    }else {
                        result= new ListNode((a)%10);
                        temp.next = result;
                        temp = result;
                    }
                    a = a/10;
                    continue;
                }
            }
            if (result==null){
                result= new ListNode((sumHeader.val+a)%10);
                resultHeader = result;
                temp = result;
            }else {
                result= new ListNode((sumHeader.val+a)%10);
                temp.next = result;
                temp = result;
            }

            a = (sumHeader.val+a)/10;
            sumHeader = sumHeader.next;
        }

        return resultHeader;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode l1temp = l1;
        ListNode l2temp = l2;
        ListNode l1Header = null;
        ListNode l2Header = null;
        while (l1temp!=null){
            ListNode temp = l1Header;
            l1Header = new ListNode(l1temp.val);
            l1Header.next = temp;
            l1temp= l1temp.next;
        }
        while (l2temp!=null){
            ListNode temp = l2Header;
            l2Header = new ListNode(l2temp.val);
            l2Header.next = temp;
            l2temp= l2temp.next;
        }

        ListNode sum = null;
        ListNode sumHeader = null;

        while (l1Header!=null||l2Header!=null){
            int sumcount =0;
            if (l1Header!=null){

                sumcount+=l1Header.val;
                l1Header=l1Header.next;
            }
            if (l2Header!=null){
                sumcount+=l2Header.val;
                l2Header = l2Header.next;
            }

            if (sum==null){
                sum = new ListNode(sumcount);
                sumHeader = sum;
            }else {
                sum.next = new ListNode(sumcount);
                sum = sum.next;
            }


        }

        ListNode result = null;
        int a= 0;
        while (true){
            if (sumHeader==null){
                if (a==0){
                    break;
                }else {
                    ListNode temp = result;
                    result = new ListNode(a%10);
                    result.next = temp;
                    a = a/10;
                    continue;
                }
            }
            ListNode temp = result;
            result = new ListNode((sumHeader.val+a)%10);
            result.next = temp;
            a = (sumHeader.val+a)/10;
            sumHeader = sumHeader.next;
        }

        return result;
    }
}
