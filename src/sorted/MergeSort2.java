package sorted;

import java.util.*;

/**
 * Created by Yangxiao on 2018/8/11.
 * desc:
 */
public class MergeSort2 {

  public int[] aux;
  public void sort(int[] a) {
    aux = new int[a.length];

    sort(a, 0, a.length-1);

  }

  public void sort(int[] a, int i, int j) {
    if (i >= j)
      return;

    int mid = i + (j - i) / 2;
    sort(a, 0, mid);
    sort(a, mid+1, j);
    merge(a, i, mid, j);
  }

  public void merge(int[] a, int low, int mid, int hight) {

    for (int k = low; k <= hight; k++) {
      aux[k] = a[k];
    }

    int i = low;
    int j = mid + 1;
    for (int k = low; k <= hight; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hight) {
        a[k] = aux[i++];
      } else {
        if (aux[i] <= aux[j]) {
          a[k] = aux[i++];
        } else {
          a[k] = aux[j++];
        }
      }
    }



    /*for (int k = low; k <= hight; k++) {
      aux[k] = a[k];
    }
    int i = low;
    int j = mid + 1;
    for (int k = low; k <= hight; k++) {
      if (i > mid) {
          a[k] = aux[j++];
      }
      else if (j > hight) {
          a[k] = aux[i++];
      }
      else {
        if (aux[i] <= aux[j])
          a[k] = aux[i++];
        else
          a[k] = aux[j++];
      }
    }*/
  }

  public static void main(String[] args) {
    int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    MergeSort2 mergeSort2 = new MergeSort2();

    mergeSort2.sort(a);

    for (int ele : a) {
      System.out.print(ele + " ");
    }

   /* Map<Integer, Integer> map = new HashMap<>();
    map.put(1,2);
    map.put(2,3);
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    });
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i).getValue());
    }*/
  }


}
