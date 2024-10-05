package org.dataStructures.queue;

import org.dataStructures.linkedList.MyNode;

public class MyQueue {
    private MyNode first, last;
    private int length;

    public MyQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public MyNode peek() {
        return this.first;
    }

    public MyQueue enqueue(int value) {
        MyNode newNode = new MyNode(value);
        if (this.length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
        this.length++;
        return this;
    }

    public MyQueue dequeue() {
        if (this.first == null) {
            return null;
        }
        if (this.first.equals(this.last)) {
            this.last = null;
        }
        this.first = (MyNode) this.first.getNext();
        this.length--;
        return this;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println(myQueue.enqueue(3));
        System.out.println(myQueue.dequeue());
    }
}
