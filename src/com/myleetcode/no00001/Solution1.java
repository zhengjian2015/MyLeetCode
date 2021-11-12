package com.myleetcode.no00001;

import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }


    public static void main(String[] args) {
	// write your code here
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        printArr((new Solution1()).twoSum(nums, target));
    }
}
