package cn.zkj.lk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        for (Integer d: depth.values())
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
        for(int x=0;x<matchsticks.length;x++){
            total+=matchsticks[x];
            maxLength = Math.max(maxLength,matchsticks[x]);
        }

        if(total==0 || total%4 >0 ){
            return false;
        }
        int avg = total/4;
        if(maxLength >avg){
            return false;
        }
        boolean[] used = new boolean[matchsticks.length];

        for(int x=0;x<matchsticks.length;x++){
            if(used[x]){
                continue;
            }
            used[x] = true;
            if(!findTargetVal(matchsticks,used,avg-matchsticks[x])){
                return false;
            }
        }
        return true;

    }

    public boolean findTargetVal(int[] matchsticks,boolean[] used,int tv){
        if(tv == 0){
            return true;
        }
        for(int x=0;x<matchsticks.length;x++){
            if(used[x] || tv < matchsticks[x]){
                continue;
            }
            used[x] = true;
            if(findTargetVal(matchsticks,used,tv-matchsticks[x])){
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
        res+= numWays(1,steps-1,arrLen);

        return res%1000000007;
    }

    public long numWays(int i,int steps,int arrLen){
        if(i<0 || i >= arrLen){
            return 0;
        }

        if(steps == 0){
            if(i == 0){
                return 1;
            }else{
                return 0;
            }
        }

        return numWays(i-1,steps-1,arrLen)+ numWays(i+1,steps-1,arrLen);
    }

    public static void main(String[] args) {
        Solution5 s5 = new Solution5();
//        s5.makesquare(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
//        s5.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
        s5.minFlipsMonoIncr("000111");
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email:emails){
            String[] split = email.split("@");
            String prefix = split[0];
            prefix = prefix.split("\\+")[0];

            prefix.replaceAll("\\.","");

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
     * 592. 分数加减运算
     *
     * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
     *
     * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param expression
     * @return
     */
    public String fractionAddition(String expression) {
        // -1/2+3/5
        int endIndex = findNowStr(expression,0);
        String f = expression.substring(0,endIndex);

        while(endIndex<expression.length()){
            int endIndexTwo = findNowStr(expression, endIndex+1);

            String s = expression.substring(endIndex,endIndexTwo);
            f = caculate(f,s);
            endIndex = endIndexTwo;
        }
        return f;
    }

    private String caculate(String f, String s) {
        // f 正数无符号 负数-
        boolean negetive = false;
        if (f.charAt(0) == '-'){
            if (s.charAt(0) == '-'){
                negetive = true;
                s = s.substring(1);
                f = f.substring(1);
                String[] sSplit = s.split("/");
                String[] fSplit = f.split("/");
                if (sSplit[1].equals(fSplit[1])){

                }

            }else {

            }
        }else {
            if (s.charAt(0) == '-'){
                //
            }else {
                negetive = false;
            }
        }

        return null;
    }

    private int findNowStr(String expression,int s) {

        int end = expression.length();
        while (s<expression.length()){
            if (s==0&&expression.charAt(s)=='-'){
                continue;
            }
            if (expression.charAt(s)=='-'||expression.charAt(s)=='+'){
                end = s;
                break;
            }
            s++;
        }
        return end;
    }
}
