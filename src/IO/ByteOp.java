package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Yangxiao on 2018/8/25.
 * desc: 字节流操作进行文件复制
 */
public class ByteOp {
  public static void copyFile(String src, String dst) throws IOException {
    FileInputStream in = new FileInputStream(src);
    FileOutputStream out = new FileOutputStream(dst);

    byte[] buffer = new byte[20 * 1024];
    //read() 最多读取 buffer.length 个字节
    //返回的是实际读取的个数
    //返回-1表示读到了eof，即文件结尾
    while (in.read(buffer, 0, buffer.length) != -1) {
      out.write(buffer);
    }
    in.close();
    out.close();
  }
}
