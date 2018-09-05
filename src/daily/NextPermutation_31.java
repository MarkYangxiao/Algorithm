package daily;

/**
 * Created by Yangxiao on 2018/9/5.
 * desc:Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place and use only constant extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 */
public class NextPermutation_31 {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    /*
    * 从尾到头找第一个 违背逆序的元素， 然后从当前元素往后找第一个大于当前元素的元素，swap，
    * 然后reverse 当前元素到最后的元素，使其成为升序
    * */
    int k = nums.length - 2;
    while (k >= 0 && nums[k] >= nums[k + 1]) {
      k--;
    }
    if (k < 0) {
      reverse(nums, 0, nums.length - 1);
      return;
    }

    int j = k + 1;
    while (j < nums.length && nums[k] < nums[j]) {
      j++;
    }
    swap(nums, k, j - 1);
    reverse(nums, k + 1, nums.length - 1);
  }

  public void reverse(int[] arr, int i, int j) {
    if (i > j) {
      reverse(arr, j, i);
    }
    while (i < j) {
      swap(arr, i ,j);
      i++;
      j--;
    }
  }
  public void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    arr[i] = arr[i] + arr[j];
    arr[j] = arr[i] - arr[j];
    arr[i] = arr[i] - arr[j];
  }
}
