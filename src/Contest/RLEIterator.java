package Contest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yangxiao on 2018/9/9.
 * desc:
 */
public class RLEIterator {
  Queue<Integer> queue;
  public RLEIterator(int[] A) {
    queue = transfer(A);
    System.out.print(queue.size());
  }

  public int next(int n) {
    Integer ans = null;
    while (!queue.isEmpty() && queue.size() - n > 0) {
      n--;
      ans = queue.poll();
    }
    if (n > 0) {
      return -1;
    }
    return ans;
  }
  private Queue<Integer> transfer(int[] A) {
    if (A == null || A.length == 0 || A.length % 2 == 1) {
      return new LinkedList();
    }
    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < A.length - 1; i += 2) {
      for (int j = 0; j < A[i]; j++) {
        queue.offer(A[i]);
      }
    }
    return queue;
  }
}
