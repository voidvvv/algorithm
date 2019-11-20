package cn.zkj.lk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring lll= new LengthOfLongestSubstring();
        int abcabcde = lll.lengthOfLongestSubstring("abba");
        System.out.println(abcabcde);
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        //初始化一个长度，0，作为返回的最大子串长度载体
        int length = 0;
        //创建一个map，用来存放遍历到的字节以及所在位置的集合。字节为键，所在位置为值
        Map<Character,Integer> map = new HashMap<>();
        //遍历字符串，设置两个索引。一个开头，一个结尾。
        for (int begin =0 ,end=0;end<s.length();end++){
            //尾部索引不断向后走
            //并且每次都会用map的检索来查看是否包含此字节
            if (map.containsKey(s.charAt(end))){
                //若包含此字节，就将初始游标改变为此字节在map中所对应的的value值+1
                begin=Math.max(map.get(s.charAt(end))+1, begin);
            }
            // 而后将检索到的字节放入map中  字节为键，所在位置下标为值
            map.put(s.charAt(end),end);
            //最后更新长度为 length与两个游标之间的较大值
            length=Math.max(length,end-begin+1);
        }

        return length;
    }
}
