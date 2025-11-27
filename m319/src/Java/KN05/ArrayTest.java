package TBZ.m319.Java.KN05;

import java.util.ArrayList;

/* OHNE KI Geschrieben!
 */

public class ArrayTest {
  public static void main(String[] args) {

    int[] numbers = { 1, 2, 3, 4, 5, 99, 400, 101, 24, 11, 55, 1001, 45, 11, 22 };
    int max = 0;
    for (int i : numbers) {

      if (i > max) {
        max = i;
      }

    }
    /* 
    Arraylist da Arrays in Java eine fixe grösse haben, Array clonen um einen Eintrag hinzu zufügen oder das array einfach vorgängig viel
    zu gross anzulegen damit sicher alles platz hat ist einfach bullshit. Darum verwende ich hier eine ArrayList
     */
    ArrayList<Integer> even = new ArrayList<>();
    ArrayList<Integer> odd = new ArrayList<>();
    for (int i : numbers) {
      if (i % 2 == 0) {
        even.add(i);
      }
      else {
        odd.add(i);
      }
    }
    
    
    System.out.println("Highest Number in Numbers is: " +  max);

    System.out.println("Numbers Array length is: " + numbers.length);

    System.out.println("Even Numbers are: " + even);
    
    System.out.println("Odd Numebers in Numbers are: " + odd);

}
}
