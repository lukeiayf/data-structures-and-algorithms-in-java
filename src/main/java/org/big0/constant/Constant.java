package org.big0.constant;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Constant {

    //TIME COMPLEXITY OF O(1) - CONSTANT TIME

    public static void logFirstTwoBoxes(List<Integer> array) {
        System.out.println(array.get(0));//0(1)
        System.out.println(array.get(1));//0(2)
    }

    public static void main(String[] args) {
        List<Integer> boxes = List.of(1, 2, 3, 4, 5);
        logFirstTwoBoxes(boxes);//O(1)
    }
}