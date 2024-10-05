package org.dataStructures.array;

import java.util.ArrayList;
import java.util.List;

public class Array {
    //initializes static array
    static String[] strings = {"a", "b", "c"};
    //static arrays in java have fixed size, in order to use operations such as add or remove a dynamic array is needed
    static ArrayList<String> dynamicArray = new ArrayList<>(List.of(strings));

    public static void main(String[] args) {
        //accessing item from array
        String string = strings[2];
        //add item to the end of the array
        dynamicArray.add("d");//O(1)
        //remove first item
        dynamicArray.removeFirst();//O(n)
        //add item to the beginning of the array
        dynamicArray.addFirst("n");//O(n)

        System.out.println(dynamicArray);
    }

}
