package org.algorithmExercises.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            //store the value in a temp variable
            int temp = array[i];
            //keep track of what value we are comparing to
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                //shift element to the right
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        System.out.println(Arrays.toString(insertionSort(numbers)));
    }
}


