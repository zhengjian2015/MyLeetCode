package com.myleetcode.no00125;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String res = s.replaceAll(" ","").toLowerCase();
        System.out.println(res);
        Stack<Character> stack = new Stack<>();
        String ma = "";
        for(int i = 0; i < res.length() ; i++) {
            if(Character.isLetterOrDigit(res.charAt(i))) {
                stack.push(res.charAt(i));
                ma=ma+res.charAt(i);
            }
        }
        System.out.println(ma);
        int j = 0;
        while (stack.isEmpty()) {
            if(!stack.pop().equals(ma.charAt(j))) {

                break;
            } else {
                j++;
            }

        }
    }
}
