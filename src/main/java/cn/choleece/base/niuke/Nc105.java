package cn.choleece.base.niuke;

/**
 * @author choleece
 * @Description: 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一
 * @Date 2020-10-18 17:39
 **/
public class Nc105 {

    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] < v) {
                left = mid + 1;
            } else if (a[mid] > v) {
                if (mid == 0 || a[mid - 1] < v) {
                    return mid + 1;
                }
                right = mid - 1;
            } else {
                // a[mid] == v
                if (mid == 0 || a[mid - 1] < v) {
                    return mid + 1;
                }
                right = mid - 1;
            }
        }

        return n + 1;
    }

}
