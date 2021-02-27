package cn.zkj.util;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/2/26
 * @version: 01
 */
public class MyMap<K, V> {

    private static final int defaultSize = 16;

    private boolean printFlag;
    private int size;

    private MyNode<K, V>[] table;

    public MyMap() {
        this(false);
    }

    public MyMap(boolean flag) {
        this(defaultSize);
        this.printFlag = flag;
    }

    private MyMap(int size) {
        if (size <= 0) {
            size = defaultSize;
        }
        this.size = size;
        this.table = (MyNode<K, V>[]) new MyNode[size];
    }

    private class MyNode<K, V> {

        private int kHash;
        private K key;
        private V value;
        private MyNode<K, V> next;


        private V findKey(K key) {
            MyNode<K,V> s= this;
            if (key==null){
                while (s!=null){
                    if (s.key==null){
                        return s.value;
                    }
                    s=s.next;
                }
            }else {
                while (s!=null){
                    if (s.key.equals(key)){
                        return s.value;
                    }
                }
            }
            return null;
        }


        private MyNode(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.kHash = hash;
        }


    }

    public void put(K key, V value) {
        int hash = toHash(key);
        int i;
        MyNode<K, V> n = table[(i = hash & (size - 1))];
        log(key + "存到了"+ i +"位置");
        if (n == null) {
            table[i] = new MyNode<>(key, value, hash);
        } else {
            MyNode<K, V> p = n, pre = n;
            while (p != null) {
                if (p.key == null) {
                    if (key == null) {
                        p.value = value;
                    }
                    break;
                }
                if (p.key.equals(key)) {
                    p.value = value;
                    break;
                }
                pre = p;
                p = p.next;
            }
            if (p == null) {
                pre.next = new MyNode<>(key, value, hash);
            }
        }
    }

    public V get(K key) {
        int hash = toHash(key);
        MyNode<K, V> node = table[hash & (size - 1)];
        if (node==null){
            return null;
        }
        return node.findKey(key);
    }



    private int toHash(Object o) {
        return o == null ? 0 : o.hashCode();
    }

    private  void log(String s){
        if (printFlag){
            System.out.println(s);
        }
    }
}
