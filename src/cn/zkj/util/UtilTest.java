package cn.zkj.util;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/2/26
 * @version: 01
 */
public class UtilTest {
    public static void main(String[] args) {
        MyMap<String,String> map = new MyMap<>();
        map.put("a","b");
        System.out.println(map.get("a"));
    }
}
