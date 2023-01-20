package com.shanggg.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));
        singleLinkedList.addByOrder(hero1);
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
        System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));
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
