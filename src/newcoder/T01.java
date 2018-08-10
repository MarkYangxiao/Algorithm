package newcoder;

/**
 * Created by Yangxiao on 2018/8/9.
 * desc:在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * 二分查找
 */
public class T01 {
    public boolean Find(int target, int [][] array) {
      if (array == null || array.length == 0) {
        return false;
      }
      int row = array.length;
      int col = array[0].length;
      int i = 0;
      int j = col - 1;
      while (i < row && j >= 0){
        if (target == array[i][j]) {
          return true;
        } else if (target > array[i][j]) {
          i++;
        } else {
          j--;
        }
      }
      return false;
    }
}
