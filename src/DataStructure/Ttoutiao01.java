package DataStructure;
import java.util.Scanner;
public class Main{
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    while (N-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      boolean nodes[][] = new boolean[n][n];
      while (m-- > 0) {
        int i = sc.nextInt() - 1;
        int j = sc.nextInt() - 1;
        nodes[i][j] = true;
        nodes[j][i] = true;
      }
      int result[] = new int[n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (nodes[i][j]) result[i]++;
        }
      }
      boolean flag = true;
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          if (!nodes[i][j]) {
            if (result[i] != result[j]) {
              flag = false;
              break;
            }
          }
        }
        if (!flag) break;
      }
      System.out.println(flag ? "Yes" : "No");
    }
  }
}