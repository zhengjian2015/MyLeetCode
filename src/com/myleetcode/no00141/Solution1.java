package com.myleetcode.no00141;

import java.util.HashMap;
import java.util.Map;

/**
 * 虽然不懂什么意思 但还是硬着头皮做出来了(没看答案嘿嘿）
 *
 * 思路是 用map来判断有没有出现过
 *
 * 时间复杂度是 O(n)
 * 空间复杂度是 O(n)
 *
 * 看了答案发现 Set 也行
 * 而且 set 在add 重复值是 会返回 false的
 * 学习了
 */
public class Solution1 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        Map<ListNode,Integer> map = new HashMap<>();
        while (cur != null) {
            cur = cur.next;
            map.put(cur,map.get(cur) == null ? 1 : map.get(cur) + 1);
            if(map.get(cur) > 1)  {
                return true;
            }
        }
        return false;
    }
}
