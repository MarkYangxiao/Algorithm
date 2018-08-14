package DataStructure;

/**
 * Created by Yangxiao on 2018/8/14.
 * desc: 使较小的树连在较大树下面
 * find 和 union 都为logn
 */
public class WeightQuickUnionUF extends UnionFind {

  //保存节点的数量信息
  private int[] sz;

  public WeightQuickUnionUF(int N) {
    super(N);
    this.sz = new int[N];
    for (int i = 0; i < N; i++) {
      this.sz[i] = 1;
    }
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
    int i = find(p);
    int j = find(q);
    if (i == j) return;
    if (sz[i] < sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
  }
}
