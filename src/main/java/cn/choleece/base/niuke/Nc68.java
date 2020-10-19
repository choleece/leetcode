package cn.choleece.base.niuke;

/**
 * @author choleece
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @Date 2020-10-19 23:22
 **/
public class Nc68 {

    public static int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        return jumpFloor(target - 2) + jumpFloor(target - 1);
    }

    public static int jumpFloorWithDp(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println("recursion: " + jumpFloor(6));
        System.out.println("dp: " + jumpFloorWithDp(6));
    }

}
