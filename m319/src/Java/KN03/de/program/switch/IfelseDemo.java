

/**
 * Diese Klasse demonstriert die grundlegende Verwendung von bedingten Anweisungen
 * mit if, else if und else.
 */
public class IfelseDemo {

    public static void main(String[] args) {
        // Wir definieren eine Zahl, die wir überprüfen wollen.
        // Ändern Sie diesen Wert, um die verschiedenen Ausgaben zu sehen (z.B. auf -5 oder 0).
        int zahl = 10;

        System.out.println("Die zu überprüfende Zahl ist: " + zahl);

        // Die if-Anweisung prüft die erste Bedingung.
        // Trifft diese zu, wird der entsprechende Block ausgeführt und der Rest übersprungen.
        if (zahl > 0) {
            System.out.println("Die Zahl ist positiv.");
        }
        // Die else if-Anweisung prüft eine zweite Bedingung, falls die erste nicht zutraf.
        else if (zahl < 0) {
            System.out.println("Die Zahl ist negativ.");
        }
        // Der else-Block wird ausgeführt, wenn keine der vorherigen Bedingungen zutraf.
        else {
            System.out.println("Die Zahl ist genau Null.");
        }

        System.out.println("Die Überprüfung ist abgeschlossen.");
    }
}