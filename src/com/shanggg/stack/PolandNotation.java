package com.shanggg.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //先定义逆波兰表达式

        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        System.out.println(calculate(rpnList));
    }

    private static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> res = new ArrayList<>();
        for(String s : split) {
            res.add(s);
        }
        return res;
    }

    //完成逆波兰表达式的计算
    public static int calculate(List<String> ls) {
        //创建栈
        Stack<String> stack = new Stack<>();

        //遍历ls
        for(String item : ls) {
            //使用正则表达式判断是否是数字
            if(item.matches("\\d+")) {//这里匹配的多位数
                stack.push(item);
            } else {
                //取出两个数运算，再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if("+".equals(item)) {
                    res = num1+num2;
                }else if("-".equals(item)) {
                    res = num2-num1;
                }else if("*".equals(item)) {
                    res = num2*num1;
                }else if("/".equals(item)) {
                    res = num2/num1;
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
