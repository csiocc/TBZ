package TBZ.m319.Java.KN04;

import java.util.Scanner;


public class KN04F25 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int inp = 1;
    System.out.print("Zahl eingeben: ");

    while (inp != 0)  
      inp = scanner.nextInt();
      if (inp == 0) {
        System.out.print("Ende");
      }

  }
  
}
