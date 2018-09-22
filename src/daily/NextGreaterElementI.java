package daily;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yangxiao on 2018/9/22.
 * desc:
 */
public class NextGreaterElementI {
  public static void main(String[] args) {
    int[] nums1 = {4, 1, 2};
    int[] nums2 = {1, 3, 4, 2};
    print(nextGreaterElement(nums1, nums2));
    print(nextGreaterElement1(nums1, nums2));
  }
  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //num1 是 subset
    if (nums1 == null || nums1.length == 0) {
      return new int[0];
    }
    int len = nums1.length;
    int[] ans = new int[len];
    for (int i = 0; i < len; i++) {
      ans[i] = -1;
    }
    for(int i = 0; i < nums1.length; i++) {
      boolean equals = false;
      for (int j = 0; j < nums2.length; j++) {
        if (equals) {
          if (nums2[j] > nums1[i]) {
            ans[i] = nums2[j];
            break;
          }
        }
        if (nums1[i] == nums2[j]) {
          equals = true;
        }

      }
    }
    return ans;
  }
//单调栈
  public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0) {
      return new int[0];
    }
    int len = nums1.length;
    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i : nums2) {
      while (!stack.isEmpty() && stack.peek() < i) {
        map.put(stack.pop(), i);
      }
      stack.push(i);
    }
    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = map.getOrDefault(nums1[i], -1);
    }
    return nums1;
  }

  public static void print(int[] nums) {
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }
}
