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
        String sql = "SELECT \n" +
                "   ifnull(partner_name,'') as partner_name, agent_code, count(0) AS order_Count, sum(ticket_count) AS ticket_Count\n" +
                " FROM \n" +
                "   (\n" +
                "      SELECT \n" +
                "         o.partner_order_id, t.agent_code, 'Ctrip.Corp' AS partner_name, count(0) AS ticket_count\n" +
                "      FROM after_order  o \n" +
                "         JOIN after_ticket  t ON o.partner_order_id = t.partner_order_id\n" +
                "      WHERE \n" +
                "         partner_name = 'Ctrip.Corp' AND \n" +
                "         t.success_time >= ? AND \n" +
                "         t.success_time <= ? AND \n" +
                "         state in (1,3)\n" +
                "      GROUP BY o.partner_order_id, t.agent_code\n" +
                "      UNION ALL\n" +
                "      SELECT \n" +
                "         o.partner_order_id, o.agent_code, 'shuntu' AS partner_name, count(0) AS ticket_count\n" +
                "      FROM after_order  o \n" +
                "         JOIN after_ticket  t ON o.partner_order_id = t.partner_order_id\n" +
                "      WHERE \n" +
                "         partner_name = 'shuntu' AND \n" +
                "         t.success_time >= ? AND \n" +
                "         t.success_time <= ? AND \n" +
                "         state in (1,3)\n" +
                "      GROUP BY o.partner_order_id, o.agent_code\n" +
                "      UNION ALL\n" +
                "      SELECT \n" +
                "         o.partner_order_id, o.agent_code, apply_msg AS partner_name, count(0) AS ticket_count\n" +
                "      FROM after_order  o \n" +
                "         JOIN after_ticket  t ON o.partner_order_id = t.partner_order_id\n" +
                "      WHERE \n" +
                "         partner_name = 'Ctrip.XBind' AND \n" +
                "         t.success_time >= ? AND \n" +
                "         t.success_time <= ? AND \n" +
                "         state in (1,3)\n" +
                "      GROUP BY o.partner_order_id, o.agent_code\n" +
                "   )  a\n" +
                "GROUP BY partner_name, agent_code";
        System.out.println(sql);
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
