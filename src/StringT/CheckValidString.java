package StringT;

/**
 * Created by Yangxiao on 2018/9/23.
 * desc: lc : 678 CheckValidString
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 */
public class CheckValidString {
  public boolean checkValidString(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    int low = 0;
    int high = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        high++;
        low++;
      } else if (s.charAt(i) == ')'){
        if (low > 0) {
          low--;
        }
        high--;
      } else {
        if (low > 0) {
          low--;
        }
        high++;
      }

      if (high < 0) {
        return false;
      }
    }
    return low == 0;
  }
}
