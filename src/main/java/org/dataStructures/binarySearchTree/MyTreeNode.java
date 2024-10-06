package org.dataStructures.binarySearchTree;

public class MyTreeNode {
    private MyTreeNode left;
    private MyTreeNode right;
    private Integer value;

    public MyTreeNode(Integer value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyTreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }
}
