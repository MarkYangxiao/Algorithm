package IO;

import java.io.File;

/**
 * Created by Yangxiao on 2018/8/25.
 * desc:
 */
public class FileOP {
  public static void listAllFiles(File dir) {
    if (dir == null || dir.exists()) {
      return;
    }
    if (dir.isFile()) {
      System.out.println(dir.getName());
      return;
    }
    for (File file : dir.listFiles()) {
      listAllFiles(file);
    }
  }
}
