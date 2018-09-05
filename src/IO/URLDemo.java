package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yangxiao on 2018/8/26.
 * desc:
 */
public class URLDemo {
  public static final String HOST_NAME ="http://www.baidu.com";
  public static void main(String[] args) throws IOException {
    URL url = new URL(HOST_NAME);
    //字节流
    InputStream is = url.openStream();
    //字符流
    InputStreamReader isr = new InputStreamReader(is, "utf-8");
    BufferedReader br = new BufferedReader(isr);
    String line = br.readLine();
    while (line != null) {
      System.out.println(line);
      line = br.readLine();
    }
    br.close();

  }
}
