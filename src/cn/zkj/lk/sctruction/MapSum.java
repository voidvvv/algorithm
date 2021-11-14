package cn.zkj.lk.sctruction;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhaoKaiJie
 * 677. 键值映射
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Description:
 * @Date: 2021/11/14
 * @version: 01
 */
public class MapSum {
    class PreFixNode{
        int val;
        PreFixNode[] children;

        public PreFixNode(int val) {
            this.val = val;
            children = new PreFixNode[26];
        }
    }
    Map<String,Integer> map ;
    PreFixNode root;

    public MapSum() {
        map = new HashMap<>();
        root = new PreFixNode(0);
    }

    public void insert(String key, int val) {
        if (key==null||key.length()==0){
            return;
        }
        Integer v = map.getOrDefault(key, 0);
        int diff = val-v;
        if (diff==0){
            return;
        }
        map.put(key,val);
        int length = key.length();
        char[] chars = key.toCharArray();
        PreFixNode tmp = root;
        for (int x=0;x<length;x++){
            PreFixNode child = tmp.children[chars[x] - 'a'];
            if (child==null){
                child = tmp.children[chars[x] - 'a']  = new PreFixNode(val);
            }else {
                child.val+=diff;
            }
            tmp = child;
        }
    }

    public int sum(String key) {
        if (key==null||key.length()==0){
            return 0;
        }
        int length = key.length();
        char[] chars = key.toCharArray();
        PreFixNode tmp = root;
        int re = 0;
        for (int x=0;x<length;x++){
            PreFixNode child = tmp.children[chars[x] - 'a'];
            if (child==null){
                return 0;
            }else {
                re = child.val;
            }
            tmp = child;
        }
        return re;
    }
}
