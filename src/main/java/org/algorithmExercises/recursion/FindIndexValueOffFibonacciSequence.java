package org.algorithmExercises.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindIndexValueOffFibonacciSequence {

    //Given a number N return the index value of the Fibonacci sequence
    //0,1,1,2,3,5,8,13...
    //If given n is 7 return the value of 13

    //O(2^n)
    public static int fibonacciRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);

        //fibonacci(5) = fibonacci(4) + fibonacci(3)
        //fibonacci(4) = fibonacci(3) + fibonacci(2)
        //fibonacci(3) = fibonacci(2) + fibonacci(1)
        //fibonacci(2) = fibonacci(1) + fibonacci(0)
        //then
        //fibonacci(2) = 1+0 = 1
        //fibonacci(5) = 3+2 = 5
        //fibonacci(3) = 1+1 = 2
        //fibonacci(4) = 2+1 = 3
    }

    //O(n)
    public static int fibonacciIterative(int n) {
        List<Integer> arr = new ArrayList<>(List.of(0, 1));
        for (int i = 2; i <= n; i++) {
            arr.add(arr.get(i - 2) + arr.get(i - 1));
        }
        return arr.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(20));
        System.out.println(fibonacciIterative(20));
    }
}
