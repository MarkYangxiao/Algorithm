package Array;

/**
 * Created by Yangxiao on 2018/9/2.
 * desc: 输入两个字符串， 表示两个大数，返回他们的和。
 * 123 456
 * return 579
 */
public class AddBigNum {

  public static void main(String[] args) {
    System.out.println(addBigInteger("123", "956"));
    System.out.println(addBigInteger1("123", "956"));
  }
  //方法1 模拟逐位相加
  public static String addBigInteger(String str1, String str2) {
    String ans = "";
    int carry = 0;
    char[] cstr1 = str1.toCharArray();
    char[] cstr2 = str2.toCharArray();
    for (int i = cstr1.length - 1, j = cstr2.length - 1; i >= 0 || j >= 0; i--, j--) {
      int sum = carry;
      sum += (i >= 0) ? cstr1[i] - '0' : 0;
      sum += (j >= 0) ? cstr2[j] - '0' : 0;

      ans = (sum % 10) + ans;
      carry = sum / 10;
    }
    if (carry != 0) {
      ans = carry + ans;
    }
    return ans;
  }
  //方法二 先全部相加 最后 进位
  public static String addBigInteger1(String str1, String str2) {
    String ans = "";
    int len = Math.max(str1.length(), str2.length());
    int[] ansArr = new int[len + 1];
    char[] cstr1 = str1.toCharArray();
    char[] cstr2 = str2.toCharArray();

    int idx = 0;
    for (int i = cstr1.length - 1, j = cstr2.length - 1; i >= 0 || j >= 0; i--, j--) {
      ansArr[idx] += (i >= 0) ? cstr1[i] - '0' : 0;
      ansArr[idx++] += (j >= 0) ? cstr2[j] - '0' : 0;
    }

    for (int i = 0; i < ansArr.length - 1; i++) {
      ansArr[i + 1] += ansArr[i] / 10;
      ansArr[i] %= 10;
    }

    idx = ansArr.length - 1;
    while (ansArr[idx] == 0 && idx > 0) {
      idx--;
    }

    for (int i = 0; i <= idx; i++) {
      ans = ansArr[i] + ans;
    }
    return ans;
  }
}
