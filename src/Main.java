import java.util.*;

public class Main{

  private static final char CHESS = 'o';

  private static HashMap<Range, Integer> visit = new HashMap<>();
  private static PriorityQueue<Status> queue = new PriorityQueue<>();
  private static int K;
  private static int N;
  private static int M;

  public static int getMinimum(List<String> board, int k) {
    char[][] b = new char[board.size()][];
    K = k;
    int cnt = 0;
    int[] nums = {1, 2,2};
    for(int i = 0; i < board.size(); ++i){
      b[i] = board.get(i).toCharArray();
      for(char c : b[i]){
        if(c == CHESS){
          cnt++;
        }
      }
    }
    if(cnt == k){
      return 0;
    }
    N = board.size();
    M = board.get(0).length();
    Range range = new Range(0, M - 1, 0, N - 1);
    visit.put(range, 0);
    queue.offer(new Status(range, cnt, 0));
    while(!queue.isEmpty()){
      Status status = queue.poll();
      if(status.cnt == k){
        return status.cost;
      }
      if(status.range.right != status.range.left){
        int rightCnt = status.cnt;
        int leftCnt = status.cnt;
        for(int i = status.range.top; i <= status.range.bottom; ++i){
          if(b[i][status.range.left] == CHESS){
            leftCnt--;
          }
          if(b[i][status.range.right] == CHESS){
            rightCnt--;
          }
        }

        Range leftRange = new Range(status.range);
        leftRange.left++;
        add(leftRange, leftCnt);

        Range rightRange = new Range(status.range);
        rightRange.right--;
        add(rightRange, rightCnt);
      }

      if(status.range.top != status.range.bottom){
        int topCnt = status.cnt;
        int bottomCnt = status.cnt;
        for(int i = status.range.left; i <= status.range.right; ++i){
          if(b[status.range.top][i] == CHESS){
            topCnt--;
          }
          if(b[status.range.bottom][i] == CHESS){
            bottomCnt--;
          }
        }

        Range topRange = new Range(status.range);
        topRange.top++;
        add(topRange, topCnt);

        Range bottomRange = new Range(status.range);
        bottomRange.bottom--;
        add(bottomRange, bottomCnt);
      }

    }

    return -1;
  }


  private static void add(Range range, int cnt){
    if(cnt >= K){
      int cost = clacCost(range);
      if(visit.getOrDefault(range, Integer.MAX_VALUE) > cost){
        visit.put(range, cost);
      }
      queue.add(new Status(range, cnt, cost));
    }
  }

  private static int clacCost(Range range) {
    int left = range.left;
    int right = M - range.right - 1;
    int top = range.top;
    int bottom = N - range.bottom - 1;
    return left + right + Math.min(left, right) +
            top + bottom + Math.min(top, bottom);
  }

  public static void main(String[] args){
    /*Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    List<String> v = new ArrayList<String>();
    for(int i = 0 ;i < n;i++){
      String temp = in.next();
      v.add(temp);
    }

    int k = in.nextInt();
    System.out.println(getMinimum(v, k));*/
   Map<Integer, Integer> map = new HashMap<>();
   map.put(1, 1);
   System.out.println(map.get(2));

  }
}

class Range{
  int left,right,top,bottom;

  public Range(int left, int right, int top, int bottom) {
    this.left = left;
    this.right = right;
    this.top = top;
    this.bottom = bottom;
  }

  public Range(Range other) {
    this.left = other.left;
    this.right = other.right;
    this.top = other.top;
    this.bottom = other.bottom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Range range = (Range) o;

    if (left != range.left) return false;
    if (right != range.right) return false;
    if (top != range.top) return false;
    return bottom == range.bottom;
  }

  @Override
  public int hashCode() {
    int result = left;
    result = 101 * result + right;
    result = 101 * result + top;
    result = 101 * result + bottom;
    return result;
  }
}

class Status implements Comparable<Status>{
  Range range;
  int cnt;
  int cost;

  public Status(Range range, int cnt, int cost) {
    this.range = range;
    this.cnt = cnt;
    this.cost = cost;
  }

  @Override
  public int compareTo(Status o) {
    return cost - o.cost;
  }
}
