package com.myleetcode.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 数组的全排列
 *
 */
public class Main_1 {

    List<List<Integer>> list2 = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return list2;

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,path,used);
        return list2;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used) {
        if(path.size() == nums.length) {
            list2.add(new ArrayList<Integer>(path));
            return;
        }
        System.out.println("done");
        for(int i = 0 ;i < nums.length ; i++) {
            System.out.println("i"+i);
            if(used[i] == true) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
           // System.out.println(Arrays.toString(used));
           // System.out.println(path);
            dfs(nums,path,used);
            System.out.println("---");
            System.out.println(path.size() -1);
            path.remove(path.size() - 1);
            System.out.println(path);
            used[i] = false;
            System.out.println(Arrays.toString(used));
            if(i == 2) System.out.println("*");
            System.out.println(i);
        }
    }


    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Main_1()).permute(nums);

    }
}
