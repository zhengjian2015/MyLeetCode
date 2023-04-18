package com.myleetcode.no0070;

import java.util.Arrays;


/**
 *
 * 递归的加缓存
 * 记忆化搜索
 */
public class Solution {
    public static void main(String[] args) {
        int n = 5;
        memo = new int[n+1];
        System.out.println(Arrays.toString(memo));
        System.out.println(getSum(n));
        System.out.println(Arrays.toString(memo));
    }

    public static int[] memo;

    private static int getSum(int n) {
        if(n == 0 || n == 1 || n == 2 || n == 3) {
            System.out.println("n:"+n);
            return n;
        }
        if(memo[n] != 0) {
            return memo[n];
        }
        memo[n] = getSum(n - 2) + getSum(n-1);
        return memo[n];
    }
}
