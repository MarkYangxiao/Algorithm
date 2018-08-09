package newcoder;

import java.util.ArrayList;

/**
 * Created by Yangxiao on 2018/8/9.
 * desc:输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 利用递归
 */

public class T03 {
  class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }


  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    if (listNode == null) {
      return new ArrayList<Integer>();
    }
    ArrayList<Integer> res = new ArrayList<Integer>();
    helper(listNode, res);
    return res;
  }

  private void helper(ListNode listNode, ArrayList<Integer> list) {
    if (listNode == null) {
      return;
    }
    helper(listNode.next, list);
    list.add(listNode.val);
  }

}
