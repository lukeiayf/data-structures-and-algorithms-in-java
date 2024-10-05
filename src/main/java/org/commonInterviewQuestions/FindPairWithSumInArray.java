package org.commonInterviewQuestions;

import java.util.*;

public class FindPairWithSumInArray {
    //GIVEN AN ARRAY FIND THE PAIR THAT HAS THE SUM OF A GIVEN NUMBER
    //EXAMPLE
    //int sum = 8;
    //array1 = [1,2,3,5];
    //RETURN TRUE SINCE 5 + 3 = 8;
    //array2 = [2,3,9,2];
    //RETURN FALSE SINCE NO MATCH FOR THE NUMBER WAS FOUND

    public static Boolean hasPairWithSum(List<Integer> arr, Integer sum) {
        //assuming no duplicates create an empty set
        HashSet<Object> set = new HashSet<>();
        //loop through the array
        for (Integer item : arr) {
            //if the set contains the item(the number needed to add to the index to get the sum) in the array
            //return true
            if (set.contains(item)) {
                return true;
            }
            //if not subtract the number
            //ex using this array [1,2,3,5]
            //if the given number was 8 and the item in the loop is 1, first we check if there is a 1 in the set
            //if not we do 8-1 = 7 and add seven to the set, now it has [7]
            //8-2 = 6, set has[7,6]
            //8-3 = 5, set has[7,6,5]
            //item is now 5, which is a number needed by 3 to sum up to 8, does 5 exist in the set? Yes, return true
            set.add(sum - item);
        }
        return false;
    }

    public static void main(String[] args) {
        Boolean result = hasPairWithSum(List.of(1,2,3,5), 8);
        System.out.println(result);
    }

}
