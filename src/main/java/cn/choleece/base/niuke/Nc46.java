package cn.choleece.base.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author choleece
 * @Description:
 * 给出一组候选数\ C C 和一个目标数\ T T，找出候选数中起来和等于\ T T 的所有组合。
 * \ C C 中的每个数字在一个组合中只能使用一次。
 * 注意：
 * 题目中所有的数字（包括目标数\ T T ）都是正整数
 * 结果中不能包含重复的组合
 * @Date 2020-10-19 21:59
 **/
public class Nc46 {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        backTrack(0, new ArrayList<Integer>(), target, result, 0, num.length, num);
        return result;
    }

    public void backTrack(int sum, ArrayList<Integer> combination, int target, ArrayList<ArrayList<Integer>> result, int start, int length, int[] num) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        for(int i = start; i < length; i++) {
            if (i > start && num[i] == num[i - 1]) {
                continue;
            }
            sum += num[i];
            if (sum <= target) {
                combination.add(num[i]);
                backTrack(sum, combination, target, result, i + 1, length, num);
                combination.remove(combination.size() - 1);
            }
            sum -= num[i];
        }
    }
}
