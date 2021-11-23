package com.myleetcode.offer18;

public class Solution1 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-99);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre.next != null) {
            ListNode deleteNode = pre.next;
            if(deleteNode.val == val) {
                pre.next = deleteNode.next;
            } else {
                pre = pre.next;
            }

        }
        return dummyHead.next;
    }

}
