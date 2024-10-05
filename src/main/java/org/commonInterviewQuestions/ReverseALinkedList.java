package org.commonInterviewQuestions;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class ReverseALinkedList {
    //REVERSE A SINGLE ORDERED LINKED LIST
    //list = [1,4,8,10]
    //SHOULD RETURN
    //[10,8,4,1]


    //O(n²) solution, real simple but quite slow
    private static LinkedList<Integer> reverse(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        if (list != null && list.size() > 1) {
            for (int i = list.size() - 1; i >= 0; i--) {
                reversedList.add(list.get(i));//O(n²) since you need to traverse the entire list
            }
        }
        return reversedList;
    }

    //O(n) using addfirst from java
    private static LinkedList<Integer> reverse2(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        for (Integer element : list) {
            reversedList.addFirst(element);//O(1) operation
        }
        return reversedList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(12);
        //native Java method
//        System.out.println(list.reversed());
        System.out.println(reverse2(list));
    }
}
