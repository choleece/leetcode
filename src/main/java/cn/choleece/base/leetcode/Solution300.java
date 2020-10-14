package cn.choleece.base.leetcode;

import java.util.Arrays;

/**
 * @author choleece
 * @Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @Date 2020-10-14 22:54
 **/
public class Solution300 {

    /**
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     *
     * @param nums 数组
     * @return lengthOfLIS
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        // init dp
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
