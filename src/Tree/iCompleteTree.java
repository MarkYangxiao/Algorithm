package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yangxiao on 2018/11/23.
 * desc:
 */
public class iCompleteTree {
  static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
      this.val = val;
    }
  }
  static public boolean isCTree(TreeNode root) {
    if (root == null) {
      return false;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode node = root;
    while (node !=  null) {
      queue.offer(node.left);
      queue.offer(node.right);
      node = queue.poll();
    }

    while (!queue.isEmpty()) {
      TreeNode node1 = queue.poll();
      if (node1 != null) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n4.left = n6;
    System.out.println(isCTree(n1));


  }
}
