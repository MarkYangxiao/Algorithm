package LinkedList;


import java.util.PriorityQueue;

/**
 * Created by Yangxiao on 2018/10/16.
 * desc:
 */
public class MergeKSortedList {
  public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
      this.val = val;
    }
  }
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
    for (ListNode listNode : lists) {
      pq.offer(listNode);
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      cur.next = node;
      if (node.next != null) {
        pq.offer(node.next);
      }
      cur = cur.next;
    }
    return dummy.next;


  }
}
