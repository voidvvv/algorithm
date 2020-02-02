package cn.zkj.lk;

import java.util.stream.IntStream;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] save=new int[26];
        for (char c:chars){
            save[c-'a']++;
        }

        for (int i=0;i<chars.length;i++){
            if (save[chars[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
