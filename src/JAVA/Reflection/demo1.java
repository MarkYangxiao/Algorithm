package JAVA.Reflection;

import java.lang.reflect.Method;

/**
 * Created by Yangxiao on 2018/9/22.
 * desc:
 */
public class demo1 {
  public static void main(String[] args) throws ClassNotFoundException {
    Class classType = Class.forName("java.util.Stack");

    Method[] methods = classType.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println(method.toString());
    }
  }
}
