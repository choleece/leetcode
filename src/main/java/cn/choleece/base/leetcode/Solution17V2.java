package cn.choleece.base.leetcode;

import java.util.*;

/**
 * @description: TODO
 * @author: choleece
 * @time: 2020-02-09 23:04
 */
public class Solution17V2 {

    static Map<String, List<Character>> DIC_MAP = new HashMap() {
        {
            put("2", Arrays.asList('a', 'b', 'c'));
            put("3", Arrays.asList('d', 'e', 'f'));
            put("4", Arrays.asList('g', 'h', 'i'));
            put("5", Arrays.asList('j', 'k', 'l'));
            put("6", Arrays.asList('m', 'n', 'o'));
            put("7", Arrays.asList('p', 'q', 'r', 's'));
            put("8", Arrays.asList('t', 'u', 'v'));
            put("9", Arrays.asList('w', 'x', 'y', 'z'));
        }
    };

    public static void backtrack(String combination, String nextDigits, List<String> result) {

        // track is ok
        if (nextDigits.length() == 0) {
            result.add(combination);
        } else {
            // choose one add to track
            String digit = nextDigits.substring(0, 1);
            List<Character> letters = DIC_MAP.get(digit);
            letters.forEach(letter -> {
                backtrack(combination + letter, nextDigits.substring(1), result);
            });
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        if (digits.length() != 0) {
            backtrack("", digits, result);
        }
        return result;
    }

    public static List<String> letterCombinations20200524(String digits) {
        List<String> result = new LinkedList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack20200524("", digits, result);

        return result;
    }

    public static void backtrack20200524(String combination, String nextDigits, List<String> result) {
        // termination
        if (nextDigits.length() == 0) {
            result.add(combination);
            return;
        }

        // choose one add to track
        String digit = nextDigits.substring(0, 1);
        List<Character> letters = DIC_MAP.get(digit);
        for (Character c : letters) {
            backtrack20200524(combination + c, nextDigits.substring(1), result);
        }
        // unchose
    }

    public static void main(String[] args) {
        String digits = "234";
        System.out.println("result: " + letterCombinations(digits));
        System.out.println("result: " + letterCombinations20200524(digits));
    }
}
