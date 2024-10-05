package org.dataStructures.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStackArrayImpl {
    private final List<Object> array;

    public MyStackArrayImpl() {
        this.array = new ArrayList<>();
    }

    public Object peek() {
        return this.array.getFirst();
    }

    public MyStackArrayImpl push(int value) {
        this.array.add(value);
        return this;
    }

    public MyStackArrayImpl pop() {
        this.array.removeLast();
        return this;
    }

    @Override
    public String toString() {
        return "MyStackArrayImpl{" +
                "array=" + array +
                '}';
    }

    public static void main(String[] args) {
        MyStackArrayImpl myStack = new MyStackArrayImpl();
        myStack.push(1);
        System.out.println(myStack.push(2));
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
    }

}
