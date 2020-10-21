package cn.choleece.base.niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author choleece
 * @Description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * @Date 2020-10-20 21:33
 **/
public class Nc119 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (k > input.length) {
            return result;
        }

        Queue<Integer> queue = new PriorityQueue();

        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }

        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }

}
