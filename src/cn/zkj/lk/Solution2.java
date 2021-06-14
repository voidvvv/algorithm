package cn.zkj.lk;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/6/4
 * @version: 01
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();

        int[] arr = {-10,-3,0,5,9};
        s2.sortedArrayToBST(arr);
    }

    /**
     * 26. 删除有序数组中的重复项
     *
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index= 0;
        for (int x=1;x<nums.length;x++){
            if (nums[x]!=nums[index]){
                nums[++index] = nums[x];
            }
        }
        return ++index;
    }

    /**
     * 203. 移除链表元素
     *
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;

        while (head!=null){
            if (head.val==val){
                pre.next = head.next;
            }
            pre = pre.next;
            head = head.next;

        }
        return first.next;

    }

    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ");
    }

    /**
     * 66. 加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        int d = 1;
        for (int x=res.length-1;x>=0;x--){
            if (d==0){
                res[x] = digits[x];
            }else {
                int now = digits[x]+d;
                res[x] = now%10;
                d = now/10;
            }

        }
        int[] res2 = new int[digits.length+1];
        if (d>0){
            res2[0] = 1;
            for (int x=1;x<res2.length;x++){
                res2[x] = res[x-1];
            }
            return  res2;
        }
        return res;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int d = '0';
        int x=charsA.length-1,y=charsB.length-1;
        StringBuilder sb = new StringBuilder();
        while (x>=0&&y>=0){
            char ac = charsA[x];
            char bc = charsB[y];
            int addRe = addChar(ac,bc,d);
            sb.append(addRe%2);
            d= addRe/2+'0';

            x--;
            y--;
        }
        while (x>=0){
            char ac = charsA[x];
            int addRe = addChar(ac,'0',d);
            sb.append(addRe%2);
            d= addRe/2+'0' ;

            x--;
        }

        while (y>=0){
            char ac = charsB[y];
            int addRe = addChar(ac,'0',d);
            sb.append(addRe%2);
            d= addRe/2+'0';

            y--;
        }
        if (d>'0'){
            sb.append(1);
        }
        return sb.reverse().toString();

    }

    private int addChar(char ac, char bc, int d) {
        return (ac-'0')+(bc-'0')+(d-'0');

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        int val = head.val;
        ListNode now = head.next;
        ListNode pre = head;
        while (now!=null){
            if (now.val==val){
                pre.next = now.next;
            }else {
                pre = now;
                val = now.val;
            }
            now = now.next;
        }
        return head;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> re = new ArrayList<>();
        inorderTraversal(root,re);
        return re;
        // 迭代
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.empty()){
//            if (stack)
//        }
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> re) {
        if (root.left!=null){
            inorderTraversal(root.left,re);
        }
        re.add(root.val);
        if (root.right!=null){
            inorderTraversal(root.right,re);
        }
    }

    /**
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stp = new Stack<>();
        Stack<TreeNode> stq = new Stack<>();
        if (p==null){
            return q == null;
        }
        if (q==null){
            return false;
        }
        stp.push(p);
        stp.push(q);

        while (!stp.empty()&&!stq.empty()){
            TreeNode popP = stp.pop();
            TreeNode popQ = stq.pop();

            TreeNode popPLeft = popP.left;
            TreeNode popPright = popP.right;
            TreeNode popQRight = popQ.right;
            TreeNode popQleft = popQ.left;
            if (popP.val!=popQ.val){
                return false;
            }
            if (popPright!=null&&popQRight!=null){
                stp.push(popPright);
                stq.push(popQRight);
            }else if (popPright==null&&popQRight==null){

            }else {
                return false;
            }

            if (popPLeft!=null&&popQleft!=null){
                stp.push(popPLeft);
                stq.push(popQleft);
            }else if (popPLeft==null&&popQleft==null){

            }else {
                return false;
            }

        }

        return true;
    }


    public boolean isSymmetric(TreeNode root) {
        TreeNode p = root.left ;
        TreeNode q = root.right ;

        Stack<TreeNode> stp = new Stack<>();
        Stack<TreeNode> stq = new Stack<>();
        if (p==null){
            return q == null;
        }
        if (q==null){
            return false;
        }
        stp.push(p);
        stp.push(q);

        while (!stp.empty()&&!stq.empty()){
            TreeNode popP = stp.pop();
            TreeNode popQ = stq.pop();

            TreeNode popPLeft = popP.left;
            TreeNode popPright = popP.right;
            TreeNode popQRight = popQ.right;
            TreeNode popQleft = popQ.left;
            if (popP.val!=popQ.val){
                return false;
            }
            if (popPright!=null&&popQleft!=null){
                stp.push(popPright);
                stq.push(popQleft);
            }else if (popPright==null&&popQleft==null){

            }else {
                return false;
            }

            if (popPLeft!=null&&popQRight!=null){
                stp.push(popPLeft);
                stq.push(popQRight);
            }else if (popPLeft==null&&popQRight==null){

            }else {
                return false;
            }

        }

        return true;
    }

    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root==null){
            return 0;
        }
        int deep = 0;
        stack.push(root);
        Stack<TreeNode> tmp = new Stack<>();
        while (!stack.empty()){
            deep++;

            while (!stack.empty()){

                TreeNode pop = stack.pop();
                if (pop.left!=null){
                    tmp.push(pop.left);
                }
                if (pop.right!=null){
                    tmp.push(pop.right);
                }
            }
            while (!tmp.empty()){
                stack.push(tmp.pop());
            }
        }
        return deep;
    }

    /**\
     * 108. 将有序数组转换为二叉搜索树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return getPiovotNode(nums,0,nums.length-1);
    }

    public TreeNode getPiovotNode(int[] nums,int ori,int des){
        if (ori<des){
            return null;
        }
        int mid = ori+(des - ori) / 2;
        int num = nums[mid];
        TreeNode root = new TreeNode(num);
        root.left = getPiovotNode(nums,0,mid);
        root.right = getPiovotNode(nums,mid+1,des);
        return root;
    }
}
