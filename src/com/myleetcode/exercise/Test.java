package com.myleetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class Test {

    /**
     * [1,2,3]
     * @param args
     */
    static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(path,nums,used);
        System.out.println(lists);
    }

    private static void dfs(List<Integer> path, int[] nums, boolean[] used) {
        if(path.size() == nums.length) {
            lists.add(new ArrayList<>(path));
        }
        for(int i = 0 ; i < nums.length ; i++) {
            if(used[i] == true) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(path,nums,used);
            path.remove(path.size() -1);
            System.out.println(path);
            used[i] = false;
        }
    }

}

