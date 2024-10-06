package org.dataStructures.binarySearchTree;

public class BinarySearchTree {
    private MyTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree insert(Integer value) {
        //create node with value
        MyTreeNode newNode = new MyTreeNode(value);
        //check if root is null
        if (this.root == null) {
            setRoot(newNode);
        } else {
            //if it's not use it as the current node to iterate from
            MyTreeNode currentNode = this.root;
            //use while loop to iterate over all items
            while (true) {
                //check if value is lower/higher than current node and set it accordingly
                if (value < currentNode.getValue()) {
                    //left
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        return this;
                    }
                    //update current node if there is a value
                    currentNode = currentNode.getLeft();
                } else {
                    //right
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        return this;
                    }
                    //update current node if there is a value
                    currentNode = currentNode.getRight();
                }
            }
        }
        return this;
    }

    public MyTreeNode lookup(Integer value) {
        if (this.root == null) {
            return null;
        }
        MyTreeNode currentNode = this.root;
        while (true) {
            if (value < currentNode.getValue()) {
                //left
                if (currentNode.getLeft() == null) {
                    return null;
                } else if (currentNode.getLeft().getValue().equals(value)) {
                    return currentNode.getLeft();
                }
                currentNode = currentNode.getLeft();
            } else {
                //right
                if (currentNode.getRight() == null) {
                    return null;
                } else if (currentNode.getRight().getValue().equals(value)) {
                    return currentNode.getRight();
                }
                currentNode = currentNode.getRight();
            }
        }
    }

    public void remove(int value) {
        if (this.root == null) {
            return;
        }
        MyTreeNode current = this.root;
        MyTreeNode parentNode = null;
        // while current is not null
        while (current != null) {
            if (value < current.getValue()) {
                // go left
                parentNode = current;
                current = current.getLeft();
            } else if (value > current.getValue()) {
                // go right
                parentNode = current;
                current = current.getRight();
            }
            // (value == current.value, means if we found the value to be removed)
            else {
                // Option 1: NO RIGHT CHILD            // Child means the child of current Node
                if (current.getRight() == null) {
                    // if parentNode is null means delete the root node
                    if (parentNode == null) {
                        this.root = current.getLeft();
                    } else {
                        // if current < parent, make current left child a left child of parent
                        if (current.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(current.getLeft());

                        }
                        // if current > parent, make current's left child a right child of parent
                        else if (current.getValue() > parentNode.getValue()) {
                            parentNode.setRight(current.getLeft());
                        }
                    }
                }

                // Option 2: RIGHT CHILD WHICH DOESN'T HAVE A LEFT CHILD
                else if (current.getRight().getLeft() == null) {
                    if (parentNode == null) {
                        this.root = current.getRight();
                    } else {
                        // if current < parent, make current's right child a left child of parent
                        if (current.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(current.getRight());
                        }
                        // if current > parent, make current's right child a right child of parent
                        else if (current.getValue() > parentNode.getValue()) {
                            parentNode.setRight(current.getRight());
                        }
                    }
                }

                // Option 3: RIGHT CHILD WHICH HAVE LEFT CHILD
                else {
                    if (parentNode == null) {
                        // save reference of left and right nodes of the root
                        MyTreeNode leftNode = this.root.getLeft();
                        MyTreeNode rightNode = this.root.getRight();
                        // root.right.left node becomes new root
                        this.root = current.getRight().getLeft();
                        rightNode.setLeft(rightNode.getLeft().getRight());
                        // set back the saved reference of left and right nodes of root.
                        this.root.setLeft(leftNode);
                        this.root.setRight(rightNode);
                    } else {
                        if (current.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(current.getRight().getLeft());
                        } else if (current.getValue() > parentNode.getValue()) {
                            parentNode.setRight(current.getRight().getLeft());
                        }
                    }
                }
                return;
            }
        }
    }

    public MyTreeNode traverse(MyTreeNode node) {
        MyTreeNode tree = new MyTreeNode(node.getValue());
        tree.setLeft(node.getLeft() == null ? null : traverse(node.getLeft()));
        tree.setRight(node.getRight() == null ? null : traverse(node.getRight()));
        return tree;
    }

    public MyTreeNode getRoot() {
        return root;
    }

    public void setRoot(MyTreeNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(5);
        bst.insert(15);
        bst.insert(270);
        System.out.println(bst.traverse(bst.getRoot()));
        System.out.println(bst.lookup(15));

    }
}
