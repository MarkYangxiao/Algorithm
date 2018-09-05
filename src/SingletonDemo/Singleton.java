package SingletonDemo;

/**
 * Created by Yangxiao on 2018/8/26.
 * desc:
 */
public enum Singleton {
    INSTANCE;
    public static Singleton getInstance() {
      return INSTANCE;
    }
}
