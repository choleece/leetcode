package cn.choleece.base.niuke;

import java.util.*;

/**
 * @author choleece
 * @Description: 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * <p>
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在
 * @Date 2020-10-19 23:11
 **/
public class Nc88 {

    public static int findKth(int[] a, int n, int K) {
        // write code here
        Queue<Integer> queue = new PriorityQueue<Integer>(K, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Set<Integer> set = new HashSet();

        for (int i = 0; i < n; i++) {
            if (!set.contains(a[i])) {
                queue.add(a[i]);
                set.add(a[i]);
            }
        }

        int result = 0;
        for (int i = 0; i < K; i++) {
            result = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 89};
        System.out.println(findKth(input, input.length, 4));
    }

}
