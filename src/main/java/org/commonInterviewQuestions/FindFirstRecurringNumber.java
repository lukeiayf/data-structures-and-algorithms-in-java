package org.commonInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindFirstRecurringNumber {
    //GIVEN AN ARRAY, RETURN THE FIRST RECURRING CHARACTER
    //array = [2,5,1,2,3,5,1,2,4]
    //should return 2
    //if not found return null/undefined on js

    //O(n) first result, not very good, could've used an array list instead of a hashmap
    static Integer findFirstRecurringNumber(List<Integer> numbers) {
        HashMap<String, Integer> lookedNumbers = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) {
                if (lookedNumbers.containsKey(
                        "Checked value: " + numbers.get(i)) &&
                        lookedNumbers.containsValue(numbers.get(i))) {
                    return lookedNumbers.get("Checked value: " + numbers.get(i));
                }
            }
            lookedNumbers.put("Checked value: " + numbers.get(i), numbers.get(i));
        }

        return null;
    }

    //O(N²) solution using nested loops, bad but simple
    static Integer findFirstRecurringNumber2(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    return numbers.get(i);
                }
            }
        }
        return null;
    }

    //O(n) optimal solution using hashmap
    static Integer findFirstRecurringNumber3(List<Integer> numbers) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            if ((i > 0) && map.containsKey(numbers.get(i))) {
                return numbers.get(i);
            }
            map.put(numbers.get(i), "");
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(2, 5, 19, 9, 3, 15, 1, 6, 9));
        Integer recurringNumber = findFirstRecurringNumber3(numbers);
        System.out.println(recurringNumber);
    }
}
