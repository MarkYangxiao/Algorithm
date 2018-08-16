package newcoder;

/**
 * Created by Yangxiao on 2018/8/16.
 * desc:一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class T08 {
  public int JumpFloor01(int target) {
    if (target <= 1) {
      return 1;
    }
    int[] dp = new int[target];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < target; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[target - 1];
  }
  public int JumpFloor02(int target) {
    if (target == 1) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }
    int first = 1;
    int second = 2;
    int res  = 0;
    for (int i = 2; i < target; i++) {
      res = first + second;
      first = second;
      second = res;
    }
    return res;
  }
}
