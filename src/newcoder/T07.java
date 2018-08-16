package newcoder;

/**
 * Created by Yangxiao on 2018/8/15.
 * desc:斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 n<=39
 */
public class T07 {
  public int Fibonacci(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int first = 0;
    int second = 1;
    int res = 0;
    for (int i = 2; i <= n; i++) {
      res = first + second;
      first = second;
      second = res;
    }
    return res;
  }
}
