package cn.choleece.base.niuke;

import java.util.Stack;

/**
 * @author choleece
 * @Description: 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法
 * @Date 2020-10-19 23:06
 **/
public class Nc52 {

    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty()) {
                char leftChar = stack.peek();
                if (match(leftChar, chars[i])) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else {
                stack.push(chars[i]);
            }
        }

        return stack.isEmpty();
    }

    private boolean match(char leftChar, char rightChar) {
        if (leftChar == '(' && rightChar == ')') {
            return true;
        }

        if (leftChar == '[' && rightChar == ']') {
            return true;
        }

        if (leftChar == '{' && rightChar == '}') {
            return true;
        }

        return false;
    }

}
