package newcoder;

/**
 * Created by Yangxiao on 2018/8/14.
 * desc: 旋转数组找最小值，数组大小为0 返回0
 */
public class T06 {
  public static int find(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > arr[left]) {
        left = mid + 1;
      } else if (arr[mid] == arr[right]) {
        right = right - 1;
      } else {
        right = mid;
      }
    }
    return arr[left];
  }
}
