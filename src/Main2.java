import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    ArrayDeque<Integer> deque = new ArrayDeque<>(100000);
    boolean reverse = false;
    in.nextLine();
    HashMap<Integer, Integer> cnt = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    while(q-- > 0){
      String s = in.nextLine();
      String[] a = s.split(" ");
      Integer x;
      switch (a[0]){
        case "push_front":
          x = Integer.parseInt(a[1]);
          if(reverse){
            deque.addLast(x);
          } else {
            deque.addFirst(x);
          }
          cnt.put(x, cnt.getOrDefault(x, 0) + 1);
          pq.add(x);
          break;
        case "push_back":
          x = Integer.parseInt(a[1]);
          if(!reverse){
            deque.addLast(x);
          } else {
            deque.addFirst(x);
          }
          cnt.put(x, cnt.getOrDefault(x, 0) + 1);
          pq.add(x);
          break;
        case "pop_front":
          if(!reverse){
            x = deque.pollFirst();
          } else {
            x = deque.pollLast();
          }
          if(x == null){
            System.out.println("Error");
          } else {
            cnt.put(x, cnt.get(x) - 1);
            System.out.println(x);
          }
          break;
        case "pop_back":
          if(reverse){
            x = deque.pollFirst();
          } else {
            x = deque.pollLast();
          }
          if(x == null){
            System.out.println("Error");
          } else {
            cnt.put(x, cnt.get(x) - 1);
            System.out.println(x);
          }
          break;
        case "reverse":
          reverse = !reverse;
          break;
        case "max":
          if(deque.isEmpty()){
            System.out.println("Error");
            break;
          }
          while (cnt.get(pq.peek()) == 0){
            pq.poll();
          }
          System.out.println(pq.peek());
          break;
      }
//      System.out.print("$ ");
//      for(int t : deque){
//        System.out.print(t + " ");
//      }
//      System.out.println();
//      System.out.println("=============");
    }
  }
}