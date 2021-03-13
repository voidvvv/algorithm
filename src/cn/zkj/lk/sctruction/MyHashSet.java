package cn.zkj.lk.sctruction;

/**
 * @Author: zhaoKaiJie
 * @Description: 705. 设计哈希集合
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * @Date: 2021/3/13
 * @version: 01
 */
public class MyHashSet {
    private int size;
    private MyHashSetNode[] table;

    private static int DEFAULT_SIZE = 1<<4;

    private class MyHashSetNode{
        MyHashSetNode next;
        int val;

        public MyHashSetNode(int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        this(DEFAULT_SIZE);
    }

    public MyHashSet(int size) {
        this.size = size;
        this.table = new MyHashSetNode[size];
    }

    public void add(int key) {
        int position = key%this.size;
        MyHashSetNode node,pre,head;
        if ((head=node=table[position])==null){
            table[position] = new MyHashSetNode(key);
        }else {
            pre = head;
            while (node!=null){
                pre = node;
                if (node.val==key){
                    //将原有的key替换掉
                    return;
                }
                node = node.next;
            }
            pre.next = new MyHashSetNode(key);
        }
    }

    public void remove(int key) {
        int position = key%this.size;
        MyHashSetNode node,pre,head;
        if ((head=node=table[position])==null){
            //若本身为空，则无操作
        }else {
            pre = head;
            while (node!=null){
                if (node.val==key){
                    if (pre==head){
                        //当前为头节点
                        table[position] = head.next;
                        return;
                    }else {
                        pre.next=node.next;
                        return;
                    }
                }
                pre = node;
                node = node.next;
            }
            pre.next = new MyHashSetNode(key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int position = key%this.size;
        MyHashSetNode node,pre;
        if ((pre=node=table[position])==null){
            return false;
        }else{
            while (node!=null){
                if (node.val==key){
                    return true;
                }
            }
            return false;
        }
    }
}
