package com.shanggg.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.infixOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        //如果数组为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右遍历递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }

    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void infixOrder(int index) {
        //如果数组为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向右遍历递归
        if ((index * 2 + 2) < arr.length) {
            infixOrder(index * 2 + 2);
        }

    }
}
