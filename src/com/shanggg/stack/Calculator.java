package com.shanggg.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "31+2*3-2";  //如何处理多位数的问题
        //创建两个栈,数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义相关变量
        int index = 0; //用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //每次扫描得到char保存到char
        String keepNum = "";
        //开始用while语句循环扫描 expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) {
                //如果是运算符号
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符就进行比较 如果优先级小于或等于，
                    // 从数栈中pop两个数，从符号栈pop一个，进行运算得到结果入数栈，然后将当前操作符入栈，如果当前操作符大于栈顶，就直接入栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算结果
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //当前操作符优先级高于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    //如果为空就直接入符号栈
                    operStack.push(ch); //1+3;
                }

            } else { //如果是数，则直接入数栈
                //不能直接入数栈，因为有可能是多位数
                //需要在看以为，如果是数字则拼接，如果是符号就入栈

                //numStack.push(ch - 48);
                //处理多为位数
                keepNum += ch;
                //如果ch已经是最后一位
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }
                //判断下一位是不是数字，如果是数字就继续扫描
                else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }


            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //表达式扫描完毕 就顺序的从数栈和符号栈 pop出相应的数字和符号
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.println("最后的结果");
        System.out.println(res2);
    }


}

//定义一个ArrayStack 表示栈  需要扩展功能
class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就存在该数组
    private int top = -1; //表示栈顶，初始化为-1

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        } else {
            stack[++top] = value;
        }
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        } else {
            return stack[top--];
        }
    }

    //遍历栈,遍历需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d", i, stack[i]);
            System.out.println();
        }
    }

    //返回运算符的优先级 优先级使用数字表示，数字越大优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //查看栈顶元素
    public int peek() {
        return stack[top];
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}


