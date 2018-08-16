package newcoder;

/**
 * Created by Yangxiao on 2018/8/16.
 * desc:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class T12 {
  public double Power(double base, int exponent) {
    if (exponent == 0) {
      return 1.0;
    }
    return exponent > 0 ? MyPower(base, exponent) : 1.0 / MyPower(base, exponent);
  }
  private double MyPower(double base, int exp) {
    if (exp == 0) {
      return 1.0 * base;
    }
    if (exp % 2 == 0) {
      return MyPower(base, exp / 2);
    } else {
      return base * MyPower(base, exp / 3);
    }
  }
}
