package com.myleetcode.no00069;

public class Solution {
    public static void main(String[] args) {
        int x = 9;
        int res = 0;
        for(int i = 0; i < x ; i++) {
            int g = x-1;
            System.out.println(i);
            System.out.println(i*i>x);
            System.out.println(i*i<=x);
            if(i*i>x && i*i <= (x+1)) {
                res = i-1;
                break;
            }
        }
        System.out.println(res);
    }
}
