package cn.zkj.lk.sctruction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2022/1/26
 * @version: 01
 */
public class DetectSquares {
    Map<Integer, Map<Integer,Integer>> ycnt;

    public DetectSquares() {
        ycnt = new HashMap<>();
    }

    public void add(int[] point) {
        Map<Integer, Integer> curMap = ycnt.getOrDefault(point[1], new HashMap<>());
        curMap.put(point[0],curMap.getOrDefault(point[0],0)+1);
        ycnt.put(point[1],curMap);
    }

    public int count(int[] point) {
        int y = point[1];
        int x = point[0];

        if (!ycnt.containsKey(y)){
            return 0;
        }
        Map<Integer, Integer> curMap = ycnt.get(y);

        Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = ycnt.entrySet();
        int res= 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry:entries){
            Integer key = entry.getKey();
            Map<Integer, Integer> countMapping = entry.getValue();
            if (!key.equals(y)){
                int d= key -y;
                res+=(countMapping.getOrDefault(x,0)*curMap.getOrDefault(x+d,0)*countMapping.getOrDefault(x+d,0));
                res+=(countMapping.getOrDefault(x,0)*curMap.getOrDefault(x-d,0)*countMapping.getOrDefault(x-d,0));

            }

        }
        return res;
    }
}
