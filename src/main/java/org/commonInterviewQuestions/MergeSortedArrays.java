package org.commonInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays {
    //Given two sorted arrays, create a function to merge them together and sort them
    //ex: [0,3,4,31] and [4,6,30] -> [0,3,4,4,6,30,31]

    //O(n) using streams
    private static List<Integer> mergeArrays(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        if (arr1.isEmpty()) {
            return arr2;
        }
        if (arr2.isEmpty()) {
            return arr1;
        }
        for (int i = 0; i <= arr1.size() - 1; i++) {//O(n)
            arr2.add(arr1.get(i));
        }
        return arr2.stream().sorted().toList();
    }

    //O(n + m) avoiding extra sorting since the arrays are already sorted
    public static List<Integer> mergeArrays2(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge the arrays while maintaining the order
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                merged.add(arr1.get(i));
                i++;
            } else {
                merged.add(arr2.get(j));
                j++;
            }
        }

        // Add remaining elements from arr1
        while (i < arr1.size()) {
            merged.add(arr1.get(i));
            i++;
        }

        // Add remaining elements from arr2
        while (j < arr2.size()) {
            merged.add(arr2.get(j));
            j++;
        }

        return merged;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(0, 3, 4, 31));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(4, 6, 30));
        List<Integer> mergedArrays = mergeArrays2(arr1, arr2);
        System.out.println(mergedArrays);
    }
}
