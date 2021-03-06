package daily;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yangxiao on 2018/9/6.
 * desc: https://leetcode.com/problems/flatten-nested-list-iterator/description/
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:

 Input: [[1,1],2,[1,1]]
 Output: [1,1,2,1,1]
 Explanation: By calling next repeatedly until hasNext returns false,
 the order of elements returned by next should be: [1,1,2,1,1].
 */
public class FlattenNestedListIterator_341 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
       public List<NestedInteger> getList();
    }
  public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
      for (int i = nestedList.size() - 1; i >= 0; i--) {
        stack.addFirst(nestedList.get(i));
      }
    }
    @Override
    public Integer next() {
      return stack.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
      while (!stack.isEmpty()) {
        NestedInteger cur = stack.peekFirst();
        if (cur.isInteger()) {
          return true;
        }
        stack.removeFirst();
        for (int i = cur.getList().size() - 1; i >= 0; i--) {
          stack.addFirst(cur.getList().get(i));
        }
      }
      return false;
    }
  }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
