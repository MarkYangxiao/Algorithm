package newcoder;

/**
 * Created by Yangxiao on 2018/8/16.
 * desc:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 当一个数不为0时，则二进制中一定有1存在
 * n & (n - 1) 去掉n二进制中最右边的1
 */
public class T11 {
  public int NumberOf1(int n) {
    int res = 0;
    while (n != 0) {
      res++;
      n = n & (n - 1);
    }
    return res;
  }
}
