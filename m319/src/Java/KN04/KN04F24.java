package TBZ.m319.Java.KN04;

public class KN04F24 {

  public static void main(String[] args) {

      int i = 0;
      while (i <= 100) {
        int j = 0;
        while (j <= 100) {
          System.out.println(i + "+" + j + "=" + (i + j));
          j++;
        }
        i++;
      }
  }
}
