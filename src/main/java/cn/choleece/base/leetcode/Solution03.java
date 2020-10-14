package cn.choleece.base.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choleece
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * @Date 2020-01-28 23:11
 **/
public class Solution03 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int maxLength = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> preChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int lastIdx = preChars.getOrDefault(chars[i], -1);
            if (lastIdx >= 0) {
                maxLength = Math.max(maxLength, preChars.size());
                preChars.clear();
                for (int j = lastIdx; j <= i; j++) {
                    preChars.put(chars[j], j);
                }
            } else {
                preChars.put(chars[i], i);
            }
        }
        maxLength = Math.max(maxLength, preChars.size());
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "acfd";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
