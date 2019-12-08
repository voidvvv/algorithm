package cn.zkj.lk;





public class Demo1 {
    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        MountainNum mountainNum = new MountainNum();
        Integer a=2;
        int i = a.compareTo(20);
        System.out.println(i);


    }

    public static void printOut(int i ){
        if(i>=10)
            printOut(i/10);
        printDigit(i%10);
    }

    private static void printDigit(int i){
        System.out.println(i);
    }
}
