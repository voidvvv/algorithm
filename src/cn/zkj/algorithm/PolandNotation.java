package cn.zkj.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String s = "5*(6+10+2*10)+3";
        PolandNotation p = new PolandNotation();

        List<String> strings = p.toMaderateExpressionList(s);

        List<String> strings1 = p.toInfixExpressionList(strings);

        System.out.println(strings);
        System.out.println(strings1);
    }

    public List<String> toMaderateExpressionList(String s) {
        String str;
        int i = 0;
        char c;
        List<String> list = new ArrayList<>();
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    public List<String> toInfixExpressionList(List<String> ls) {

        //符号
        Stack<String> s1 = new Stack<>();
        //结果
        List<String> s2 = new ArrayList<>();

        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                //这里检测到的是运算符
                while (s1.size() > 0 && getValue(s1.peek()) >= getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() > 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    public int getValue(String s) {
        int result = 0;
        switch (s) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
