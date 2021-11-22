package com.myleetcode.no00392;

public class Solution01 {
    public static void main(String[] args) {
    }

    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int s1 = 0;
        int t1 = 0;
        int g = 0;
        while(s1 <= sl && t1 <= tl) {
            if(s.charAt(s1) == t.charAt(t1)) {
                s1++;
                t1++;
                g++;
            } else {
                t1++;
            }
        }
        return g == s1;
    }
}
