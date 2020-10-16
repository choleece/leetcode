package cn.choleece.base.leetcode;

import java.util.Arrays;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-29 21:23
 **/
public class Solution53V2 {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        // 保存以往结果集
        Integer[][] sums = new Integer[len][len];

        int maxSum = Integer.MIN_VALUE;

        // 从小往大开始计算
        for (int i = 0; i < len; i++) {
            maxSum = Math.max(maxSum, nums[i]);
            sums[i][i] = nums[i];
            for (int j = i + 1; j < len; j++) {
                Integer t = sums[i][j - 1];

                // 状态转移公式: sum[i][j] = sum[i][j] + nums[j]
                sums[i][j] = (t == null ? 0 : t) + nums[j];

                maxSum = Math.max(maxSum, sums[i][j]);
            }
        }

        return maxSum;
    }

    /**
     * 动态规划的做法
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 状态为以i结尾的连续的子数组的最大值
            // 状态转移方程
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 动态规划的做法
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        // 用一个字段接收
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 状态为以i结尾的连续的子数组的最大值
            // 状态转移方程
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }

        return max;
    }

    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            // cur +起来的 和
            cur += nums[i];
            maxSum = Math.max(maxSum, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max sum: " + maxSubArray(nums));

        System.out.println("max sum1: " + maxSubArray1(nums));

        System.out.println("max sum2: " + maxSubArray2(nums));

        System.out.println("max sum3: " + maxSubArray3(nums));
    }
}
