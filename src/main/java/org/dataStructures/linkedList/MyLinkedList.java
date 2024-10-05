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

    private MyNode traverseToIndex(Integer index) {
        int counter = 0;
        MyNode currentNode = this.head;
        while (counter != index) {
            currentNode = (MyNode) currentNode.getNext();
            counter++;
        }
        return currentNode;
    }

    private MyNode reverse() {
//        if (this.head == null || this.head.getNext() == null) {
//            return;
//        }
//
//        MyNode first = this.head;
//        this.tail = this.head; // tail becomes the old head
//        MyNode second = (MyNode) first.getNext();
//
//        while (second != null) {
//            MyNode temp = (MyNode) second.getNext(); // store the next node
//            second.setNext(first); // reverse the current node's pointer
//            first = second; // move first one step forward
//            second = temp; // move second one step forward
//        }
//
//        this.head.setNext(null); // the old head is now the tail, set its next to null
//        this.head = first; // the last node becomes the new head


        MyNode prev = null;
        MyNode current = this.head;
        while (current != null) {
            MyNode next = (MyNode) current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;

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
        MyNode reversed = myLinkedList.reverse();
//        ArrayList<Object> reversed = myLinkedList.printList();
        System.out.println(reversed);

    }
}
