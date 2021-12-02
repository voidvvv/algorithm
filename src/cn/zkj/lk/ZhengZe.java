package cn.zkj.lk;

public class ZhengZe {

    public static void main(String[] args) {
        String[] s = {"1111", "1000100010001000"};
        String[] s2 = {"0000"
                + "0000"
                + "0010"
                + "1110",
                "0000"
                + "1000"
                + "1000"
                + "1100",
                "0000"
                + "0000"
                + "1110"
                + "1000",
                "0000"
                + "1100"
                + "0100"
                + "0100"};

        String[] s3 = {"0000"
                + "0000"
                + "1110"
                + "0010",
                "0000"
                        + "0100"
                        + "0100"
                        + "1100",
                "0000"
                        + "0000"
                        + "1000"
                        + "1110",
                "0000"
                        + "1100"
                        + "1000"
                        + "1000"};

        String [] s4 = {"0000"+"0000"+"1100"+"1100"};

        String [] s5 = {"0000"+"0000"+"0100"+"1110",
                "0000"+"1000"+"1100"+"1000",
                "0000"+"0000"+"1110"+"0100",
                "0000"+"0010"+"0110"+"0010",
                };
        System.out.println(0xf);
        for (int x=0;x<s.length;x++){
            System.out.print(Integer.parseInt(s[x],2)+",");
        }
        System.out.println();
        for (int x=0;x<s2.length;x++){
            System.out.print(Integer.parseInt(s2[x],2)+",");
        }
        System.out.println();
        for (int x=0;x<s3.length;x++){
            System.out.print(Integer.parseInt(s3[x],2)+",");
        }
        System.out.println();
        for (int x=0;x<s4.length;x++){
            System.out.print(Integer.parseInt(s4[x],2)+",");
        }
        System.out.println();
        for (int x=0;x<s5.length;x++){
            System.out.print(Integer.parseInt(s5[x],2)+",");
        }

    }

    public boolean isMatch(String s, String p) {

        if (p.equals("*")) {
            return true;
        }
        boolean f = false;
        return f;
    }
}
