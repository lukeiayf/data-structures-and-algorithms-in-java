package org.algorithmExercises.sorting;

import java.util.Arrays;

public class BubbleSort {

    //O(n²)
    public static int[] bubbleSort(int[] n) {
        int temp;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length - 1; j++) {
                if (n[j] > n[j + 1]) {
                    temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
            }
        }
        return n;
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        System.out.println(Arrays.toString(bubbleSort(numbers)));
    }
}
