package DataStructure;

/**
 * Created by Yangxiao on 2018/8/14.
 * desc:quick union Union很简单，只需要改变一个节点
 * 缺点： find的时候很麻烦，因为同一连通分量的各个节点id都不一样,
 * find操作和树高成正比，最坏情况下树的高度为触点数目
 */
public class QuickUnion_UnioinFind extends UnionFind {
  public QuickUnion_UnioinFind(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    while (p != id[p]) {
      p = id[p];
    }
    return p;
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot != qRoot) {
      id[pRoot] = qRoot;
    }
  }
}
