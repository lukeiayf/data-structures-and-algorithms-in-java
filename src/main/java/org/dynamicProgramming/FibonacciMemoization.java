package org.dynamicProgramming;

import java.util.HashMap;

public class FibonacciMemoization {
    private static final HashMap<Integer, Integer> cache = new HashMap<>();
    //memoization turns an O(2^n) to O(n)
    public static Integer fibonacciMaster(Integer n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            if (n < 2) {
                return n;
            } else {
                Integer result = fibonacciMaster(n - 1) + fibonacciMaster(n - 2);
                cache.put(n, result);
                return result;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacciMaster(10));
    }
}
