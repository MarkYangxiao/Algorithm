package IO.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Yangxiao on 2018/9/24.
 * desc:
 */
public class WebServer {
  public static void main(String[] args) throws IOException {
    try {
      ServerSocketChannel ssc = ServerSocketChannel.open();
      ssc.socket().bind(new InetSocketAddress("127.0.0.1", 3333));
      SocketChannel socketChannel = ssc.accept();

      ByteBuffer writeBuffer = ByteBuffer.allocate(128);
      writeBuffer.put("hello WebClient this is from WebServer".getBytes());
      writeBuffer.flip();
      socketChannel.write(writeBuffer);

      ByteBuffer readBuffer = ByteBuffer.allocate(128);
      socketChannel.read(readBuffer);
      readBuffer.flip();
      StringBuilder stringBuilder = new StringBuilder();
      while (readBuffer.hasRemaining()) {
        stringBuilder.append((char) readBuffer.get());
      }
      System.out.println("从客户端接收到的数据： " + stringBuilder);
      socketChannel.close();
      ssc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
