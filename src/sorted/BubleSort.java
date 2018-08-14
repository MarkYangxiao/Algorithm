package sorted;

/**
 * Created by Yangxiao on 2018/8/8.
 * desc:
 */
public class BubleSort {
  public static void main(String[] args) {

  }
  public static void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return ;
    }

    //下沉排序，一次之后最大的降到最后（升序） 时间复杂度 N^2
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
        }
      }
    }
  }

  public static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    arr[i] = arr[i] + arr[j];
    arr[j] = arr[i] - arr[j];
    arr[i] = arr[i] - arr[j];
  }

  public static void print(int[] arr) {
    if (arr == null) {
      return;
    }
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}


