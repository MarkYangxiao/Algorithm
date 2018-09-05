package SingletonDemo;

/**
 * Created by Yangxiao on 2018/8/26.
 * desc: 线程安全的懒汉
 * 懒汉： 类初始化 不创建，需要的时候再创建
 */
public class LanHan02 {
  private static LanHan02 instance;

  public LanHan02() {}

  public static synchronized LanHan02 getInstance() {
    if (instance == null) {
      instance = new LanHan02();
    }
    return instance;
  }
}
