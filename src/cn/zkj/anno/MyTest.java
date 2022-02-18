package cn.zkj.anno;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2022/2/17
 * @version: 01
 */
public record MyTest(int age) {

    public static void main(String[] args) {
        MyTest m = new MyTest(20);

        System.out.println(m.toString());
    }
}
