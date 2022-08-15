package cn.zkj.algorithm.construct.lru;

import java.util.Arrays;

/**
 * 最近使用队列类
 * Author: KJ.ZHAO
 * Date: 2022/8/12 16:21
 */
public class LRUcache {
    class Node{
        int key;
        int val;
        Node next;
        Node pre;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }

        public String toString(){
            return String.format("{preKey:%s,nextKey:%s,key:%s,val:%s}",pre==null?"null":pre.key,next==null?"null":next.key,key,val);
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private int curSize;
    private Node[] cache;

    public LRUcache(int size) {
        this.size = size;
        this.curSize = 0;
        cache = new Node[10001];
    }

    public void put(int key,int val){
        Node x= new Node(key,val);

        if (cache[key] == null){
            cache[key] = x;
            if (this.head == null){
                this.head = x;
            }
            if (this.tail == null){
                this.tail = x;
            }else {
                this.tail.next = x;
                x.pre = tail;
                this.tail = x;
            }
            curSize++;
        }else {
            Node t = cache[key];
            Node pre = t.pre;
            Node next = t.next;
            if (pre!=null){
                pre.next = next;
            }
            if (next!=null){
                next.pre = pre;
            }
            this.tail.next = x;
            x.pre = tail;
            this.tail = x;
        }
        this.head.pre = null;
        if (curSize>size){
            Node oHead = this.head;
            this.head = oHead.next;
            this.head.pre = null;
            cache[oHead.key] = null;
        }
    }

    public int get(int key){
        if (cache[key]!=null){
            Node x = cache[key];
            Node pre = x.pre;
            Node next = x.next;
            if (pre!=null){
                pre.next = next;
            }
            if (next!=null){
                next.pre =pre;
            }
            if (this.head == x){
                if (x.next!=null){
                    this.head = x.next;
                }
            }
            if (this.tail!=x){
                x.next = null;
                this.tail.next = x;
                x.pre = this.tail;
                this.tail = x;
            }
            this.head.pre = null;
            return x.val;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LRUcache lrUcache = new LRUcache(2);

        lrUcache.put(1,2);
        System.out.println(Arrays.toString(lrUcache.cache));
        lrUcache.get(1);
        System.out.println(Arrays.toString(lrUcache.cache));
        lrUcache.put(2,2);
        System.out.println(Arrays.toString(lrUcache.cache));

//        lrUcache.get(1);
//        System.out.println(Arrays.toString(lrUcache.cache));

        lrUcache.put(3,2);
        System.out.println(Arrays.toString(lrUcache.cache));

        System.out.println(lrUcache.get(1));
    }
}
