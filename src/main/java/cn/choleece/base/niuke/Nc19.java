package cn.choleece.base.niuke;

/**
 * @author choleece
 * @Description: 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * @Date 2020-10-18 17:42
 **/
public class Nc19 {
    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        // dp[i] 的状态表示为以i为结尾的子数组的最大值
        int max = Integer.MIN_VALUE;
        int dp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            dp = Math.max(dp + arr[i], arr[i]);
            max = Math.max(dp, max);
        }

        return max;
    }
}
