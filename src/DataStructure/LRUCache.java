package DataStructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Yangxiao on 2018/8/18.
 * desc:
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V > {
  private static final int MAX_ENTRIES = 3;

  protected boolean removeEldestEntry(Map.Entry eldest) {
    return size() > MAX_ENTRIES;
  }
  public LRUCache() {
    super(MAX_ENTRIES, 0.75f, true);
  }

  public static void main(String[] args) {
    LRUCache<Integer, String> cache = new LRUCache<>();
    cache.put(1, "a");
    cache.put(2, "b");
    cache.put(3, "c");
    cache.get(1);
    cache.put(4, "d");
    System.out.println(cache.keySet());
  }
}
