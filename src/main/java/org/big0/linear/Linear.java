package org.big0.linear;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Linear {

    //TIME COMPLEXITY OF O(N) - LINEAR TIME

    public static void findName(List<String> array) {
        for (String s : array) {
            if (Objects.equals(s, "nemo")) {
                System.out.println("Found him!");
                break;
            }
        }
        System.out.println("He's not here :(");
    }

    public static void main(String[] args) {
        List<String> names = Collections.nCopies(10, "names");
        findName(names);
    }
}