package com.myleetcode.offer10;

public class Solution3 {
    public int fib(int n) {
        final int MOD = 1000000007;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <=n ; i++) {
            memo[i] = memo[i-1]+memo[i-2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println( new Solution3().fib(3));
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
