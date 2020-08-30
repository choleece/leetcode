package cn.choleece.base.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author choleece
 * @Description: Given a string, find the length of the longest substring without repeating characters.
 * @Date 2020-08-30 11:48
 **/
public class Solution03V2 {

    /**
     * input: abcabcbb
     * output: 3
     *
     * Input: "bbbbb"
     * Output: 1
     *
     * @param s str of input
     * @return the longest substr length()
     */
    public static int lengthOfLongestSubstring1(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int max = 0;
        Set<Character> set = new HashSet();
        for(int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                // 出现了重复的位置，满足不重复条件的字符串已出现，可以去跟前值比较最大值了
                if (set.contains(chars[j])) {
                    break;
                } else {
                    set.add(chars[j]);
                }
            }

            max = Math.max(max, set.size());
            set.clear();
        }

        return max;
    }

    /**
     * slide window
     * @param s original s
     * @return the longest length of sub string
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int max = 0;
        int appearFirstIdx = -1;

        // 因为是char, 所以这里的map阔以用int代替，利用ASCII, a-z A-Z, 在128范围内
        Map<Character, Integer> map = new HashMap();

        // 这里有个改进，当出现重复的字符串后，直接用当前的位置-重复的位置即是最大长度
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            Integer idx = map.get(chars[i]);
            if (idx != null) {
                appearFirstIdx = Math.max(idx, appearFirstIdx);
            }

            max = Math.max(max, i - appearFirstIdx);
            map.put(chars[i], i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("longest sub string length is : " + lengthOfLongestSubstring("pwwkew"));
    }
}
