package cn.zkj.lk.sctruction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. 全 O(1) 的数据结构
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
 *
 * 实现 AllOne 类：
 *
 * AllOne() 初始化数据结构的对象。
 * inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
 * dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
 * getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-oone-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Classname AllOne
 * @Description
 * @Date 2022/3/16 13:36
 * @Created by zkj
 */
public class AllOne {
    private Node root;
    private Map<String,Node> map;

    public AllOne() {
        this.root = new Node("",0);
        this.root.pre = this.root;
        this.root.next = this.root;

        map = new HashMap<>();
    }

    public void inc(String key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            Node nxt = node.next;
            if (nxt == this.root || nxt.count>node.count+1){
                // 此时需要插入结点
                map.put(key,node.insert(new Node(key,node.count+1)));
            }else {
                nxt.keys.add(key);
                map.put(key,nxt);
            }
            node.keys.remove(key);
            if (node.keys.isEmpty()){
                node.del();
            }
        }else {
            if (this.root.next == this.root || this.root.next.count>1){
                map.put(key,this.root.insert(new Node(key,1)));
            }else {
                this.root.next.keys.add(key);
                map.put(key,this.root.next);
            }
        }
    }

    public void dec(String key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.keys.remove(key);

            if (node.count == 1){
                map.remove(key);
            }else {
                Node pre = node.pre;
                if (pre.count== node.count-1){
                    pre.keys.add(key);
                    map.put(key,pre);
                }else {
                    map.put(key,pre.insert(new Node(key,node.count-1)));
                }

            }

            if (node.keys.isEmpty()){
                node.del();;
            }
        }
    }

    public String getMaxKey() {
        return root.pre != null ? root.pre.keys.iterator().next() : "";
    }

    public String getMinKey() {
        return root.next != null ? root.next.keys.iterator().next() : "";
    }

    class Node{
        Node pre;
        Node next;
        int count;
        Set<String> keys;
        public Node(String key,int count) {
            keys = new HashSet<String>();
            keys.add(key);
        }

        public Node insert(Node node){
            Node nxt = this.next;
            this.next = node;
            node.next = nxt;
            node.pre = this;
            nxt.pre = node;
            return node;
        }

        public void del(){
            this.pre.next = this.next;
            this.next.pre = this.pre;
        }
    }
}
