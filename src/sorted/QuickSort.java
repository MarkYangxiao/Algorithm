package sorted;

import static sorted.BubleSort.print;

/**
 * Created by Yangxiao on 2018/8/8.
 * desc: 快排
 *
 */
public class  QuickSort {
  public static void main(String[] args) {
    int[] nums = {5, 4, 3, 2, 1, 4};
    sort(nums, 0, nums.length - 1);
    print(nums);
  }
  public static void sort(int[] nums, int low, int high) {
    if (low < high) {
      int middle = getMiddle(nums, low, high);
      sort(nums, low, middle - 1);
      sort(nums, middle + 1, high);
    }
  }

  public static int getMiddle(int[] nums, int low, int high) {
    int tmp = nums[low]; //选定一个key ，左边比key 小 右边比key大
    while (low < high) {
      while (low < high && tmp <= nums[high]) {
        high--;
      }
      nums[low] = nums[high];
      while (low < high && tmp >= nums[low]) {
        low++;
      }
      nums[high] = nums[low];
    }
    nums[low] = tmp;
    return low;
  }
}
