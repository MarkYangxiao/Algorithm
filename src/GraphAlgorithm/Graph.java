package GraphAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yangxiao on 2018/10/6.
 * desc:
 */
public class  Graph{

  private int num; // 节点数
  private LinkedList<Integer> adj[];

  public Graph(int num) {
    this.num = num;
    adj = new LinkedList[num];
    for (int i = 0; i < num; i++) {
      adj[i] = new LinkedList<>();
    }
  }
  public void addEdge(int from, int to) {
    adj[from].add(to);
  }

  public void BFS(int start) {
    boolean[] visited = new boolean[num];

    LinkedList<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;
    while (!queue.isEmpty()) {

    }
  }
}
