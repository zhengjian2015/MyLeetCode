package com.shanggg.binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arrs = {7, 5, 13, 25, 18, 22};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int a : arrs) {
            binarySortTree.add(new Node(a));
        }
        System.out.println("中序遍历：");
        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        this.root.infixOrder();
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            //如果我们发现当前二叉树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = searchParent(value);
            //如果要删除的节点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode 是父节点的左子节点还是 右子节点
                if(parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if(parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            }

        }
    }
}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //添加节点
    //递归的形式添加节点
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的节点的值和当前子树的根节点的关系
        if (node.value < this.value) {
            //如果当前节点的左子节点为空
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {
            //添加的节点的值大于当前节点的值
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }

    //查找要删除的节点

    /**
     * 查找删除的节点 返回Node或者null
     *
     * @param val
     * @return
     */
    public Node search(int val) {
        if (val == this.value) {
            return this;
        } else if (val < this.value) {
            //如果左子节点为空
            if (this.left == null) return null;
            return this.left.search(val);
        } else {
            if (this.right == null) return null;
            return this.right.search(val);
        }
    }

    //查找要删除的节点的父节点
    public Node searchParent(int val) {
        if ((this.left != null && this.left.value == val)
                || (this.right != null && this.right.value == val)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值，并且当前结点的左子节点不为空
            if (val < this.value && this.left != null) {
                return this.left.searchParent(val); //向左子树递归查找
            } else if (val >= this.value && this.right != null) {
                return this.right.searchParent(val); //向右子树递归查找
            } else {
                return null;
            }
        }
    }


    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}