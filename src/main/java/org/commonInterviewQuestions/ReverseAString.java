package org.commonInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseAString {
    //CREATE A FUNCTION THAT REVERSES A GIVEN STRING
    //EX: "Hi, My name is Lucas" -> "sacuL si eman ym, iH"

    //O(n) solution, not very optimized
    static String reverseStr(String str) {
        if (str == null || (str.length() < 2)) {
            return "Must be a valid string";
        }
        ArrayList<String> arr = new ArrayList<>();//O(1)
        String reversedString = "";//O(1)
        for (int i = 0; i < str.length(); i++) {//O(n)
            arr.add(String.valueOf(str.charAt(i)));
        }
        List<String> reversed = arr.reversed();

        for (String s : reversed) {//O(n)
            reversedString = reversedString.concat(s);
        }

        return reversedString;
    }

    //optimized
    private static String reverse2(String string) {
        StringBuilder temp = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            temp.append(string.charAt(i));
        }
        return temp.toString();
    }

    //using string builder
    private static String reverse3(String str) {
       return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        String reversedStr = reverse3("Hy, my name is Lucas");
        System.out.println(reversedStr);
    }
}
