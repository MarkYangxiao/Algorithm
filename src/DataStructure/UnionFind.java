package DataStructure;

/**
 * Created by Yangxiao on 2018/8/14.
 * desc: union find 动态连通性问题，给定两个点 判断是否连通
 */
public abstract class UnionFind {
  //借助数组
  public int[] id;

  //初始化数组
  public UnionFind(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }
  //判断两点是否连通
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }
  //查找P所在的连通分量
  public abstract int find(int p);
  //连接p和q
  public abstract void union(int p, int q);
}
