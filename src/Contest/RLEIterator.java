package Contest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yangxiao on 2018/9/9.
 * desc:
 */
public class RLEIterator {
  static Queue<Integer> queue;

  public static void main(String[] args) {
    int[] A = {3,8,0,9,2,5};
    RLEIterator rleIterator = new RLEIterator(A);
    System.out.print(next(2));
    System.out.print(next(1));
    System.out.print(next(1));
    System.out.print(next(2));

  }
  public RLEIterator(int[] A) {
    queue = transfer(A);

  }

  public static int next(int n) {
    Integer ans = null;
    while (!queue.isEmpty() && queue.size() - n >= 0 && n > 0) {
      n--;
      ans = queue.poll();
    }
    if (n > 0) {
      return -1;
    }
    return ans;
  }
  private static Queue<Integer> transfer(int[] A) {
    if (A == null || A.length == 0 || A.length % 2 == 1) {
      return new LinkedList();
    }
    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < A.length - 1; i += 2) {
      for (int j = 0; j < A[i]; j++) {
        queue.offer(A[i + 1]);
      }
    }
    return queue;
  }
}
