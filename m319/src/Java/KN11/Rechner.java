package TBZ.m319.Java.KN11;

/**
 * ============================================
 * Datei: Rechner.java
 * @author: Christian ( Chat GPT )
 * Datum: 18.09.2025
 * Beschreibung:
 *   Diese Klasse stellt einfache mathematische
 *   Funktionen wie Addition und Multiplikation
 *   zur Verfügung.
 * ============================================
 */
public class Rechner {

    /**
     * Addiert zwei Ganzzahlen.
     *
     * @param a erste Zahl
     * @param b zweite Zahl
     * @return Summe von a und b
     */
    public int addieren(int a, int b) {
        return a + b; // Inline-Kommentar: Addition durchführen
    }

    /**
     * Multipliziert zwei Ganzzahlen.
     *
     * @param a erste Zahl
     * @param b zweite Zahl
     * @return Produkt von a und b
     */
    public int multiplizieren(int a, int b) {
        return a * b;
    }

    /**
     * Gibt eine kurze Beschreibung zurück.
     *
     * @return String mit Text
     */
    public String beschreibung() {
        /* Mehrzeiliger Kommentar:
         * Hier könnte man später noch Details
         * über die Implementierung ergänzen.
         *
         * TODO: Beschreibung dynamisch aus einer
         *       Konfigurationsdatei laden.
         */
        return "Einfacher Rechner für Grundoperationen.";
    }
}

