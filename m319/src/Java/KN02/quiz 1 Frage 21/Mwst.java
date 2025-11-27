import java.util.Scanner;

public class Mwst {

  public static void main(String[] args) {
    final double MWST = 7.7;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Insert Price");
    double price = scanner.nextDouble();
    calc(price, MWST);
    scanner.close();
  }

  static void calc(double price, double MWST) {
    System.out.println("Price+Mwst is:" + (price + (price * (MWST / 100))));
  }
}