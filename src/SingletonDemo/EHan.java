package SingletonDemo;

/**
 * Created by Yangxiao on 2018/8/26.
 * desc: 类被加载就创建
 */
public class EHan {
  private static EHan instance = new EHan();

  private EHan() {}

  public static EHan getInstance() {
    return instance;
  }
}
