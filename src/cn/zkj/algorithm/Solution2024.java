package cn.zkj.algorithm;

import java.util.*;
import java.util.stream.Stream;

public class Solution2024 {

    /**
     * 752. 打开转盘锁
     *
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        String start = "0000";
        for (String deadend : deadends) {
            seen.add(deadend);
        }
        if (seen.contains(start)) {
            return -1;
        }
        queue.offer(start);
        seen.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> nextList = findNext(cur);
                for (String next : nextList) {
                    if (next.equals(target)) {
                        return step;
                    }
                    if (!seen.contains(next)) {
                        seen.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> findNext(String cur) {
        char[] charArray = cur.toCharArray();
        List<String> result= new ArrayList<>();
        for (int x=0; x<charArray.length; x++) {
            char ch = charArray[x];
            char c = leftChar(ch);
            charArray[x] = c;
            result.add(new String(charArray));
            c = rightChar(ch);
            charArray[x] = c;
            result.add(new String(charArray));
            charArray[x] = ch;
        }
        return result;
    }

    private char rightChar(char ch) {
        return ch == '9' ? '0' : (char)(ch+1);
    }

    private char leftChar(char ch) {
        return ch == '0' ? '9' : (char)(ch-1);
    }

    Set<String> seen = new HashSet<String>();

    Queue<String> queue = new LinkedList<String>();

    public static void main(String[] args) {
        Solution2024 solution = new Solution2024();
        int i = solution.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
        System.out.println(i);
    }
}
