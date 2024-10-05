package org.dataStructures.linkedList;

public class MyNode {
    private int value;
    private Object next;

    private Object previous;

    public MyNode(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public Object getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}
