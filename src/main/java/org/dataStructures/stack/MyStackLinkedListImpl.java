package org.dataStructures.stack;

import org.dataStructures.linkedList.MyNode;

public class MyStackLinkedListImpl {
    private MyNode top, bottom;
    private int length;

    public MyStackLinkedListImpl() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public MyNode peek() {
        return this.top;
    }

    public MyStackLinkedListImpl push(int value) {
        MyNode newNode = new MyNode(value);
        if (this.length == 0) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            MyNode holdingPointer = this.top;
            this.top = newNode;
            this.top.setNext(holdingPointer);
        }
        this.length++;
        return this;
    }


    public MyStackLinkedListImpl pop() {
        if (this.top == null) {
            return null;
        }
        if (this.top.equals(this.bottom)) {
            this.bottom = null;
        }
        this.top = (MyNode) this.top.getNext();
        this.length--;
        return this;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        MyStackLinkedListImpl myStack = new MyStackLinkedListImpl();
        myStack.push(1);
        System.out.println(myStack.push(2));
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
    }

}
