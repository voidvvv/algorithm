package cn.zkj.lk.sctruction;


/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。
当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache {
    private int capacity;
    private int capacityNow = 0;
    private int[] keySet;
    private Node [] nodes;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.keySet=new int[capacity];
        this.nodes=new Node[capacity];
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }

    class Node implements Comparable{
        private int key;
        private int value;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Node){
                int key = ((Node) o).getKey();
                return this.key-key;
            }
            return 0;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */