package org.commonInterviewQuestions;

import org.dataStructures.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindCommonItemsInArrays {

    //GIVEN TWO ARRAYS
    //CREATE A FUNCTION THAT RETURN TRUE OF FALSE IF THERE IS COMMON ITEMS BETWEEN THEM
    //EXAMPLE
    //array1 = ['a', 'b', 'c' , 'x']
    //array2 = ['z', 'y', 'i']
    //SHOULD RETURN FALSE
    //array1 = ['a', 'b', 'c' , 'x']
    //array2 = ['z', 'y', 'X']
    //SHOULD RETURN TRUE

    //O(a*b)/0(n²) solution, nested for loops, bad
    public static Boolean badContainsCommonItem(List<Character> array1, List<Character> array2) {
        for (Character character : array1) {
            for (Character value : array2) {
                if (character.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    //O(a+b) complexity, better solution, change first array to an object and check if the second array has an item that exists in it
    //loop through first array and create a map object where properties = items in the array
    //loop through second array and check if item in second array exists in object
    public static Boolean containsCommonItem(List<Character> array1, List<Character> array2) {
        Map<Character, Boolean> map = array1.stream().collect(
                Collectors.toMap(
                        c -> c,
                        c -> Boolean.TRUE
                ));
        for (Character character : array2) {
            if (map.containsKey(character)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<Character> array1 = List.of('a', 'b', 'c', 'x');
        List<Character> array2 = List.of('z', 'd', 'x');
        Boolean result = containsCommonItem(array1, array2);
        System.out.println(result);
    }
}