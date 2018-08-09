package newcoder;

import java.util.Stack;

/**
 * Created by Yangxiao on 2018/8/9.
 * desc: 两个栈实现一个队列
 */
public class T05 {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

}
