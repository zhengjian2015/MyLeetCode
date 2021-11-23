package com.myleetcode.offer05;

public class Soluton1 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        for(int i = 0; i < l; i++) {
            char ts = s.charAt(i);
            if(' ' == ts) {
                sb.append("%20");
            } else {
                sb.append(ts);
            }
        }
        return sb.toString();
    }
}
