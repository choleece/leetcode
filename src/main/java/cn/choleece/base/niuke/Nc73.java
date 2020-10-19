package cn.choleece.base.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choleece
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 * @Date 2020-10-19 22:56
 **/
public class Nc73 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        int threshold = array.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++) {
            Integer count = map.getOrDefault(array[i], 0) + 1;
            if (count >= threshold) {
                return array[i];
            }
            map.put(array[i], count);
        }

        return 0;
    }

}
