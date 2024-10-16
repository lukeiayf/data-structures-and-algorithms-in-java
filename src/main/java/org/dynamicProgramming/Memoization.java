package org.dynamicProgramming;

import java.util.HashMap;

public class Memoization {

    //to persist across method calls it needs to be final
    private static final HashMap<Integer, Integer> cache = new HashMap<>();

    public int memoizedAddTo80(Integer n) {


        if (!cache.containsKey(n)) {
            cache.put(n, n + 80);
        }
        return cache.get(n);
    }


    public static void main(String[] args) {
        Memoization memoization = new Memoization();
        System.out.println(memoization.memoizedAddTo80(5));
    }
}
