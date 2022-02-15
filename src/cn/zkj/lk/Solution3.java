package cn.zkj.lk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/12/25
 * @version: 01
 */
public class Solution3 {


    /**
     * 1609. 奇偶树
     * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
     *
     * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
     * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
     * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
     * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/even-odd-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     * @return
     */
//    public boolean isEvenOddTree(TreeNode root) {
//        int x=0;
//        Stack<TreeNode> stack1 = new Stack<>();
//        Stack<TreeNode> stack2 = new Stack<>();
//        stack1.push(root);
//
//        while (!stack1.isEmpty() || !stack2.isEmpty()){
//            if (!stack1.isEmpty()){
//
//            }
//        }
//
//    }

    public void test() throws IOException {
        File file = new File("tt.text");
        System.out.println(file.exists());
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        int down1 = 22066;
        int up1 = 22353;

        int down2 = 22026;
        int up2 = 22362;
        int down3 = 22500;
        int up3 = 22508;
        int down4 = 22510;
        int up4 = 22518;
        int down5 = 22368;
        int up5 = 22407;
        bw.write("//绿装");
        bw.newLine();
        for (int x=down1;x<=up1;x++){
            StringBuilder sb = new StringBuilder("\t");
            sb.append(x);
            sb.append("\t");
            sb.append(1);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.write("//绿武器");
        bw.newLine();
        for (int x=down2;x<=up2;x++){
            StringBuilder sb = new StringBuilder("\t");
            sb.append(x);
            sb.append("\t");
            sb.append(1);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.write("//古代武器");
        bw.newLine();
        for (int x=down3;x<=up3;x++){
            StringBuilder sb = new StringBuilder("\t");
            sb.append(x);
            sb.append("\t");
            sb.append(1);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.write("//吸血武器");
        bw.newLine();
        for (int x=down4;x<=up4;x++){
            StringBuilder sb = new StringBuilder("\t");
            sb.append(x);
            sb.append("\t");
            sb.append(1);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.write("//U 武器");
        bw.newLine();
        for (int x=down5;x<=up5;x++){
            StringBuilder sb = new StringBuilder("\t");
            sb.append(x);
            sb.append("\t");
            sb.append(1);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        bw.flush();
        bw.close();
    }


    public int minArray(int[] numbers) {
        int i1 = 0;
        int i2 = numbers.length-1;

        while (numbers[i1]>numbers[i2]){
            i1++;
            i2--;
        }
        return numbers[i1];
    }

    /**
     * 1391. 检查网格中是否存在有效路径
     * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
     *
     * 1 表示连接左单元格和右单元格的街道。
     * 2 表示连接上单元格和下单元格的街道。
     * 3 表示连接左单元格和下单元格的街道。
     * 4 表示连接右单元格和下单元格的街道。
     * 5 表示连接左单元格和上单元格的街道。
     * 6 表示连接右单元格和上单元格的街道。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public boolean hasValidPath(int[][] grid) {
        int x=0;
        int y = 0;
        if (grid[y][x]!=1&&grid[y][x]!=2&&grid[y][x]!=3){
            return false;
        }
        int last = -1;
        while (x>=0&&y>=0&&  x< grid.length-1 && y <grid[0].length-1){
            int tmplast = last;
            last = grid[y][x];

            if (grid[y][x]==1){

            }else if (grid[y][x]==2){

            }else if (grid[y][x]==3){

            }else if (grid[y][x]==4){

            }else if (grid[y][x]==5){

            }else if (grid[y][x]==6){

            }
        }
        return false;
    }

    /**
     * 1765. 地图中的最高点
     * 给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
     *
     * 如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
     * 如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
     * 你需要按照如下规则给每个单元格安排高度：
     *
     * 每个格子的高度都必须是非负的。
     * 如果一个格子是是 水域 ，那么它的高度必须为 0 。
     * 任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
     * 找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
     *
     * 请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/map-of-highest-peak
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param isWater
     * @return
     */

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(ans[i], -1); // -1 表示该格子尚未被访问过
        }

        // 填充水域
        Queue<int[]> queue = new ArrayDeque<int[]>(); // 记录是否被计算过
        for(int y=0;y<m;y++){
            for (int x=0;x<n;x++){
                if (isWater[y][x]==1){
                    ans[y][x] = 0;
                    queue.offer(new int[]{y,x});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int[] dir:dirs){
                int y=poll[0]+dir[0];
                int x= poll[1]+dir[1];
                if (x>=0&&x<=n && y>=0&&y<=n&& ans[y][x] == -1){
                    ans[y][x] = ans[poll[0]][poll[1]]+1;
                    queue.offer(new int[]{y,x});
                }
            }

        }
        return ans;
    }

    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * @param nums
     * @return
     */
    boolean[] vis ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        Arrays.sort(nums);
        trackBack(nums,ans,0,perm);
        return ans;
    }

    // 每一次trackBack都是将某个位置上将所有元素都放置一遍
    private void trackBack(int[] nums, List<List<Integer>> ans, int index, List<Integer> perm) {
        if (index==nums.length){
            ans.add(new ArrayList<>(perm));
            return;
        }

        for (int i=0;i<nums.length;i++){
            // 如果该位置被访问过了，或者相同位置之前的元素未被访问国，则跳过此次元素
            if (vis[i] || (i>0 && nums[i]==nums[i-1] && !vis[i-1])){
                continue;
            }
            vis[i] = true;
            perm.add(nums[i]);
            // 该位置填充完了，进行下一个位置填充
            trackBack(nums,ans,index+1,perm);
            // 填充完毕后，需要换元素填充当前位置
            vis[i] = false;
            perm.remove(index);

        }
    }

    /**
     * 10. 正则表达式匹配
     *
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param p
     * @return
     */
//    public boolean isMatch(String s, String p) {
//        for (int x=0;x<s.length();x++){
//            char c = s.charAt(x);
//
//        }
//    }


    /**
     * 1991. 找到数组的中间位置
     *
     * 给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。
     *
     * 中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
     *
     * 如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
     *
     * 请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-middle-index-in-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int x=0;x<nums.length;x++){
            sum+=nums[x];
        }
        int right = 0;
        int left = sum;
        for (int x=0;x<nums.length;x++){
            int t  = left - nums[x];
            if (right==t){
                return x;
            }
            right+=nums[x];
            left-=nums[x];
        }
        return -1;
    }

    /**
     * 1763. 最长的美好子字符串
     *
     * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
     *
     * 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-nice-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public String longestNiceSubstring(String s) {

        int maxLength = 0;
        String ans = "";
        for (int x=0;x<s.length();x++){
            for (int y=x+1;y<s.length();y++){
                int low = 0;
                int up = 0;
                for (int t=x;t<y;t++){
                    if (s.charAt(t)>='a'&& s.charAt(t)<='z'){
                        low|=1<<(s.charAt(t)-'a');
                    }else {
                        up|=1<<(s.charAt(t)-'A');
                    }
                }
                if (low==up && y-x>maxLength){
                    maxLength = y-x;
                    ans = s.substring(x,y+1);
                }

            }

        }
        return ans;
    }

    /**
     * 2000. 反转单词前缀
     *
     * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
     *
     * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
     * 返回 结果字符串 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-prefix-of-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param word
     * @param ch
     * @return
     */
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int i = -1;
        Stack<Character> stack = new Stack<>();
        for (int x=0;x<chars.length;x++){
            stack.push(chars[x]);
            if (chars[x]==ch){
                i=x;
                break;
            }
        }
        if (i>=0){
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            for (int x=i+1;x<chars.length;x++){
                sb.append(chars[x]);
            }
            return sb.toString();
        }else {
            return word;
        }
    }

    /**
     * 1414. 和为 K 的最少斐波那契数字数目
     * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
     *
     * 斐波那契数字定义为：
     *
     * F1 = 1
     * F2 = 1
     * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
     * 数据保证对于给定的 k ，一定能找到可行解。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param k
     * @return
     */
    public int findMinFibonacciNumbers(int k) {
        List<Integer> f = new ArrayList<Integer>();
        f.add(1);
        int a = 1, b = 1;
        while (a + b <= k) {
            int c = a + b;
            f.add(c);
            a = b;
            b = c;
        }
        int ans = 0;
        for (int i = f.size() - 1; i >= 0 && k > 0; i--) {
            int num = f.get(i);
            if (k >= num) {
                k -= num;
                ans++;
            }
        }
        return ans;

    }

    /**
     * 1725. 可以形成最大正方形的矩形数目
     *
     * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
     *
     * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
     *
     * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
     *
     * 请你统计有多少个矩形能够切出边长为 maxLen 的正方形，并返回矩形 数目 。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param rectangles
     * @return
     */
    public int countGoodRectangles(int[][] rectangles) {
        int ans = 0;
        int maxLen = 0;

        for (int[] rec:rectangles){
            int max = Math.max(rec[0], rec[1]);
            if(max >maxLen){
                ans = 1;
                maxLen = max;
            }else if (max == maxLen){
                ans++;
            }else {
                continue;
            }
        }
        return ans;
    }


    /**
     * 1219. 黄金矿工
     *
     * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
     *
     * 为了使收益最大化，矿工需要按以下规则来开采黄金：
     *
     * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
     * 矿工每次可以从当前位置向上下左右四个方向走。
     * 每个单元格只能被开采（进入）一次。
     * 不得开采（进入）黄金数目为 0 的单元格。
     * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-with-maximum-gold
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
//    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1},};
    int ans = 0;
    int m = 0;
    int n = 0;
    int[][] grid = null;
    public int getMaximumGold(int[][] grid) {
        this.m = grid.length;
        ans = 0;
        this.n = grid[0].length;
        this.grid = grid;
        for (int y=0;y<m;y++){
            for (int x =0;x<n;x++){
                if (grid[y][x]>0){
                    dfs(x,y,0);
                }

            }
        }
        return ans;
    }

    private void dfs(int x, int y, int gold) {
        gold += grid[x][y];
        int rec = grid[x][y];
        grid[x][y] = 0;

        ans = Math.max(ans,gold);

        for (int d = 0; d < 4; ++d) {
            int nx = x + dirs[d][0];
            int ny = y + dirs[d][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0) {
                dfs(nx, ny, gold);
            }
        }

        this.grid[y][x] = rec;
    }

    /**
     * 1909. 删除一个元素使数组严格递增
     *
     * 给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。如果数组本身已经是严格递增的，请你也返回 true 。
     *
     * 数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-one-element-to-make-the-array-strictly-increasing
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public boolean canBeIncreasing(int[] nums) {
        int sign = 1;

        for (int x=1;x<nums.length;x++){
            if (nums[x]<=nums[x-1]){
                if ((--sign)<=0){
                    return false;
                }
                if (x==1 || nums[x]>nums[x-2] || (x==nums.length-1 || (nums[x-1] < nums[x+1]))){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 962. 最大宽度坡
     *
     * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
     *
     * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-width-ramp
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> indexStack = new Stack<>();

        int ans = 0;

        for (int x=0;x<nums.length;x++){
            if (indexStack.isEmpty() || nums[indexStack.peek()] > nums[x]){
                indexStack.push(x);
            }
        }

        for (int x= nums.length-1;x>=0;x--){
            while (!indexStack.isEmpty() && indexStack.peek()<= nums[x]){
                Integer pop = indexStack.pop();

                ans = Math.max(x-pop,ans);
            }

        }

        return ans;
    }

    /**
     * 1020. 飞地的数量
     *
     * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
     *
     * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
     *
     * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-enclaves
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] tmp = new int[n][m];
        int ans = 0;
        for (int y=0;y<n;y++){
            for (int x = 0;x<m;x++){
                if (grid[y][x] == 1 && tmp[y][x] == notVisit){
                    Stack<int[]> stack = new Stack<>();
                    boolean s = findEnclaves(grid,tmp,y,x,stack);
                    if (!s){ // 是飞地
                        ans+=stack.size();
                    }
                    int sign = s?not:yes;
                    while (!stack.isEmpty()){
                        int[] pop = stack.pop();
                        tmp[pop[0]][pop[1]] = sign;
                    }
                }
            }
        }
        return ans;
    }

    // 看当前坐标是否与外界联通
    private boolean findEnclaves(int[][] grid, int[][] tmp, int y, int x, Stack<int[]> stack) {

        if (y==0||y==tmp.length-1 || x==0 || x==tmp.length-1){
            tmp[y][x] = not;
            return true;
        }
        tmp[y][x] = visited;
        boolean b = false;
        stack.push(new int[]{y,x});
        for (int[] dir:dirs){
            int tmpY = y+dir[0];
            int tmpX = x + dir[1];
            if (grid[tmpY][tmpX]==1){
                // 只有在是陆地的情况下才判断
                if (tmp[tmpY][tmpX]==notVisit){
                    b = findEnclaves(grid,tmp,tmpY,tmpX,stack);
                    if (b){
                        return true;
                    }
                }else if (tmp[tmpY][tmpX]==yes){
                    return false; // 不能联通外界
                }else if (tmp[tmpY][tmpX]==not){
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 1551. 使数组中所有元素相等的最小操作数
     * 存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
     *
     * 一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。最终的目标是使数组中的所有元素都 相等 。题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
     *
     * 给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int minOperations(int n) {
        int s= n/2;
        return (1+s)*s/2;
    }

    /**
     * 1189. “气球” 的最大数量
     *
     * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
     *
     * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
//        int min = 0;
        for (int x=0;x<text.length();x++){
            char c = text.charAt(x);
            if (c=='b' || c=='a' || c=='n' || c=='l' || c=='o' ){
                int count = map.getOrDefault(c,0)+1;
                map.put(c,count);
            }
        }

        int b = map.get('b');
        int a = map.get('a');
        int n = map.get('n');
        int l = map.get('l');
        int o = map.get('o');

        return Math.min(o/2,Math.min(l/2,Math.min(n,Math.min(b,a))));
    }

    /**
     * 1380. 矩阵中的幸运数
     *
     * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
     *
     * 幸运数是指矩阵中满足同时下列两个条件的元素：
     *
     * 在同一行的所有元素中最小
     * 在同一列的所有元素中最大
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] horizon = new int[n];
        int[] vertical = new int[m];

        for (int y=0;y<n;y++){
            int[] tmp = matrix[y];
            int minIndex = 0;
            for (int x=0;x<m;x++){
                if (tmp[x] <tmp[minIndex]){
                    minIndex = x;
                    int vm = matrix[vertical[x]][x];
                    if (vm<tmp[x]){
                        vertical[x] = y;
                    }
                }

            }
            horizon[y] = minIndex;
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j =0;j<m;j++){
                if (horizon[i] == j && vertical[j] == i){
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;

    }
    int notVisit = 0;
    int visited = -1;
    int yes = 1; // 是飞地
    int not = 2; // 不是飞地
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        Solution3 s3 = new Solution3();
        s3.numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0},});
    }
}
