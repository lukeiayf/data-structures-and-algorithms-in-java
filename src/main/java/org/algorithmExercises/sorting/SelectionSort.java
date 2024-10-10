package org.algorithmExercises.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {

        //O(n²)
        for (int i = 0; i < array.length; i++) {
            //set current minimum value
            var min = i;
            var temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    //update the minimum if the current is lower than what we had
                    min = j;
                }
            }
            array[i] = array[min];
            array[min] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        System.out.println(Arrays.toString(selectionSort(numbers)));
    }
}


