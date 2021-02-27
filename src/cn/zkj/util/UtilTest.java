package cn.zkj.util;

import java.util.logging.Logger;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/2/26
 * @version: 01
 */
public class UtilTest {
    public static void main(String[] args) {
        MyMap<String,String> map = new MyMap<>();
        map.put(null,"b");
        map.put(null,"c");
        System.out.println(map.get(null));
        Logger.getLogger("a").info("{}");
    }
}
