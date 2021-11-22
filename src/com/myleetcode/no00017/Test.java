package com.myleetcode.no00017;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if("".equals(digits)) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s){

        if(index == digits.length()) {
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        System.out.println("c:"+c);
        System.out.println(c - '0');
        String letters = letterMap[c - '0'];
        System.out.println(letters);
        for(int i = 0; i < letters.length() ; i++) {
            System.out.println("i-"+i);
            findCombination(digits,index+1,s+letters.charAt(i));
        }
        return;
    }

    private static void printList(List<String> list){
        for(String s: list)
            System.out.println(s);
    }

    public static void main(String[] args) {

        printList((new Test()).letterCombinations("23"));
    }
}
