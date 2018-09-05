package Array;

/**
 * Created by Yangxiao on 2018/9/2.
 * desc: 大数相乘
 */
public class MutiplyBigInteger {
  public static void main(String[] args) {
    System.out.println(mutiplyBigInteger("12", "5"));
  }

  public static String mutiplyBigInteger(String str1, String str2) {
    String ans = "";
    int[] ansArr = new int[str1.length() + str2.length() + 1];
    char[] cstr1 = str1.toCharArray();
    char[] cstr2 = str2.toCharArray();
    for (int i = 0; i < str1.length(); i++) {
      for (int j = 0; j < str2.length(); j++) {
        ansArr[i + j] += (cstr1[str1.length() - i - 1] - '0') * (cstr2[str2.length() - j - 1] - '0');
      }
    }

    for (int i = 0; i < ansArr.length - 1; i++) {
      ansArr[i + 1] += ansArr[i] / 10;
      ansArr[i] %= 10;
    }

    int idx = ansArr.length - 1;
    while (idx > 0 && ansArr[idx] == 0) {
      idx--;
    }
    while (idx >= 0) {
      ans += ansArr[idx--];
    }
    return ans;
  }
}
