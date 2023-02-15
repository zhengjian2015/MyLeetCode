package com.shanggg.stack;

import javax.print.DocFlavor;

/**
 *
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

//定义一个ArrayStack 表示栈
class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就存在该数组
    private int top = -1; //表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize -1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value) {
        //先判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        } else {
            stack[++top] = value;
        }
    }
    //出栈
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        } else {
           return stack[top--];
        }
    }
    //遍历栈,遍历需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for(int i = top; i >=0 ;i--) {
            System.out.printf("stack[%d]=%d",i,stack[i]);
            System.out.println();
        }
    }

}