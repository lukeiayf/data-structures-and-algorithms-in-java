package org.dataStructures.linkedList;

import java.util.ArrayList;

public class MyDoublyLinkedList {
    private MyNode head;
    private MyNode tail;
    private int length;

    public MyDoublyLinkedList(Integer value) {
        this.head = new MyNode(value);
        this.tail = this.head;
        this.length = 1;
    }

    private void append(Integer value) {
        MyNode newNode = new MyNode(value);
        newNode.setPrevious(this.tail);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    private void prepend(Integer value) {
        MyNode newNode = new MyNode(value);
        this.head.setPrevious(newNode);
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
        MyNode follower = (MyNode) leader.getNext();
        leader.setNext(newNode);
        newNode.setPrevious(leader);
        newNode.setNext(follower);
        follower.setPrevious(newNode);
        this.length++;
    }

    private void remove(Integer index) {
        MyNode leader = this.traverseToIndex(index - 1);
        MyNode unwantedNode = (MyNode) leader.getNext();
        MyNode follower = (MyNode) unwantedNode.getNext();
        leader.setNext(follower);
        follower.setPrevious(leader);
        this.length--;
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

    public static void main(String[] args) {
        MyDoublyLinkedList myLinkedList = new MyDoublyLinkedList(10);
        myLinkedList.prepend(12);
        myLinkedList.append(5);
        myLinkedList.append(16);
        myLinkedList.insert(1, 99);
        myLinkedList.insert(2, 45);
        myLinkedList.remove(2);
        ArrayList<Object> list = myLinkedList.printList();
        System.out.println(list);
    }
}
