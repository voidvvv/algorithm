package cn.zkj.lk;

import java.util.ArrayList;
import java.util.List;


/*
在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。

例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。

我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。

最终结果按照字典顺序输出。

示例 1:

输入: "abbxxxxzzy"
输出: [[3,6]]
解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
示例 2:

输入: "abc"
输出: []
解释: "a","b" 和 "c" 均不是符合要求的较大分组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/positions-of-large-groups
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int start=0;
        int end=1;

        int n=1;
        while (end<S.length()){
            while (end<S.length()&&S.charAt(start)==S.charAt(end)){
                n++;
                end++;
            }
            if (n>=3){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end-1);
                result.add(temp);
            }
            start=end;
            end++;
            n=1;
        }

        return result;
    }
}
