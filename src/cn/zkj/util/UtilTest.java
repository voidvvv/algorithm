package cn.zkj.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/2/26
 * @version: 01
 */
public class UtilTest {

    public static void main(String[] args) throws InterruptedException {
//        String sql = "SELECT \n" +
//                "   pullState, sum(\n" +
//                "      CASE \n" +
//                "         WHEN o.urgentFlag = 0 THEN 1\n" +
//                "         ELSE 0\n" +
//                "      END) AS normal_count, sum(\n" +
//                "      CASE " +
//                "         WHEN o.urgentFlag > 0 THEN 1 " +
//                "         ELSE 0 " +
//                "      END) AS urgent_count " +
//                " FROM outlet_Deliveryorderpull  p " +
//                "   LEFT JOIN outlet_Deliveryorder  o ON p.partnerOrderId = o.partnerOrderId " +
//                " WHERE pullState IN ( 0, 1, 10 ) AND p.createTime > '2021-10-01' and o.orderType=1 " +
//                " GROUP BY pullState;";

//        System.out.println(sql);
        System.out.println(Integer.toBinaryString(Integer.parseInt("e6",16)));
        System.out.println(Integer.toBinaryString(Integer.parseInt("88",16)));
        System.out.println(Integer.toBinaryString(Integer.parseInt("91",16)));
        System.out.println(Integer.toBinaryString(Integer.parseInt("ffff",16)));
        System.out.println(Integer.toBinaryString((int) Short.MAX_VALUE));
    }

    private static int findA() {
        return 20;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            ans.add(total);
        }
        return ans;

    }


}
