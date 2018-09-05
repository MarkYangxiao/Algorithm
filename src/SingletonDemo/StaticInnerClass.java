package SingletonDemo;

/**
 * Created by Yangxiao on 2018/8/26.
 * desc:
 */
public class StaticInnerClass {
  private static class Singleton {
    private static final StaticInnerClass instance = new StaticInnerClass();
  }

  private StaticInnerClass() {}
  public static final StaticInnerClass getInstance() {
    return Singleton.instance;
  }
}
