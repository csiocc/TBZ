package TBZ.m319.Java.KN02.de.program.start;
public class VariablenVsKonstanten {

    public static void main(String[] args) {

        // --- 1. Die Variable ---
        // Eine Variable ist wie eine beschreibbare Tafel. 📝
        // Ihr Wert kann deklariert und später beliebig oft geändert werden.

        int anzahlLeben = 5;
        System.out.println("Spiel gestartet! Du hast " + anzahlLeben + " Leben.");

        // Der Wert der Variablen wird verändert.
        anzahlLeben = anzahlLeben - 1; // Spieler verliert ein Leben.
        System.out.println("Oh nein, ein Fehler! Du hast jetzt noch " + anzahlLeben + " Leben.");

        anzahlLeben = 10; // Leben aufgefüllt.
        System.out.println("Power-Up gefunden! Deine Leben sind jetzt auf " + anzahlLeben + " erhöht.");


        System.out.println("\n-----------------------------------\n");


        // --- 2. Die Konstante ---
        // Eine Konstante ist wie eine in Stein gemeisselte Inschrift. 📜
        // Sie wird mit dem Schlüsselwort 'final' deklariert und ihr Wert
        // kann nach der ersten Zuweisung NIE WIEDER geändert werden.
        // Konvention: Konstanten werden oft in GROSSBUCHSTABEN geschrieben.

        final int MAX_SPIELER = 4;
        System.out.println("Dieses Spiel ist für maximal " + MAX_SPIELER + " Spieler ausgelegt.");

        // Der folgende Code würde einen FEHLER verursachen, wenn man ihn einkommentiert.
        // MAX_SPIELER = 8; // <-- COMPILER FEHLER: "cannot assign a value to final variable MAX_SPIELER"

        // Wir können den Fehler demonstrieren, indem wir versuchen, die Konstante zu ändern.
        System.out.println("Versuch, die maximale Spieleranzahl zu ändern...");
        System.out.println("...Fehler! Der Wert einer Konstante ist unveränderlich.");

    }
}