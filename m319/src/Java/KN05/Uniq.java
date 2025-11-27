package TBZ.m319.Java.KN05;

import java.util.ArrayList;
import java.util.Collections;

/* Ohne Ki geschrieben
 * uniq deletes all doubles from an Array
 */

public class Uniq {

  public static void main(String[] args) {
    int numbers = 50;
    ArrayList<Integer> array = new ArrayList<>();

    for (int i = 0; i < numbers; i++) {
      double rnd = Math.random();
      rnd = rnd * 100;
      int rndInt = (int) rnd;
      array.add(rndInt);
    }

    Collections.sort(array);
    System.out.println("orginal: " + array);
    System.out.println("Array Length: " + array.size());

    int before = array.size();

    for (int i = 0; i < array.size() - 1; i++) {
      int a = array.get(i);
      int b = array.get(i + 1);
      if (a == b) {
        array.remove(i);
      }
    }
    System.out.println("uniq: " + array);
    System.out.println("Array Length: " + array.size());
    System.out.println("Doubles deleted: " + (before - array.size()));

  }
  
}
