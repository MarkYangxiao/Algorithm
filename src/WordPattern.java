import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yangxiao on 2018/9/11.
 * desc:
 */
public class WordPattern {
  public static void main(String[] args) {
    String p = "abba";
    String str =  "dog cat cat fish";
    System.out.println(wordPattern(p , str));
  }
  /*
  * leetcode 290
  *Input: pattern = "abba", str = "dog cat cat dog"
    Output: true
  * */
  public static boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
      return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i) {
      if (index.putIfAbsent(pattern.charAt(i), i) != index.putIfAbsent(words[i], i)) {
        return false;
      }
    }
    return true;
  }
  /*890 leetcode 890
  * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    Output: ["mee","aqq"]
    Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
    "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
    since a and b map to the same letter.
  * */
  public static List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> ans = new ArrayList<>();
    if (words == null || words.length == 0 || pattern == null || pattern.length() == 0) {
      return ans;
    }
    for (String word : words) {
      int[] s = new int[26];
      int[] p = new int[26];
      boolean same = true;
      for (int i = 0; i < pattern.length(); i++) {
        if (p[pattern.charAt(i) - 'a'] != s[word.charAt(i) - 'a']) {
          same = false;
        } else {
          p[pattern.charAt(i) - 'a'] = i + 1;
          s[word.charAt(i) - 'a'] = i + 1;
        }
      }
      if (same) {
        ans.add(word);
      }
    }
    return ans;

  }

}
