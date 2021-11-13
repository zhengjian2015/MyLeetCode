package com.myleetcode.no00347;

import java.util.*;

/**
 * 不熟练 collections.sort的用法， 要用lambda表达式
 *
 * 时间复杂度是 O(Nlog(N))
 * 空间复杂度是 O(N)
 */
public class Solution1 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x,map.get(x) == null ? 0 : map.get(x)+1);
        }
        List<Integer> res = new ArrayList<>();
        for(int key : map.keySet()) {
            res.add(key);
        }
        Collections.sort(res,(a,b) -> {
            if(map.get(a) != map.get(b)) {
                return map.get(a) - map.get(b);
            }
            return a-b;
        });

        int[] result = new int[k];
        for(int i =0 ; i < k; i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        Collections.sort(res,(a,b) -> {
            return b - a;
        });
        System.out.println(res);
    }

}
