package com.myleetcode.offer06;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在leetcode上做一遍，如果不会做，看答案，再在牛客网上做一遍
 */
public class Solution1 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            int[] res = new int[0];
            return res;
        }
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] res = new int[list.size()];
        int j = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[j++] = list.get(i);
        }
        return res;
    }
}
