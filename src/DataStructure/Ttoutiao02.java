package DataStructure;

import java.util.Scanner;

/**
 * Created by Yangxiao on 2018/8/25.
 * desc:
 */
public class Ttoutiao02 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int t = in.nextInt();
    int[] origin = new int[n];
    int[] pm = new int[n * t];
    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      origin[i] = num;
    }
    for (int i = 0; i < pm.length; i++) {
      pm[i] = origin[i % n];
    }
    System.out.println(max(pm));
  }
  public static int max(int[] nums) {
    int size = nums.length;
    int[] dp = new int[nums.length];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = 1;
    }
    int res = 1;
    for (int i = 1; i < size; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
