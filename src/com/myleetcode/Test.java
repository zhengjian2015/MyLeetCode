package com.myleetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Test {
    public  int sumNums(int n) {
        if(n == 1) {
            return 1;
        }
        else {
         return   n+ sumNums(n - 1);
        }
    }
}
