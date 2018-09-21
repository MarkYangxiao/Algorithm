package StringT;

/**
 * Created by Yangxiao on 2018/9/13.
 * desc:
 */
public class fraction {
  public static void main(String[] args) {
    String ex = "10/9-4/1+10/9-9/10+4/3";
    System.out.println(fractionAddition(ex));
  }
  public static String fractionAddition(String expression) {
    char[] exChar = expression.toCharArray();
    String numerator = "";
    String denominator = "";
    for (int i = 0; i < exChar.length;) {
      while (i < exChar.length && exChar[i] != '/' ) {
          numerator += exChar[i++];
          while (i < exChar.length && Character.isDigit(exChar[i])) {
            numerator += exChar[i++];
          }
      }
      numerator += '#';
      i++;
      if (i < exChar.length) {
        denominator += exChar[i++];
        while (i < exChar.length && Character.isDigit(exChar[i])) {
          denominator += exChar[i++];
        }
      }
      denominator += '#';
    }
    String[] numerators = numerator.split("#");
    String[] denominators = denominator.split("#");
    int[] fenzi = new int[numerators.length];
    int[] fenmu = new int[denominators.length];
    for (int i = 0; i < denominators.length; i++) {
      fenzi[i] = numerators[i].length() < 2 ? numerators[i].charAt(0) - '0' : numerators[i].charAt(0) == '-' ? -Integer.valueOf(numerators[i].substring(1, numerators[i].length())) :
      Integer.valueOf(numerators[i].substring(0, numerators[i].length()));
      fenmu[i] = Integer.valueOf(denominators[i]);
    }
    int ansDen = 1;
    int ansNum = 0;
    ansDen = fenmu[0];
    ansNum = fenzi[0];
    for (int i = 1; i < fenzi.length; i++) {
      int tempDen = (fenmu[i] * ansDen) / gcd(ansDen, fenmu[i]);
      fenzi[i] *= (tempDen / fenmu[i]);
      ansNum *= (tempDen / ansDen);
      ansDen = tempDen;
      ansNum = (fenzi[i] + ansNum);
    }
    if (ansNum % ansDen == 0) {
      return ansNum / ansDen + "/1";
    } else {
      return ansNum / gcd(Math.abs(ansNum), Math.abs(ansDen)) + "/" + ansDen / gcd(Math.abs(ansNum), Math.abs(ansDen));
    }
  }
  public static int gcd(int a, int b) {
    return a > b ? gcd(a - b, b) : a < b ? gcd(a, b - a) : a;
  }
}
