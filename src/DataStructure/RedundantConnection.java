package DataStructure;

/**
 * Created by Yangxiao on 2018/8/14.
 * desc:  冗余连接
 * 一棵树 N个节点，无环
 * 输入 一张图，去掉冗余的边之后变成树，返回冗余的边。
 * leetcode : 684
 */
public class RedundantConnection {
  public int[] findRedundantConnection(int[][] edges) {
    int N = edges.length;
    UF uf = new UF(N);
    for (int[] edge : edges) {
      //点的编号 给定从1开始
      int p = edge[0] - 1;
      int q = edge[1] - 1;

      if (uf.find(p) == uf.find(q)) {
        return edge;
      } else {
        uf.union(p, q);
      }
    }
    return null;
  }

  class UF{
    int[] id;
    public UF(int N) {
      id = new int[N];
      for (int i = 0; i < N; i++) {
        id[i] = i;
      }
    }

    public int find(int p) {
      while (p != id[p]) {
        p = id[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int pRoot = find(p);
      int qRoot = find(q);
      if (pRoot == qRoot) {
        return;
      }
      id[pRoot] = qRoot;
    }

  }
}
