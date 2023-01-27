package com.shanggg.linkedlist;


import java.util.Stack;

/**
 *
 * https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/comments/
 * 新浪面试题是 力扣原题， 最好的方案是 双指针，就循环一遍
 *
 *
 * 腾讯面试题  单链表的反转  这题做过很多遍了 ，感觉还是没掌握
 *
 * 1.先定义一个节点 reserveHead = new HeroNode();
 * 2.从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reserveHead的最前端
 * 3.原来的链表的head.next = reserveHead.next
 *
 *
 * 百度面试题  倒叙打印链表
 *     1.用栈 先进后出
 *     2.反转链表再打印，不建议，破坏了原来的结构
 *
 *  课后题 合并两个有序链表
 *
 *  思路：  创建一个新的头节点， 两个cur指针分别指着A和B往下移动
 *          把头节点
 *
 *          就是 l1 和 l2 不需要再用变量指着了， 否则会 超时 ， 不懂啊啊啊啊啊
 *           while(l1 != null && l2 != null) {
 *             if(l1.val > l2.val) {
 *                  cur3.next = l2;
 *                  l2 = l2.next;
 *             } else {
 *                 cur3.next = l1;
 *                 l1 = l1.next;
 *             }
 *             cur3 = cur3.next;
 *         }
 *         if (l1 != null) {
 *             cur3.next = l1;
 *         }
 *         if (l2 != null) {
 *             cur3.next = l2;
 *         }
 *
 */
public class Test {
    //练习栈的使用方法
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.add("tom");
        stack.add("peter");
        stack.add("alan");

        while (stack.size() > 0 ) {
            System.out.println(stack.pop());
        }
    }


}
