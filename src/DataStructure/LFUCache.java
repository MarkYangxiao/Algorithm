package DataStructure;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by Yangxiao on 2018/9/21.
 * desc:
 */
public class LFUCache {
  HashMap<Integer, Integer> vals;// 维护key--value
  HashMap<Integer, Integer> counts; // 维护key ---counts
  HashMap<Integer, LinkedHashSet<Integer>> lists;// 维护 key 顺序

  int cap;
  int min = -1;

  public LFUCache(int cap) {
    this.cap = cap;
    vals = new HashMap<>();
    lists = new HashMap<>();
    counts = new HashMap<>();
    lists.put(1, new LinkedHashSet<>());
  }

  public int get(int key) {
    //当前cache不存在key
    if (!vals.containsKey(key)) {
      return -1;
    }
    //获取key的次数，
    int count = counts.get(key);
    //更新key的次数
    counts.put(key, counts.get(key) + 1);
    //把key从当前次数里移除
    lists.get(count).remove(key);
    //当前次数为最小的Min,且在最小的min里面没有元素，则min + 1
    if (count == min && lists.get(count).size() == 0) {
      min++;
    }
    //如果当前不存在count + 1的 linkedHashSet 则new 1 个
    if (!lists.containsKey(count + 1)) {
      lists.put(count + 1, new LinkedHashSet<>());
    }
    //把当前的key放入count + 1的set中
    lists.get(count + 1).add(key);
    return vals.get(key);
  }

  public void set(int key, int value) {
    //cache 容量小于0
    if (cap <= 0) {
      return;
    }
    //如果存在key
    if (vals.containsKey(key)) {
      //更新key
      vals.put(key, value);
      //访问了一次key
      get(key);
      //返回
      return;
    }
    //如果 当前cache 已满
    if (vals.size() >= cap) {
      //得到最小的次数的第一个
      int evit = lists.get(min).iterator().next();
      //移除从set中
      lists.get(min).remove(evit);
      //从值中移除
      vals.remove(evit);
    }
    //加入新的key--value
    vals.put(key, value);
    //次数为1
    counts.put(key, 1);
    //最小为 1
    min = 1;
    //当前1里面加入新元素
    lists.get(1).add(key);
  }
}
