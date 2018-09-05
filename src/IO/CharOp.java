package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Yangxiao on 2018/8/25.
 * desc:  不管是磁盘还是网络传输，最小存储单元都是字节，而不是字符。
 * 但是在程序中操作的通常是字符形式的数据，因此需要提供字符进行操作的方法
 *
 * InputStreamReader 字节流解码成字符流
 * OutputStreamWriter 字符流编码成字节流
 */
public class CharOp {
  //逐行输出文本内容
  public static void readFileContent(String filePath) throws IOException {
    FileReader fileReader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      System.out.println(line);
    }
    bufferedReader.close();
  }
}
