package DataStructure;

import java.util.*;

/**
 * Created by Yangxiao on 2018/8/25.
 * desc:
 */
public class Ttoutiao01 {

    private static ArrayList<ArrayList<Integer>> l;

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();
      int nx = t;
      int[][] infor = new int[t][2];
      int idx = 0;
      l = new ArrayList<>();
      while (t-- > 0) {
        int n = in.nextInt();//点
        int m = in.nextInt();
        infor[idx][0] = n;
        infor[idx++][1] = m;

        for (int i = 0; i < m; i++) {
          ArrayList<Integer> t1 = new ArrayList<>();
          int x = in.nextInt();
          int y = in.nextInt();
          t1.add(x);
          t1.add(y);
          l.add(t1);
        }
      }
      int start = 0;
      for (int i = 0; i < nx; i ++) {
        System.out.println(isMoreG(l.subList(start, start + infor[i][1]), infor[i][0], infor[i][1]));
        start += infor[i][1];
      }
    }
    private static String isMoreG(List<ArrayList<Integer>> nums, int n, int m) {
      UF uf = new UF(n);
      for (int i = 0; i < m; i++) {
        uf.union(nums.get(i).get(0), nums.get(i).get(1) - 1);
      }
      Set<Integer> hashSet = new HashSet<>();
      for (int i = 0; i < n; i++) {
        hashSet.add(uf.find(i));
      }
      return hashSet.size() > 2 ? "Yes" : "No";
    }
  static class UF {
    int[] id;
    public UF(int N) {
      id = new int[N];
      for (int i = 0; i < N; i++) {
        id[i] = i;
      }
    }
    public int find(int p) {
      return id[p];
    }

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
}
