package com.myleetcode.offer24;

/**
 *
 * 反转链表
 *     简单题 过一段时间还是做不来啊
 *     然后需要 三个变量，  pre cur next
 *     其中 next循环中定义
 *      {
 *          ListNode next = cur.next;
 *          cur.next = pre;
 *          pre = cur;
 *          cur = next;
 *      }
 *     反正记得是  最后return pre;
 *     呜呼哀哉，每次面试前背一遍算了
 */
public class Soluton1 {
}
