package sorted;

import static sorted.BubleSort.print;
import static sorted.BubleSort.swap;
/**
 * Created by Yangxiao on 2018/8/8.
 * desc: 建堆，
 */
public class HeapSort {
  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};
    sort(nums);
    print(nums);
  }

  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      createHeap(nums, nums.length - i - 1);
      swap(nums, 0, nums.length - 1 - i);
    }
  }
  public static void createHeap(int[] nums, int last) {
    //find the parent
    for (int i = (last - 1) / 2; i >= 0; i--) {
      int parent = i;
      //if has left child
      while (parent * 2 + 1 <= last) {
        //point to smallest
        int small = parent * 2 + 1;
        //if has right child
        if (small < last) {
          if (nums[small] > nums[small + 1]) {
              small = small + 1;
          }
        }

        if (nums[small] < nums[parent]) {
          swap(nums, small, parent);
          parent = small;
        } else {
          break;
        }
      }
    }

  }
}
