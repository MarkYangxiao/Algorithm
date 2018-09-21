package Array;

import java.util.Arrays;

/**
 * Created by Yangxiao on 2018/9/12.
 * desc:
 */
public class Palindrome {
  public static void main(String[] args) {
    //System.out.println(higerPalindrome(1343));
    System.out.println(findMaxPalindoromic(5));
    System.out.println(findMinPalindoromic(5));
  }
  public static long higerPalindrome(long limit, boolean isRight) {
    String n = Long.toString(limit);
    char[] s = n.toCharArray(); // limit
    int m = s.length;
    char[] t = Arrays.copyOf(s, m); // target
    for (int i = 0; i < m / 2; i++) {
      t[m - 1 - i] = t[i];
    }
    for (int i = 0; i < m; i++) {
        if (s[i] < t[i]) {
          return Long.parseLong(String.valueOf(t));
        } else if (s[i] > t[i]) {
          for (int j = (m - 1) / 2; j >= 0; j--) {
            if (++t[j] > '9') {
              t[j] = '0';
            } else {
              break;
            }
          }
          // make it palindrome again
          for (int k = 0; k < m / 2; k++) {
            t[m - 1 - k] = t[k];
          }
          return Long.parseLong(String.valueOf(t));
        }
    }
    return Long.parseLong(String.valueOf(t));
  }
  public static long findMaxPalindoromic(long num) {
    String s = String.valueOf(num);
    char[] nums = s.toCharArray();
    char[] t = Arrays.copyOf(nums, nums.length);
    for (int i = 0; i < nums.length / 2; i++) {
      t[nums.length - 1 - i] = t[i];
    }
    for (int i = 0; i < nums.length; i++) {
      if (s.charAt(i) < t[i]) {
        return Long.parseLong(String.valueOf(t));
      } else {
        for (int j = (nums.length - 1) / 2; j >= 0; j--) {
          if (++t[j] > '9') {
            t[j] = 0;
          } else {
            break;
          }
        }

        for (int k = 0; k < nums.length / 2; k++) {
          t[nums.length - 1 - k] = t[k];
        }
      }
    }
    return Long.parseLong(String.valueOf(t));
  }

  public static long findMinPalindoromic(long num) {
    String s = String.valueOf(num);
    char[] nums = s.toCharArray();
    char[] t = Arrays.copyOf(nums, nums.length);
    for (int i = 0; i < nums.length / 2; i++) {
      t[nums.length - 1 - i] = t[i];
    }
    for (int i = 0; i < nums.length; i++) {
      if (s.charAt(i) >= t[i]) {
        return Long.parseLong(String.valueOf(t));
      } else {
        for (int j = (nums.length - 1) / 2; j >= 0; j--) {
          if (--t[j] < '0') {
            t[j] = 9;
          } else {
            break;
          }
        }

        for (int k = 0; k < nums.length / 2; k++) {
          t[nums.length - 1 - k] = t[k];
        }
      }
    }
    return Long.parseLong(String.valueOf(t));
  }
}
