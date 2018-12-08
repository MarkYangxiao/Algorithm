package StringT;

/**
 * Created by Yangxiao on 2018/9/24.
 * desc: lc 424 Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * Given a string that consists of only uppercase English letters,
 * you can replace any letter in the string with another letter at most k times.
 * Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

 Note:
 Both the string's length and k will not exceed 104.

 Example 1:

 Input:
 s = "ABAB", k = 2

 Output:
 4

 Explanation:
 Replace the two 'A's with two 'B's or vice versa.
 */
public class LongestRepeatingCharacterReplacement {
  public int characterReplacement(String s, int k) {
    //维护一个滑动窗口，if(窗口的大小-窗口中出现最多字符的频次) <= k，则窗口可以继续往后延申
    int maxSize = 0, maxCount = 0, start = 0;
    //因为全为大写字符，所以维护一个大小为26的数组来充当map就可以了
    int[] map = new int[26];
    //end为目前窗口的尾端
    for (int end = 0; end < s.length(); end++) {
      map[s.charAt(end) - 'A']++;
      //maxCount窗口中出现最多次字符的频次
      maxCount = Math.max(maxCount, map[s.charAt(end) - 'A']);
      //如果窗口内所有元素，在k次变化内不能成为所有重复的字符
      if (end - start + 1 - maxCount > k) {
        //窗口头部字符 滑出窗口
        map[s.charAt(start) - 'A']--;
        //窗口起始点，往后滑
        start++;
      }
      maxSize = Math.max(maxSize, end - start + 1);
    }
    return maxSize;
  }

}
