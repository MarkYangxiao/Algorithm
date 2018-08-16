package newcoder;

/**
 * Created by Yangxiao on 2018/8/16.
 * desc:输入一个链表，输出该链表中倒数第k个结点。
 */
public class T13 {

  public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
      if (head == null || k < 0) {
        return null;
      }
      ListNode cur = head;
      for (int i = 0; i < k; i++) {
        if (cur == null) {
          return null;
        }
        cur = cur.next;
      }
      ListNode res = head;
      while (cur != null) {
        res = res.next;
        cur = cur.next;
      }
      return res;
    }
  }
}
