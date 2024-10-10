package org.algorithmExercises.recursion;

public class FindFactorialValue {

    //Given a number n find the factorial value of it and return
    //5! = 5 * 4 * 3 * 2 * 1
    //5! = 5 * 4!
    private static int count;

    //O(n)
    public static int findFactorialRecursive(int number) {
        if (number == 2) {
            return 2;
        }
        return number * findFactorialRecursive(number - 1);
    }

    //O(n)
    public static int findFactorialIterative(int number) {
        int answer = 1;
        if (number == 2) {
            answer = 2;
        }
        for (int i = 2; i <= number; i++) {
            answer = answer * i;
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(findFactorialRecursive(5));
        System.out.println(findFactorialIterative(5));
    }
}
