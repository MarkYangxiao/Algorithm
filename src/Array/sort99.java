package Array;

import java.util.Arrays;

/**
 * Created by Yangxiao on 2018/11/18.
 * desc:
 */
public class sort99 {
  public int minDeletionSize(String[] A) {
    int eachLen = A[0].length();
    int len = A.length;
    int ans = 0;

    String[] newStr = new String[eachLen];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < eachLen; j++) {
        newStr[j] += A[i].charAt(j);
      }
    }

    for (String str : newStr) {
      char[] ch = str.toCharArray();
      Arrays.sort(ch);
      String tmp = String.valueOf(ch);
      if (!tmp.equals(str)) {
        ans++;
      }
    }
    return ans;
  }
}
