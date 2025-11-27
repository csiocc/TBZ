package TBZ.m319.Java.KN05;

/* Ki erstellt */

public class ArrayDemo {
    public static void main(String[] args) {
        System.out.println("=== Arrays in Java ===");

        // 1. Array-Erstellung mit fester Größe
        int[] zahlen = new int[5]; // Array mit 5 Elementen (Index 0 bis 4)
        System.out.println("\nEin int-Array mit 5 Elementen wurde erstellt (alle Werte standardmäßig = 0).");

        // Werte zuweisen
        zahlen[0] = 10;
        zahlen[1] = 20;
        zahlen[2] = 30;
        zahlen[3] = 40;
        zahlen[4] = 50;

        // Zugriff auf Werte
        System.out.println("\nWerte im Array:");
        System.out.println("Erstes Element (Index 0): " + zahlen[0]);
        System.out.println("Letztes Element (Index 4): " + zahlen[4]);

        // 2. Array-Erstellung mit Initialisierung
        String[] namen = {"Anna", "Ben", "Clara", "David"};
        System.out.println("\nEin String-Array wurde erstellt und initialisiert:");
        System.out.println("namen[0] = " + namen[0]);
        System.out.println("namen[2] = " + namen[2]);

        // 3. Länge eines Arrays
        System.out.println("\nLänge des Arrays 'namen': " + namen.length);

        // 4. Iteration mit for-Schleife (Index-basiert)
        System.out.println("\nAlle Werte von 'zahlen' mit for-Schleife:");
        for (int i = 0; i < zahlen.length; i++) {
            System.out.println("Index " + i + ": " + zahlen[i]);
        }

        // 5. Iteration mit for-each-Schleife
        System.out.println("\nAlle Werte von 'namen' mit for-each-Schleife:");
        for (String name : namen) {
            System.out.println(name);
        }

        // 6. Beispiel: Summe aller Zahlen im Array berechnen
        int summe = 0;
        for (int z : zahlen) {
            summe += z;
        }
        System.out.println("\nSumme aller Zahlen im Array 'zahlen': " + summe);

        // 7. Beispiel: Größten Wert im Array finden
        int max = zahlen[0];
        for (int z : zahlen) {
            if (z > max) {
                max = z;
            }
        }
        System.out.println("Größter Wert im Array 'zahlen': " + max);

        System.out.println("\n=== Ende der Array-Demonstration ===");
    }
}
