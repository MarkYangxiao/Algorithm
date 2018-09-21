package DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yangxiao on 2018/9/21.
 * desc:  双向链表 和 hashmap 实现
 *  双向链表维护顺序 hashmap实现快速查找
 */
public class LRUCache1 {
  /*define double linkedlist node*/
  class DoubleLinkedNode {
    int key;
    int value;
    DoubleLinkedNode pre;
    DoubleLinkedNode next;

    public DoubleLinkedNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  /*implements lru cache*/
  Map<Integer, DoubleLinkedNode> map;
  int capicity, count;
  DoubleLinkedNode head, tail;

  public LRUCache1(int capicity) {
    this.capicity = capicity;
    map = new HashMap<>();
    head = new DoubleLinkedNode(0, 0);
    tail = new DoubleLinkedNode(0, 0);
    head.next = tail;
    tail.next = null;
    head.pre = null;
    tail.pre = head;
    count = 0;
  }

  private void deleteNode(DoubleLinkedNode node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }

  private void addToHead(DoubleLinkedNode node) {
    //后半部分
    head.next.pre = node;
    node.next = head.next;
    //前半部分
    head.next = node;
    node.pre = head;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      DoubleLinkedNode node = map.get(key);
      int result = node.value;
      deleteNode(node);
      addToHead(node);
      return result;
    }
    return -1;
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      DoubleLinkedNode node = map.get(key);
      node.value = value;
      deleteNode(node);
      addToHead(node);
    } else {
      DoubleLinkedNode node = new DoubleLinkedNode(key, value);
      map.put(key, node);
      if (count < capicity) {
        count++;
        addToHead(node);
      } else {
        map.remove(tail.pre.key);
        deleteNode(tail.pre);
        addToHead(node);
      }
    }
  }
}
