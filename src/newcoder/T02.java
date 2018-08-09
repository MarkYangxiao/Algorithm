package newcoder;

/**
 * Created by Yangxiao on 2018/8/9.
 * desc:
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 1. replace 库函数
 * 2. 先遍历一遍 统计有多少个空格，再对str进行扩容，在遍历进行添加  优点：空间为O(1) ,缺点:代码复杂
 * 3. 新建一个StringBuilder 遍历 将原字符一一加入到新的sb中，遇到空格则进行替换。缺点： 空间O(n)  优点：代码简洁
 */
public class T02 {
  public class Solution {
    public String replaceSpace(StringBuffer str) {

      //Best way
      char a = '%';
      char b = '2';
      char c = '0';
      int count = 0;
      int strlen = str.length();
      for (int i = 0; i < strlen; i++) {
        if (str.charAt(i) == ' ') {
          count++;
        }
      }
      int new_length = strlen - count + 3*count;
      str.setLength(new_length);
      int j = new_length - 1;
      for (int i = strlen - 1; i != j; i--) {
        char ch = str.charAt(i);
        if (ch != ' ') {
          str.setCharAt(j-- , ch);
        } else {
          str.setCharAt(j--, c);
          str.setCharAt(j--, b);
          str.setCharAt(j--, a);
        }
      }
      return str.toString();
       /*
        String string = "%20";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append(string);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
        */
    }
  }
}
