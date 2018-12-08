package IO;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;

/**
 * Created by Yangxiao on 2018/9/24.
 * desc:
 */
public class ByteBufferMethods {
  public static void main(String[] args) {

    ByteBuffer buffer = ByteBuffer.allocate(33);
   // System.out.println("init allocate: " + buffer);
    System.out.println("--test reset--");
    buffer.position(5);
    buffer.mark();
    buffer.position(10);
    System.out.println("---before reset:  " + buffer);
    buffer.reset();
    System.out.println("after reset:  " + buffer);

    System.out.println("---test rewind---");

    buffer.clear();
    System.out.println("---after clear---" + buffer);
    buffer.position(10);
    //
    buffer.limit(15);
    System.out.println("before rewind: " + buffer);
    buffer.rewind();
    System.out.println("---after rewind---" + buffer);
    System.out.println("---Test Compact----");
    buffer.clear();
    System.out.println("---after clear---" + buffer);
    buffer.put("abcd".getBytes());
    System.out.println("before compact: " + buffer);
    System.out.println(new String(buffer.array()));

    buffer.flip();
    System.out.println("---after flip---" + buffer);
    System.out.println((char) buffer.get());
    System.out.println((char) buffer.get());
    System.out.println((char) buffer.get());

    System.out.println("---after get three Buffer---" + buffer);
    System.out.println("\t" + new String(buffer.array()));
    buffer.compact();
    System.out.println("---after compact---" + buffer);
    System.out.println("\t" + new String(buffer.array()));

    System.out.println("--Test get---");
    buffer = ByteBuffer.allocate(32);
    System.out.println("---after new allocate---" + buffer);
    System.out.println("\t" + new String(buffer.array()));

    buffer.put((byte) 'a').put((byte) 'b').put((byte) 'c').put((byte) 'd').put((byte) 'e').put((byte) 'f');

    System.out.println("before flip():  " + buffer);

    buffer.flip();
    System.out.println("before get():  " + buffer);
    System.out.println((char) buffer.get());
    System.out.println("after get(): " + buffer);

    System.out.println("get(index)  " + (char) buffer.get(2));
    System.out.println("after get(index): " + buffer);

    byte[] dst = new byte[10];
    buffer.get(dst, 0, 2);

    System.out.println("after get(dst, 0, 2): " + buffer);
    System.out.println("\t" + new String (dst));
    System.out.println("buffer now " + buffer);
    System.out.println("\t" + new String (buffer.array()));

    System.out.println("---Test put-----");
    ByteBuffer bb = ByteBuffer.allocate(32);
    System.out.println("before put(byte):   " + bb);
    System.out.println("after put(byte)   " + bb.put((byte) 'z'));
    System.out.println("\t" + bb.put(2, (byte) 'c'));
    System.out.println("after put(2, (byte) 'c')" + bb);
    System.out.println("\t" + new String(bb.array()));

    bb.put(buffer);
    System.out.println("after put(buffer)  " + bb);
    System.out.println("\t" + new String(bb.array()));
  }
}
