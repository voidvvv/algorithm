package cn.zkj.lk;

import java.util.ArrayList;
import java.util.List;

/* 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 3
 输出: [1,3,3,1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class YasngHui {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        if (rowIndex<=1){
            for (int x=0;x<rowIndex;x++){
                result.add(1);

            }
            return result;
        }

        List<Integer> row = getRow(rowIndex - 1);
        result.add(1);
        for (int x=0;x<row.size()-1;x++){
            result.add(row.get(x)+row.get(x+1));
        }
        result.add(1);
        return result;


    }
}
