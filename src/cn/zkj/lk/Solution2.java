package cn.zkj.lk;

import cn.zkj.lk.sctruction.Node;

import java.util.*;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/6/4
 * @version: 01
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();

//        List<String> arr = Arrays.asList("ale", "apple", "monkey", "plea");
//        s2.findLongestWord("abpcplea", arr);

        int[][] maze = {{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1},};
        int problem = s2.problem(maze);
        System.out.println(problem);
//        System.out.println(b);
    }

    /**
     * 26. 删除有序数组中的重复项
     * <p>
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int x = 1; x < nums.length; x++) {
            if (nums[x] != nums[index]) {
                nums[++index] = nums[x];
            }
        }
        return ++index;
    }

    /**
     * 203. 移除链表元素
     * <p>
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

        while (head != null) {
            if (head.val == val) {
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
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        int d = 1;
        for (int x = res.length - 1; x >= 0; x--) {
            if (d == 0) {
                res[x] = digits[x];
            } else {
                int now = digits[x] + d;
                res[x] = now % 10;
                d = now / 10;
            }

        }
        int[] res2 = new int[digits.length + 1];
        if (d > 0) {
            res2[0] = 1;
            for (int x = 1; x < res2.length; x++) {
                res2[x] = res[x - 1];
            }
            return res2;
        }
        return res;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int d = '0';
        int x = charsA.length - 1, y = charsB.length - 1;
        StringBuilder sb = new StringBuilder();
        while (x >= 0 && y >= 0) {
            char ac = charsA[x];
            char bc = charsB[y];
            int addRe = addChar(ac, bc, d);
            sb.append(addRe % 2);
            d = addRe / 2 + '0';

            x--;
            y--;
        }
        while (x >= 0) {
            char ac = charsA[x];
            int addRe = addChar(ac, '0', d);
            sb.append(addRe % 2);
            d = addRe / 2 + '0';

            x--;
        }

        while (y >= 0) {
            char ac = charsB[y];
            int addRe = addChar(ac, '0', d);
            sb.append(addRe % 2);
            d = addRe / 2 + '0';

            y--;
        }
        if (d > '0') {
            sb.append(1);
        }
        return sb.reverse().toString();

    }

    private int addChar(char ac, char bc, int d) {
        return (ac - '0') + (bc - '0') + (d - '0');

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int val = head.val;
        ListNode now = head.next;
        ListNode pre = head;
        while (now != null) {
            if (now.val == val) {
                pre.next = now.next;
            } else {
                pre = now;
                val = now.val;
            }
            now = now.next;
        }
        return head;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> re = new ArrayList<>();
        inorderTraversal(root, re);
        return re;
        // 迭代
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.empty()){
//            if (stack)
//        }
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> re) {
        if (root.left != null) {
            inorderTraversal(root.left, re);
        }
        re.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, re);
        }
    }

    /**
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stp = new Stack<>();
        Stack<TreeNode> stq = new Stack<>();
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        stp.push(p);
        stp.push(q);

        while (!stp.empty() && !stq.empty()) {
            TreeNode popP = stp.pop();
            TreeNode popQ = stq.pop();

            TreeNode popPLeft = popP.left;
            TreeNode popPright = popP.right;
            TreeNode popQRight = popQ.right;
            TreeNode popQleft = popQ.left;
            if (popP.val != popQ.val) {
                return false;
            }
            if (popPright != null && popQRight != null) {
                stp.push(popPright);
                stq.push(popQRight);
            } else if (popPright == null && popQRight == null) {

            } else {
                return false;
            }

            if (popPLeft != null && popQleft != null) {
                stp.push(popPLeft);
                stq.push(popQleft);
            } else if (popPLeft == null && popQleft == null) {

            } else {
                return false;
            }

        }

        return true;
    }


    public boolean isSymmetric(TreeNode root) {
        TreeNode p = root.left;
        TreeNode q = root.right;

        Stack<TreeNode> stp = new Stack<>();
        Stack<TreeNode> stq = new Stack<>();
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        stp.push(p);
        stp.push(q);

        while (!stp.empty() && !stq.empty()) {
            TreeNode popP = stp.pop();
            TreeNode popQ = stq.pop();

            TreeNode popPLeft = popP.left;
            TreeNode popPright = popP.right;
            TreeNode popQRight = popQ.right;
            TreeNode popQleft = popQ.left;
            if (popP.val != popQ.val) {
                return false;
            }
            if (popPright != null && popQleft != null) {
                stp.push(popPright);
                stq.push(popQleft);
            } else if (popPright == null && popQleft == null) {

            } else {
                return false;
            }

            if (popPLeft != null && popQRight != null) {
                stp.push(popPLeft);
                stq.push(popQRight);
            } else if (popPLeft == null && popQRight == null) {

            } else {
                return false;
            }

        }

        return true;
    }

    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return 0;
        }
        int deep = 0;
        stack.push(root);
        Stack<TreeNode> tmp = new Stack<>();
        while (!stack.empty()) {
            deep++;

            while (!stack.empty()) {

                TreeNode pop = stack.pop();
                if (pop.left != null) {
                    tmp.push(pop.left);
                }
                if (pop.right != null) {
                    tmp.push(pop.right);
                }
            }
            while (!tmp.empty()) {
                stack.push(tmp.pop());
            }
        }
        return deep;
    }

    /**
     * \
     * 108. 将有序数组转换为二叉搜索树
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return getPiovotNode(nums, 0, nums.length - 1);
    }

    public TreeNode getPiovotNode(int[] nums, int ori, int des) {
        if (ori < des) {
            return null;
        }
        int mid = ori + (des - ori) / 2;
        int num = nums[mid];
        TreeNode root = new TreeNode(num);
        root.left = getPiovotNode(nums, 0, mid);
        root.right = getPiovotNode(nums, mid + 1, des);
        return root;
    }

    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * <p>
     * 本题中，一棵高度平衡二叉树定义为：
     * <p>
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && (root.right != null && (root.right.right != null || root.right.left != null))) {
            return false;
        } else if (root.right == null && (root.left != null && (root.left.right != null || root.left.left != null))) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

//    private boolean isBalanced(TreeNode left,TreeNode right) {
//
//    }

    /**
     * 125. 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        s = s.trim();
        int indexStart = 0;
        int indexEnd = s.length() - 1;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();

        while (indexStart < indexEnd) {
            char sTmp = chars[indexStart];
            while ((indexStart < s.length()) && ((sTmp < '0' || sTmp > '9') && (sTmp < 'a' || sTmp > 'z'))) {
                sTmp = chars[++indexStart];
            }
            char eTmp = chars[indexEnd];
            while ((indexEnd >= 0) && ((eTmp < '0' || eTmp > '9') && (eTmp < 'a' || eTmp > 'z'))) {
                eTmp = chars[--indexEnd];
            }
            if ((indexStart < indexEnd) && sTmp != eTmp) {
                return false;
            }
            indexStart++;
            indexEnd--;
        }
        return true;
    }

    public int singleNumber(int[] nums) {
        // 牛皮的亦或法
        int r = nums[0];
        for (int x = 1; x < nums.length; x++) {
            r ^= nums[x];
        }
        return r;
    }

    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode tmp01 = head;
        ListNode tmp02 = head;

        while (tmp01 != null && tmp02 != null && tmp02.next != null) {
            if (tmp01 == tmp02) {
                return true;
            }
            tmp01 = tmp01.next;
            tmp02 = tmp02.next.next;

        }
        return false;
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 双指针
     * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     * <p>
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     * <p>
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (numbers[start] + numbers[end] != target) {
            if (numbers[start] + numbers[end] < target) {
                start++;
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            }

        }
        int[] res = {start, end};
        return res;

    }

    /**
     * 168. Excel表列名称
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 26进制
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        int ra = 26;
        int count = 1;
//        columnNumber = columnNumber-1;
        int i = columnNumber / ra;
        int mod = columnNumber % ra;

//        char a01 = (char) ('A'+mod);
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('A' + (mod - 1)));
        columnNumber -= mod;
        while (i > 0) {
            ra *= 26;
            i = columnNumber / ra;
            mod = i % ra;
            sb.append((char) ('A' + (mod - 1)));
            columnNumber -= mod;
        }

        return sb.reverse().toString();
    }

    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;
        for (int x = 1; x < nums.length; x++) {
            if (nums[x] == cur) {
                count++;
            } else {
                count--;
            }
            if (count <= 0) {
                cur = nums[x];
            }
        }
        return cur;
    }

    int maxbitC = 0;

    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        maxLength(arr, 0, list);

        return maxbitC;
    }

    private void maxLength(List<String> arr, int x, List<Integer> list) {
        if (x >= arr.size()) {
            return;
        }
        String s = arr.get(x);
        char[] chars = s.toCharArray();
        int m = 0;
        for (int y = 0; y < chars.length; y++) {
            if (m == (m | (1 << (chars[y] - 'a')))) {
                maxLength(arr, x + 1, list);
                return;
            } else {
                m = m | (1 << (chars[y] - 'a'));
            }
        }

        maxbitC = Math.max(Integer.bitCount(m), maxbitC);

        for (int n = 0; n < list.size(); n++) {
            if ((list.get(n) & m) == 0) {
                maxbitC = Math.max(Integer.bitCount(m), maxbitC);
                list.add(list.get(n) | m);
            }
        }
        list.add(m);
        maxLength(arr, x + 1, list);
    }

    /**
     * 1276. 不浪费原料的汉堡制作方案
     * 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
     * <p>
     * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
     * <p>
     * 巨无霸汉堡：4 片番茄和 1 片奶酪
     * 小皇堡：2 片番茄和 1 片奶酪
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-burgers-with-no-waste-of-ingredients
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param tomatoSlices
     * @param cheeseSlices
     * @return
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2) {
            return new ArrayList<>();
        }
        //鸡兔同笼问题：首先假设所有汉堡都是小的，则tomatoSlices/2-cheeseSlices应该为0；
        int y = tomatoSlices / 2 - cheeseSlices;//  这里y就是剩下的tomatoSlices
        if (y % 2 != 0) {
            return new ArrayList<>();
        }
        // 有一个小汉堡变成大汉堡，就会多用2个tomatoSlices。即，y/2即为需要的大汉堡的个数。
        int big = y / 2;
        return Arrays.asList(big, cheeseSlices - big);

    }

    /**
     * todo 969. 煎饼排序
     * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
     * <p>
     * 一次煎饼翻转的执行过程如下：
     * <p>
     * 选择一个整数 k ，1 <= k <= arr.length
     * 反转子数组 arr[0...k-1]（下标从 0 开始）
     * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
     * <p>
     * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pancake-sorting
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int x = arr.length - 1; x >= 0; x--) {
            int maxIndex = 0;
            for (int y = 1; y < x; y++) {
                if (arr[y] > arr[maxIndex]) {
                    maxIndex = y;
                }
            }


        }
        return res;
    }


    /**
     * 1450. 在既定时间做作业的学生人数
     * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
     * <p>
     * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
     * <p>
     * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-students-doing-homework-at-a-given-time
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int x = 0; x < startTime.length; x++) {
            if (queryTime >= startTime[x] && queryTime <= endTime[x]) {
                res++;
            }

        }
        return res;
    }

    /**
     * 1013. 将数组分成和相等的三个部分
     * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
     * <p>
     * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public boolean canThreePartsEqualSum(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        // 思路： 创建一个数组，长度等于原数组。存储原数组的前缀和.并且同时求出原数组元素总和，在前缀和中找出是否有等于原数组元素和3分之一和三分之二的元素即可
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int x = 1; x < arr.length; x++) {
            sum[x] = sum[x - 1] + arr[x];
        }
        if (sum[arr.length - 1] % 3 != 0) {
            return false;
        }
        int multi = 0;

        int ra = (sum[arr.length - 1] / 3);
        for (int x = 0; x < sum.length; x++) {
            if (sum[x] == ra && x < sum.length - 1) {
                ra += ra;
                multi++;
            }
            if (multi == 2) {
                break;
            }
        }
        return multi == 2;

    }


    /**
     * 951. 翻转等价二叉树
     * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
     * <p>
     * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
     * <p>
     * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 != null && root2 != null) {
            if (root1.val != root2.val) {
                return false;
            } else {

                return (flipEquiv(root1.left, root2.left) || flipEquiv(root1.left, root2.right)) && (flipEquiv(root1.right, root2.left) || flipEquiv(root1.right, root2.right));

            }
        } else if (root1 == null && root2 == null) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 1437. 是否所有 1 都至少相隔 k 个元素
     * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean kLengthApart(int[] nums, int k) {
        int preIn = 0;
        boolean first = true;
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] == 1) {
                if (first) {
                    first = false;
                } else {
                    if ((x - preIn) <= k) {
                        return false;
                    }

                }
                preIn = x;

            }
        }
        return true;
    }

    /**
     * 1304. 和为零的N个唯一整数
     * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
     *
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int limit = n / 2;
        int size = n % 2 == 1 ? (limit * 2 + 1) : (limit * 2);
        int[] sum = new int[size];


        for (int x = 0; x < size; x++) {
            int v = -n + x;
            if (n % 2 == 0 && v == 0) {
                sum[x] = v + 1;
            } else {
                sum[x] = v;
            }
        }
        return sum;
    }


    /**
     * 430. 扁平化多级双向链表
     * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
     * <p>
     * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    Node result = new Node();
    Node curPre;
    Node curNext;
//    public Node flatten(Node head) {
//        if (head==null){
//            return null;
//        }
////        result= head;
//        Node yummy = result;
//        flatten2(head);
//        return yummy;
//    }

    public void flatten2(Node head) {
        result.next = head;
        head.prev = result;
        result = result.next;
        if (head.child != null) {
            flatten2(head.child);
        }
        if (head.next != null) {
            flatten2(head.next);
        }

    }

    /**
     * 678. 有效的括号字符串
     * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
     * <p>
     * 任何左括号 ( 必须有相应的右括号 )。
     * 任何右括号 ) 必须有相应的左括号 ( 。
     * 左括号 ( 必须在对应的右括号之前 )。
     * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
     * 一个空字符串也被视为有效字符串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int conCount = 0;
        int starCount = 0;
        for (int x = 0; x < chars.length; x++) {
            char tmp = chars[x];
            if (tmp == '*') {
                if (stack.empty()) {
                    starCount++;
                } else {
                    stack.pop();
                    conCount++;
                }
            } else if (tmp == '(') {
                stack.push(tmp);
            } else {
                if (stack.empty()) {
                    if (conCount == 0 && starCount == 0) {
                        return false;
                    } else if (conCount > 0) {
                        conCount--;
                    } else if (starCount > 0) {
                        starCount--;
                    }
                } else {
                    stack.pop();
                }

            }

        }

        return stack.empty();
    }

    /**\
     * 1768. 交替合并字符串
     * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     *
     * 返回 合并后的字符串 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-strings-alternately
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param word1
     * @param word2
     * @return
     */
//    public String mergeAlternately(String word1, String word2) {
//        String[] tmp = {word1,word2};
//        int[] tmpIn = {0,0};
//        StringBuilder sb  = new StringBuilder();
//        while (tmpIn[0])
//        return sb.toString();
//    }

    /**
     * 1418. 点菜展示表
     * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
     * <p>
     * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
     * <p>
     * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param orders
     * @return
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        titles.add("Table");
        res.add(titles);
        for (int x = 0; x < orders.size(); x++) {
            List<String> order = orders.get(x);
            String tableNumberi = order.get(1);
            String foodItemi = order.get(2);
            int tabIndex = 1;
            List<String> tableNow = null;
            while (tabIndex < res.size()) {

                if (res.get(tabIndex).get(0).equals(tableNumberi)) {
                    tableNow = res.get(tabIndex);
                    break;
                }
                tabIndex++;
            }
            if (tableNow == null) {
                tableNow = new ArrayList<>();
                tableNow.add(tableNumberi);
                res.add(tableNow);

            }
            int tIndex = 1;
            for (; tIndex < titles.size(); tIndex++) {
                if (tIndex >= tableNow.size()) {
                    tableNow.add("0");
                }
                if (titles.get(tIndex).equals(foodItemi)) {

                    break;
                }
            }
            if (tIndex >= titles.size()) {
                titles.add(foodItemi);
            }
            if (tIndex >= tableNow.size()) {
                tableNow.add("0");
            }
            String s = tableNow.get(tIndex);
            tableNow.set(tIndex, String.valueOf(Integer.parseInt(s) + 1));

        }
        for (int x = 1; x < res.size(); x++) {
            List<String> list = res.get(x);
            while (list.size() < titles.size()) {
                list.add("0");
            }

        }

        res.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {

                return Integer.parseInt(o1.get(0)) - Integer.parseInt(o2.get(0));
            }
        });
        return res;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = binaryFindMid(nums, 0, nums.length - 1, target);
        if (nums[i] != target) {
            return 0;
        }
        int left = i;
        int right = i;

        while (nums[left] == target) {
            if (--left < 0) {
                break;
            } else if (nums[left] != target) {
                left++;
                break;
            }
        }
        while (nums[right] == target) {
            if (++right >= nums.length) {
                break;
            } else if (nums[right] != target) {
                right--;
                break;
            }
        }
        return right - left + 1;

    }

    private int binaryFindMid(int[] nums, int left, int right, int target) {
        if (left >= right) {
            return left;
        }
        int mid = (left + right) / 2;
        int tmp = nums[mid];
        if (tmp == target) {
            return mid;
        } else if (tmp < target) {
            return binaryFindMid(nums, mid + 1, right, target);
        } else {
            return binaryFindMid(nums, left, mid - 1, target);
        }

    }

    /**
     * 138. 复制带随机指针的链表
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * <p>
     * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     * <p>
     * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
     * <p>
     * 返回复制链表的头节点。
     * <p>
     * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     * <p>
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     * 你的代码 只 接受原链表的头节点 head 作为传入参数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node hResult = new Node(-1);
        List<Integer> list = new ArrayList<>();
        fillNode(hResult, head, list);
        fillRandom(hResult, list);
        return hResult;
    }

    private void fillRandom(Node hResult, List<Integer> list) {
        Node head = hResult;
        int c = 0;
        while (hResult != null) {
            Node tmp = head;
            int count = 0;
            Integer integer = list.get(c);
            if (integer == -1) {
                break;
            }
            while (tmp != null) {
                if (count == integer) {
                    hResult.random = tmp;
                    break;
                }
                count++;
                tmp = tmp.next;
            }
            hResult = hResult.next;
        }
    }

    private void fillNode(Node hResult, Node head, List<Integer> list) {

        Node tmpOut = head;
        while (tmpOut != null) {
            hResult.next = new Node(tmpOut.val);
            int x = 0;
            Node tmp = head;
            boolean f = false;
            while (tmp != null) {
                if (tmp == head.random) {
                    list.add(x);
                    f = true;
                    break;
                }
                tmp = tmp.next;
                x++;
            }
            if (!f) {
                list.add(-1);
            }

            tmpOut = tmpOut.next;
            hResult = hResult.next;
        }

    }

    /**
     * 797. 所有可能的路径
     * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
     * <p>
     * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
     * <p>
     * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param
     * @return
     */
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        for (int x=0;x<graph.length;x++){
//            int[] ints = graph[x];
//            for (int y=0;y<ints.length;y++){
//                int anInt = ints[y];
//                if(!map.containsKey(anInt)){
//
//                }
//
//
//            }
//
//        }
//    }
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;

        Arrays.sort(people);
        int is = 0;
        int ie = people.length - 1;
        while (is < ie) {
            if (people[is] + people[ie] > limit) {
                ie--;
            } else {
                is++;
                ie--;
            }
            boat++;

        }
        return boat;

    }

    /**
     * 524. 通过删除字母匹配到字典里最长单词
     * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
     * <p>
     * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        int size = dictionary.size();
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] ins = new int[size];
        int maxIndex = -1;
        int maxLen = 0;
        for (int x = 0; x < length; x++) {
            char aChar = chars[x];
            for (int y = 0; y < size; y++) {
                if (ins[y] < dictionary.get(y).length() && (dictionary.get(y).charAt(ins[y]) == aChar)) {
                    ins[y]++;
                    if ((ins[y]) == dictionary.get(y).length()) {
                        if (ins[y] > maxLen) {
                            maxLen = ins[y];
                            maxIndex = y;
                        } else if (ins[y] == maxLen) {
                            String s1 = dictionary.get(maxIndex);
                            if (s1.compareToIgnoreCase(dictionary.get(y)) > 0) {
                                maxIndex = y;
                            }
                        }

                    }
                }
            }

        }
        if (maxLen > 0 && maxIndex >= 0) {
            return dictionary.get(maxIndex);
        } else {
            return "";
        }
    }

    /**
     * 430. 扁平化多级双向链表
     * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
     * <p>
     * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Node t = head;
        Node tmp = t.next;
        if (t.child != null) {
            t.next = t.child;
            Node s = manage(t.child);
            s.next = tmp;
        }
        if (tmp != null) {
            flatten(tmp);
        }
        return head;
    }

    private Node manage(Node head) {
        Node tail = head;
        Node tt = tail.next;


        while (tail != null && tail.next != null) {
            if (tail.child != null) {
                tail.next = tail.child;
                Node s = manage(tail.child);
                s.next = tt;
            }

            tail = tail.next;
        }

        return tail;
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int xl = Math.max(ax1, bx1);
        int xr = Math.min(ax2, bx2);

        int yu = Math.min(ay2, by2);
        int yd = Math.max(ay1, by1);
        int p = (xr - xl) * (yu - yd);
        if ((xr - xl) <= 0 || (yu - yd) <= 0) {
            p = 0;
        }

        int p1 = (ax2 - ax1) * (ay2 - ay1);
        int p2 = (bx2 - bx1) * (by2 - by1);

        return p1 + p2 - p;
    }

    /**
     * 375. 猜数字大小 II
     * 我们正在玩一个猜数游戏，游戏规则如下：
     * err 错误！
     * 我从 1 到 n 之间选择一个数字。
     * 你来猜我选了哪个数字。
     * 如果你猜到正确的数字，就会 赢得游戏 。
     * 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
     * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
     * 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        int left = 1;
        int right = n;
        int re = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            re += mid;
            left = mid + 1;
        }
        return re;
    }


    /**
     * 520. 检测大写字母
     * 我们定义，在以下情况时，单词的大写用法是正确的：
     * <p>
     * 全部字母都是大写，比如 "USA" 。
     * 单词中所有字母都不是大写，比如 "leetcode" 。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
     * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/detect-capital
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int length = word.length();
        int i = (chars[0] >= 'A' && chars[0] <= 'Z') ? 1 : 0; //

        for (int x = 1; x < length; x++) {
            if ((chars[0] >= 'A' && chars[0] <= 'Z')) {
                if (i != 1) {
                    return false;
                }
            } else {
                i = 0;
            }
        }
        return true;
    }


    /**
     * 391. 完美矩形
     * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
     * <p>
     * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-rectangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param rectangles
     * @return
     */
    public boolean isRectangleCover(int[][] rectangles) {
        return false;
    }

    /*

新版极速分配：

订单处理时效=处理时间点-分配时间点

取此代售点账号前10单的ordertype=1的订单处理时效，计算平均值，记为此代售点账号的“平均订单处理时效“



预计处理完成时间点=代售点现有订单的预计处理完成时间点+新进入订单的预计处理时长

即——预计处理完成时间点=代售点账号中现有订单里最早的分配时间点+平均订单处理时效×（现有订单数量+1）



取当前可用代售点账号中计算预计处理完成时间点最早的1个，将订单分配给该代售点。

若计算出订单分给多个代售点预计处理完成时间一致，则优先分给当前订单最少的代售点，若当前订单一致，则随机分配一个。
     */

    /**
     * 397. 整数替换
     * 给定一个正整数 n ，你可以做如下操作：
     * <p>
     * 如果 n 是偶数，则用 n / 2替换 n 。
     * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
     * n 变为 1 所需的最小替换次数是多少？
     * <p>
     * 11011
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-replacement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        int re = 0;
        int pre = 0;
        int now = 1;
        while (now < n) {
            pre = now;
            now *= 2;
            re++;
        }
        // pre(2^x-1) < n < now(2^x)
        return re;
    }

    /**
     * 594. 最长和谐子序列
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
     * <p>
     * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
     * <p>
     * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * eg
     * 输入：nums = [1,3,2,2,5,2,3,7]
     * 输出：5
     * 解释：最长的和谐子序列是 [3,2,2,2,3]
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> mapping = new HashMap<>();
        int re = 0;
        for (int x = 0; x < nums.length; x++) {
            int num = nums[x];
            int i = mapping.getOrDefault(num, 0) + 1;
            mapping.put(num, i);
            re = Math.max(re, i);
            if (num > 1 && mapping.get(num - 1) != null) {
                i = mapping.get(num - 1) + 1;
                re = Math.max(re, i);
                mapping.put(num - 1, i);
            }
            if (num < 2 * 10000 && mapping.get(num + 1) != null) {
                i = mapping.get(num + 1) + 1;
                re = Math.max(re, i);
                mapping.put(num + 1, i);
            }

        }
        return re;
    }


    /**
     * 506. 相对名次
     * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
     * <p>
     * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
     * <p>
     * 名次第 1 的运动员获金牌 "Gold Medal" 。
     * 名次第 2 的运动员获银牌 "Silver Medal" 。
     * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
     * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
     * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/relative-ranks
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param score
     * @return
     */
    public String[] findRelativeRanks(int[] score) {
        int[] copy = Arrays.copyOf(score, score.length);
        Arrays.sort(copy);

        String[] re = new String[copy.length];

        for (int x = 0; x < copy.length; x++) {
            String s = "";
            if (x == copy.length - 1) {
                s = "Gold Medal";
            } else if (x == copy.length - 2) {
                s = "Silver Medal";
            } else if (x == copy.length - 3) {
                s = "Bronze Medal";
            } else {
                s = (copy.length - x) + "";
            }
            int t = copy[x];
            for (int i = 0; i < score.length; i++) {
                if (score[i] == t) {
                    re[i] = s;
                    break;
                }
            }

        }
        return re;
    }


    /**
     * 383. 赎金信
     * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
     *
     * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
     *
     * 如果可以构成，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ransom-note
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteArr = new int[26];
        char[] chars = ransomNote.toCharArray();
        char[] chars1 = magazine.toCharArray();

        for (int x=0;x<chars.length;x++){
            ransomNoteArr[chars[x]-'a']++;
        }
        for (int x=0;x<chars1.length;x++){
            ransomNoteArr[chars1[x]-'a']--;
        }

        for (int x=0;x<26;x++){
            if (ransomNoteArr[x]>0){
                return false;
            }
        }
        return true;
    }

    /**
     * 700. 二叉搜索树中的搜索
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode re = null;
        if (root.val == val) {
            return root;
        } else if (val > root.val) {
            re = searchBST(root.right, val);
        } else {
            re = searchBST(root.left, val);
        }
        return re;
    }


    public int numWaterBottles(int numBottles, int numExchange) {
        int re = numBottles;
        while (numBottles >= numExchange) {
            int t = numBottles / numExchange;
            int y = numBottles % numExchange;

            re += t;
            numBottles = t + y;
        }
        return re;
    }


    /**
     * 1345. 跳跃游戏 IV
     * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
     * <p>
     * 每一步，你可以从下标 i 跳到下标：
     * <p>
     * i + 1 满足：i + 1 < arr.length
     * i - 1 满足：i - 1 >= 0
     * j 满足：arr[i] == arr[j] 且 i != j
     * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
     * <p>
     * 注意：任何时候你都不能跳到数组外面。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-iv
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> idxSameValue = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            idxSameValue.putIfAbsent(arr[i], new ArrayList<Integer>());
            idxSameValue.get(arr[i]).add(i);
        }
        Set<Integer> visitedIndex = new HashSet<Integer>();
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, 0});
        visitedIndex.add(0);
        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0], step = idxStep[1];
            if (idx == arr.length - 1) {
                return step;
            }
            int v = arr[idx];
            step++;
            if (idxSameValue.containsKey(v)) {
                for (int i : idxSameValue.get(v)) {
                    if (visitedIndex.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                idxSameValue.remove(v);
            }
            if (idx + 1 < arr.length && visitedIndex.add(idx + 1)) {
                queue.offer(new int[]{idx + 1, step});
            }
            if (idx - 1 >= 0 && visitedIndex.add(idx - 1)) {
                queue.offer(new int[]{idx - 1, step});
            }
        }
        return -1;
    }

    /**
     * 给与一个地图，2代表障碍，1代表积分，0代表正常路
     * 从左上角走到右下角，再从右下角走到左上角，统计所有积分总和最大的可能
     * @param maze
     * @return
     */
    public int problem(int[][] maze){
        int x=0;
        int y = 0;
        int score = 0;


        int[][] mazeCopy = new int[maze.length][];
        for (int t=0;t<mazeCopy.length;t++){
            mazeCopy[t] = Arrays.copyOf(maze[t],maze[t].length);
        }

        score+=fillMazeScore(mazeCopy,y,x);
//        mazeScore[0][0];

        return score;

    }

    private int fillMazeScore( int[][] mazeCopy, int y, int x) {
        if (x<0||x>mazeCopy[0].length-1 || y<0 || y>mazeCopy.length-1){
            return 0;
        }
        int cur = mazeCopy[y][x]==1?1:0;


        if (y==mazeCopy.length-1 && x==mazeCopy[0].length-1){
            mazeCopy[y][x] = 0;
            return cur;
        }
        if(mazeCopy[y][x]==2){
            return -1;
        }

        int down = 0;
        if (y<mazeCopy.length-1){
            down = fillMazeScore(mazeCopy,y+1,x);
        }
        int right = 0;
        if (x<mazeCopy[0].length-1){
            right = fillMazeScore(mazeCopy,y,x+1);
        }
        if (right==-1 && down==-1){
            return -1;
        }

        if (right>down){
            mazeCopy[y][x+1] = 0;
            return cur + right;
        }
        if (down>right){
            mazeCopy[y+1][x] = 0;
            return  cur + down;
        }
        mazeCopy[y][x+1] = 0;
        return cur + right;
    }

    /**
     * 1984. 学生分数的最小差值
     * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
     *
     * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
     *
     * 返回可能的 最小差值 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        k=k-1;
        int ans = Integer.MAX_VALUE;
        for (int x=0;x<nums.length-k;x++){
            ans = Math.min(nums[x+k]-nums[x],ans);
        }
        return ans;
    }


    /**
     * 419. 甲板上的战舰
     * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
     *
     * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/battleships-in-a-board
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int re = 0;
        for (int x=0;x<board.length;x++){
            for (int y = 0;y<board[x].length;y++){
                if (board[x][y]=='X'){
                    if (((x==0) || board[x-1][y]=='.') && ((y==0) || board[x][y-1]=='.')){
                        re++;
                    }
                }

            }
        }
        return re;
    }


    public int findRadius(int[] houses, int[] heaters) {
        int heatIndex = 0;
//        int heatRight = heaters.length-1;
        int minRange = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int x=0;x<houses.length;x++){
            int curMinRange = Integer.MAX_VALUE;
            int house = houses[x];
            while (heatIndex<heaters.length && heaters[heatIndex]<=house){
                heatIndex++;
            }
            int left=heatIndex>0?heatIndex-1:0;
            int right = heatIndex>=heaters.length-1?heaters.length-1 : heatIndex+1;

            curMinRange = Math.min(Math.abs(heaters[left]-house),Math.abs(heaters[right]-house));
            minRange = Math.max(minRange,curMinRange);
        }
        return minRange;
    }
}
