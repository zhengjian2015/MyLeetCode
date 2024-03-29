package com.shanggg.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "林冲2", "豹子头2");
        HeroNode hero6 = new HeroNode(6, "林冲3", "豹子头3");
        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero5);
        singleLinkedList.add(hero6);
        System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));
        singleLinkedList.list();
        /*singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero2);
        //显示一把
        singleLinkedList.list();

        System.out.println("修改后的");
        HeroNode newHero = new HeroNode(2, "卢员外", "豹子头");
        singleLinkedList.update(newHero);
        singleLinkedList.list();

        singleLinkedList.del(1);
        System.out.println("删除后的");
        singleLinkedList.list();
        System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));*/
        /*System.out.println("反转后的");
        SingleLinkedList.reserveHead(singleLinkedList.getHead());
        singleLinkedList.list();*/

        //SingleLinkedList.reservePrint(singleLinkedList.getHead());

        System.out.println("反转后的");
        //SingleLinkedList.reserveHead(singleLinkedList.getHead(),1,2);
        //singleLinkedList.list();
        SingleLinkedList.reverseKGroup(singleLinkedList.getHead(), 5);
        singleLinkedList.list();
    }
}

class SingleLinkedList {
    //先初始化一个头节点，头节点不要动 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next 指向新的节点
    public void add(HeroNode headNode) {

        //因为head节点不能动,因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表,找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = headNode;
    }

    //显示链表【遍历】
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //往后移
            temp = temp.next;
        }
    }


    public void addByOrder(HeroNode heroNode) {

        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                System.out.println(heroNode.no + "该英雄序号已存在,不能插入");
                return;
            }
            temp = temp.next;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    //修改节点信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode newHeroNode) {

        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
            }
            temp = temp.next;
        }
    }


    //删除节点
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    //方法，获取到单链表节点的个数(如果是带头节点的链表，需要不统计头节点)

    /**
     * @param head 链表的头节点
     * @return
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            System.out.println("空节点");
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (true) {
            if (cur == null) {
                break;
            }
            length++;
            cur = cur.next;
        }
        return length;
    }


    public static void reserveHead(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针(变量),帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reserveHead = new HeroNode(0, "", "");
        //从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reserveHead的最前端
        while (cur != null) {
            next = cur.next; //临时保存一下 后面需要使用
            cur.next = reserveHead.next;  //将cur的下一个节点指向新的链表的最前端
            reserveHead.next = cur;
            cur = next;  //让cur 后移动
        }
        head.next = reserveHead.next;

    }

    /**
     * 终于平自己的努力做出了链表的中等题，值得纪念
     * 思路就是 基于 反转链表1的思路
     * 新链表， 把旧链表逐一遍历 ，left-right之间还是老思路，但是小于left和大于right的就正常拼接
     * 需要主要<left 不需要把头结点往后移
     * 但是大于right 的需要把头节点移到最后，再拼接
     * 同时正常拼接 需要把 cur.next = null,否则有链表里有环
     *
     * @param head
     * @param left
     * @param right
     */
    public static void reserveHead(HeroNode head, int left, int right) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null || left >= right) {
            return;
        }
        //定义一个辅助的指针(变量),帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reserveHead = new HeroNode(0, "", "");
        HeroNode temp = reserveHead;
        int i = 1;
        //从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reserveHead的最前端
        while (cur != null) {
            //System.out.println(temp.next != null ? temp.next.no : "ss");
            if (i >= left && i <= right) {
                System.out.println("kk" + i);
                next = cur.next; //临时保存一下 后面需要使用
                cur.next = temp.next;  //将cur的下一个节点指向新的链表的最前端
                temp.next = cur;
                cur = next;  //让cur 后移动
                //temp = temp.next;
            } else {
                while (temp.next != null) {
                    temp = temp.next;
                }
                next = cur.next;
                cur.next = null;
                temp.next = cur;
                cur = next;
                temp = temp.next;
            }
            i++;
        }
        head.next = reserveHead.next;
    }


    /**
     * 结合上面两个例子后。leetcode这道最难题也做出来了
     * 调式难点是  g < m 和 g >= m
     *
     * @param head
     * @param k
     */
    public static void reverseKGroup(HeroNode head, int k) {
        if (head == null || head.next == null) {
            return;
        }
        HeroNode reserveHead = new HeroNode(0, "", "");
        HeroNode temp = head.next;
        HeroNode cur = head.next;
        HeroNode dummyHead = reserveHead;
        int n = 0;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        System.out.println("n:"+n);
        if (n == k) {
            while (cur != null) {
                HeroNode next = cur.next;
                cur.next = reserveHead.next;
                reserveHead.next = cur;
                cur = next;
            }
            head.next = reserveHead.next;
        }
        int g = 0; //记录当前编号

        if (n > k) {
            int m = (n / k) * k; //最后头节点的落点编号
            //System.out.println(m);
            while (cur != null) {
                HeroNode next = cur.next;

                if (g < m) {

                    if(g % k == 0) {
                        while (dummyHead.next != null) {
                            dummyHead = dummyHead.next;
                        }
                    }
                    cur.next = dummyHead.next;
                    dummyHead.next = cur;
                    cur = next;

                    g++;
                }
                if (g >= m) {
                    while (dummyHead.next != null) {
                        dummyHead = dummyHead.next;
                    }
                    dummyHead.next = cur;
                    if(cur != null)
                        cur.next = null;
                    cur = next;
                    dummyHead = dummyHead.next;
                    g++;
                }
            }
            head.next = reserveHead.next;
        }

    }

    //逆序打印 ，使用栈的方法
    public static void reservePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

//定义HeroNode
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
