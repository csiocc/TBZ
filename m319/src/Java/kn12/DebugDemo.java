package Java.kn12;

public class DebugDemo {

    public static void main(String[] args) {
        System.out.println("Starte DebugDemo...");

        // --- Syntaxfehler Beispiel ---
        // Entferne mal die Slashes unten und versuche zu kompilieren:
        // System.out.println("Das ist ein Syntaxfehler"

        // --- Laufzeitfehler Beispiel ---
        try {
            int result = divide(10, 0); // Division durch 0
            System.out.println("Ergebnis: " + result);
        } catch (Exception e) {
            System.out.println("Fehler beim Teilen: " + e);
        }

        // --- Logikfehler Beispiel ---
        int[] zahlen = {1, 2, 3, 4, 5};
        int sum = calculateSum(zahlen);
        System.out.println("Summe sollte 15 sein, ist aber: " + sum);

        // --- Debuggen mit Step Into / Step Over / Step Out ---
        int a = 5;
        int b = 3;
        int produkt = multiply(a, b); // hier kannst du Step Into üben
        System.out.println("Produkt: " + produkt);

        System.out.println("Programmende erreicht.");
    }

    // absichtlich falsche Logik (soll alle Zahlen addieren, überspringt aber den letzten Wert)
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) { // BUG: sollte i < arr.length sein
            sum += arr[i];
        }
        return sum;
    }

    public static int divide(int x, int y) {
        return x / y;
    }

    public static int multiply(int x, int y) {
        int result = 0;
        for (int i = 0; i < y; i++) {
            result += x; // hier kannst du Step Over / Step Into üben
        }
        return result;
    }
}
