package DataStructure;

import java.util.*;

/**
 * Created by Yangxiao on 2018/8/25.
 * desc:
 */
public class Ttoutiao01 {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int nums = in.nextInt();
      List<List<Integer>> list = new ArrayList<>();
      in.nextLine();
      for (int i = 0; i < nums; i++) {
        List<Integer> line = new ArrayList<>();
        String str = in.nextLine();
        String[] strArr = str.split(" ");
        for (String s: strArr) {
          int a = Integer.valueOf(s);
          line.add(a);
        }
        list.add(line);
      }
      UF uf = new UF(nums);
      for (int i = 0; i < list.size(); i++) {
        for (int j = 0; j < list.get(i).size() - 1; j++) {
          uf.union(i, list.get(i).get(j) - 1);
        }
      }
      Set<Integer> hashSet = new HashSet<>();
      for (int i = 0; i < nums; i++) {
        hashSet.add(uf.find(i));
      }
      System.out.println(hashSet.size());
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
      if (p == id[p]) {
        return p;
      } else {
        return id[p] = find(id[p]);
      }
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
