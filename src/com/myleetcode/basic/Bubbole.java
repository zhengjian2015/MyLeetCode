package com.myleetcode.basic;

import java.util.Arrays;

//冒泡排序
public class Bubbole {

    public static void main(String[] args) {
        int[] a = {1,7,4,3,2};
        for(int i = 0 ; i < a.length - 1 ; i++) {
            for(int j = 0 ; j < a.length -1 - i; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
