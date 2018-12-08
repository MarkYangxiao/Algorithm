package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yangxiao on 2018/10/12.
 * desc:
 */
public class CartesianProduct {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N  = in.nextInt();
    List<List<Object>> arrays = new ArrayList<>();
    while (N-- > 0) {
      String str = in.next();
      List<Object> list = Arrays.asList(str.split(","));
      arrays.add(list);
    }
    List<List<Object>> ans = new ArrayList<>();
    dfs(ans, arrays, new ArrayList<Object>(), 0);
    for (List<Object> list : ans) {
      System.out.println(list);
    }
  }
  public static void dfs(List<List<Object>> ans, List<List<Object>> arrays, List<Object> list, int level) {
    if (level == arrays.size()) {
      ans.add(new ArrayList<>(list));
      return;
    }
    List<Object> tmp = arrays.get(level);
    for (int j = 0; j < tmp.size(); j++) {
      list.add(tmp.get(j));
      dfs(ans, arrays, list, level + 1);
      list.remove(list.size() - 1);
    }
  }
}
