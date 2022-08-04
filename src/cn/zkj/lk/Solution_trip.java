//package cn.zkj.lk;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Author: KJ.ZHAO
// * Date: 2022/7/1 14:50
// */
//public class Solution_trip {
//
//
//    /**
//     *241. 为运算表达式设计优先级
//     给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
//
//     生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
//     * @param expression
//     * @return
//     */
//    List<Integer> parseInts = new ArrayList<>();
//    List<String> opts = new ArrayList<>();
//    List<Integer> leftRes = new ArrayList<>();
//    List<Integer> rightRes = new ArrayList<>();
//    public List<Integer> diffWaysToCompute(String expression) {
//        parseFormulator(expression);
//
//        for (int x=0;x<opts.size();x++){
//
//        }
//    }
//
//    private void parseFormulator(String expression) {
////        Pattern p = Pattern.compile("[+\\-*]");
//        int i = 0;
//        for(int x=0;x<expression.length();x++){
//            String substring = expression.substring(x, x + 1);
//            if (substring.matches("[+\\-*]")){
//                parseInts.add(Integer.valueOf(expression.substring(i,x)));
//                opts.add(substring);
//                i=x+1;
//            }
//        }
//    }
//
//    private List<Integer> crossComput(String expression, int i, int j) {
//
//        return null;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("+".matches("[+\\-*]"));
//        System.out.println("22".matches("[0-9]"));
//        Pattern p = Pattern.compile("[+\\-*]");
//        Matcher matcher = p.matcher("asdad+asdasdasd");
////        matcher.
//
//    }
//}
