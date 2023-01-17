package com.shanggg.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        CircleArray arrayQueue = new CircleArray(3);
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

class CircleArray {
    private int maxSize; //表示数组的最大容量  最大容量比最多有效数据大1，rear有空出一个
    //front的变量含义调整：front指向队列的第一个元素，也就是说arr[front]
    //front的初始值 = 0
    private int front;
    //rear变量的含义做一个调整:rear指向队列的最后一个元素的后一个位置，因为希望空出一个位置
    //rear的初始值 = 0
    private int rear; //队列尾
    private int[] arr;//该数据用于存储数据，模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = 0;
        rear = 0;
    }


    //判断队列是否满
    //当队列满时 rear总处在front的前一个位置
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        //将队列后移动，这里必须考虑取模
        rear = (rear + 1) % maxSize;

    }


    //数据出队列
    public int getQueue() {
        //判断数据是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        //这里分析出 front 是指向队列的第一个元素
        //1.先把 front 对应的值保存在临时变量
        //2.将 front 往后移
        //3.将临时变量保存
        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    //当前有效数据个数

    /**
     *
     * 当 rear > front
     * size  =  rear - front
     *
     * 当 rear < front
     * rear+1 + maxsize - front - 1 = rear +maxsize - front
     *
     * 合并成 (rear+maxsize-front) % maxsize
     * @return
     */
    public int size() {
        //rear=1
        //front=0
        //maxSize = 3
        //rear比front是因为只出不进，front跑到rear的后面了
        // 其实就是 front-rear的绝对值  这样写说明 空间比有效数据大超过1个也可以
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return arr[front + 1];
    }
}
