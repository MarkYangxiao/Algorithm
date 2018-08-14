package sorted;

/**
 * Created by Yangxiao on 2018/8/12.
 * desc:  n个不重复的数放在大小为n的数组中 排序 在O(n)
 */
public class BSort {
  public static void main(String[] args) {
    int[] arr = {5, 3, 1, 0 , 2, 4};
    sort(arr);
    print(arr);
  }

  public static void sort(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      if (arr[i] != i) {
        swap(arr, i, arr[i]);
      }
    }
    for (int j = arr.length - 1; j >=0; j--) {
      if (arr[j] != j) {
        swap(arr, j, arr[j]);
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
