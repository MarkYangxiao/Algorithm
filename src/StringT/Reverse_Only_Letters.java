package StringT;

/**
 * Created by Yangxiao on 2018/10/7.
 * desc:
 */
public class Reverse_Only_Letters {
  public static void main(String[] args) {
    System.out.println("Qedo1ct-eeLg=ntse-T!".equals(reverseOnlyLetters("Test1ng-Leet=code-Q!")));
  }
  public static String reverseOnlyLetters(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        sb.append(c);
      }
    }
    sb.reverse();
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isLetter(s.charAt(i))) {
        sb.insert(i, s.charAt(i));
      }
    }
    return sb.toString();
  }
  public static int max (int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int sofar = 0;
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length - 1; i++) {
      sum = sofar > 0 ? sofar + nums[i] : nums[i];
      sofar = sum;
      max = Math.max(sum, max);
    }

    sofar = 0;
    sum = 0;
    int max1 = Integer.MIN_VALUE;
    for (int i = 1; i < nums.length; i++) {
      sum = sofar > 0 ? sofar + nums[i] : nums[i];
      sofar = sum;
      max1 = Math.max(sum, max1);
    }
    return Math.max(max, max1);
  }
}
