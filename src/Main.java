import java.util.*;

/**
 * Created by Yangxiao on 2018/9/8.
 * desc:
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      String z = sc.next();
      for(int j = 1;j < z.length(); ++j){
        try{
          int a = Integer.parseInt(z.substring(0,j), x);
          int b = Integer.parseInt(z.substring(j), y);
          if(a == b){
            System.out.println(a);
            break;
          }
        } catch (NumberFormatException e){

        }
      }
    }

  }

}
