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

    public static void main(String[] args) {
        Solution5 s5 = new Solution5();
//        s5.makesquare(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        s5.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
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
}
