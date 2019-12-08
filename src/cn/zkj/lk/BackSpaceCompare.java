package cn.zkj.lk;

/*给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

         

        示例 1：

        输入：S = "ab#c", T = "ad#c"
        输出：true
        解释：S 和 T 都会变成 “ac”。
        示例 2：

        输入：S = "ab##", T = "c#d#"
        输出：true
        解释：S 和 T 都会变成 “”。
        示例 3：

        输入：S = "a##c", T = "#a#c"
        输出：true
        解释：S 和 T 都会变成 “c”。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/backspace-string-compare
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class BackSpaceCompare {

    public static void main(String[] args) {
        BackSpaceCompare c = new BackSpaceCompare();

        ArrayList a = new ArrayList();

        System.out.println(c.backspaceCompare("ab#c","ac"));
    }

    public boolean backspaceCompare(String S, String T) {
        //用刚学的栈的思想
        Stack<Character> S1=new Stack<>();
        Stack<Character> T1 = new Stack<>();

        for (int x=0;x<S.length();x++){
            if (S.charAt(x)=='#'){
                if (S1.empty()){

                }else {
                    S1.pop();
                }
            }else {
                S1.push(S.charAt(x));
            }
        }

        for (int x=0;x<T.length();x++){
            if (T.charAt(x)=='#'){
                if (T1.empty()){

                }else {
                    T1.pop();
                }
            }else {
                T1.push(T.charAt(x));
            }
        }

        return S1.equals(T1);
    }
}
