package com.shanggg.queue;

import java.util.Scanner;

/**
 *
 * 这个队列的问题是 空间浪费， 队列取出后，再添加无法添加
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println(res);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println(res);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出");
                default:
                    break;
            }
        }
    }
}

//使用数组模拟队列
class ArrayQueue {

    private int maxSize; //表示数组的最大容量
    private int front;   //队列头
    private int rear;    //队列尾
    private int[] arr;   //该数据用于存放数据，模拟队列

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;  //指向队列头部 front指向队列头的前一个位置
        rear = -1;   //指向队列尾，指向队列尾的数据
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到对列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //数据出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        //先进先出  rear是不对的
        //return arr[rear--];
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return arr[front + 1];
    }
}
