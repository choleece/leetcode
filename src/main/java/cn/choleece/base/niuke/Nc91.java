package cn.choleece.base.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author choleece
 * @Description: 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
 * @Date 2020-10-18 23:31
 **/
public class Nc91 {

    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] LIS(int[] arr) {
        // write code here
        // 记录长度为i + 1， i个位置的元素
        int[] tail = new int[arr.length];
        // 记录位置arr[i] i 位置的长度
        int[] lis = new int[arr.length];
        tail[0] = arr[0];
        // 最大长度
        int length = 1;
        lis[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tail[length - 1]) {
                tail[length++] = arr[i];
                lis[i] = length;
            } else {
                int idx = findFirstIdx(tail, length, arr[i]);
                tail[idx] = arr[i];
                lis[i] = idx + 1;
            }
        }

        int[] res = new int[length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (lis[i] == length) {
                res[--length] = arr[i];
            }
        }

        return res;
    }

    public static int findFirstIdx(int[] tail, int len, int num) {
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (tail[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] res = LIS(input);
        for (int i = 0; i < res.length; i++) {
            System.out.printf(res[i] + " ");
        }
        System.out.println("");
    }
}
