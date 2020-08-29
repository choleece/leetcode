package cn.choleece.base.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choleece
 * @Description: Given an array of integers nums and and integer target, return the indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * @Date 2020-08-29 09:43
 **/
public class Solution01V2 {

    /**
     * 利用hash map O(1)的特性
     *
     * @param nums   源数组
     * @param target 目标值
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            int firstIdx;
            if ((firstIdx = map.getOrDefault(complement, -1)) >= 0) {
                return new int[]{firstIdx, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 暴力法
     *
     * @param nums 源数组
     * @param target 目标值
     * @return int[]
     */
    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = bruteForce(new int[]{1, 2, 3, 4, 5}, 4);
        for (int value : result) {
            System.out.println(value);
        }
    }
}
