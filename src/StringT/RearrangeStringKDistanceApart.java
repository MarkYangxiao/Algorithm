package StringT;

import java.util.*;

/**
 * Created by Yangxiao on 2018/10/13.
 * desc:
 */
public class RearrangeStringKDistanceApart {
  public static String rearrangeString(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
      @Override
      public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return -o1.getValue().compareTo(o2.getValue());
      }
    });

    int len = map.size();
    int count = 0;
    int max = list.get(0).getValue();
    int i = 0;
    while (i < len && list.get(i).getValue() == max) {
      i++;
      count++;
    }
    String f = "";
    for (int j = 0; j < count; j++) {
      f += list.get(j).getKey();
    }
    //String[] tmp = new String[];
    return "";
  }
}
