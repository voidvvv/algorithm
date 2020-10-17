package cn.zkj.lk;

public class ReversInt implements Comparable<Object>{
    public static void main(String[] args) {
        ReversInt re = new ReversInt();
        ReversInt re2 = new ReversInt();
        CalPoint ca = new CalPoint();

        re2.test(re,ca);
    }

    public int reverse(int x) {
        int y=0;
        try{
            while (x>0){
                int temp = x%10;
                y=y*10+temp;
                x/=10;
            }
        }catch (Exception e){
            return 0;
        }
        return y;
    }

    void test(Comparable c1,Comparable c2){
        System.out.println(c1==c2);
        System.out.print("asdasdasdasda");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
