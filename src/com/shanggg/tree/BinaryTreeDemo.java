package com.shanggg.tree;

import java.util.Stack;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //创建一颗二叉树
        /*HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "吴用");
        //创建二叉树  后面用递归方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
       // binaryTree.preOrder();
        System.out.println(" ");*/
        //二叉搜索树
        HeroNode root = new HeroNode(5,"定点");
        HeroNode node0 = new HeroNode(1,"左1");
        HeroNode node1 = new HeroNode(3,"左1");
        HeroNode node2 = new HeroNode(2,"左1");
        HeroNode node4 = new HeroNode(4,"左1");
        root.setLeft(node1);
        node1.setLeft(node2);
        node2.setLeft(node0);
        node1.setRight(node4);
        HeroNode node7 = new HeroNode(7,"左1");
        HeroNode node8 = new HeroNode(8,"左1");
        HeroNode node9 = new HeroNode(9,"左1");
        root.setRight(node8);
        node8.setLeft(node7);
        node8.setRight(node9);
        binaryTree.setRoot(root);
        binaryTree.postOrder2();
    }


}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 栈的使用
     */
    public void infixOrder2(){
        Stack<HeroNode> stack = new Stack<>();
        HeroNode node = this.root;
        while (node!=null || !stack.isEmpty()) {
            if(node != null) {
                System.out.println(node.getNo()); //前序遍历
                stack.push(node);
                node = node.getLeft();
            } else {
                HeroNode pop = stack.pop();
               // System.out.println(pop.getNo()); //后序遍历
                node = pop.getRight();
            }
        }
    }

    public void postOrder2() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode node = this.root;
        HeroNode prev = null;
        while (node != null || !stack.isEmpty() ) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }
            node = stack.pop();
            if (node.getRight() == null || node.getRight() == prev) {
                System.out.println(node.getNo());
                prev = node;
                node = null;
            } else {
                stack.push(node);
                node = node.getRight();
            }
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public HeroNode invertTree(HeroNode root) {
        if (root == null) {
            return null;
        }
        HeroNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        invertTree(root.getLeft());
        invertTree(root.getRight());
        return root;
    }

    public HeroNode getChildNode(int no) {
        if (root == null) {
            return null;
        }
        return root.postOrderSearch(no);
    }

    public void delNode(int no) {
        if(root != null) {
            if(root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树");
        }
    }

}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this); //先输出父结点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 删除结点
     * @param no
     */
    public void delNode(int no) {
        if(this.left != null && this.left.no == no) {
            this.left = null;
            System.out.println("k");
            //return;
        }

        if(this.right != null && this.right.no == no) {
            this.right = null;
            System.out.println("k0");
            //return;
        }

        if(this.left != null) {
            this.left.delNode(no);
            System.out.println("k11");
        }

        if(this.right != null) {
            System.out.println("k2");
            this.right.delNode(no);
        }
    }

    /**
     * 前序遍历查找结点
     *
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;

        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }
        return res;
    }


    /**
     * 中序遍历查找结点
     *
     * @param no
     * @return
     */
    public HeroNode infixOrderSearch(int no) {
        HeroNode res = null;

        if (this.left != null) {
            res = this.left.infixOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        System.out.println("进入中序遍历");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            res = this.right.infixOrderSearch(no);
        }
        return res;
    }


    /**
     * 后序遍历查找结点
     *
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode res = null;
        //在这写好几次只是进入判断左右是否为空
        //System.out.println("进入后序遍历");
        if (this.left != null) {
            res = this.left.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        System.out.println("进入后序遍历");
        if (this.no == no) {
            return this;
        }
        return res;
    }
}
