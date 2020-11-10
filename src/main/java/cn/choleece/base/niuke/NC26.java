package cn.choleece.base.niuke;

import java.util.ArrayList;

/**
 * @author choleece
 * @Description: 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())",
 * @Date 2020-11-09 15:24
 **/
public class NC26 {

    /**
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public static ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> result = new ArrayList();
        if (n <= 0) {
            return result;
        }
        backtrack("", 0, 0, n, result);
        return result;
    }

    public static void backtrack(String combination, int open, int close, int n, ArrayList<String> result) {
        if (open + close == 2 * n) {
            result.add(combination);
            return;
        }
        if (open < n) {
            backtrack(combination + "(", open + 1, close, n, result);
        }
        if (close < open) {
            backtrack(combination + ")", open, close + 1, n, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
