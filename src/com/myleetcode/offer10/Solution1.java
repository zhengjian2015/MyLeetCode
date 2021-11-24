package com.myleetcode.offer10;

/**
 * 斐波那契数列 超出时间限制
 */
public class Solution1 {
    public int fib(int n) {
        if(n == 0 || n == 1)
            return n;
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println( new Solution1().fib(45));
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
