package com.myleetcode.no00141;

/**
 * 看到 O(1)的空间复杂度 就想到双指针了
 *
 * 但是具体怎么个双指针法 还是一脸懵逼
 *
 * 看答案 ，兔子一定先进入 环，而且一直绕圈
 * 总会和 乌龟相遇的
 */
public class Solution2 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast.next == null || fast == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
