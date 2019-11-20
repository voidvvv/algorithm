package cn.zkj.lk;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。*/

public class LongestSubString {
    public static void main(String[] args) {
        LongestSubString l = new LongestSubString();
       /* int asdasd = l.lengthOfLongestSubstring1("asdasdasd");
        System.out.println(asdasd);*/
        System.out.println(l.lengthOfLongestSubstring1("哈哈啊哈哈哈"));
        System.out.println("哈哈啊哈哈哈");
    }




    //暴力法
    public int lengthOfLongestSubstring1(String s) {
        int subLong = 0;//定义一个初始长度，最少为1 ，就定为1
        if (s.length()==1){
            return 1;
        }

        for(int x=0;x<s.length();x++){
            Loop:for(int y=x+1;y<s.length();y++){
                for(int z=x;z<y;z++){
                    if (s.charAt(y)==s.charAt(z)){
                        subLong=Math.max(subLong,z-x+1);
                        break Loop;
                    }
                }
                subLong=Math.max(subLong,y-x+1);

            }
        }


        return subLong;
    }
}
