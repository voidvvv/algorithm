package cn.zkj.lk;



import java.util.*;

/**
 * @Classname Solution4
 * @Description
 * @Date 2022/3/20 17:19
 * @Created by zkj
 */
public class Solution4 {

    /**
     * 2039. 网络空闲的时刻
     *
     * 给你一个有 n 个服务器的计算机网络，服务器编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示服务器 ui 和 vi 之间有一条信息线路，在 一秒 内它们之间可以传输 任意 数目的信息。再给你一个长度为 n 且下标从 0 开始的整数数组 patience 。
     *
     * 题目保证所有服务器都是 相通 的，也就是说一个信息从任意服务器出发，都可以通过这些信息线路直接或间接地到达任何其他服务器。
     *
     * 编号为 0 的服务器是 主 服务器，其他服务器为 数据 服务器。每个数据服务器都要向主服务器发送信息，并等待回复。信息在服务器之间按 最优 线路传输，也就是说每个信息都会以 最少时间 到达主服务器。主服务器会处理 所有 新到达的信息并 立即 按照每条信息来时的路线 反方向 发送回复信息。
     *
     * 在 0 秒的开始，所有数据服务器都会发送各自需要处理的信息。从第 1 秒开始，每 一秒最 开始 时，每个数据服务器都会检查它是否收到了主服务器的回复信息（包括新发出信息的回复信息）：
     *
     * 如果还没收到任何回复信息，那么该服务器会周期性 重发 信息。数据服务器 i 每 patience[i] 秒都会重发一条信息，也就是说，数据服务器 i 在上一次发送信息给主服务器后的 patience[i] 秒 后 会重发一条信息给主服务器。
     * 否则，该数据服务器 不会重发 信息。
     * 当没有任何信息在线路上传输或者到达某服务器时，该计算机网络变为 空闲 状态。
     *
     * 请返回计算机网络变为 空闲 状态的 最早秒数 。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param edges
     * @param patience
     * @return
     */
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;

        List<Integer>[] graph = new List[n];

        for (int x=0;x<n;x++){
            graph[x] = new ArrayList<>();
        }

        for (int[] v :edges){
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int dist = 1;
        int ans= 0;
        boolean[] visit = new boolean[n];
        visit[0] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i<size;i++){
                Integer cur = queue.poll();

                for (int m: graph[cur]){
                    if (visit[m]){
                        continue;
                    }
                    queue.offer(m);
                    int time = patience[m]*((2*dist-1)/patience[m])+2*dist+1;
                    ans = Math.max(time,ans);
                    visit[m] = true;
                }

            }
            dist++;
        }
        return ans;
    }


    /**
     * 653. 两数之和 IV - 输入 BST
     *
     * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        inorderTraverse(root);

        int l = 0,r = list.size()-1;

        while (l<r){
            int i = list.get(l) + list.get(r);
            if (i == k){
                return true;
            }else if (i<k){
                l++;
            }else if (i>k){
                r--;
            }
        }
        return false;
    }

    private void inorderTraverse(TreeNode root) {
        if (root!=null){
            if (root.left!=null){
                inorderTraverse(root.left);
            }
            list.add(root.val);
            if (root.right!=null){
                inorderTraverse(root.right);
            }
        }
    }

    /**
     * 661. 图片平滑器
     * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
     *
     * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
     *
     * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/image-smoother
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param img
     * @return
     */
    public int[][] imageSmoother(int[][] img) {
        int m = img.length,n = img[0].length;

        int[][] ans = new int[m][n];
        for (int y=0;y<m;y++){
            for (int x=0;x<n;x++){
                ans[y][x] = smooth(x,y,img);

            }
        }


        return ans;
    }

    private int smooth(int x, int y, int[][] img) {
        int sum = img[y][x];
        int cnt = 1;
        for (int[] dir:dirs){
            if (validCor(img,x+dir[0],y+dir[0])){
                sum+=img[y+dir[0]][x+dir[0]];
            }
        }

        return sum/cnt;
    }

    private boolean validCor(int[][] img, int x, int y) {

        return !( y<0||x<0 || y>=img.length || x>=img[0].length );
    }

    /**
     * 682. 棒球比赛
     *
     * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
     *
     * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
     *
     * 整数 x - 表示本回合新获得分数 x
     * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
     * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
     * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
     * 请你返回记录中所有得分的总和。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/baseball-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
//        Logger.getLogger("",).info("aaaaaa");
        int [] temp = new int[ops.length];
        int sum =0;
        int i =0;
        for (String s: ops){
            switch (s){
                case "+":
                    temp[i]=temp[i-1]+temp[i-2];
                    break;
                case "D":
                    temp[i] = 2*temp[i-1];
                    break;
                case "C":
                    temp[i-1] =0;
                    i--;
                    i--;
                    break;
                default:
                    temp[i] =Integer.valueOf(s);
                    break;
            }
            i++;
        }
        for (int x=0;x<temp.length;x++){
            sum+=temp[x];
        }
        return sum;
    }

    /**
     * 2028. 找出缺失的观测数据
     * 现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
     *
     * 给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
     *
     * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
     *
     * k 个数字的 平均值 为这些数字求和后再除以 k 。
     *
     * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-missing-observations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param rolls
     * @param mean
     * @param n
     * @return
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int m = rolls.length;

        for (int x=0;x<m;x++){
            sum+=rolls[x];
        }

        sum = mean*(m+n)-sum;

        if (sum<n || sum>6*n){
            return new int[0];
        }

        int[] ans = new int[n];

        int t = sum/n;
        int tt = sum%n;

        for (int x=0;x<n;x++){
            if (x<tt){
                ans[x] = t+1;
            }else {
                ans[x] = t;
            }

        }
        return ans;

    }

    /**
     * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
     *
     * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
     *
     * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
     *
     *  
     *
     * 注意：你 不能 对两棵二叉树，以及 target 节点进行更改。只能 返回对克隆树 cloned 中已有的节点的引用。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(target);
        stack1.push(cloned);

        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            TreeNode popt = stack1.pop();
            if (pop==target){
                return popt;
            }
            if (pop.right!=null){
                stack.push(pop.right);
            }
            if (pop.left!=null){
                stack.push(pop.left);
            }
            if (popt.right!=null){
                stack1.push(popt.right);
            }
            if (popt.left!=null){
                stack1.push(popt.left);
            }

        }
        return null;
    }

    /**
     * 728. 自除数
     *
     * 自除数 是指可以被它包含的每一位数整除的数。
     *
     * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
     * 自除数 不允许包含 0 。
     *
     * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for (int x=left;x<=right;x++){
            if (selfDivid(x)){
                ans.add(x);
            }
        }
        return ans;
    }

    private boolean selfDivid(int x) {
        int ori = x;
        while (x>0){
            int m = x%10;
            if (ori%m>0){
                return false;
            }
            x/=10;
        }
        return true;
    }

    /**
     * 1509. 三次操作后最大值与最小值的最小差
     *
     * 给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个元素并将它改成任意值。
     *
     * 请你返回三次操作后， nums 中最大值与最小值的差的最小值。
     * @param nums
     * @return
     */
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n<=4){
            return 0;
        }
        Arrays.sort(nums);
        int l =3;
        int r= n-1;
        int res = nums[r]-nums[l];
        while (l>=0){
            l--;
            r--;
            res = Math.max(res,nums[r]-nums[l]);
        }
        return res;

//        int res = nums[n-1]-nums[0];
//        int l = 0;
//        int r= 0;
//        return Math.min(minDifference(nums,l+1,r,2),minDifference(nums,l,r+1,2));


    }

    public int minDifference(int[] nums,int l,int r,int count){
        if (count==0){
            return nums[nums.length-1-r]-nums[l];
        }else {
            return Math.min(minDifference(nums,l+1,r,count-1),minDifference(nums,l,r+1,count-1));
        }
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int start = 0;
        int end = 1;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 1;
        int cur = 1<<(chars[0]-'a');
        int maxLength = res;
        while (end<n){
            if ((cur& 1<<(chars[end]-'a'))>0){
                for (int x=start;x<end;x++){
                    if (chars[x]==chars[end]){
                        start = x+1;
                        break;
                    }else {
                        cur&=(~(1<<(chars[x]-'a')));
                    }
                }

                res = end-start+1;
                maxLength = Math.max(res,maxLength);
            }else {
                cur |= 1<<(chars[end]-'a');
                res++;
            }
            end++;
        }
        return Math.max(res,maxLength);

    }

    private int findStartIndex(int start, int end, char aChar,char[] chars) {
        for (int x=start;x<end;x++){
            if (chars[x]==aChar){
                return x;
            }
        }
        return 0;
    }

    /**
     * 389. 找不同
     *
     * 给定两个字符串 s 和 t ，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int nums = computeInt(s);
        int numt = computeInt(t);

        return (char) (numt-nums);
    }

    private int computeInt(String s) {
        if (s==null|| s.length()==0){
            return 0;
        }
        int sum = 0;
        for (int x=0;x<s.length();x++){
            sum+=(int) (s.charAt(x));
        }
        return sum;
    }

    /**
     * 面试题 17.10. 主要元素
     *
     * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int i = -1;
        int cnt = 0;

        for (int x=0;x<nums.length;x++){
            if (cnt==0){
                i = nums[x];
                cnt = 1;
            }else if (i==nums[x]){
                cnt++;
            }else {
                cnt--;
            }
        }
        if (cnt>0){
            int m=0;
            for (int x=0;x<nums.length;x++){
                if (nums[x] == i){
                    m++;
                }
            }
            if (m> nums.length/2){
                return i;
            }else {
                return -1;
            }
        }else {
            return -1;
        }
//        return cnt>0?i:-1;
    }

    /**
     * 面试题 16.10. 生存人数
     *
     * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
     *
     * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
     *
     * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/living-people-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param birth
     * @param death
     * @return
     */
    public int maxAliveYear(int[] birth, int[] death) {
        int[] cnts = new int[102];
        for (int x=0;x<birth.length;x++){

            cnts[birth[x]-1900]++;
            cnts[death[x]-1899]--;
        }

        int max = 0;
        int cur = 0;
        int year =  1900;
        for (int x=0;x<cnts.length;x++){
            cur+=cnts[x];
            if (cur>max){
                max = cur;
                year = 1900+x;
            }
        }
        return year;
    }

    /**
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
     *
     * 'a' 对应 ".-" ，
     * 'b' 对应 "-..." ，
     * 'c' 对应 "-.-." ，以此类推。
     *
     * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
     *
     * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
     * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-morse-code-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        return 0;
    }

    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        final int a = 100;
        for (int x=0;x<s.length();x++){
            if (res[1]+ widths[s.charAt(x)-'a']<=a){
                res[1]+=widths[s.charAt(x)-'a'];
            }else {
                res[0]++;
                res[1] = widths[s.charAt(x)-'a'];
            }
        }
        return res;
    }

    /**
     * 1456. 定长子串中元音的最大数目
     *
     * 给你字符串 s 和整数 k 。
     *
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     *
     * 英文中的 元音字母 为（a, e, i, o, u）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        int max = 0;
        final  int t = 1065233; // 100000100000100010001
        for (int x=0;x<k;x++){
            if (((1<<(s.charAt(x)-'a'))&t)>0){
                max++;
            }
        }
        int last = ((1<<(s.charAt(0)-'a'))&t)>0?1:0;
        for (int x=1;x<=s.length()-k;x++){
            if (max == k){
                return max;
            }
            max-=last;
            int next = ((1<<(s.charAt(x+k-1)-'a'))&t)>0?1:0;
            max+=next;
            last = ((1<<(s.charAt(x)-'a'))&t)>0?1:0;
        }
        return max;
    }


    /**
     * 865. 具有所有最深节点的最小子树
     *
     * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
     *
     * 返回包含原始树中所有 最深节点 的 最小子树 。
     *
     * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
     *
     * 一个节点的 子树 是该节点加上它的所有后代的集合
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        return null;

    }

    char[][] mapping = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return ans;
        }
        char[] curMap = mapping[digits.charAt(0)-'0'];
        char[] tmp = new char[digits.length()];
        for(int x=0;x<curMap.length;x++){
            tmp[0] = curMap[x];
            fill(digits,tmp,1,ans);
//            ans.add(new String(tmp));
        }
        return ans;
    }

    public void fill(String digits,char[] tmp,int cur,List<String> ans ){
        if(cur == digits.length()){
            ans.add(new String(tmp));
            return;
        }
        char[] curMap = mapping[digits.charAt(cur)-'0'];
        for(int x=0;x<curMap.length;x++){
            tmp[cur] = curMap[x];
            fill(digits,tmp,cur+1,ans);
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] visit = new int[heights.length][heights[0].length]; // 0 未访问 -1 正在访问    1 太平洋 2 大西洋 3 both

        List<List<Integer>> ans = new ArrayList<>();

        for(int y=0;y<heights.length;y++){
            for(int x=0;x<heights[0].length;x++){
                callBack(y,x,visit,heights,ans);
            }
            printArray(visit);
        }
        return ans;
    }

    public static void printArray(int[][] arr){
        for(int y =0;y<arr.length;y++){
            for(int x=0;x<arr[y].length;x++){
                System.out.print(arr[y][x]+"\t");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    int[][] dirst = {{1,0},{-1,0},{0,1},{0,-1},};
    public int callBack(int y,int x,int[][] visit,int[][] heights,List<List<Integer>> ans){
        if(y<0||x<0 || y >=heights.length || x>= heights[0].length){
            return 0;
        }

        if(visit[y][x] != 0 ){
            return visit[y][x] ;
        }
        int cur = 0;
        if(y==0 || x==0){
            cur|=1;
        }
        if(y==heights.length-1 || x== heights[0].length-1){
            cur|=2;
        }
        if(cur==3){
            visit[y][x] = 3;
            ans.add(Arrays.asList(y,x));
            return cur;
        }

        if(cur >0 ){
            visit[y][x] = cur;
        }else{
            visit[y][x] = -1;
        }
        for(int[] dir: dirst){

            if(valid(y,x,dir,heights)){
                int i = callBack(y+dir[0],x+dir[1],visit,heights,ans);
                if(i>0){
                    cur|= i;
                }
                if(cur == 3){
                    ans.add(Arrays.asList(y,x));
                    visit[y][x] = 3;
                    return cur;
                }
            }
        }

        if(cur > 0){
            visit[y][x] = cur;
        }else{
            visit[y][x] = 0;
        }
        return visit[y][x] ;
    }

    public boolean valid(int y,int x,int[] dir,int[][] heights){
        int tmpY = y+dir[0];
        int tmpX = x+dir[1];

        if(tmpY<0 || tmpX<0 || tmpY>= heights.length || tmpX>= heights[0].length){
            return false;
        }

        return heights[y][x]>= heights[tmpY][tmpX];
    }

    // 1065233
    String[] mol = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1},};
    List<Integer> list = new ArrayList<>();


    /**
     * 591. 标签验证器
     *
     * 给定一个表示代码片段的字符串，你需要实现一个验证器来解析这段代码，并返回它是否合法。合法的代码片段需要遵守以下的所有规则：
     *
     * 代码必须被合法的闭合标签包围。否则，代码是无效的。
     * 闭合标签（不一定合法）要严格符合格式：<TAG_NAME>TAG_CONTENT</TAG_NAME>。其中，<TAG_NAME>是起始标签，</TAG_NAME>是结束标签。起始和结束标签中的 TAG_NAME 应当相同。当且仅当 TAG_NAME 和 TAG_CONTENT 都是合法的，闭合标签才是合法的。
     * 合法的 TAG_NAME 仅含有大写字母，长度在范围 [1,9] 之间。否则，该 TAG_NAME 是不合法的。
     * 合法的 TAG_CONTENT 可以包含其他合法的闭合标签，cdata （请参考规则7）和任意字符（注意参考规则1）除了不匹配的<、不匹配的起始和结束标签、不匹配的或带有不合法 TAG_NAME 的闭合标签。否则，TAG_CONTENT 是不合法的。
     * 一个起始标签，如果没有具有相同 TAG_NAME 的结束标签与之匹配，是不合法的。反之亦然。不过，你也需要考虑标签嵌套的问题。
     * 一个<，如果你找不到一个后续的>与之匹配，是不合法的。并且当你找到一个<或</时，所有直到下一个>的前的字符，都应当被解析为 TAG_NAME（不一定合法）。
     * cdata 有如下格式：<![CDATA[CDATA_CONTENT]]>。CDATA_CONTENT 的范围被定义成 <![CDATA[ 和后续的第一个 ]]>之间的字符。
     * CDATA_CONTENT 可以包含任意字符。cdata 的功能是阻止验证器解析CDATA_CONTENT，所以即使其中有一些字符可以被解析为标签（无论合法还是不合法），也应该将它们视为常规字符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/tag-validator
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param code
     * @return
     */
    public boolean isValid(String code) {
        final String cdataPre = "[CDATA[";
        final String cdataLast = "]]";
        Stack<String> preTag = new Stack<>();
        int cdataPreCount = 0;
        int cdataLastCount = 0;
        char[] chars = code.toCharArray();

//        for(int x=0;x<chars.length;x++){
//            if(chars[x] == '<'){
//                if(x==chars.length-1){
//                    return false;
//                }else if (chars[x+1] == '!'){
//                    if (preTag.isEmpty()){
//                        return false;
//                    }
//                    x+=2;
//
//                }else if (chars[x+1] == '/'){
//                    if (preTag.isEmpty()){
//                        return false;
//                    }
//                }else {
//                    // 前标签
//                }
//            }
//        }
        return false;
    }
    public static void main(String[] args) {
        Solution4 s4 = new Solution4();

            //new int[][]{{1,2,2,3,5},{3,2,3,4,4},
        //                {2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4},}

    }



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer,Integer> fre = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(candidates);
        for(int x=0;x<candidates.length;x++){
            fre.put(candidates[x],fre.getOrDefault(candidates[x],0)+1);
        }



        Set<Integer> set = fre.keySet();

        List<Integer> keysList = new ArrayList<>(set);
        Collections.sort(keysList);
        int[] usedCount = new int[keysList.size()];
        callBack(keysList,usedCount,0,target,ans,fre);
        return ans;

    }

    public void callBack( List<Integer> keysList,int[] usedCount ,int cur,int target, List<List<Integer>> ans,Map<Integer,Integer> fre){
        if(cur<keysList.size() && target>=keysList.get(cur) ){
            usedCount[cur] = 0;
            int curKey = keysList.get(cur);
            int freCount = fre.getOrDefault(curKey,0);
            while(target > 0){
                callBack(keysList,usedCount,cur+1,target,ans,fre);
                if(freCount > 0 ){
                    target-= curKey ;
                    usedCount[cur]++;
                    freCount--;
                }else{
                    break;
                }

            }
            if(target == 0){
                ans.add(tmpList(keysList,usedCount,cur));
            }
        }
    }

    public List<Integer> tmpList(List<Integer> keysList,int[] usedCount,int cur){
        List<Integer> ans = new ArrayList<>();
        for(int x=0;x<=cur;x++){
            for(int y=0;y<usedCount[x];y++){
                ans.add(keysList.get(x));
            }
        }
        return ans;
    }
}
