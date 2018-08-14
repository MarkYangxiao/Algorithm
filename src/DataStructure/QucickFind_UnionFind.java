package DataStructure;

/**
 * Created by Yangxiao on 2018/8/14.
 * desc:   quick find 同一连通分量的所有id值相同,
 * 优点： 可以快速判断两个点 是否连通
 * 缺点： union麻烦，需要将同一连通分量的id值置为一样
 */
public class QucickFind_UnionFind extends UnionFind{
  public QucickFind_UnionFind(int N) {
    super(N);
  }
  @Override
  public int find(int p) {
    return id[p];
  }

  @Override
  public void union(int p, int q) {
    int pid = find(p);
    int qid = find(q);

    if (qid == pid) {
      return;
    }
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) {
        id[i] = qid;
      }
    }
  }
}
