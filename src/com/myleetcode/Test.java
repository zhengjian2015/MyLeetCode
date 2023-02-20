package com.myleetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        boolean t = s.add("1");
        boolean t2 = s.add("1");
        System.out.println(t);
        System.out.println(t2);
        //长度为3  ，n = 4. 0~3  4
        //长度为2  n = 3  0~2  0,1,2 3个数字
        int[] nums = {6,2,5};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //1 4 5 6  -3 < -1 2
    }
}
