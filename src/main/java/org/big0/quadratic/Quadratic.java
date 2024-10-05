package org.big0.quadratic;

import java.util.List;

public class Quadratic {

    //TIME COMPLEXITY OF O(N²) - QUADRATIC TIME

    public static void logAllPairsOfBoxes(List<String> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                System.out.println(array.get(i) + array.get(j));
            }
        }
    }

    public static void main(String[] args) {
        List<String> boxes = List.of("a", "b", "c", "d", "e");
        logAllPairsOfBoxes(boxes);
    }
}