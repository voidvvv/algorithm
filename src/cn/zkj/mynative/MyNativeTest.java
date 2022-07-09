package cn.zkj.mynative;

/**
 * @Classname MyNativeTest
 * @Description
 * @Date 2022/6/25 1:08
 * @Created by zkj
 */
public class MyNativeTest {
    public static native int add(int a,int b);

    static {
        System.load("E:\\develop\\cpp-pro\\Dll1\\x64\\Debug\\Dll1.dll");
    }

    public static void main(String[] args) {
        MyNativeTest m = new MyNativeTest();
        int a = 10;
        m.test(a++,a++,a++,a++);
    }
    
    public void test(int a,int b,int c, int d){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
