package cn.zkj.lk;

import java.util.*;

/**
 * @Classname Solution5
 * @Description
 * @Date 2022/4/19 23:57
 * @Created by zkj
 */
public class Solution5 {
    Map<TreeNode, Integer> depth;
    int max_depth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap();
        depth.put(null, -1);
        dfs(root, null);
        max_depth = -1;
        for (Integer d : depth.values())
            max_depth = Math.max(max_depth, d);

        return answer(root);
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == max_depth)
            return node;
        TreeNode L = answer(node.left),
                R = answer(node.right);
        if (L != null && R != null) return node;
        if (L != null) return L;
        if (R != null) return R;
        return null;
    }


    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        int maxLength = 0;
        for (int x = 0; x < matchsticks.length; x++) {
            total += matchsticks[x];
            maxLength = Math.max(maxLength, matchsticks[x]);
        }

        if (total == 0 || total % 4 > 0) {
            return false;
        }
        int avg = total / 4;
        if (maxLength > avg) {
            return false;
        }
        boolean[] used = new boolean[matchsticks.length];

        for (int x = 0; x < matchsticks.length; x++) {
            if (used[x]) {
                continue;
            }
            used[x] = true;
            if (!findTargetVal(matchsticks, used, avg - matchsticks[x])) {
                return false;
            }
        }
        return true;

    }

    public boolean findTargetVal(int[] matchsticks, boolean[] used, int tv) {
        if (tv == 0) {
            return true;
        }
        for (int x = 0; x < matchsticks.length; x++) {
            if (used[x] || tv < matchsticks[x]) {
                continue;
            }
            used[x] = true;
            if (findTargetVal(matchsticks, used, tv - matchsticks[x])) {
                return true;
            }
            used[x] = false;
        }
        return false;
    }

    public int numWays(int steps, int arrLen) {
        // 0
        int res = 0;
        // res+= numWays(0-1;steps-1,arrLen);
        res += numWays(1, steps - 1, arrLen);

        return res % 1000000007;
    }

    public long numWays(int i, int steps, int arrLen) {
        if (i < 0 || i >= arrLen) {
            return 0;
        }

        if (steps == 0) {
            if (i == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        return numWays(i - 1, steps - 1, arrLen) + numWays(i + 1, steps - 1, arrLen);
    }

    /**
     * 1161. 最大层内元素和
     * <p>
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
     * <p>
     * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        int aspect = 1;
        int max = root.val;

        queue.offer(root);
        int curas = 1;
        while (!queue.isEmpty()) {
            int curmax = 0;
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                TreeNode poll = queue.poll();
                curmax += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            if (curmax > max) {
                aspect = curas;
            }
            curas++;
        }
        return aspect;
    }

//    public static void main(String[] args) {
//        Solution5 s5 = new Solution5();
////        s5.makesquare(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
////        s5.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
//        Solution5.WordFilter wf = s5.new WordFilter(new String[]{"apple"});
//        int f = wf.f("a", "e");
//        System.out.println(f);
//    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] split = email.split("@");
            String prefix = split[0];
            prefix = prefix.split("\\+")[0];

            prefix.replaceAll("\\.", "");

            StringBuilder sb = new StringBuilder(prefix).append(split[1]);
            set.add(sb.toString());
        }
        return set.size();
    }

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }

    /**
     * 741. 摘樱桃
     *
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int totalK = n * 2 - 1;
        int[][][] dp = new int[totalK][n][n];

        for (int i = 0; i < totalK; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = grid[0][0];

        for (int k = 1; k < totalK; k++) {
            for (int y1 = Math.max(k - n + 1, 0); y1 <= Math.min(k, n - 1); y1++) {
                if (grid[y1][k - y1] == -1) {
                    continue;
                }

                for (int y2 = y1; y2 <= Math.min(k, n - 1); y2++) {
                    if (grid[y2][k - y2] == -1) {
                        continue;
                    }

                    int res = dp[k - 1][y1][y2];

                    if (y1 > 0) {
                        res = Math.max(res, dp[k - 1][y1 - 1][y2]);
                    }
                    if (y2 > 0) {
                        res = Math.max(res, dp[k - 1][y1][y2 - 1]);
                    }

                    if (y1 > 0 && y2 > 0) {
                        res = Math.max(res, dp[k - 1][y1 - 1][y2 - 1]);
                    }

                    res += grid[y1][k - y1];
                    if (y1 != y2) {
                        res += grid[y2][k - y2];
                    }

                    dp[k][y1][y2] = res;
                }
            }
        }
        return Math.max(dp[n * 2 - 2][n - 1][n - 1], 0);
    }

    class WordFilter {
        DicTree prefix;
        DicTree suffix;

        public WordFilter(String[] words) {
            prefix = new DicTree();
            suffix = new DicTree();
            for (int i = 0; i < words.length; i++) {
                prefix.orderCompose(words[i], 0, i);
                suffix.disOrderCompose(words[i], words[i].length() - 1, i);
            }
            System.out.println("==");
        }

        public int f(String pref, String suff) {
            List<Integer> p = findPrefix(pref);
            List<Integer> s = findSuffix(suff);
            if (p == null || s == null || p.size() == 0 || s.size() == 0) {
                return -1;
            }

            int pi = p.size() - 1;
            int si = s.size() - 1;

            while (pi >= 0 && si >= 0) {
                if (p.get(pi).equals(s.get(si))) {
                    return p.get(pi);
                } else if (p.get(pi).compareTo(s.get(si)) > 0) {
                    pi--;
                } else {
                    si--;
                }
            }
            return -1;
        }

        public List<Integer> findPrefix(String s) {
            DicTree tmp = prefix;
            int i = 0;
            while (tmp != null && i < s.length()) {
                tmp = tmp.children[s.charAt(i) - 'a'];
                i++;
            }
            if (tmp != null) {
                return tmp.list;
            }
            return null;

        }

        public List<Integer> findSuffix(String s) {
            DicTree tmp = suffix;
            int i = s.length() - 1;
            while (tmp != null && i >= 0) {
                tmp = tmp.children[s.charAt(i) - 'a'];
                i--;
            }
            if (tmp != null) {
                return tmp.list;
            }
            return null;
        }
    }

    /**
     * Your WordFilter object will be instantiated and called as such:
     * WordFilter obj = new WordFilter(words);
     * int param_1 = obj.f(pref,suff);
     */

    class DicTree {
        public DicTree[] children;
        List<Integer> list;

        public DicTree() {
            this.children = new DicTree[26];
            list = new ArrayList();
        }

        public void orderCompose(String s, int i, int j) {
            if (i < 0 || i >= s.length()) {
                return;
            }
            int next = s.charAt(i) - 'a';
            if (this.children[next] == null) {
                this.children[next] = new DicTree();
            }

            this.children[next].list.add(j);
            this.children[next].orderCompose(s, i + 1, j);
        }


        public void disOrderCompose(String s, int i, int j) {
            if (i < 0 || i >= s.length()) {
                return;
            }
            int next = s.charAt(i) - 'a';
            if (this.children[next] == null) {
                this.children[next] = new DicTree();
            }

            this.children[next].list.add(j);
            this.children[next].disOrderCompose(s, i - 1, j);
        }


    }

    /**
     * 592. 分数加减运算
     * <p>
     * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
     * <p>
     * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param expression
     * @return
     */
    public String fractionAddition(String expression) {
        // -1/2+3/5
        int endIndex = findNowStr(expression, 0);
        String f = expression.substring(0, endIndex);

        while (endIndex < expression.length()) {
            int endIndexTwo = findNowStr(expression, endIndex + 1);

            String s = expression.substring(endIndex, endIndexTwo);
            f = caculate(f, s);
            endIndex = endIndexTwo;
        }
        return f;
    }

    private String caculate(String f, String s) {
        // f 正数无符号 负数-
        boolean negetive = false;
        if (f.charAt(0) == '-') {
            if (s.charAt(0) == '-') {
                negetive = true;
                s = s.substring(1);
                f = f.substring(1);
                String[] sSplit = s.split("/");
                String[] fSplit = f.split("/");
                if (sSplit[1].equals(fSplit[1])) {

                }

            } else {

            }
        } else {
            if (s.charAt(0) == '-') {
                //
            } else {
                negetive = false;
            }
        }

        return null;
    }

    private int findNowStr(String expression, int s) {

        int end = expression.length();
        while (s < expression.length()) {
            if (s == 0 && expression.charAt(s) == '-') {
                continue;
            }
            if (expression.charAt(s) == '-' || expression.charAt(s) == '+') {
                end = s;
                break;
            }
            s++;
        }
        return end;
    }

    /**
     * 1403. 非递增顺序的最小子序列
     * <p>
     * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
     * <p>
     * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
     * <p>
     * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
     * <p>
     * 注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int x = 0; x < nums.length; x++) {
            sum += nums[x];
        }
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int sum2 = 0;
        for (int x = nums.length - 1; x >= 0; x--) {
            sum2 += nums[x];
            res.add(nums[x]);
            if (sum2 > sum - sum2) {
                return res;
            }
        }
        return res;
    }

    /**
     * 1302. 层数最深叶子节点的和
     * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int c = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = 0;
            for (int x = 0; x < size; x++) {
                TreeNode pop = queue.poll();
                res += pop.val;
                System.out.println("val:" + pop.val);
                if (pop.left != null) {
                    queue.offer(pop.left);
                }
                if (pop.right != null) {
                    queue.offer(pop.right);
                }
            }
            System.out.println(c + "__" + size + "____" + res);
            c++;
        }
        return res;
    }

    /**
     * 915. 分割数组
     * <p>
     * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
     * <p>
     * left 中的每个元素都小于或等于 right 中的每个元素。
     * left 和 right 都是非空的。
     * left 的长度要尽可能小。
     * 在完成这样的分组后返回 left 的 长度 。
     * <p>
     * 用例可以保证存在这样的划分方法。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/partition-array-into-disjoint-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] lnums = new int[n];
        int[] rnums = new int[n];

        lnums[0] = nums[0];
        rnums[n - 1] = nums[n - 1];
        for (int x = 1; x < n; x++) {
            int l = x;
            int r = n - x - 1;

            lnums[l] = Math.max(nums[l], lnums[l - 1]);
            rnums[r] = Math.min(nums[r], rnums[r + 1]);
        }

        for (int x = 0; x < n; x++) {
            if (lnums[x] < rnums[x]) {
                return x + 1;
            }
        }
        return -1;
    }

    /**
     * 2116. 判断一个括号字符串是否有效
     * 一个括号字符串是只由 '(' 和 ')' 组成的 非空 字符串。如果一个字符串满足下面 任意 一个条件，那么它就是有效的：
     * <p>
     * 字符串为 ().
     * 它可以表示为 AB（A 与 B 连接），其中A 和 B 都是有效括号字符串。
     * 它可以表示为 (A) ，其中 A 是一个有效括号字符串。
     * 给你一个括号字符串 s 和一个字符串 locked ，两者长度都为 n 。locked 是一个二进制字符串，只包含 '0' 和 '1' 。对于 locked 中 每一个 下标 i ：
     * <p>
     * 如果 locked[i] 是 '1' ，你 不能 改变 s[i] 。
     * 如果 locked[i] 是 '0' ，你 可以 将 s[i] 变为 '(' 或者 ')' 。
     * 如果你可以将 s 变为有效括号字符串，请你返回 true ，否则返回 false 。
     *
     * @param s
     * @param locked
     * @return
     */
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> preStack = new Stack<>();
        Stack<Integer> wildcardStack = new Stack<>();
        int singleCnt = s.length() / 2;
        if (s.length() % 2 == 1) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    preStack.push(i);
                } else if (preStack.isEmpty() && wildcardStack.isEmpty()) {
                    return false;
                } else if (!preStack.isEmpty()) {
                    preStack.pop();
                } else if (!wildcardStack.isEmpty()) {
                    wildcardStack.pop();
                }
            } else {
                wildcardStack.push(i);
            }
        }

        while (!preStack.isEmpty()) {
            Integer pop = preStack.pop();
            if (wildcardStack.isEmpty()) {
                return false;
            }
            Integer pop1 = wildcardStack.pop();
            if (pop > pop1) {
                return false;
            }
        }
        return true;
    }


    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        for (int x = 0; x < n; x++) {
            int c = map.getOrDefault(nums[x] - x, 0);
            map.put(nums[x] - x, c + 1);
        }
        long totalPair = choice(n, 2);
        long goodPair = 0;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (var entry : set) {
            Integer v = entry.getValue();
            Integer k = entry.getKey();

            if (v > 1) {
                goodPair += choice(v, 2);
            }
        }
        System.out.println("totalElements: " + n);

        System.out.println("totalPair: " + totalPair);
        System.out.println("goodPair: " + goodPair);

        return totalPair - goodPair;
    }

    public long choice(int n, int m) {
        long a = stepMulti(n);
        long b = stepMulti(m);
        long c = stepMulti(n - m);
        System.out.printf("n: %s, m : %s", n, m);
        System.out.println();

        System.out.printf("a : %s, b: %s, c : %s", a, b, c);
        System.out.println();

        return (long) (a / (b * c));
    }

    public long stepMulti(int v) {
        long result = 1;
        for (int x = 1; x <= v; x++) {
            result *= ((long) x);
        }
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> mapping = new TreeMap<>();
        int l = 0, r = 0;
        int[] ans = new int[nums.length - k + 1];
        while (r < k) {
            int num = nums[r];
            int c = mapping.getOrDefault(num, 0);
            mapping.put(num, c + 1);
            r++;
        }
        int index = 0;
        while (r < nums.length) {
            Map.Entry<Integer, Integer> entry = mapping.lastEntry();
            ans[index++] = entry.getKey();

            int lv = mapping.get(nums[l]);
            if (lv > 1) {
                mapping.put(nums[l], lv - 1);
            } else {
                mapping.remove(nums[l]);
            }
            l++;

            r++;
        }
        return ans;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] bits = new int[26];
        int pn = p.length();
        int diff = 0;
        for (int x = 0; x < pn; x++) {
            int ori = bits[(p.charAt(x) - 'a')];
            if (ori == 0) {
                diff++;
            }
            bits[(p.charAt(x) - 'a')] = ori + 1;
        }

        List<Integer> ans = new ArrayList<>();
        int r = 0;
        while (r < pn) {
            int ori = bits[(s.charAt(r) - 'a')];
            bits[(s.charAt(r) - 'a')] = ori - 1;
            if (ori - 1 == 0) {
                diff--;
            } else if (ori == 0) {
                diff++;
            }
            r++;
        }
        if (diff == 0) {
            ans.add(0);
        }

        while (r < s.length()) {
            int ori = bits[(s.charAt(r) - 'a')];
            bits[(s.charAt(r) - 'a')] = ori - 1;
            if (ori - 1 == 0) {
                diff--;
            } else if (ori == 0) {
                diff++;
            }
            int l = r - pn;
            ori = bits[(s.charAt(l) - 'a')];
            bits[(s.charAt(l) - 'a')] = ori + 1;
            if (ori + 1 == 0) {
                diff--;
            } else if (ori == 0) {
                diff++;
            }
            if (diff == 0) {
                ans.add(l + 1);
            }
            r++;
        }
        return ans;
    }


    public int longestPalindrome(String[] words) {
        Map<String, Integer> prefix = new HashMap<>();
        Map<String, Integer> subffix = new HashMap<>();
        int len = 0;
        int[] middleNums = new int[26];
        for (String w : words) {
            // check middle
            char c1 = w.charAt(0);
            char c2 = w.charAt(1);
            String reverse = new String(new char[]{c2, c1});
            if (c1 == c2) {
                middleNums[c1 - 'a']++;
            } else if (prefix.containsKey(w) || !prefix.containsKey(reverse)) {
                int num = prefix.getOrDefault(w, 0);
                prefix.put(w, num + 1);

                int pNum = subffix.getOrDefault(reverse, 0);
                if (pNum >= num + 1) {
                    len += 4;
                }
            } else {
                int num = subffix.getOrDefault(w, 0);
                subffix.put(w, num + 1);
                String originWord = new String(new char[]{c2, c1});
                int pNum = prefix.getOrDefault(originWord, 0);
                if (pNum >= num + 1) {
                    len += 4;
                }
            }
        }
        int maxMiddle = 0;

        for (int m : middleNums) {
            len += ((m / 2) * 4);
            maxMiddle = Math.max(m * 2, maxMiddle);
        }
        len -= ((maxMiddle/4) * 4);
        return len + maxMiddle;
    }

    public static void main(String[] args) {
        Solution5 s5 = new Solution5();

        var answer = s5.longestPalindrome(new String[]{"nn","nn","hg","gn","nn","hh","gh","nn","nh","nh"});
        System.out.println(answer);
    }


}
