package com.myleetcode.offer10;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    final int MOD = 1000000007;

    public int fib(int n) {
        int[] memo = new int[n];
        return fib(n,memo);
    }
    public int fib(int n,int[] memo) {
        if(n == 0 || n == 1) {
            return n ;
        }
        if(memo[n-1] != 0) {
            return memo[n-1];
        }
        memo[n-1] = (fib(n-2,memo)+fib(n-1,memo))% MOD;
        return memo[n-1];
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println( new Solution2().fib(45));
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
