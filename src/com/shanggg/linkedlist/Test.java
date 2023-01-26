package com.shanggg.linkedlist;


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
 *
 */
public class Test {
}
