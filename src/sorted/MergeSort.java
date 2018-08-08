package sorted;

import static sorted.BubleSort.print;

/**
 * Created by Yangxiao on 2018/8/8.
 * desc:
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] nums = {5, 4, 3, 2, 1};
    sort(nums, 0 , nums.length - 1);
    print(nums);
  }

  public static void sort(int[] nums, int low, int high) {
    if (low >= high) {
      return;
    }
    int center = low + (high - low) / 2;
    sort(nums, low, center);
    sort(nums, center + 1, high);
    merge(nums, low, center, high);
  }

  private static void merge(int[] nums, int low, int center, int high) {
    int idx = low;
    int tmpIdx = low;
    int right = center + 1;
    int[] tempArr = new int[nums.length];

    while (low <= center && right <= high) {
      if (nums[low] < nums[right]) {
        tempArr[idx++] = nums[low++];
      } else {
        tempArr[idx++] = nums[right++];
      }
    }

    while (low <= center) {
      tempArr[idx++] = nums[low++];
    }

    while (right <= high) {
      tempArr[idx++] = nums[right++];
    }
    while (tmpIdx <= high) {
      nums[tmpIdx] = tempArr[tmpIdx++];
    }
  }
}
