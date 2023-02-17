package com.shanggg.stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack lst = new LinkedListStack();
        lst.push(2);
        lst.push(3);
        lst.list();
    }
}


class LinkedListStack {
    // 这个node节点就表示top的指向,它的next始终指向最后放入的数据
    private ListNode top = new ListNode(-99);; //表示栈顶，初始化为-1


    //value
    public void push(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = top.next;
        top.next = newNode;

    }

    public int pop() {
        if(top.next == null) {
            throw new IllegalArgumentException("栈为空");
        }
        int res = top.next.val;
       /* if(top.next != null) {
            top.next = top.next.next;
        } else {
            top.next = null;
        }*/
        top = top.next;
        return res;
    }

    public void list() {
        if (top.next == null) {
            return;
        }
        ListNode temp = top.next;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}





 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
