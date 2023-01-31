package com.shanggg.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

    }


}

//创建一个双向链表的类
class DoubleLinkedList {

    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //显示链表【遍历】
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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

    //添加节点到单向链表
    //思路，当不考虑编号顺序
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next 指向新的节点
    public void add(HeroNode2 headNode) {

        //因为head节点不能动,因此我们需要一个辅助遍历 temp
        HeroNode2 temp = head;
        //遍历链表,找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = headNode;
        headNode.pre = temp;
    }

    //修改节点信息，根据no编号来修改，即no编号不能改
    //单链表和双链表的修改内容方法一样的
    public void update(HeroNode2 newHeroNode) {

        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        HeroNode2 temp = head.next;
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

    /**
     * 从双向链表中删除一个节点，
     * 说明
     * 1. 对于双向链表，我们可以直接找到要删除的节点
     * 2. 找到后，自我删除即可
     *
     * @param no
     */
    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null) { //空链表
            System.out.println("链表为空,无法删除");
            return;
        }

        HeroNode2 temp = head.next; //不需要找到前一个节点，所以是head的后个节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                //找到的删除的节点的前一个节点的temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //如果要删除最后一个节点
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }

    }
}

//定义HeroNode
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre; //指向前一个节点

    public HeroNode2(int no, String name, String nickName) {
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