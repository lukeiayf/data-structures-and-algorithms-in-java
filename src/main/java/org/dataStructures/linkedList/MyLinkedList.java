package org.dataStructures.linkedList;

import java.util.ArrayList;

public class MyLinkedList {
    private MyNode head;
    private MyNode tail;
    private int length;

    public MyLinkedList(Integer value) {
        this.head = new MyNode(value);
        this.tail = this.head;
        this.length = 1;
    }

    private void append(Integer value) {
        MyNode newNode = new MyNode(value);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        }
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    private void prepend(Integer value) {
        MyNode newNode = new MyNode(value);
        newNode.setNext(this.head);
        this.head = newNode;
        this.length++;
    }

    private ArrayList<Object> printList() {
        ArrayList<Object> arr = new ArrayList<>();
        var currentNode = this.head;
        while (currentNode != null) {
            arr.add(currentNode.getValue());
            currentNode = (MyNode) currentNode.getNext();
        }
        return arr;
    }

    private void insert(Integer index, Integer value) {
        //how the process of inserting works
        // *-* -> *  * -> *   * -> *-*-*
        //         \       \ /
        //          *       *
        if (index >= this.length) {
            this.append(value);
        }
        var newNode = new MyNode(value);
        var leader = this.traverseToIndex(index - 1);
        var holdingPointer = leader.getNext();
        leader.setNext(newNode);
        newNode.setNext(holdingPointer);
        this.length++;
        this.printList();
    }

    private void remove(Integer index) {
        MyNode leader = this.traverseToIndex(index - 1);
        MyNode unwantedNode = (MyNode) leader.getNext();
        leader.setNext(unwantedNode.getNext());
        this.length--;
    }

    private MyNode removeLast() {
        if (this.length == 0) {
            return null;
        }
        MyNode pre = this.head;
        MyNode temp = this.head;
        while (temp.getNext() != null) {
            pre = temp;
            temp = (MyNode) temp.getNext();
        }
        this.tail = pre;
        this.tail.setNext(null);
        length--;
        if (length == 0) {
            this.head = null;
            this.tail = null;
        }
        return temp;
    }

    private MyNode traverseToIndex(Integer index) {
        int counter = 0;
        MyNode currentNode = this.head;
        while (counter != index) {
            currentNode = (MyNode) currentNode.getNext();
            counter++;
        }
        return currentNode;
    }

    private void reverse() {
        MyNode temp = head;
        this.head = this.tail;
        this.tail = temp;
        MyNode after = null;
        MyNode before = null;
        for (int i = 0; i < this.length; i++) {
            after = (MyNode) temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }


//        MyNode prev = null;
//        MyNode current = this.head;
//        while (current != null) {
//            MyNode next = (MyNode) current.getNext();
//            current.setNext(prev);
//            prev = current;
//            current = next;
//        }
//        return prev;

    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
//        myLinkedList.insert(1, 3);
//        myLinkedList.insert(2, 4);
//        myLinkedList.remove(2);
        ArrayList<Object> list = myLinkedList.printList();
        System.out.println(list);
        System.out.println(myLinkedList.removeLast());
        System.out.println(myLinkedList.printList());
        myLinkedList.reverse();
        System.out.println(myLinkedList.printList());
//        ArrayList<Object> reversed = myLinkedList.printList();
//        System.out.println(reversed);

    }
}
