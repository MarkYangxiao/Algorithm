package SingletonDemo;

/**
 * Created by Yangxiao on 2018/8/26.
 * desc: 懒汉模式： 类初始化的时候 并不创建， 什么时候需要 什么时候创建
 *  线程不安全
 */

public class LanHan {
  private static LanHan instance;
  public LanHan() {}

  public static LanHan getInstance() {
    if (instance == null) {
      instance = new LanHan();
    }
    return instance;
  }
}
