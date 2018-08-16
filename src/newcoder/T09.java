package newcoder;

/**
 * Created by Yangxiao on 2018/8/16.
 * desc:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(1) = 1
 * f(2) = 2
 * f(n) = 2 * f(n - 1)
 *
 * 转移成求2的n 次方
 */
public class T09 {
  public int JumpFloorII(int target) {
    return 1 << (target - 1);
  }
}
