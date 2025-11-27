package Java.KN05;

import java.util.ArrayList;

/* Ohne Ki geschrieben */

public class BubbleSort {

  public static void main(String[] args) {
    int numbers = 100;
    ArrayList<Integer> array = new ArrayList<>();

    for (int i = 0; i < numbers; i++){
      double rnd = Math.random();
      rnd = rnd * 100;
      int rndInt = (int) rnd;
      array.add(rndInt);
    }

    boolean sorting = true;
    int length = array.size();

    while (sorting == true) {
      sorting = false;
      for (int i = 0; i < length - 1; i++) {
        int a = array.get(i);
        int b = array.get(i + 1);
        if (b > a) {
          array.set(i + 1, a);
          array.set(i, b);
          sorting = true;
        }
      }
    }
    System.out.println(array);
  }
  
}
